package com.cfl.xuexispace.utils;

import java.io.*;

/**
 * @CreateUser: 李明
 * @CreateDate: 2018/7/20 20:20
 * @Version: 1.0
 * @Description: 文件操作工具类
 */
public class FileUtil {
    /**
     * 读取文件内容
     * @param path
     * @return
     */
    public static String readFile(String path){
        String content = "";
        InputStreamReader isr = null;
        BufferedReader read = null;
        try {
            File file = new File(path);
            isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
            read = new BufferedReader(isr);
            String tempContent = "";
            while ((tempContent=read.readLine())!=null){
                content+=tempContent;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(read!=null){
                try {
                    read.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return content;
    }

    /**
     * 把内容写成文件
     * @param path 文件地址
     * @param content 内容
     */
    public static void writeFile(String path,String content){
        FileOutputStream outSTr = null;
        BufferedOutputStream Buff = null;
        try{
            outSTr = new FileOutputStream(new File(path));
            Buff = new BufferedOutputStream(outSTr);
            Buff.write(content.getBytes());
            Buff.flush();
            Buff.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
