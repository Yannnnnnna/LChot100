/**
 * @author wyr on 2026/2/24
 */
public class _33Search {
    //关键点就是判断哪边有序，然后通过有序部分的值范围来确定目标值在哪边。
    public int search(int[] nums, int target) {
        //二分查找
        int n = nums.length;
        int left = 0, right = n -1;
        while (left <= right){
            int mid = (left + right) /2;
            if (nums[mid] == target){
                return mid;
            } else if (nums[left] <= nums[mid]) {
                //左边有序
                if (nums[mid] > target && nums[left] <= target){
                    // 目标值在左半部分
                    right = mid - 1;
                }else {
                    //目标值在右半部分
                    left = mid +1;
                }

            } else {
                //右边有序
                if (nums[mid] < target && nums[right] >= target){
                    // 中间值小于目标值，目标值在右边
                    left = mid + 1;
                }else {
                    //目标值在左边
                   right = mid -1;
                }

            }
        }
        return -1;
    }
}
