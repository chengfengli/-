package com.cfl.xuexispace.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @CreateUser: 李明
 * @CreateDate: 2018/7/4 22:02
 * @Version: 1.0
 * @Description: 文件类
 */
@Getter
@Setter
public class FileEntity extends Page {
    // 文件id
    private Integer fileId;
    // 文件名称
    private String fileName;
    // 文件别名
    private String fileAlias;
    // 笔记id
    private String noteId;
    // 文件物理存储地址
    private String filePath;
    // 文案金网络地址
    private String fileURL;
    // 文件大小
    private String fileSize;
    // 下载量
    private Integer downloadCount = 0;
}
