import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wyr on 2025/7/14
 */
public class _15ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len < 3) {
            return res; // 如果数组长度小于3，直接返回空结果
        }
        // 排序数组
        Arrays.sort(nums);
        for (int i = 0; i < len; i++){
            if(nums[i] > 0) {
                break; // 如果当前数字大于0，后续数字也都大于0，直接跳出循环
            }
            // 跳过重复的数字
            if(i >0 && nums[i] == nums[i - 1]) {
                continue; // 如果当前数字和前一个数字相同，跳过
            }
            int l = i+1, r = len - 1;
            while (l < r ){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum < 0){
                    l++; // 如果和小于0，左指针右移
                }else  if(sum>0){
                    r--; // 如果和大于0，右指针左移
                }else {
                    // 找到一个三元组
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    //在找到满足条件的三元组后，跳过重复元素时未将左右指针进一步移动，导致死循环或重复解。
                    while (l < r && nums[l] == nums[l + 1]) l++; // 跳过左重复 [[8]]
                    while (l < r && nums[r] == nums[r - 1]) r--; // 跳过右重复 [[8]]
                    l++; // 强制移动左指针
                    r--; // 强制移动右指针
                }
            }
        }
        return res;
    }
}
