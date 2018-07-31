package com.cfl.xuexispace.controller.bg;

import com.cfl.xuexispace.entity.FileEntity;
import com.cfl.xuexispace.entity.Result;
import com.cfl.xuexispace.service.FileService;
import com.cfl.xuexispace.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @CreateUser: 李明
 * @CreateDate: 2018/6/26 21:54
 * @Version: 1.0
 * @Description:
 */
@Controller
@RequestMapping("file")
public class FileController {
    @Autowired
    private FileService fileService;
    /**
     * 上传附件
     * @param request
     * @param file
     * @return
     */
    @RequestMapping("upload")
    @ResponseBody
    public Result upload(HttpServletRequest request, @RequestParam("file") MultipartFile file,String id) {
        Result result  = new Result();
        try {
            FileEntity fileEntity = fileService.uploadFile(file);
            fileEntity.setCreateUser(CommonUtils.getCurrentUser(request).getUserName());
            result.setCode(0);
            result.setData(fileEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 文件下载
     * @param fileId
     * @param response
     * @param request
     */
    @RequestMapping("download")
    @ResponseBody
    public void downLoad(Integer fileId, HttpServletResponse response, HttpServletRequest request){
        try{
            FileEntity fileEntity = fileService.selectFileById(fileId);
            //获得文件实际名称
            String fileName = fileEntity.getFileName();
            //设置文件MIME类型
            response.setContentType(request.getServletContext().getMimeType(fileName));
            //设置Content-Disposition
            response.setHeader("Content-Disposition", "attachment;filename="+fileName);

            //读取文件，通过response将目标文件写到客户端
            //获取文件的物理存储地址
            String filePath = fileEntity.getFilePath();
            //读取文件
            InputStream in = new FileInputStream(filePath);
            OutputStream out = response.getOutputStream();
            //写文件
            int b;
            while((b=in.read())!= -1) {
                out.write(b);
            }
            in.close();
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
