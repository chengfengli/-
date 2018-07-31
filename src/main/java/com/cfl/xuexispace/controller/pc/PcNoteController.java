package com.cfl.xuexispace.controller.pc;

import com.cfl.xuexispace.entity.FileEntity;
import com.cfl.xuexispace.entity.Note;
import com.cfl.xuexispace.entity.Result;
import com.cfl.xuexispace.service.FileService;
import com.cfl.xuexispace.service.NoteService;
import com.cfl.xuexispace.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @CreateUser: 李明
 * @CreateDate: 2018/7/1 10:08
 * @Version: 1.0
 * @Description:
 */
@Controller
@RequestMapping("pc")
public class PcNoteController {
    @Autowired
    private NoteService noteService;
    @Autowired
    private FileService fileService;

    /**
     * 搜索列表页面
     * @param keyword 关键字
     * @return
     */
    @RequestMapping("list")
    public String searchList(String keyword,Model model){
        model.addAttribute("total",noteService.selectCountByKeyword(keyword));
        model.addAttribute("keyword",keyword);
        model.addAttribute("newCourse",noteService.selectNew(2));
        return "pc/list";
    }

    /**
     * 详情界面
     * @return
     */
    @RequestMapping("note_details")
    public String noteDetails(Note note, Model model){
        List<Note> list = noteService.select(note);
        // 修改浏览量
        noteService.updateBrowseCount(note);
        if(list.size()!=0){
            note = list.get(0);
            String content = FileUtil.readFile(note.getNoteTxt());
            note.setNoteTxt(content);
            model.addAttribute("note",note);
            // 查询附件
            List<FileEntity> files = fileService.selectFileByNoteId(note.getNoteId());
            model.addAttribute("files",files);
        }
        return "pc/details";
    }

    /**
     * 更新笔记有效采用量
     * @param note
     * @return
     */
    @RequestMapping("updateUseCount")
    @ResponseBody
    public Result updateUseCount(Note note){
        Result result = new Result();
        int count = noteService.updateUseCount(note);
        if(count>0){
            result.setCode(0);
            result.setMsg("点赞成功，感谢你的支持");
        }else{
            result.setCode(400);
            result.setMsg("点赞失败，请再试一次");
        }
        return result;
    }

    /**
     * 更新笔记无效反馈量
     * @param note
     * @return
     */
    @RequestMapping("updateUnusedCount")
    @ResponseBody
    public Result updateUnusedCount(Note note){
        Result result = new Result();
        int count = noteService.updateUnusedCount(note);
        if(count>0){
            result.setCode(0);
            result.setMsg("谢谢你的反馈，我们会尽快查证！");
        }else{
            result.setCode(400);
            result.setMsg("反馈失败，请再试一次");
        }
        return result;
    }

    /**
     * 根据关键字搜索笔记
     * @param note
     * @return
     */
    @RequestMapping("select_note_keyword")
    @ResponseBody
    public Result selectNoteByKeyword(Note note){
        Result result = new Result();
        List<Note> list = noteService.selectNoteByKeyword(note);
        result.setCode(0);
        result.setData(list);
        return result;
    }
}
