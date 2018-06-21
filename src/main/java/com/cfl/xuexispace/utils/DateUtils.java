package com.cfl.xuexispace.utils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @CreateUser: 李明
 * @CreateDate: 2018/6/19 22:27
 * @Version: 1.0
 * @Description: 时间工具类
 */
public class DateUtils {
    /**
     * 时间格式化
     * @param date
     * @return
     */
    public static String dateToString(Date date,String format){
        SimpleDateFormat sdf=new SimpleDateFormat(format);
        String str = sdf.format(date);
        return str;
    }
    /**
     * 获取当前本地时间
     * @return
     */
    public static String nowLocalDate(){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String str = sdf.format(new Date());
        return str;
    }
    /**
     * 获取时间戳
     * @return
     */
    public static String dateTime(Date date){
        long time = date.getTime();
        return Long.toString(time);
    }

    /**
     * 获取当前网络时间
     * @return
     */
    public static String nowNetworkDate1(){
        String webUrl = "http://www.baidu.com";// 百度
        try {
            URL url = new URL(webUrl);
            URLConnection conn = url.openConnection();
            conn.connect();
            long dateL = conn.getDate();
            Date date = new Date(dateL);
            SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
            return dateFormat.format(date);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 获取当前网络时间
     * @return
     */
    public static Date nowNetworkDate2(){
        String webUrl = "http://www.baidu.com";// 百度
        try {
            URL url = new URL(webUrl);
            URLConnection conn = url.openConnection();
            conn.connect();
            long dateL = conn.getDate();
            Date date = new Date(dateL);
            return date;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
