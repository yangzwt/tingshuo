package com.tingshuo.common.core.utils;


import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.CompressionLevel;
import net.lingala.zip4j.model.enums.EncryptionMethod;
import org.apache.commons.logging.Log;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.aspectj.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * 类文件描述:
 * zip的处理操作，压缩、加密、解压
 *
 * @author yangz
 * @version 1.0.0
 * @date 2023年01月12日 20:51
 **/
public class ZipUtils {

    private static final Logger log = LoggerFactory.getLogger(ZipUtils.class);
    /**
     * 压缩单个文件
     *
     * @param file
     */
    public static void ZipFile(File file, String password, String fileZipName) {
        ZipParameters zipParameters = new ZipParameters();
        zipParameters.setEncryptFiles(true);
        zipParameters.setCompressionLevel(CompressionLevel.HIGHER);
        zipParameters.setEncryptionMethod(EncryptionMethod.AES);
        ZipFile zipFile = new ZipFile(fileZipName, password.toCharArray());
        try {
            zipFile.addFile(file, zipParameters);
        } catch (ZipException e) {
            e.printStackTrace();
        } finally {
            try {
                zipFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 压缩多个文件
     *
     * @param fileList
     */
    public static void ZipFileList(List<File> fileList, String password, String fileZipName) {
        ZipParameters zipParameters = new ZipParameters();
        zipParameters.setEncryptFiles(true);
        zipParameters.setCompressionLevel(CompressionLevel.HIGHER);
        zipParameters.setEncryptionMethod(EncryptionMethod.AES);

        ZipFile zipFile = new ZipFile(fileZipName, password.toCharArray());
        try {
           /* List<File> filesToAdd = Arrays.asList(
                    new File("aFile.txt"),
                    new File("bFile.txt")
            );*/
            List<File> filesToAdd = fileList;
            zipFile.addFiles(filesToAdd, zipParameters);
        } catch (ZipException e) {
            e.printStackTrace();
        } finally {
            try {
                zipFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 压缩文件目录
     *
     * @param fileZipName 压缩包文件名称
     * @param password    对应的密码
     * @param file        文件目录
     */
    public  boolean ZipMenu(String fileZipName, String password, File file) {
        ZipParameters zipParameters = new ZipParameters();
        zipParameters.setEncryptFiles(true);
        zipParameters.setCompressionLevel(CompressionLevel.HIGHER);
        zipParameters.setEncryptionMethod(EncryptionMethod.AES);

        ZipFile zipFile = new ZipFile(fileZipName, password.toCharArray());
        try {
            zipFile.addFolder(file, zipParameters);
            return true;
        } catch (ZipException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 按照文件大小进行分割压缩
     *
     * @param fileZipName zip包名称
     * @param password    对应的密码
     * @param file        文件
     */

    public static void Zip(String fileZipName, String password, File file) {
        ZipParameters zipParameters = new ZipParameters();
        zipParameters.setEncryptFiles(true);
        zipParameters.setCompressionLevel(CompressionLevel.HIGHER);
        zipParameters.setEncryptionMethod(EncryptionMethod.AES);

        ZipFile zipFile = new ZipFile(fileZipName, password.toCharArray());
        int splitLength = 1024 * 1024 * 10; //10MB 按照多少进行分割
        try {
            zipFile.createSplitZipFile(Arrays.asList(file), zipParameters, true, splitLength);
        } catch (ZipException e) {
            e.printStackTrace();
        }
    }

    /****
     * 将文件分割成多个文件
     * @param fileZipName 分割的zip文件
     * @param password 对应的文密码
     * @param file 文件
     */
    public static void ZipAll(String fileZipName, String password, File file) {
        ZipParameters zipParameters = new ZipParameters();
        zipParameters.setEncryptFiles(true);
        zipParameters.setCompressionLevel(CompressionLevel.HIGHER);
        zipParameters.setEncryptionMethod(EncryptionMethod.AES);
        ZipFile zipFile = new ZipFile(fileZipName, password.toCharArray());
        int splitLength = 1024 * 1024 * 10; //10MB 按照多少进行分割 字节
        try {
            zipFile.createSplitZipFileFromFolder(file, zipParameters, true, splitLength);
        } catch (ZipException e) {
            e.printStackTrace();
        }
    }

    /**
     * 提取多个文件
     *
     * @param fileZipName 压缩包名称
     * @param password    对应的密码
     * @param path        解压的位置
     */
    public static void UnZipAll(String fileZipName, String password, String path) {
        ZipFile zipFile = new ZipFile(fileZipName, password.toCharArray());
        try {
            zipFile.extractAll(path);
        } catch (ZipException e) {
            e.printStackTrace();
        }
    }

    /**
     * 解压单个文件
     *
     * @param fileZipName 解压的压缩包名称
     * @param password    压缩包的名称
     * @param file        对应文件
     * @param path        解压后的路径
     */
    public static void unzipFile(String fileZipName, String password, String file, String path) {
        ZipFile zipFile = new ZipFile(fileZipName, password.toCharArray());
        try {
            zipFile.extractFile(file, path);
        } catch (ZipException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {

        File file = new File("D:\\testZip\\0001.txt");
        File file2 = new File("D:\\testZip\\0002.txt");
        //压缩单个文件
        //ZipFile(file, "123456", "test01.zip");
        List<File> list = new ArrayList<File>();
        list.add(file);
        list.add(file2);
        //压缩多个文件
        //ZipFileList(list, "123456", "test02.zip");
        String pathOld="D:\\testZip\\";
        File path= new File(pathOld);
        String newPath="D:\\testNew\\"+"testZipNew.zip";
      /*  boolean b = ZipMenu(newPath, "123456", path);
        if (b){
            Path path1 = Paths.get(pathOld);
            try {
                Stream<Path> walk = Files.walk(path1);
                walk.sorted(Comparator.reverseOrder()).forEach(ZipUtils::deleteDirectoryStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
        //解压多个文件
        //UnZipAll("test02.zip","123456","D:\\testZip");
        //解压当个文件
        //unzipFile("test02.zip","123456","0001.txt","D:\\testZip\\0\\");
    }
    public void deleteDirectoryStream(Path path) {
        try {
            Files.delete(path);
            log.info("删除文件成功：%s%n", path.toString());
        } catch (IOException e) {
            log.error("无法删除的路径 %s%n%s", path, e);
        }
    }
}
