import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wyr on 2026/2/22
 */
public class _15threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        int left = 0; int right = n - 1;
        for (int i = 0; i < n; i++) {
            //大于0，不可能存在等于0的组合了
            if (nums[i] > 0) {
                break;
            }
            //跳过重复元素，避免出现重复组合
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            left = i + 1;
            right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    //找到一个组合，添加到结果列表中
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    //移动左指针，跳过重复元素
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    //移动右指针，跳过重复元素
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                }
                else if (sum < 0){
                    ++left;
                } else {
                    --right;
                }
            }
        }
        return res;
    }
}
