package com.tingshuo.system.file.controller;

import com.tingshuo.common.core.utils.ZipUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.stream.Stream;

/**
 * 类文件描述:
 * 文件下載
 * @author yangz
 * @version 1.0.0
 * @date 2023年01月13日 21:11
 **/
@RestController
@RequestMapping(value = "/api")
public class ZipFileController {
    private static final Logger logger = LoggerFactory.getLogger(ZipFileController.class);

    @GetMapping("/download")
    public void download(HttpServletResponse response, Integer userId, String fileUrl) {
        boolean b = false;
        String pathOld = "D:\\testZip\\";
        ZipUtils zipUtil = new ZipUtils();
        String fileNameNew = "testZipNew.zip";
        String newPath = "D:\\testNew\\";
        String newPathFileName = newPath + fileNameNew;
        try {
           /* File file = new File(fileUrl);
            String filename = file.getName();*/

            File path = new File(pathOld);
            //压缩指定目录下的文件
            b = zipUtil.ZipMenu(newPathFileName, "123456", path);
            // 以流的形式下载文件。
            InputStream fis = new BufferedInputStream(new FileInputStream(newPathFileName));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();

            response.setContentType("application/octet-stream;charset=UTF-8");
            String fileName = new String(fileNameNew.getBytes("gb2312"), "iso8859-1");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName);
            OutputStream ouputStream = response.getOutputStream();
            ouputStream.write(buffer);
            ouputStream.flush();
            ouputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("下载文件失败");
        } finally {
            if (b) {
                //下载成功删除文件
                Path path1 = Paths.get(pathOld);
                Path path2 = Paths.get(newPath);
                try {
                    Stream<Path> walk = Files.walk(path1);
                    walk.sorted(Comparator.reverseOrder()).forEach(zipUtil::deleteDirectoryStream);
                    Stream<Path> walknew = Files.walk(path2);
                    walknew.sorted(Comparator.reverseOrder()).forEach(zipUtil::deleteDirectoryStream);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
