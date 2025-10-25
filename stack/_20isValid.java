import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author wyr on 2025/10/24
 */
public class _20isValid {
//    public boolean isValid(String s) {
//        Stack<Character> stack = new Stack<>();
//        int i = 0;
//        while (i < s.length()) {
//            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
//                stack.push(s.charAt(i));
//
//            } else {
//                if (stack.isEmpty()) {
//                    return false;
//                } else if (stack.peek() == '(' && s.charAt(i) == ')') {
//                    stack.pop();
//
//                } else if (stack.peek() == '[' && s.charAt(i) == ']') {
//                    stack.pop();
//
//                } else if (stack.peek() == '{' && s.charAt(i) == '}') {
//                    stack.pop();
//                } else {
//                    return false;
//                }
//            }
//            i++;
//        }
//        if (stack.isEmpty()){
//            return true;
//        }
//        return false;
//    }
    //用Map写法
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()){
            if (map.containsKey(c)) {
                char top = stack.isEmpty() ? '*' : stack.pop();
                if (top!= map.get(c)){
                    return false;
                }
            }else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
