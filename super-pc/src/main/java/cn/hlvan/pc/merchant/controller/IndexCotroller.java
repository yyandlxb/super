package cn.hlvan.pc.merchant.controller;

import cn.hlvan.pc.exception.ApplicationException;
import cn.hlvan.pc.util.Reply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
    private ResourceLoader resourceLoader;

    @Autowired
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @PostMapping("/file/upload")
    @ResponseBody
    public Map preview(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            throw new ApplicationException("上传文件失败");
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
        Map<String,String> map = new HashMap<>();
        map.put("code","0");
        map.put("msg",fileName);
        return map;
    }
    @GetMapping("/file/{fileName}")
    public ResponseEntity preview(@PathVariable String fileName) {
        try {
            // 由于是读取本机的文件，file是一定要加上的， path是在application配置文件中的路径
            return ResponseEntity.ok(resourceLoader.getResource("file:" +path+fileName));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
