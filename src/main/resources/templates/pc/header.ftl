<div class="header-bg">
    <div class="header">
        <div class="col"><a href="${springMacroRequestContext.contextPath}/pc/" class="title">学习空间</a></div>
        <div style="width: 450px;">
            <div class="layui-form">
                <div class="layui-form-item">
                    <div class="layui-input-inline type-box" >
                        <select id="type">
                            <option value="all">所有</option>
                            <option value="1">问答</option>
                            <option value="2">教程</option>
                        </select>
                    </div>
                    <div class="layui-input-inline keyword-box" >
                        <input type="text" id="keyword" required value="${(keyword)!}"  lay-verify="required" placeholder="请输入关键字" autocomplete="off" class="layui-input keyword">
                    </div>
                    <div class="layui-input-inline search-btn-box" >
                        <button type="button" id="search-btn" class="layui-btn layui-btn-normal">搜索</button>
                    </div>
                </div>
            </div>
        </div>
        <div class="col">
            <a href="javascript:void(0)"> </a>
        </div>
    </div>
</div>