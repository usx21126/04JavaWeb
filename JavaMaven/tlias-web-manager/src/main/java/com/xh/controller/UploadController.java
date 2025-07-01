package com.xh.controller;

import com.xh.entity.AliOSSProperties;
import com.xh.entity.Result;
import com.xh.utils.AliyunOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/upload")
public class UploadController {
//    @Value("${aliyun.oss.endpoint}")
//    private String endpoint;
//    @Value(("${aliyun.oss.bucket}"))
//    private String bucketName;
    @Autowired
    private AliOSSProperties aliOSSProperties;
    /**
     * 文件上传阿里云
     */
    @PostMapping
    public Result upload(MultipartFile file) throws Exception {
        log.info("参数:{}",file);
        String originFileName = file.getOriginalFilename();
        //后缀 .jpg
        String extName = originFileName.substring(originFileName.lastIndexOf("."));
        String url = AliyunOSSUtils.upload(aliOSSProperties.getEndpoint(), aliOSSProperties.getBucket(), file.getBytes(), extName);

        return Result.success(url);
    }
}
