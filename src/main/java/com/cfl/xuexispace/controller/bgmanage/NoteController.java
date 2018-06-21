package com.cfl.xuexispace.controller.bgmanage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @CreateUser: 李明
 * @CreateDate: 2018/6/10 13:59
 * @Version: 1.0
 * @Description:
 */
@Controller
@RequestMapping("bgmanage/note")
public class NoteController {

    @RequestMapping("list")
    public String toNoteList(){
        return "bgmanage/note_list";
    }

    @RequestMapping("edit")
    public String toEditNote(){
        return "bgmanage/edit_note";
    }
}
