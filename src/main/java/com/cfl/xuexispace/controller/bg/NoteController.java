package com.cfl.xuexispace.controller.bg;

import com.cfl.xuexispace.entity.Direction;
import com.cfl.xuexispace.entity.FileEntity;
import com.cfl.xuexispace.entity.Note;
import com.cfl.xuexispace.entity.Result;
import com.cfl.xuexispace.service.DirectionService;
import com.cfl.xuexispace.service.FileService;
import com.cfl.xuexispace.service.NoteService;
import com.cfl.xuexispace.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @CreateUser: 李明
 * @CreateDate: 2018/6/10 13:59
 * @Version: 1.0
 * @Description:
 */
@Controller
@RequestMapping("bgmanage")
public class NoteController {
    @Autowired
    private DirectionService directionService;
    @Autowired
    private NoteService noteService;
    @Autowired
    private FileService fileService;

    /**
     * 笔记列表页面
     * @return
     */
    @RequestMapping("noteList")
    public String toNoteList(Model model){
        List<Direction> list = directionService.select(null);
        model.addAttribute("directions",list);
        return "bgmanage/note_list";
    }

    /**
     * 笔记编辑页面
     * @return
     */
    @RequestMapping("note")
    public String toEditNote(Model model, String id){
        List<Direction> list = directionService.select(null);
        model.addAttribute("directions",list);
        if(CommonUtils.isNotEmpty(id)){
            Note note =  new Note();
            note.setNoteId(id);
            List<Note> notes = noteService.select(note);
            model.addAttribute("note",notes.get(0));
            List<FileEntity> files = fileService.selectFileByNoteId(notes.get(0).getNoteId());
            model.addAttribute("files",files);
        }
        return "bgmanage/edit_note";
    }

    /**
     * 发布笔记
     * @param note 笔记对象
     * @param request
     * @param fileList 文件数组
     */
    @RequestMapping("releaseNote")
    @ResponseBody
    public Result releaseNote(Note note, HttpServletRequest request, String fileList,@RequestParam(value="newFiles[]",required = false) String[] newFiles, String haveFiles){
        note.setStatus(1);
        Result result = new Result();
        int count  = 0;
        if(CommonUtils.isEmpty(note.getNoteId())){
            note.setCreateUser(CommonUtils.getCurrentUser(request).getUserName());
            count  = noteService.insert(note,fileList,newFiles);
        }else{
            note.setUpdateUser(CommonUtils.getCurrentUser(request).getUserName());
            count  = noteService.update(note,fileList,newFiles,haveFiles);
        }
        if(count!=0){
            result.setCode(0);
            result.setMsg("发布成功");
        }else{
            result.setCode(400);
            result.setMsg("发布失败");
        }
        return result;
    }

    /**
     * 保存笔记
     * @param note 笔记对象
     * @param request
     * @param fileList 文件数组
     * @return
     */
    @RequestMapping("editNote")
    @ResponseBody
    public Result editNote(Note note, HttpServletRequest request, String fileList,@RequestParam(value="newFiles[]",required = false) String[] newFiles, String haveFiles){
        note.setStatus(0);
        Result result = new Result();
        int count  = 0;
        if(CommonUtils.isEmpty(note.getNoteId())){
            note.setCreateUser(CommonUtils.getCurrentUser(request).getUserName());
            count  = noteService.insert(note,fileList,newFiles);
        }else{
            note.setUpdateUser(CommonUtils.getCurrentUser(request).getUserName());
            count  = noteService.update(note,fileList,newFiles,haveFiles);
        }
        if(count!=0){
            result.setCode(0);
            result.setMsg("暂存成功");
        }
        return result;
    }

    /**
     * 笔记列表数据
     * @return
     */
    @RequestMapping("selectNote")
    @ResponseBody
    public Result selectNote(Note note){
        Result result = new Result();
        List<Note> list = noteService.select(note);
        Integer count = noteService.selectCount(note);
        result.setCode(0);
        result.setData(list);
        result.setCount(count);
        return result;
    }

    /**
     * 删除笔记
     * @return
     */
    @RequestMapping("deleteNote")
    @ResponseBody
    public Result deleteNote(String id){
        Result result = new Result();
        int count = noteService.deleteNote(id);
        if(count!=0){
            result.setCode(0);
            result.setMsg("删除成功");
        }else{
            result.setCode(400);
            result.setMsg("删除成功");
        }
        return result;
    }

    /**
     * 通过id查询笔记
     * @return
     */
    @RequestMapping("selectNoteById")
    @ResponseBody
    public Result selectNoteById(String noteId){
        Result result = new Result();
        Note note = new Note();
        note.setNoteId(noteId);
            note = noteService.selectNoteById(note);
        result.setCode(0);
        result.setData(note);
        return result;
    }

    /**
     * 笔记数量统计
     * @return
     */
    @RequestMapping("noteCountStatistics")
    @ResponseBody
    public Result noteCountStatistics(){
        Result result =  new Result();
        int allCount = noteService.selectCount(null);
        List<Map<String,Object>> list = noteService.countGroupDirection();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("allCount",allCount);
        map.put("list",list);
        result.setCode(0);
        result.setData(map);
        return result;
    }

    /**
     * 笔记预览前数据缓存
     * @param note
     * @param request
     * @return
     */
    @RequestMapping("noteStorage")
    @ResponseBody
    public Result storage(Note note,HttpServletRequest request){
        String id = CommonUtils.getUuid();
        request.getSession().setAttribute(id,note);
        Result result = new Result();
        result.setCode(0);
        result.setData(id);
        return result;
    }

    /**
     * 笔记预览
     * @param id
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("noteView")
    public String noteView(String id,Model model,HttpServletRequest request){
        Object note = request.getSession().getAttribute(id);
        model.addAttribute("note",note);
        return "bgmanage/note_view";
    }

    /**
     * 各方向访问量排行Top10
     * @return
     */
    @RequestMapping("browseTopGroupByDirection")
    @ResponseBody
    public Result browseTopGroupByDirection(){
        Result result = new Result();
        Map<String,Integer> map = noteService.browseTopGroupByDirection();
        result.setCode(0);
        result.setData(map);
        return result;
    }

    /**
     * 有用笔记排行
     * @return
     */
    @RequestMapping("selectByUse")
    @ResponseBody
    public Result selectByUse(){
        Result result = new Result();
        List<Note> list = noteService.selectByUse("use");
        result.setCode(0);
        result.setData(list);
        return result;
    }

    /**
     * 有用笔记排行
     * @return
     */
    @RequestMapping("selectByUnUse")
    @ResponseBody
    public Result selectByUnUse(){
        Result result = new Result();
        List<Note> list = noteService.selectByUse("unuse");
        result.setCode(0);
        result.setData(list);
        return result;
    }
}
