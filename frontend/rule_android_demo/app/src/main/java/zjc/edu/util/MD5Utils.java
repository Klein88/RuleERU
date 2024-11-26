package zjc.edu.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {
    /**
     * 随机密钥长度
     */
    private static final int _KEYTLENGTH = 6;

    /**
     * 生成随机密钥
     *
     * @param length
     *            密钥长度
     */
    private String getRandomKeyt(int length) throws Exception {
        if (length < 1)
            throw new Exception("密钥长度不能小于 1");
        StringBuilder sb = new StringBuilder("0123456789abcdefghijklmnopqrstuvwxyz");
        int len = sb.length();
        System.out.println("len " + len);
        String _keyt = "";
        for (int i = 0; i < length; i++) {
            int ran = (int) (Math.random() * len);
            System.out.println("ran " + ran);
            int index = ran % len;
            System.out.println("index " + index);
            System.out.println("char " + sb.charAt(index));
            _keyt += sb.charAt(index);

        }
        return _keyt;
    }

    /**
     * 32位标准 MD5 加密
     *
     * @param plainText
     *            明文
     * @return 密文<br>
     *         返回 Null 值则出现异常
     */
    public static String cell32(String plainText) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            return buf.toString();// 32位的加密

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 32 位 salt 加密
     *
     * @param plainText
     *            明文
     * @return 索引 0 是密文，索引 1 是二次密钥
     */
//    public String[] salt32(String plainText) throws Exception {
//        return salt("cell32", plainText);
//    }
//
    /**
     * 32 位 salt 加密
     *
     * @param plainText
     *            明文
     * @return 索引 0 是密文，索引 1 是二次密钥
     */
    public String salt32(String plainText) throws Exception {
        return salt1("cell32", plainText);
    }


    /**
     * 16 位标准 MD5 加密
     *
     * @param plainText
     *            明文
     * @return 密文<br>
     *         返回 Null 值则出现异常
     */
    public static String cell16(String plainText) {
        String result = cell32(plainText);
        if (result == null)
            return null;
        return result.toString().substring(8, 24);// 16位的加密
    }

    /**
     * 16 位 salt 加密
     *
     * @param plainText
     *            明文
     * @return 索引 0 是密文，索引 1 是二次密钥
     */
    public String[] salt16(String plainText) throws Exception {
        return salt("cell16", plainText);
    }

    /**
     * 根据调用的方法名称执行不同的方法
     *
     * @param saltFunctionName
     *            加密的方法名称
     */
    private String[] salt(String saltFunctionName, String plainText)
            throws Exception {
        String _keyt = getRandomKeyt(_KEYTLENGTH);
        return new String[] {(String) this.getClass().getMethod(saltFunctionName, Class.forName("java.lang.String")).invoke(this, (cell32(plainText) + _keyt)), _keyt };
    }

    private String salt1(String saltFunctionName, String plainText)
            throws Exception {
        String _keyt = getRandomKeyt(_KEYTLENGTH);
        return (String) this.getClass().getMethod(saltFunctionName, Class.forName("java.lang.String")).invoke(this, cell32(plainText)) + _keyt;
    }
}
