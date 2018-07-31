package com.cfl.xuexispace.entity;

import com.cfl.xuexispace.utils.CommonUtils;
import lombok.Getter;
import lombok.Setter;

/**
 * @CreateUser: 李明
 * @CreateDate: 2018/6/23 21:40
 * @Version: 1.0
 * @Description: 笔记实体类
 */
@Setter
@Getter
public class Note extends Page {
    private String noteId;
    // 笔记标题
    private String noteTitle;
    // 笔记简介
    private String subtitle;
    // 笔记文本内容
    private String noteTxt;
    // 笔记类型 1：问答，2：教程
    private Integer noteType;
    // 笔记方向id
    private Integer directionId;
    // 笔记方向
    private Direction direction;
    // 标签
    private String tag;
    // 浏览量
    private Integer browseCount = 0;
    // 有效采用量
    private Integer useCount = 0;
    // 无效反馈量
    private Integer unusedCount = 0;
    // 状态：-1：删除，0：未发表，1：已发表
    private Integer status;
}
