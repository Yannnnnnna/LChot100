import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author wyr on 2025/7/13
 */
public class _128LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0; // 如果数组为空，返回0
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int maxLength = 1; // 初始化最长连续序列长度为1
        for (Integer num : set){
            int currentLength = 1; // 当前数字的连续序列长度
            if(!set.contains(num - 1)) {
                while (set.contains(++num)){
                    currentLength++; // 如果下一个数字存在，长度加1
                }
                maxLength  = Math.max(maxLength, currentLength); // 更新最长连续序列长度
            }



        }
        return maxLength; // 返回最长连续序列长度
    }
}
//核心教训一：识别算法瓶颈 —— 从 O(N²) 到 O(N) 的飞跃
//这是解决算法题时最重要的思维转变。
//
//遇到的问题：最直观的想法是“对每个数字，都去检查它能连接多长”，但这导致了大量的重复计算。比如对于序列 [1, 2, 3, 4]，我们从 1 开始计算了一遍 1->2->3->4，之后又从 2 开始计算了一遍 2->3->4，这就是性能的瓶颈。
//
//学到的思路：当发现一个解法太慢时，要问自己：“我在重复计算什么？”
//
//解决方案：这道题的突破口在于意识到，任何一个连续序列，我们只需要从它的“起点”开始计算一次就足够了。如何识别起点？如果一个数 x 的前一个数 x-1 不存在，那么 x 就是一个起点。这个小小的 if (!set.contains(num - 1)) 判断，就是从 O(N²) 思维到 O(N) 思维的钥匙。
//
//** takeaway**: 优化算法时，核心是消除冗余。找到重复的计算，并想办法让它只执行一次。
//
//核心教训二：选择正确的数据结构 —— HashSet 的妙用
//遇到的问题：我们需要一个能**快速判断“某个数是否存在”**的工具。
//
//学到的思路：
//
//如果用数组 nums 本身来查找，每次查找都是 O(N) 的，总复杂度会是 O(N²)，太慢。
//
//我们需要一个平均查找时间为 O(1) 的数据结构。HashMap 和 HashSet 都符合要求。
//
//因为我们只关心一个数“存不存在”，而不需要存储额外的值（比如索引），所以 HashSet 在语义上比 HashMap 更精确、更合适。
//
//takeaway: 刷题时要对常用数据结构的特性了如指掌。遇到“查找/去重”的需求，第一时间就应该想到 HashSet 或 HashMap。
//
//核心教训三：明确你的“操作对象” —— 遍历 nums vs 遍历 set
//这是你在几次修正中遇到的最关键、最持久的问题。
//
//遇到的问题：你已经正确地用 HashSet 去除了重复数字，但在主循环中，你仍然选择遍历原始的、包含大量重复元素的 nums 数组。
//
//学到的思路：数据预处理（比如去重、排序）的目的是为了给后续的算法提供一个更优的“操作平台”。如果你已经花力气构建了这个平台（set），那么接下来的核心逻辑就应该在这个新平台上进行。
//
//解决方案：将外层循环从 for (int num : nums) 改为 for (int num : set)，问题迎刃而解。这保证了你的核心判断逻辑（if 语句）对于每个唯一的数字只执行一次。
//
//takeaway: 数据经过预处理后，要记得在处理后的新数据上继续操作，否则预处理就失去了意义。
//
//核心教训四：养成良好的编码习惯
//不要修改循环变量：在 for-each 循环中，应避免修改循环变量本身（比如你的 while(set.contains(++num))）。虽然有时它能“碰巧”正常工作，但这极易出错且让代码难以理解。引入一个新变量 currentNum 是更规范、更安全的选择。
//
//合理的初始值：将 maxLength 初始化为 0 比 1 更符合通用逻辑。虽然这道题有 if (nums.length == 0) 的保护，但将计数器初始化为0是一个更安全、普适的习惯。