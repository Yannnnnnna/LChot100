/**
 * @author wyr on 2025/11/23
 */
public class _136singleNumber {
    public int singleNumber(int[] nums) {
        //A ^ 0 = A
        //A ^ A = 0
        //(A ^ B) ^ C = A ^ (B ^ C) , A ^ B = B ^ A
        int result = 0;
        for (int num : nums){
            result = result ^ num;
        }
        return result;
    }
}
