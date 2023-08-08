package 转换gb2312为utf8代码;

import java.io.UnsupportedEncodingException;

/**
 * @author lujinpeng
 * @date 2023-08-07 7:10 下午
 */
public class Solution02 {
    public static void main(String[] args) {
        try {
            // GB2312编码的字符串
            String gb2312Str = "你好，世界！";
            // 将GB2312编码的字符串转换为字节数组
            byte[] gb2312Bytes = gb2312Str.getBytes("GB2312");
            // 将字节数组从GB2312编码转换为UTF-8编码
            byte[] utf8Bytes = new String(gb2312Bytes, "GB2312").getBytes("UTF-8");
            // 将字节数组转换为UTF-8编码的字符串
            String utf8Str = new String(utf8Bytes, "UTF-8");
            System.out.println(utf8Str); // 输出：你好，世界！
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
