package com.cfl.xuexispace.service;

import com.cfl.xuexispace.entity.Note;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @CreateUser: 李明
 * @CreateDate: 2018/6/23 22:33
 * @Version: 1.0
 * @Description:
 */
public interface NoteService {
    public int insert(Note note,String fileList,String[] newFiles);

    public List<Note> select(Note note);

    public Integer selectCount(Note note);

    public List<Map<String,Object>> countGroupDirection();

    public int deleteNote(String id);

    public Note selectNoteById(Note note);

    public int update(Note note,String fileList,String[] delNewFiles,String haveFiles);

    public int updateBrowseCount(Note note);

    public int updateUseCount(Note note);

    public int updateUnusedCount(Note note);

    public List<Note> selectHot(Integer type);

    public List<Note> selectNoteByKeyword(Note note);

    public int selectCountByKeyword(String keyword);

    public List<Note> selectNew(Integer type);

    public Map<String,Integer> browseTopGroupByDirection();

    public List<Note> selectByUse(String type);

}
