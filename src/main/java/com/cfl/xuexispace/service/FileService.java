package com.cfl.xuexispace.service;

import com.cfl.xuexispace.entity.FileEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.List;

/**
 * @CreateUser: 李明
 * @CreateDate: 2018/7/4 20:06
 * @Version: 1.0
 * @Description:
 */
public interface FileService {
    public FileEntity uploadFile(MultipartFile file) throws Exception;

    public List<FileEntity> selectFileByNoteId(String noteId);

    public FileEntity selectFileById(Integer fileId);
}
