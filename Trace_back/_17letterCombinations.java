import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wyr on 2025/10/15
 */
public class _17letterCombinations {

    static final Map<String, String> digit = new HashMap<>();
    static {
        digit.put("0", "");
        digit.put("1", "");
        digit.put("2", "abc");
        digit.put("3", "def");
        digit.put("4", "ghi");
        digit.put("5", "jkl");
        digit.put("6", "mno");
        digit.put("7", "pqrs");
        digit.put("8", "tuv");
        digit.put("9", "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        backTrack(result, 0, digits, path);
        return result;
    }

    private void backTrack(List<String> result, int i, String digits, StringBuilder path) {
        if(path.length() == digits.length()){
            result.add( path.toString());
            return;
        }
        char nowChar = digits.charAt(i);
        String letters = digit.get(Character.toString(nowChar));
        for (char c: letters.toCharArray()){
            path.append(c);
            backTrack(result, i+1, digits, path);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
