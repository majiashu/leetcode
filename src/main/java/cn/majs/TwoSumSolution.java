package cn.majs;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @program leetcode
 * @description: 1.两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @author: mac
 * @create: 2020/08/04 22:46
 * 自己修改
 *
 * 管理员用户通过gitlab修改
 */

public class TwoSumSolution {
    /**
     * 两遍哈希表
     * 一个简单的实现使用了两次迭代。在第一次迭代中，我们将每个元素的值和它的索引添加到表中。
     * 然后，在第二次迭代中，我们将检查每个元素所对应的目标元素（target - nums[i]）是否存在于表中。
     * 注意，该目标元素不能是 nums[i] 本身！
     *
     * 也就是两遍哈希表，第一遍赋值key为nums[i], value为i，第二遍遍历然后判断对应的元素（target - nums [i]）是否存在与表中，
     * 同时需满足目标元素不是nums[i]本身！
     * 时间复杂度为：O（n）
     * 空间复杂度为：O（n）
     *
     * @param nums
     * @param target
     * @return
     */
        public static int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], i);
            }
            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];
                if (map.containsKey(complement) && map.get(complement) != i) {
                    return new int[] { i, map.get(complement) };
                }
            }
            throw new IllegalArgumentException("No two sum solution");
        }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4, 5};
        int target = 5;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

}
