package com.aaa.until;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

public class FileUpUtil {
    //file上传的文件，files上传文件存放的文件夹地址
    public static String upFile(MultipartFile file, HttpServletRequest req, String files) throws IOException {
        //上传文件本地文件夹地址
        String dirStr = req.getServletContext().getRealPath("/")+"/"+files+"/";
        File dir=new File(dirStr);
        if(!dir.exists()) {//如果文件夹不存在
            dir.mkdir();//创建文件夹
        }
        //空文件传来
        if(file.getSize()==0){
            return null;
        }
        //文件名称
        String fileName = System.currentTimeMillis()+"."
                + FilenameUtils.getExtension(file.getOriginalFilename());
        //本地存储位置+文件名称
        String path = dirStr+fileName;
        System.out.println("路径"+path);
        //根据path定义目标文件
        File f = new File(path);
        //上传的文件复制到f中
        file.transferTo(f);
        //返回文件相对项目的存储位置
        return "/"+files+"/"+fileName;
    }
}
