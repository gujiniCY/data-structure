package com.songhaozhi.线性表.栈.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _20_有效的括号 {
    private static Map<Character,Character> map = new HashMap<>();
    static {
        map.put('{','}');
        map.put('[',']');
        map.put('(',')');
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            //遍历字符
            char c = s.charAt(i);
            //左括号
            if (map.containsKey(c)) {
                stack.push(c);
            } else {//右括号
                if (stack.isEmpty()) {
                    return false;
                }
                if(c != map.get(stack.pop())){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            //遍历字符
            char c = s.charAt(i);
            //左括号
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {//右括号
                if (stack.isEmpty()) {
                    return false;
                }
                char left = stack.pop();
                if (left == '(' && c != ')') {
                    return false;
                }
                if (left == '{' && c != '}') {
                    return false;
                }
                if (left == '[' && c != ']') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
