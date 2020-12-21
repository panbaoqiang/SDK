package com.bosssoft.gpmscloud.utils;

import cn.hutool.core.io.file.FileReader;
import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.security.MessageDigest;

/**
 * MD5计算组件
 */
@Slf4j
public class MD5Util {
    protected static char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
//    protected static MessageDigest messageDigest = null;
//
//    static {
//        try {
//            messageDigest = MessageDigest.getInstance("MD5");
//        } catch (NoSuchAlgorithmException e) {
//            log.error("{}初始化失败，MessageDigest不支持MD5", MD5Util.class.getName());
//            e.printStackTrace();
//        }
//    }


    public static boolean validatedMd5(InputStream fileIs, String expectMd5) {
        if (fileIs != null) {
            String fileMd5 = getFileMD5(fileIs);
            return fileMd5.equals(expectMd5);
        }
        return false;
    }

    public static String getMD5(String source) {
        FileReader fileReader = new FileReader(source);
        return getFileMD5(fileReader.getInputStream());
    }

    public static String getFileMD5(InputStream fis) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            byte[] buffer = new byte[1024];
            int numRead = 0;
            while ((numRead = fis.read(buffer)) > 0) {
                messageDigest.update(buffer, 0, numRead);
            }
            fis.close();
        } catch (Exception e) {
            log.info("md5计算失败");
            e.printStackTrace();
            return "";
        }
        return bufferToHex(messageDigest.digest());
    }

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                FileInputStream fis = new FileInputStream("D:\\安装包\\eureka-0.0.1-SNAPSHOT.jar");
                String fileMD5 = MD5Util.getFileMD5(fis);
                System.out.println("eureka-0.0.1-SNAPSHOT.jar的md5：" + fileMD5);
                System.out.println("eureka-0.0.1-SNAPSHOT.jar的期望的md5：e56af7c862c161cbd7aa064357679c8a");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                FileInputStream fis = new FileInputStream("D:\\安装包\\BaiduNetdisk_7.0.5.9.exe");
                String fileMD5 = MD5Util.getFileMD5(fis);
                System.out.println("BaiduNetdisk_7.0.5.9.exe的md5：" + fileMD5);
                System.out.println("BaiduNetdisk_7.0.5.9.exe的期望的md5：fed37d52a2a4bce9711f0f2254de5f06");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                FileInputStream fis = new FileInputStream("D:\\安装包\\jdk-8u171-windows-x64.exe");
                String fileMD5 = MD5Util.getFileMD5(fis);
                System.out.println("jdk-8u171-windows-x64.exe的md5：" + fileMD5);
                System.out.println("jdk-8u171-windows-x64.exe的期望的md5：190c8f5b344cfe7ecf4aa6f80c9f517f");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                FileInputStream fis = new FileInputStream("D:\\安装包\\eureka-0.0.1-SNAPSHOT.jar");
                String fileMD5 = MD5Util.getFileMD5(fis);
                System.out.println("eureka-0.0.1-SNAPSHOT.jar的md5：" + fileMD5);
                System.out.println("eureka-0.0.1-SNAPSHOT.jar的期望的md5：e56af7c862c161cbd7aa064357679c8a");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                FileInputStream fis = new FileInputStream("D:\\安装包\\BaiduNetdisk_7.0.5.9.exe");
                String fileMD5 = MD5Util.getFileMD5(fis);
                System.out.println("BaiduNetdisk_7.0.5.9.exe的md5：" + fileMD5);
                System.out.println("BaiduNetdisk_7.0.5.9.exe的期望的md5：fed37d52a2a4bce9711f0f2254de5f06");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                FileInputStream fis = new FileInputStream("D:\\安装包\\ideaIU-2020.2.2.exe");
                String fileMD5 = MD5Util.getFileMD5(fis);
                System.out.println("ideaIU-2020.2.2.exe的md5：" + fileMD5);
                System.out.println("ideaIU-2020.2.2.exe的期望的md5：ca35222f8615f9ea8d62352d9c980569");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }).start();
    }


    private static String bufferToHex(byte[] bytes) {
        return bufferToHex(bytes, 0, bytes.length);
    }

    private static String bufferToHex(byte[] bytes, int m, int n) {
        StringBuffer stringbuffer = new StringBuffer(2 * n);
        int k = m + n;
        for (int l = m; l < k; l++) {
            appendHexPair(bytes[l], stringbuffer);
        }
        return stringbuffer.toString();
    }

    private static void appendHexPair(byte bt, StringBuffer stringbuffer) {
        char c0 = hexDigits[(bt & 0xf0) >> 4];
        char c1 = hexDigits[bt & 0xf];
        stringbuffer.append(c0);
        stringbuffer.append(c1);
    }
}
