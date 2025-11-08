/**
 * @author wyr on 2025/11/8
 */
public class _121maxProfit {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int earn = 0;
        for (int p : prices){
            if (p < min){
                min = p;
            }else {
                earn = Math.max(earn, p-min);
            }
        }
        return earn;
    }
}
