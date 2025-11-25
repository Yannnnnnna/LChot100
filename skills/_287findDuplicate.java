/**
 * @author wyr on 2025/11/25
 */
public class _287findDuplicate {
    //快慢指针法
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int fast = nums[nums[0]];
        int slow = nums[0];
        //查找相遇点
        while (fast != slow){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        slow = 0;
        //查找环入口
        while (fast != slow){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
