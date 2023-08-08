package 内容签名比对;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * @author lujinpeng
 * @date 2023-08-07 6:39 下午
 */
public class Solution02 {
    private static final String ALGORITHM = "SHA-256";

    public static String sign(String message, String secretKey) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(ALGORITHM);
        messageDigest.update(message.getBytes());
        messageDigest.update(secretKey.getBytes());
        byte[] digest = messageDigest.digest();
        return Base64.getEncoder().encodeToString(digest);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String message = "hello world";
        String secretKey = "my_secret_key";
        String signature = sign(message, secretKey);
        System.out.println(signature);
    }
}
