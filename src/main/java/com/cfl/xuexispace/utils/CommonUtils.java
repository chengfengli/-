package com.cfl.xuexispace.utils;

import com.cfl.xuexispace.entity.User;
import net.sf.json.JSONObject;
import org.apache.commons.codec.binary.Base64;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;

/**
 * @CreateUser: 李明
 * @CreateDate: 2018/6/18 17:07
 * @Version: 1.0
 * @Description:
 */
public class CommonUtils {
    /**
     * 判断对象为空
     * @param obj
     * @return
     */
    public static boolean isEmpty(Object obj){
        if (obj == null) {
            return true;
        } else if (obj instanceof String && (obj.toString().trim().equals(""))) {
            return true;
        } else if (obj instanceof Collection && ((Collection) obj).isEmpty()) {
            return true;
        } else if (obj instanceof Map && ((Map) obj).isEmpty()) {
            return true;
        } else if (obj instanceof Object[] && ((Object[]) obj).length == 0) {
            return true;
        }
        return false;
    }

    /**
     * 判断对象不为空
     * @param obj
     * @return
     */
    public static boolean isNotEmpty(Object obj){
        return !isEmpty(obj);
    }

    /**
     * md5加密
     * @param str
     * @return
     */
    public static String md5(String str){
        if(isNotEmpty(str)){
            String newStr = "";
            try {
                MessageDigest md5 = MessageDigest.getInstance("MD5");
                Base64 base64en = new Base64();
                newStr = base64en.encodeAsString(md5.digest(str.getBytes()));
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            return newStr;
        }else{
            return "";
        }
    }

    /**
     * 生成唯一ID
     * @return
     */
    public static String getUuid() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-","");
    }

    /**
     * 组装字符串
     * @param ss  字符串列表
     * @param split 分割符
     * @return  组合过后字符串
     */
    public static String combination(String[] ss,String split) {
        if(ss.length==0)
            return null;
        StringBuffer sb = new StringBuffer();
        for (String str : ss) {
            sb.append(str);
            sb.append(split);
        }
        return sb.toString().substring(0, sb.length() - 1);
    }

    /**
     * 获取客户端的ip地址
     * @param request
     * @return
     */
    public static String getClientIP(HttpServletRequest request){
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * 获取IP地址的归属地
     * @param ip
     * @return
     */
    public static String getIpCity(String ip) {
        //淘宝IP地址库：http://ip.taobao.com/instructions.php
        String add = null;
        try {
            //URL U = new URL("http://ip.taobao.com/service/getIpInfo.php?ip=114.111.166.72");
            URL U = new URL("http://ip.taobao.com/service/getIpInfo.php?ip="+ip);
            URLConnection connection = U.openConnection();
            connection.connect();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String result = "";
            String line;
            while ((line = in.readLine())!= null){
                result += line;
            }
            in.close();
            JSONObject jsonObject = JSONObject.fromObject(result);
            Map<String, Object> map = (Map) jsonObject;
            String code = String.valueOf(map.get("code"));//0：成功，1：失败。
            if("1".equals(code)){//失败
                String data = String.valueOf(map.get("data"));//错误信息
            }else if("0".equals(code)){//成功
                Map<String, Object> data = (Map<String, Object>) map.get("data");

                String country = String.valueOf(data.get("country"));//国家
                String area = String.valueOf(data.get("area"));//
                String city = String.valueOf(data.get("city"));//省（自治区或直辖市）
                String region = String.valueOf(data.get("region"));//市（县）
                add = country+"-"+city+"-"+region;
            }
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return add;
    }

    /**
     * 获取当前用户的信息
     * @param request
     * @return
     */
    public static User getCurrentUser(HttpServletRequest request){
        return (User)request.getSession().getAttribute("user");
    }
}
