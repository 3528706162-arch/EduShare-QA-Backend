package org.example.edushare_qa.Controller;

import lombok.extern.slf4j.Slf4j;
import org.example.edushare_qa.Pojo.Result;
import org.example.edushare_qa.Utils.AliyunOSSOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
public class UploadController {
    /*  @PostMapping("/upload")
      public Result upload(String name, Integer age, MultipartFile  file) throws IOException {
          log.info("接受的参数:{},{},{}",name,age,file);
          //获取原始文件名
          String originalFilename = file.getOriginalFilename();
          //新文件名
          String extension=originalFilename.substring(originalFilename.lastIndexOf("."));
          String newFileName = UUID.randomUUID().toString()+extension;
          //保存文件
          file.transferTo(new File("D:/idea/JavaWeb/images/"+newFileName));
          return Result.success();*/
    @Autowired
    private AliyunOSSOperator aliyunOSSOperator;
    @PostMapping("/api/v1/Fileupload")
    public Result Upload(MultipartFile file) throws Exception {
        log.info("文件上传:{}", file.getOriginalFilename());
        //将文件交给OSS存储管理
        String url = aliyunOSSOperator.upload(file.getBytes(), file.getOriginalFilename());
        log.info("文件上传到OSS,url:{}", url);
        return Result.success(url);
    }
}
