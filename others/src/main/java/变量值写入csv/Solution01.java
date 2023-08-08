package 变量值写入csv;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author lujinpeng
 * @date 2023-08-07 6:44 下午
 */
public class Solution01 {
    public static void main(String[] args) {
        // 假设我们有一个字符串变量我们希望写入CSV
        String variable = "Hello, World";

        // 定义我们希望创建的CSV文件的路径
        String csvFile = "file.csv";
//        File outputFile = new File(System.getProperty("user.home"), "test.JPG");

        FileWriter writer;

        try {

            writer = new FileWriter(csvFile);

            // 写入变量值
            writer.append(variable);

            // 添加新行
            writer.append('\n');

            // 关闭writer
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
