package com.aiguigu.springboot.controller;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping("file")
public class FileController {

    //文件下载
    @RequestMapping("down")
    public void download(String fileName, HttpServletRequest request, HttpServletResponse response) throws IOException {
        //根据相对路径获取绝对路径
        String realPath = request.getServletContext().getRealPath("/files/download");
        //获取文件名，根据文件名去指定的目录读取文件
        FileInputStream is = new FileInputStream(new File(realPath, fileName));
        //设置下载时响应头
        //attachment为附件下载,inline为在线打开
        response.setHeader("content-disposition","attachment;fileName="+ URLEncoder.encode(fileName,"UTF-8"));
        //通过响应流响应即可
        ServletOutputStream outputStream = response.getOutputStream();
        //流的复制
        IOUtils.copy(is,outputStream);
        IOUtils.closeQuietly(is);
        IOUtils.closeQuietly(outputStream);
    }


    //文件上传
    //查看文件上传的参数及大小可以看MultipartProperties这个类
    @RequestMapping("upload")
    public String uploadFile(MultipartFile mFile, HttpServletRequest request) throws IOException {
        System.out.println("文件名: "+mFile.getOriginalFilename());
        System.out.println("文件类型: "+mFile.getContentType());
        System.out.println("文件大小: "+mFile.getSize());
        //根据相对路径获取绝对路径
        String realPath = request.getSession().getServletContext().getRealPath("/files");
        //创建时间文件夹
        String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        File file = new File(realPath, format);
        if(!file.exists()) file.mkdirs();
        //获取文件后缀
        String extension = FilenameUtils.getExtension(mFile.getOriginalFilename());

        //根据文件后缀动态获取文件类型
        //String mimeType = request.getSession().getServletContext().getMimeType("." + extension);
        //System.out.println("根据文件后缀动态获取文件类型: "+mimeType);

        String prefixName = UUID.randomUUID().toString().replace("-", "") +
                new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
        String newFileName = prefixName + "." + extension;
        //处理上传操作
        mFile.transferTo(new File(file,newFileName));
        return "redirect:/upload.jsp";
    }
}
