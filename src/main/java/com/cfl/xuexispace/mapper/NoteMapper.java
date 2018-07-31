package com.cfl.xuexispace.mapper;

import com.cfl.xuexispace.entity.Note;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @CreateUser: 李明
 * @CreateDate: 2018/6/23 22:32
 * @Version: 1.0
 * @Description: 笔记mapper层
 */
public interface NoteMapper {
    public int insert(Note note);

    public List<Note> select(Note note);

    public List<Note> selectCount(Note note);

    public int delete(String[] ids);

    public Note selectNoteById(Note note);

    /**
     * 更新笔记
     * @param note
     * @return
     */
    public int update(Note note);

    /**
     * 更新笔记浏览量
     * @param note
     * @return
     */
    public int updateBrowseCount(Note note);

    /**
     * 更新笔记有效采用量
     * @param note
     * @return
     */
    public int updateUseCount(Note note);

    /**
     * 更新笔记无效反馈量
     * @param note
     * @return
     */
    public int updateUnusedCount(Note note);

    /**
     * 热门笔记排行查询
     * @param type 类型，1：问答，2：教程
     * @return
     */
    public List<Note> selectHot(Integer type);

    /**
     * 关键字搜索笔记
     * @param note
     * @return
     */
    public List<Note> selectNoteByKeyword(Note note);

    /**
     * 根据关键字获取数据总数量
     * @param keyword
     * @return
     */
    public List<Note> selectCountByKeyword(String keyword);

    /**
     * 最新推荐
     * @param type 类型，1：问答，2：教程
     * @return
     */
    public List<Note> selectNew(Integer type);

    /**
     * 各方向访问量排行Top10
     * @return
     */
    public List<Note> browseTopGroupByDirection();

    /**
     * 有用/无用笔记
     * @param type
     * @return
     */
    public List<Note> selectByUse(@Param("type") String type);

}
