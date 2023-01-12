package com.tingshuo.common.core.utils;


import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.CompressionLevel;
import net.lingala.zip4j.model.enums.EncryptionMethod;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 类文件描述:
 * zip的处理操作，压缩、加密、解压
 *
 * @author yangz
 * @version 1.0.0
 * @date 2023年01月12日 20:51
 **/
public class ZipUtils {
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
    public static void ZipMenu(String fileZipName, String password, File file) {
        ZipParameters zipParameters = new ZipParameters();
        zipParameters.setEncryptFiles(true);
        zipParameters.setCompressionLevel(CompressionLevel.HIGHER);
        zipParameters.setEncryptionMethod(EncryptionMethod.AES);

        ZipFile zipFile = new ZipFile(fileZipName, password.toCharArray());
        try {
            zipFile.addFolder(file, zipParameters);
        } catch (ZipException e) {
            e.printStackTrace();
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
        ZipFile(file, "123456", "test01.zip");
        List<File> list = new ArrayList<File>();
        list.add(file);
        list.add(file2);
        //压缩多个文件
        ZipFileList(list, "123456", "test02.zip");
        File path= new File("D:\\testZip\\");
        //ZipMenu("test02.zip","123456",path);
        //解压多个文件
        //UnZipAll("test02.zip","123456","D:\\testZip");
        //解压当个文件
        unzipFile("test02.zip","123456","0001.txt","D:\\testZip\\0\\");
    }
}
