package com.cfl.xuexispace.controller.wap;

import com.cfl.xuexispace.entity.FileEntity;
import com.cfl.xuexispace.entity.Note;
import com.cfl.xuexispace.service.FileService;
import com.cfl.xuexispace.service.NoteService;
import com.cfl.xuexispace.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * @CreateUser: 李明
 * @CreateDate: 2018/7/11 20:08
 * @Version: 1.0
 * @Description: 手机wap端接口
 */
@Controller
@RequestMapping("wap")
public class WapIndexController {
    @Autowired
    private NoteService noteService;
    @Autowired
    private FileService fileService;
    /**
     * 首页
     * @param model
     * @return
     */
    @RequestMapping("/")
    public String wapIndex(Model model){
        Note note = new Note();
        note.setPage(1);
        note.setLimit(10);
        // 最新教程
        note.setNoteType(2);
        List<Note> list1 = noteService.select(note);
        model.addAttribute("list1",list1);

        // 最新问答
        note.setNoteType(1);
        List<Note> list2 = noteService.select(note);
        model.addAttribute("list2",list2);

        // 数据总览
        List<Map<String,Object>> list3 = noteService.countGroupDirection();
        model.addAttribute("list3",list3);

        // 热门教程
        List<Note> hotCourse = noteService.selectHot(2);
        model.addAttribute("hotCourse",hotCourse);

        // 热门问答
        List<Note> hotQuestion = noteService.selectHot(1);
        model.addAttribute("hotQuestion",hotQuestion);
        return "/wap/index";
    }

    /**
     * 搜索列表页面
     * @return
     */
    @RequestMapping("list")
    public String wapList(String keyword,Model model){
        Note note = new Note();
        note.setNoteTitle(keyword);
        List<Note> list = noteService.selectNoteByKeyword(note);
        model.addAttribute("total",noteService.selectCountByKeyword(keyword));
        model.addAttribute("keyword",keyword);
        model.addAttribute("list",list);
        return "wap/list";
    }

    /**
     * 详情页面
     * @param note
     * @param model
     * @return
     */
    @RequestMapping("details")
    public String wapDetails(Note note, Model model){
        List<Note> list = noteService.select(note);
        // 修改浏览量
        noteService.updateBrowseCount(note);
        if(list.size()!=0){
            note = list.get(0);
            String content = FileUtil.readFile(note.getNoteTxt());
            note.setNoteTxt(content);
            model.addAttribute("note",note);
            // 查询附件
            List<FileEntity> files = fileService.selectFileByNoteId(list.get(0).getNoteId());
            model.addAttribute("files",files);
        }
        return "/wap/details";
    }
}
