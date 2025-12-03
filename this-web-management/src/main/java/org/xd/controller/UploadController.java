package org.xd.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.xd.pojo.Result;
import org.xd.utils.AliyunOSSOperator;

@Slf4j
@RestController
public class UploadController {

    private static final String UPLOAD_DIR = "D:/images/";
    /**
     * 上传文件 - 参数名file
     */
    /*    @PostMapping("/upload")
        public Result upload(String name, Integer age, MultipartFile file) throws Exception {
            log.info("上传文件：{}, {}, {}", name, age, file);

            // 生成唯一文件名
            String originalFilename = file.getOriginalFilename();

            // 保存文件
            file.transferTo(new File("D:/images/"+originalFilename));

            return Result.success();
        }*/
    /**
     * 本地磁盘存储
     */
    /*    @PostMapping("/upload")
        public Result upload(String name, Integer age, MultipartFile file) throws Exception {
            log.info("上传文件：{}, {}, {}", name, age, file);
            if (!file.isEmpty()) {
                // 生成唯一文件名
                String originalFilename = file.getOriginalFilename();
                String extName = originalFilename.substring(originalFilename.lastIndexOf("."));
                String uniqueFileName = UUID.randomUUID().toString().replace("-", "") + extName;
                // 拼接完整的文件路径
                File targetFile = new File(UPLOAD_DIR + uniqueFileName);

                // 如果目标目录不存在，则创建它
                if (!targetFile.getParentFile().exists()) {
                    targetFile.getParentFile().mkdirs();
                }
                // 保存文件
                file.transferTo(targetFile);
            }
            return Result.success();
        }*/
    /**
     * 阿里云OSS存储
     */
    @Autowired
    private AliyunOSSOperator aliyunOSSOperator;
    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws Exception {
        log.info("上传文件：{}", file.getOriginalFilename());
        if (!file.isEmpty()) {
            // 上传到阿里云OSS
            String fileUrl = aliyunOSSOperator.upload(file.getBytes(), file.getOriginalFilename());
            log.info("文件上传成功，访问地址：{}", fileUrl);
            return Result.success(fileUrl);
        } else {
            return Result.fail("文件为空，上传失败");
        }
    }

}