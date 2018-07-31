package com.cfl.xuexispace.mapper;

import com.cfl.xuexispace.entity.FileEntity;

import java.util.List;
/**
 * @CreateUser: 李明
 * @CreateDate: 2018/7/5 21:19
 * @Version: 1.0
 * @Description: 文件上传信息操作
 */
public interface FileMapper {
    /**
     * 保存文件信息到数据库
     * @param fileEntity
     * @return
     */
    public int insertFile(FileEntity fileEntity);

    /**
     * 根据笔记id查询附件
     * @param noteId
     * @return
     */
    public List<FileEntity> selectFileByNoteId(String noteId);

    /**
     * 根据文件id删除文件
     * @param fileId
     * @return
     */
    public int deleteFile(Integer fileId);

    /**
     * 根据文件id查询文件信息
     * @param fileId
     * @return
     */
    public FileEntity selectFileById(Integer fileId);
}
