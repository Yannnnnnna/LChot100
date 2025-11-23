/**
 * @author wyr on 2025/11/23
 */
public class _169majorityElement {
    public int majorityElement(int[] nums) {
        int count = 0;
        int winner  = nums[0];
        for (int n : nums){
            if (count == 0){
                winner = n;
                count = 1;
            }
            else if (winner == n){
                count++;
            }else {
                count--;
            }
        }
        return winner;
    }
}
