/**
 * @author wyr on 2025/11/10
 */
public class _300lengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int[] tail = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            //二分查找, 找到第一个》= num的位置，替换他
            int i = 0, j = len;
            while (i < j){
                int mid = (i +j) / 2;
                if (tail[mid] >= num ){
                    j = mid;
                }else {
                    i= mid+ 1;
                }
            }
            tail[i] = num;
            if (i == len){
                len ++;
            }
        }
        return len;
    }
}
