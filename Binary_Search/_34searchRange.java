/**
 * @author wyr on 2025/10/19
 */
public class _34searchRange {
    public int[] searchRange(int[] nums, int target) {
        int left = findLeft(nums,target);
        if (left == nums.length || nums[left] != target ){
            return new int[]{-1,-1};
        }
        int right = findLeft(nums,target + 1);
        return new int[]{left,right - 1};
    }

    private int findLeft(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target){
                right = mid -1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }
}
