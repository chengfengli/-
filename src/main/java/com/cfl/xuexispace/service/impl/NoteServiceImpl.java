package com.cfl.xuexispace.service.impl;

import com.cfl.xuexispace.entity.Direction;
import com.cfl.xuexispace.entity.FileEntity;
import com.cfl.xuexispace.entity.Note;
import com.cfl.xuexispace.mapper.DirectionMapper;
import com.cfl.xuexispace.mapper.FileMapper;
import com.cfl.xuexispace.mapper.NoteMapper;
import com.cfl.xuexispace.service.NoteService;
import com.cfl.xuexispace.utils.CommonUtils;
import com.cfl.xuexispace.utils.DateUtils;
import com.cfl.xuexispace.utils.FileUtil;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @CreateUser: 李明
 * @CreateDate: 2018/6/23 22:34
 * @Version: 1.0
 * @Description:
 */
@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteMapper noteMapper;
    @Autowired
    private DirectionMapper directionMapper;
    @Autowired
    private FileMapper fileMapper;
    @Value("${upload.file.path.temp}")
    private String uploadPath_temp;
    @Value("${upload.file.path}")
    private String uploadPath;

    /**
     * 新增笔记
     * @param note 笔记
     * @param fileList 文件
     * @param delNewFiles 要删除的文件名称
     * @return
     */
    @Override
    @Transactional
    public int insert(Note note,String fileList,String[] delNewFiles){
        int count = 0;
        try {
            // 生成笔记id
            String noteId = CommonUtils.getUuid();
            note.setNoteId(noteId);
            note.setCreateTime(DateUtils.nowNetworkDate1());
            List<FileEntity> list = new ArrayList<FileEntity>();
            if(CommonUtils.isNotEmpty(fileList)){
                JSONArray array = JSONArray.fromObject(fileList);
                list = array.toList(array,new FileEntity(),new JsonConfig());
            }

            for(int i=0;i<list.size();i++){
                String alias = list.get(i).getFileAlias();
                // 拷贝临时目录文件到正式目录
                FileCopyUtils.copy(new FileInputStream(new File(uploadPath_temp+alias)),new FileOutputStream(new File(uploadPath+alias)));
                // 删除临时目录中的文件
                FileUtils.forceDelete(new File(uploadPath_temp + alias));
                list.get(i).setNoteId(noteId);
                list.get(i).setCreateTime(DateUtils.nowNetworkDate1());
                // 保存文件信息
                fileMapper.insertFile(list.get(i));
            }
            // 删除新上传文件中要删除的文件
            if(CommonUtils.isNotEmpty(delNewFiles) && delNewFiles.length>0){
                for(int i=0;i<delNewFiles.length;i++){
                    FileUtils.forceDelete(new File(uploadPath_temp + delNewFiles[i]));
                }
            }

            //把内容存储为文件
            //生成文件名
            String path = uploadPath+CommonUtils.getUuid()+".txt";
            FileUtil.writeFile(path,note.getNoteTxt());
            note.setNoteTxt(path);
            count = noteMapper.insert(note);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     * 查询笔记
     * @param note
     * @return
     */
    @Override
    public List<Note> select(Note note){
        return noteMapper.select(note);
    }

    /**
     * 查询笔记数量
     * @param note
     * @return
     */
    @Override
    public Integer selectCount(Note note){
        return noteMapper.selectCount(note).size();
    }

    /**
     * 按方向统计数量
     * @return
     */
    @Override
    public List<Map<String,Object>> countGroupDirection(){
        List<Direction> list = directionMapper.select(null);
        Note note = new Note();
        List<Map<String,Object>> list2 = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            note.setDirectionId(list.get(i).getDirectionId());
            int count = noteMapper.selectCount(note).size();
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("name",list.get(i).getDirectionName());
            map.put("value",count);
            list2.add(map);
        }
        return list2;
    }

    /**
     * 删除笔记
     * @param id
     * @return
     */
    @Override
    @Transactional
    public int deleteNote(String id){
        String[] ids = id.split(",");
        return noteMapper.delete(ids);
    }

    /**
     * 通过id查询笔记
     * @param note
     * @return
     */
    @Override
    public Note selectNoteById(Note note){
        note = noteMapper.selectNoteById(note);
        String content = FileUtil.readFile(note.getNoteTxt());
        note.setNoteTxt(content);
        return note;
    }

    /**
     * 修改笔记
     * @param note
     * @param fileList 新上传的文件
     * @param delNewFiles 新上传但要删除的文件
     * @param haveFiles 已经存在但要删除的文件
     * @return
     */
    @Override
    @Transactional
    public int update(Note note,String fileList,String[] delNewFiles,String haveFiles){
        int count = 0;
        try {
            note.setUpdateTime(DateUtils.nowNetworkDate1());
            List<FileEntity> list = new ArrayList<FileEntity>();
            if(CommonUtils.isNotEmpty(fileList)){
                JSONArray array = JSONArray.fromObject(fileList);
                list = array.toList(array,new FileEntity(),new JsonConfig());
            }

            for(int i=0;i<list.size();i++){
                String alias = list.get(i).getFileAlias();
                // 拷贝临时目录文件到正式目录
                FileCopyUtils.copy(new FileInputStream(new File(uploadPath_temp+alias)),new FileOutputStream(new File(uploadPath+alias)));
                // 删除临时目录中的文件
                FileUtils.forceDelete(new File(uploadPath_temp + alias));
                // 保存文件信息
                list.get(i).setNoteId(note.getNoteId());
                list.get(i).setCreateTime(DateUtils.nowNetworkDate1());
                fileMapper.insertFile(list.get(i));
            }
            // 删除新上传文件中需要上传的文件
            if(CommonUtils.isNotEmpty(delNewFiles) && delNewFiles.length>0){
                for(int i=0;i<delNewFiles.length;i++){
                    FileUtils.forceDelete(new File(uploadPath_temp + delNewFiles[i]));
                }
            }

            // 删除已有的文件
            List<FileEntity> have_file_list = new ArrayList<FileEntity>();
            if(CommonUtils.isNotEmpty(haveFiles)){
                JSONArray array = JSONArray.fromObject(haveFiles);
                have_file_list = array.toList(array,new FileEntity(),new JsonConfig());
            }
            for(int i=0;i<have_file_list.size();i++){
                fileMapper.deleteFile(have_file_list.get(i).getFileId());
                FileUtils.forceDelete(new File(uploadPath + have_file_list.get(i).getFileAlias()));
            }
            String path = noteMapper.selectNoteById(note).getNoteTxt();
            FileUtil.writeFile(path,note.getNoteTxt());
            note.setNoteTxt(path);
            count = noteMapper.update(note);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     * 修改笔记浏览量
     * @param note
     * @return
     */
    @Override
    @Transactional
    public int updateBrowseCount(Note note){
        return noteMapper.updateBrowseCount(note);
    }

    /**
     * 更新笔记有效采用量
     * @param note
     * @return
     */
    @Override
    @Transactional
    public int updateUseCount(Note note){
        return noteMapper.updateUseCount(note);
    }

    /**
     * 更新笔记无效反馈量
     * @param note
     * @return
     */
    @Override
    @Transactional
    public int updateUnusedCount(Note note){
        return noteMapper.updateUnusedCount(note);
    }

    /**
     * 热门笔记排行查询
     * @param type 类型，1：问答，2：教程
     * @return
     */
    public List<Note> selectHot(Integer type){
        return noteMapper.selectHot(type);
    }

    /**
     * 关键字搜索笔记
     * @param note
     * @return
     */
    public List<Note> selectNoteByKeyword(Note note){
        return noteMapper.selectNoteByKeyword(note);
    }

    /**
     * 根据关键字获取数据总数量
     * @param keyword
     * @return
     */
    public int selectCountByKeyword(String keyword){
        return noteMapper.selectCountByKeyword(keyword).size();
    }

    /**
     * 最新推荐
     * @param type 类型，1：问答，2：教程
     * @return
     */
    public List<Note> selectNew(Integer type){
        return noteMapper.selectNew(type);
    }

    /**
     * 各方向访问量排行Top10
     * @return
     */
    public Map<String,Integer> browseTopGroupByDirection(){
        List<Note> notes = noteMapper.browseTopGroupByDirection();
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<notes.size();i++){
            map.put(notes.get(i).getNoteTxt(),notes.get(i).getBrowseCount());
        }
        return map;
    }

    /**
     * 有用/无用笔记
     * @param type
     * @return
     */
    public List<Note> selectByUse(String type){
        return noteMapper.selectByUse(type);
    }
}
