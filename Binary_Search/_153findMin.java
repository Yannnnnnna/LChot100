/**
 * @author wyr on 2025/10/22
 */
public class _153findMin {
    public int findMin(int[] nums) {

        int left = 0, right = nums.length - 1;
        while (left < right){
            int mid = left + (right - left) / 2;

            if (nums[right] < nums[mid]){
                //有序，说明在另一边
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return nums[left];
    }

}
