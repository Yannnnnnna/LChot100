import java.util.Stack;

/**
 * @author wyr on 2025/10/25
 */
public class _394decodeString {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        int cur = 0;
        StringBuilder string = new StringBuilder();
        for (char c : s.toCharArray()){
            if (Character.isDigit(c)){
                cur = cur * 10 + (c - '0');
            }else if(c == '['){
                numStack.push(cur);
                stringStack.push(string.toString());
                cur = 0;
                string = new StringBuilder();

            }else if (c == ']'){
                int n = numStack.pop();
                String prefix = stringStack.pop();
                String current = string.toString();
                StringBuilder now = new StringBuilder(prefix);
                now.append(current.repeat(Math.max(0, n)));
                string = now;

            }else{
                string.append(c);
            }
        }
        return string.toString();
    }
}
