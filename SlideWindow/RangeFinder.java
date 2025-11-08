import java.util.Arrays;

public class RangeFinder {

    /**
     * 寻找一个区间 [l, r]，使得数组 a 中恰好有 k 个元素落入该区间。
     * 此实现寻找长度最短的此类区间。
     *
     * @param a 原始数组
     * @param k 目标元素个数
     * @return 包含 [l, r] 的数组，如果找不到则返回 null
     */
    public int[] findRangeWithExactlyKElements(int[] a, int k) {

        // --- 1. 处理边界情况 ---
        if (a == null || a.length == 0) {
            return (k == 0) ? new int[]{0, 0} : null;
        }

        if (k > a.length) {
            return null;
        }

        // --- 2. 排序 ---
        Arrays.sort(a);

        if (k == 0) {
            // k=0, 返回一个不包含任何元素的区间
            return new int[]{a[a.length - 1] + 1, a[a.length - 1] + 1};
        }

        // --- 3. 初始化 ---
        long minLength = Long.MAX_VALUE; // 使用 long 避免整数溢出
        int resultL = -1;
        int resultR = -1;
        boolean found = false;

        // --- 4. 遍历所有大小为 k 的窗口 ---
        // i 是窗口的起始索引
        for (int i = 0; i <= a.length - k; i++) {

            // 窗口的结束索引是 i + k - 1
            int l_candidate = a[i];
            int r_candidate = a[i + k - 1];

            // --- 5. 检查有效性 ---

            // 检查左边界：必须确保 a[i-1] (如果存在) 不在区间内
            //
            boolean leftCheck = (i == 0) || (a[i - 1] < l_candidate);

            // 检查右边界：必须确保 a[i+k] (如果存在) 不在区间内
            boolean rightCheck = (i + k == a.length) || (a[i + k] > r_candidate);

            // --- 6. 更新最优解 ---
            if (leftCheck && rightCheck) {
                // 这是一个有效的区间，它恰好包含 k 个元素
                found = true;
                long currentLength = (long)r_candidate - (long)l_candidate;

                if (currentLength < minLength) {
                    minLength = currentLength;
                    resultL = l_candidate;
                    resultR = r_candidate;
                }
            }
        }

        // --- 7. 返回结果 ---
        if (found) {
            return new int[]{resultL, resultR};
        } else {
            // 遍历了所有窗口，但没有一个满足“恰好k个”的条件
            // (例如 a=[1, 2, 2, 2, 5], k=2, 没有解)
            return null;
        }
    }

    // --- 主函数测试 ---
    public static void main(String[] args) {
        RangeFinder finder = new RangeFinder();

        // 示例 1: 包含重复元素
        int[] a1 = {1,2,1,2,1,2};
        int k1 = 3;
        // 排序后: [1, 2, 2, 2, 5, 7, 8]
        // i=0: [1, 2, 2]. l=1, r=2. 检查a[3]=2 (不大于r), 无效.
        // i=1: [2, 2, 2]. l=2, r=2. 检查a[0]=1 (<l), a[4]=5 (>r). 有效. 长度 0.
        // i=2: [2, 2, 5]. l=2, r=5. 检查a[1]=2 (不小于l), 无效.
        // i=3: [2, 5, 7]. l=2, r=7. 检查a[2]=2 (不小于l), 无效.
        // i=4: [5, 7, 8]. l=5, r=8. 检查a[3]=2 (<l), a[7]=越界. 有效. 长度 3.
        // 最短的是 [2, 2]
        int[] result1 = finder.findRangeWithExactlyKElements(a1, k1);
        System.out.println("Test 1 (k=3): " + (result1 != null ? Arrays.toString(result1) : "Not found")); // [2, 2]

        // 示例 2: 无重复元素
        int[] a2 = {1,2,1,2};
        int k2 = 3;
        // i=0: [1, 3]. l=1, r=3. 左右ok. 长度 2.
        // i=1: [3, 5]. l=3, r=5. 左右ok. 长度 2.
        // ...
        // 都会返回第一个找到的 [1, 3] (如果长度相同)
        int[] result2 = finder.findRangeWithExactlyKElements(a2, k2);
        System.out.println("Test 2 (k=3): " + (result2 != null ? Arrays.toString(result2) : "Not found")); // [1, 3]

        // 示例 3: 找不到解
        int[] a3 = {5, 5, 5, 5};
        int k3 = 2;
        // i=0: [5, 5]. l=5, r=5. 右侧a[2]=5 (不大于r), 无效.
        // i=1: [5, 5]. l=5, r=5. 左侧a[0]=5 (不小于l), 右侧a[3]=5 (不大于r), 无效.
        // i=2: [5, 5]. l=5, r=5. 左侧a[1]=5 (不小于l), 无效.
        int[] result3 = finder.findRangeWithExactlyKElements(a3, k3);
        System.out.println("Test 3 (k=2): " + (result3 != null ? Arrays.toString(result3) : "Not found")); // Not found
    }
}