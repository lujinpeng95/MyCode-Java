package 内容签名比对;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * @author lujinpeng
 * @date 2023-08-07 6:39 下午
 */
public class Solution01 {
    public static void main(String[] args) {
        String originalString = "你的签名内容";  // 需要签名的内容
        String signature = getSignature(originalString);
        System.out.println("签名: " + signature);
    }

    static String getSignature(String originalString) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(originalString.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
