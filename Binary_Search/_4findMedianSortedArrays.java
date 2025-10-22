/**
 * @author wyr on 2025/10/22
 */
public class _4findMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length;
        int n = nums2.length;
        int left = 0, right = m;
        int half = (m + n + 1) / 2; //左半边需要包含的元素的数量
        while (left <= right) {
            int i = (left + right) / 2;
            int j = half - i;
            int num1leftMax = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int num1rightMin = (i == m) ? Integer.MAX_VALUE : nums1[i];
            int num2leftMax = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int num2rightMin = (j == n) ? Integer.MAX_VALUE : nums2[j];

            //条件是数组1左边最大值 小于 数组2右边最小值
            //数组1右边最小值  大于 数组2 左边最大值
            if(num1leftMax > num2rightMin){
                right = i -1;
            }else if (num1rightMin<num2leftMax){
                left = i + 1;
            }else {
                //找到
                int maxLeft = Math.max(num1leftMax, num2leftMax);
                int minRight = Math.min(num1rightMin, num2rightMin);
                if ((m + n) % 2 == 0){
                    return (maxLeft + minRight) / 2.0;
                }
                else {
                    return maxLeft;
                }
            }
        }
        return 0.0;
    }
}
