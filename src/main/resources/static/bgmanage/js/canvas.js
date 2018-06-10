(function(){
    $.fn.canvas1=function (options) {
        var defaultoptions = {
            background:"#000",
            width:"100%",
            height:"100%",
            fillColor:"#FFF",
            lineColor:"#fff"
        }
        var newoptions = $.extend({},defaultoptions, options);
        var selector = this.selector.substring(1);
        var canvas = document.getElementById(selector);
        canvas.style.background = newoptions.background;
        canvas.style.width = newoptions.width;
        canvas.style.height = newoptions.height;
        var ctx = canvas.getContext("2d");

        resize();
        window.onresize = resize;

        function resize() {
            canvas.height = $('#canvas').height();
            canvas.width = $('#canvas').width();
        }

        var RAF = (function () {
            return window.requestAnimationFrame || window.webkitRequestAnimationFrame || window.mozRequestAnimationFrame || window.oRequestAnimationFrame || window.msRequestAnimationFrame || function (callback) {
                window.setTimeout(callback, 1000 / 60);
            };
        })();

        // 鼠标活动时，获取鼠标坐标
        var warea = { x: null, y: null, max: 20000 };
        window.onmousemove = function (e) {
            e = e || window.event;

            warea.x = e.clientX;
            warea.y = e.clientY;
        };
        window.onmouseout = function (e) {
            warea.x = null;
            warea.y = null;
        };

        // 添加粒子
        // x，y为粒子坐标，xa, ya为粒子xy轴加速度，max为连线的最大距离
        var dots = [];
        for (var i = 0; i < 250; i++) {
            var x = Math.random() * canvas.width;
            var y = Math.random() * canvas.height;
            var xa = Math.random() * 2 - 1;
            var ya = Math.random() * 2 - 1;

            dots.push({
                x: x,
                y: y,
                xa: xa,
                ya: ya,
                max: 6000
            })
        }

        // 延迟100秒开始执行动画，如果立即执行有时位置计算会出错
        setTimeout(function () {
            animate();
        }, 100);

        // 每一帧循环的逻辑
        function animate() {
            ctx.clearRect(0, 0, canvas.width, canvas.height);

            // 将鼠标坐标添加进去，产生一个用于比对距离的点数组
            var ndots = [warea].concat(dots);

            dots.forEach(function (dot) {

                // 粒子位移
                dot.x += dot.xa;
                dot.y += dot.ya;

                // 遇到边界将加速度反向
                dot.xa *= (dot.x > canvas.width || dot.x < 0) ? -1 : 1;
                dot.ya *= (dot.y > canvas.height || dot.y < 0) ? -1 : 1;

                // 绘制点
                ctx.fillStyle = newoptions.fillColor;
                ctx.fillRect(dot.x - 0.5, dot.y - 0.5, 1, 1);

                // 循环比对粒子间的距离
                for (var i = 0; i < ndots.length; i++) {
                    var d2 = ndots[i];

                    if (dot === d2 || d2.x === null || d2.y === null) continue;

                    var xc = dot.x - d2.x;
                    var yc = dot.y - d2.y;

                    // 两个粒子之间的距离
                    var dis = xc * xc + yc * yc;

                    // 距离比
                    var ratio;

                    // 如果两个粒子之间的距离小于粒子对象的max值，则在两个粒子间画线
                    if (dis < d2.max) {

                        // 如果是鼠标，则让粒子向鼠标的位置移动
                        if (d2 === warea && dis > (d2.max / 2)) {
                            dot.x -= xc * 0.03;
                            dot.y -= yc * 0.03;
                        }

                        // 计算距离比
                        ratio = (d2.max - dis) / d2.max;

                        // 画线
                        ctx.beginPath();
                        ctx.lineWidth = ratio / 2;
                        ctx.strokeStyle = newoptions.lineColor;
                        ctx.moveTo(dot.x, dot.y);
                        ctx.lineTo(d2.x, d2.y);
                        ctx.stroke();
                    }
                }

                // 将已经计算过的粒子从数组中删除
                ndots.splice(ndots.indexOf(dot), 1);
            });

            RAF(animate);
        }
    }
    $.fn.canvas2=function (options) {
        var defaultoptions = {
            background:"#000",
            width:"100%",
            height:"600px",
            fillColor:"#FFF",
            lineColor:null
        }
        var newoptions = $.extend({},defaultoptions, options);
        var selector = this.selector;
        var canvas = document.getElementById(selector);
        var ctx = canvas.getContext('2d');
        canvas.style.background = newoptions.background;


        ctx.strokeStyle = (new Color(500)).style;

        //屏幕分辨率，并非屏幕宽度
        var screenWidth = screen.width;
        canvas.width = window.document.body.clientWidth;
        canvas.height = window.innerHeight;
        //线条、白点数量
        var dotCount = 20;
        var dotRadius = 70;
        var dotDistance = 70;
        if (screenWidth >= 768 && screenWidth < 992) {
            dotCount = 170;
            dotRadius = 90;
            dotDistance = 60;
            canvas.height = window.innerHeight / 3;
        } else if (screenWidth >= 992 && screenWidth < 1200) {
            dotCount = 120;
            dotRadius = 140;
            dotDistance = 70;
            canvas.height = window.innerHeight * 1 / 3;
        } else if (screenWidth >= 1200 && screenWidth < 1700) {
            dotCount = 140;
            dotRadius = 150;
            dotDistance = 80;
            canvas.height = window.innerHeight * 1 / 3;
        } else if (screenWidth >= 1700) {
            dotCount = 1000;
            dotRadius = 80;
            dotDistance = 80;
            canvas.height = window.innerHeight * 1 / 3;
        }
        canvas.height = window.innerHeight;
        var mousePosition = {
            x: 50 * canvas.width / 100,
            y: 50 * canvas.height / 100
        };
        var dots = {
            count: dotCount,
            distance: dotDistance,
            d_radius: dotRadius,
            array: []
        };

        function colorValue(min) {
            return Math.floor(Math.random() * 255 + min);
        }

        function createColorStyle(r, g, b) {
            return 'rgba(' + r + ',' + g + ',' + b + ', 0.8)';
        }

        function mixComponents(comp1, weight1, comp2, weight2) {
            return (comp1 * weight1 + comp2 * weight2) / (weight1 + weight2);
        }

        function averageColorStyles(dot1, dot2) {
            var color1 = dot1.color,
                color2 = dot2.color;

            var r = mixComponents(color1.r, dot1.radius, color2.r, dot2.radius),
                g = mixComponents(color1.g, dot1.radius, color2.g, dot2.radius),
                b = mixComponents(color1.b, dot1.radius, color2.b, dot2.radius);
            return createColorStyle(Math.floor(r), Math.floor(g), Math.floor(b));
        }

        function Color(min) {
            min = min || 0;
            this.r = colorValue(min);
            this.g = colorValue(min);
            this.b = colorValue(min);
            this.style = createColorStyle(this.r, this.g, this.b);
        }

        function Dot() {

            this.x = Math.random() * canvas.width;
            this.y = Math.random() * canvas.height;
            //鐢诲竷涓婄偣鐨勬祦鍔ㄩ€熷害
            this.vx = -.9 + Math.random();
            this.vy = -.9 + Math.random();
            //鐢诲竷涓婄偣鐨勫ぇ灏�
            this.radius = Math.random() * 3;

            this.color = new Color();
        }

        Dot.prototype = {
            draw: function () {
                ctx.beginPath();
                ctx.fillStyle = newoptions.fillColor;
                ctx.arc(this.x, this.y, this.radius, 0, Math.PI * 2, false);
                ctx.fill();
            }
        };

        function createDots() {
            for (i = 0; i < dots.count; i++) {
                dots.array.push(new Dot());
            }
        }

        function moveDots() {
            for (i = 0; i < dots.count; i++) {

                var dot = dots.array[i];

                if (dot.y < 0 || dot.y > canvas.height) {
                    dot.vx = dot.vx;
                    dot.vy = -dot.vy;
                }
                else if (dot.x < 0 || dot.x > canvas.width) {
                    dot.vx = -dot.vx;
                    dot.vy = dot.vy;
                }
                dot.x += dot.vx;
                dot.y += dot.vy;
            }
        }

        function connectDots1() {
            var pointx = mousePosition.x;
            for (i = 0; i < dots.count; i++) {
                for (j = 0; j < dots.count; j++) {
                    i_dot = dots.array[i];
                    j_dot = dots.array[j];

                    if ((i_dot.x - j_dot.x) < dots.distance && (i_dot.y - j_dot.y) < dots.distance && (i_dot.x - j_dot.x) > -dots.distance && (i_dot.y - j_dot.y) > -dots.distance) {
                        if ((i_dot.x - pointx) < dots.d_radius && (i_dot.y - mousePosition.y) < dots.d_radius && (i_dot.x - pointx) > -dots.d_radius && (i_dot.y - mousePosition.y) > -dots.d_radius) {
                            ctx.beginPath();
                            if(newoptions.lineColor!=null){
                                ctx.strokeStyle = newoptions.lineColor;
                            }else{
                                ctx.strokeStyle = averageColorStyles(i_dot, j_dot);
                            }
                            ctx.moveTo(i_dot.x, i_dot.y);
                            ctx.lineTo(j_dot.x, j_dot.y);
                            ctx.stroke();
                            ctx.closePath();
                        }
                    }
                }
            }
        }

        function drawDots() {
            for (i = 0; i < dots.count; i++) {
                var dot = dots.array[i];
                dot.draw();
            }
        }

        function animateDots() {
            ctx.clearRect(0, 0, canvas.width, canvas.height);
            moveDots();
            connectDots1()
            drawDots();

            requestAnimationFrame(animateDots);
        }

        $('canvas').on('mousemove', function (e) {
            mousePosition.x = e.pageX;
            mousePosition.y = e.pageY;
        });

        $('canvas').on('mouseleave', function (e) {
            mousePosition.x = canvas.width / 2;
            mousePosition.y = canvas.height / 2;
        });

        createDots();
        requestAnimationFrame(animateDots);
    }
})(jQuery)