package web.rulemanage.config;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class AESUtil {

    public static String encrypt(String data, String key) throws Exception {
        // 根据给定的字节数组构造一个密钥，使用AES加密算法
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
        // 获取实现指定转换的 Cipher 对象。这里的转换是指加密算法、工作模式、填充方式
        Cipher cipher = Cipher.getInstance("AES");
        // 使用加密模式初始化 Cipher 对象
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        // 执行加密操作。完成加密操作的多阶段处理
        byte[] encrypted = cipher.doFinal(data.getBytes());
        // 使用Base64将加密后的字节数组转换为字符串
        // 这样可以确保加密字符串在网络上传输或存储时不会出现问题
        return Base64.getEncoder().encodeToString(encrypted);
    }
    public static String decrypt(String encryptedData, String key) throws Exception {
        // 同样使用给定的字节数组构造一个密钥，使用AES加密算法
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
        // 获取Cipher实例，同样不指定特定的工作模式和填充方式
        Cipher cipher = Cipher.getInstance("AES");
        // 使用解密模式初始化 Cipher 对象
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        // 将加密并编码后的字符串数据进行Base64解码
        byte[] original = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
        // 将解密后的字节数组转换为字符串并返回
        return new String(original);
    }
}
