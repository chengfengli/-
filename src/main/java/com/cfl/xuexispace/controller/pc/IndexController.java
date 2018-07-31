package com.cfl.xuexispace.controller.pc;

import com.cfl.xuexispace.entity.Note;
import com.cfl.xuexispace.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * @CreateUser: 李明
 * @CreateDate: 2018/6/30 15:58
 * @Version: 1.0
 * @Description:
 */
@Controller
@RequestMapping("pc")
public class IndexController {
    @Autowired
    private NoteService noteService;

    @RequestMapping("/")
    public String index(Model model){
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
        return "/pc/index";
    }
}
