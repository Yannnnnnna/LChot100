import java.util.ArrayList;
import java.util.List;

/**
 * @author wyr on 2025/10/17
 */
public class _42generateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        traceBack(res, sb, n, 0,0);
        return res;
    }

    private void traceBack(List<String> res, StringBuilder sb, int n, int left, int right) {
        if (sb.length() == 2*n){
            res.add(sb.toString());
            return;
        }
        //尝试放左括号
        if (left < n ){
            sb.append("(");
            traceBack(res, sb, n, left+1, right);
            sb.deleteCharAt(sb.length() - 1);
        }
        //尝试放右括号
        if (right < left){
            sb.append(")");
            traceBack(res,sb, n, left, right + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
