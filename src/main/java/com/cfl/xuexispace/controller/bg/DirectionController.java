package com.cfl.xuexispace.controller.bg;

import com.cfl.xuexispace.entity.Direction;
import com.cfl.xuexispace.entity.Note;
import com.cfl.xuexispace.entity.Result;
import com.cfl.xuexispace.entity.User;
import com.cfl.xuexispace.service.DirectionService;
import com.cfl.xuexispace.service.NoteService;
import com.cfl.xuexispace.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @CreateUser: 李明
 * @CreateDate: 2018/6/10 14:04
 * @Version: 1.0
 * @Description: 笔记方向
 */
@Controller
@RequestMapping("bgmanage")
public class DirectionController {
    @Autowired
    private DirectionService directionService;

    @Autowired
    private NoteService noteService;

    /**
     * 笔记方向页面
     * @return
     */
    @RequestMapping("direction")
    public String toDirection(){
        return "bgmanage/direction";
    }

    /**
     * 编辑笔记方向页面
     * @return
     */
    @RequestMapping("edit_direction_page")
    public String toEditDirection(Integer directionId, Model model){
        Direction direction = new Direction();
        if(CommonUtils.isNotEmpty(directionId)){
            direction.setDirectionId(directionId);
            List<Direction> list = directionService.select(direction);
            if(list.size()>0){
                direction = list.get(0);
            }

        }
        model.addAttribute("direction",direction);
        return "bgmanage/edit_direction";
    }

    /**
     * 编辑笔记方向：新增/修改
     * @param direction
     * @return
     */
    @RequestMapping("eidtDirection")
    @ResponseBody
    public Result eidtDirection(Direction direction, HttpServletRequest request){
        String user = ((User)request.getSession().getAttribute("user")).getUserName();
        Result result = new Result();

        int count = 0;
        if(CommonUtils.isEmpty(direction.getDirectionId())){
            // 查询该方向名是否存在
            List<Direction> list = directionService.select(direction);
            if(list.size()==0){
                count = directionService.insert(direction.getDirectionName(),user);
            }else{
                result.setMsg("保存失败，该方向名称已存在，不能重复添加！");
                result.setCode(400);
            }
        }else{
            direction.setUpdateUser(user);
            count = directionService.update(direction);
        }
        if(count>0){
            result.setMsg("保存成功");
            result.setCode(0);
        }
        return result;
    }

    /**
     * 查询所有笔记方向
     * @return
     */
    @RequestMapping("selectDirection")
    @ResponseBody
    public Result select(){
        List<Direction> list = directionService.select(null);
        Result result = new Result();
        result.setCode(0);
        result.setData(list);
        return result;
    }

    /**
     * 删除笔记方向
     * @return
     */
    @RequestMapping("deleteDirection")
    @ResponseBody
    public Result delete(String id){

        Result result = new Result();
        Note note = new Note();
        note.setDirectionId(Integer.parseInt(id));
        List<Note> list = noteService.select(note);
        if(list.size()>0){
            result.setCode(400);
            result.setMsg("删除失败,当前方向正在使用中，请先删除该方向的相关笔记！");
        }else{
            int count = directionService.delete(id);
            if(count>0){
                result.setCode(0);
                result.setMsg("删除成功");
            }else{
                result.setCode(400);
                result.setMsg("删除失败");
            }
        }
        return result;
    }
}
