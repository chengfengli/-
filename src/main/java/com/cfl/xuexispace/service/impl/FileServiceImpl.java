package com.cfl.xuexispace.service.impl;

import com.cfl.xuexispace.entity.FileEntity;
import com.cfl.xuexispace.entity.Result;
import com.cfl.xuexispace.mapper.FileMapper;
import com.cfl.xuexispace.service.FileService;
import com.cfl.xuexispace.utils.CommonUtils;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

/**
 * @CreateUser: 李明
 * @CreateDate: 2018/7/4 20:07
 * @Version: 1.0
 * @Description:
 */
@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private FileMapper fileMapper;

    @Value("${upload.file.path.temp}")
    private String uploadPath_temp;
    @Value("${upload.file.path}")
    private String uploadPath;
    @Value("${file.url}")
    private String fileURL;
    /**
     * 文件上传
     * @param file 文件对象
     * @return
     */
    @Override
    public FileEntity uploadFile(MultipartFile file) throws Exception {
        // 文件名
        String fileName = file.getOriginalFilename();
        // 获取文件的扩展名
        String suffixName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        // 文件别名
        String alias = CommonUtils.getUuid()+suffixName;
        FileCopyUtils.copy(file.getInputStream(),new FileOutputStream(new File(uploadPath_temp+alias)));
        FileEntity fileEntity = new FileEntity();
        fileEntity.setFileName(fileName);
        fileEntity.setFileAlias(alias);
        fileEntity.setFileSize(this.getFileSize(file.getSize()));
        fileEntity.setFilePath(uploadPath+alias);
        fileEntity.setFileURL(fileURL+alias);
        return fileEntity;
    }

    /**
     * 根据笔记id查询附件
     * @param noteId
     * @return
     */
    @Override
    public List<FileEntity> selectFileByNoteId(String noteId){
        return fileMapper.selectFileByNoteId(noteId);
    }

    /**
     * 换算文件大小
     * @param size
     * @return
     */
    private String getFileSize(double size){
        String fileSize = "";
        if(size<1024){
            fileSize = (double)Math.round(size/1024*100)/100+"B";
        }else if(size<1024*1024){
            fileSize = (double)Math.round(size/1024/1024*100)/100+"KB";
        } else if(size<1024*1024*1024){
            fileSize = (double)Math.round(size/(1024*1024)*100)/100+"MB";
        }
        return fileSize;
    }

    /**
     * 删除文件，包括数据库和文件
     * @param fileId
     * @param path
     * @return
     */
    public int deleteFileData(String fileId,String path) throws IOException {
        File file = new File(path);
        FileUtils.forceDelete(file);
        return 0;
    }

    /**
     * 根据文件id查询文件
     * @param fileId
     * @return
     */
    public FileEntity selectFileById(Integer fileId){
        return fileMapper.selectFileById(fileId);
    }
}
