package _020_有效的括号;

import java.util.HashMap;
import java.util.Stack;

/**
 * 1、java中map没有关键词『in』，是 containsKey；
 * 2、位运算比『!=』优先级低
 *
 * @author lujinpeng
 * @date 2024-05-19 20:39
 */
public class Solution {
    public boolean isValid(String s) {
        int len = s.length();
        // 奇数
        if ((len & 1) != 0) {
            return false;
        }

        HashMap<Character, Character> charMap = new HashMap<>();
        charMap.put('{', '}');
        charMap.put('(', ')');
        charMap.put('[', ']');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            char chr = s.charAt(i);
            if (charMap.containsKey(chr)) {
                stack.push(chr);
                continue;
            }

            if (stack.isEmpty() || chr != charMap.get(stack.pop())) {
                return false;
            }

        }

        return stack.isEmpty();

    }

    public static void main(String[] args) {
        String[] caseStr = {"()", "()[]{}", "(]"};
        boolean[] res = {true, true, false};

        Solution solver = new Solution();
        boolean flag = true;
        for (int i = 0; i < caseStr.length; i++) {
            if (solver.isValid(caseStr[i]) != res[i]) {
                flag = false;
                System.out.println("error! case : " + caseStr[i] + ", res should be: " + res[i]);
            }
        }

        if (flag) {
            System.out.println("success!");
        }

    }
}
