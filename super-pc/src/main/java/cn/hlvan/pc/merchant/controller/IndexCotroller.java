package cn.hlvan.pc.merchant.controller;

import cn.hlvan.pc.util.Reply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/merchant")
public class IndexCotroller {

    private static Logger logger = LoggerFactory.getLogger(IndexCotroller.class);
    @Value("${file.path}")
    private String path;
    @RequestMapping("/index")
    public String index(){
        return "/merchant/index";
    }

    @PostMapping("/file/upload")
    @ResponseBody
    public Reply preview(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return Reply.fail().message("上传文件失败");
        }
        String fileName = System.currentTimeMillis()+file.getOriginalFilename();
        String filePathName = path + fileName;
        File dest = new File(filePathName);
        if (!dest.getParentFile().exists()) { //判断文件父目录是否存在
            dest.getParentFile().mkdir();
        }
        try {
            file.transferTo(dest); //保存文件
        } catch (IllegalStateException | IOException e) {
            logger.info("上传文件失败", e);
        }

        return Reply.success().data(fileName);
    }
}
