package 转换gb2312为utf8代码;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

/**
 * @author lujinpeng
 * @date 2023-08-07 7:10 下午
 */
public class Solution01 {
    public static void main(String[] args) throws Exception {
        // 创建一个GB2312编码的字符串
        String str = "你好，世界！";

        // 使用GB2312编码获取字节
        byte[] bytes = str.getBytes("GB2312");

        // 将GB2312编码的字节转换为字符
        Charset charsetGb2312 = Charset.forName("GB2312");
        CharBuffer charBuffer = charsetGb2312.decode(ByteBuffer.wrap(bytes));

        // 将字符转换为UTF-8编码的字节
        Charset charsetUtf8 = Charset.forName("UTF-8");
        ByteBuffer byteBuffer = charsetUtf8.encode(charBuffer);
        byte[] utf8Bytes = byteBuffer.array();

        // 使用UTF-8编码创建一个新的字符串
        String strUtf8 = new String(utf8Bytes, "UTF-8");

        System.out.println("原始字符串: " + str);
        System.out.println("转换后的字符串: " + strUtf8);
    }
}
