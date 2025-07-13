import java.util.*;

/**
 * @author wyr on 2025/7/13
 */
public class _49GroupAnagrams {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 输入字符串数组长度
        System.out.print("请输入字符串数组的长度: ");
        int length = scanner.nextInt();
        scanner.nextLine(); // 清除换行符
        // 初始化字符串数组
        String[] strs = new String[length];
        // 输入字符串数组元素
        System.out.println("请输入字符串数组元素（每个元素一行）:");
        for (int i = 0; i < length; i++) {
            strs[i] = scanner.nextLine();
        }
        System.out.println("groupAnagrams方法的结果: " + new _49GroupAnagrams().groupAnagrams(strs));

        scanner.close(); // 关闭输入流
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        // 处理边缘情况，如果输入为null或空数组，直接返回一个空列表
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        // 创建一个Map，key是排序后的字符串，value是对应的异位词列表
        Map<String, List<String>> map = new HashMap<>();

        // 遍历输入的字符串数组
        for (String str : strs) {
            // 将字符串转换为字符数组，以便排序
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            // 将排序后的字符数组转换回字符串，作为map的key
            String key = new String(chars);

            // 如果map中不存在这个key，就创建一个新的列表；如果存在，就获取它
            // map.getOrDefault(key, new ArrayList<>()) 是一个简洁的写法
            List<String> group = map.getOrDefault(key, new ArrayList<>());

            // 将原始字符串添加到对应的分组列表中
            group.add(str);

            // 将更新后的列表放回map中
            map.put(key, group);
        }

        // map的values()方法返回所有值的集合，即所有的异位词分组列表
        // 将其转换为ArrayList并返回
        return new ArrayList<>(map.values());
    }
}
