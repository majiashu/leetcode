package cn.majs.array;

import java.util.Arrays;

/**
 * @program leetcode
 * @description: 645. 错误的集合
 * 集合 S 包含从1到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，导致集合丢失了一个整数并且有一个元素重复。
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。你的任务是首先寻找到重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 * <p>
 * 示例 1:
 * 输入: nums = [1,2,2,4]
 * 输出: [2,3]
 * <p>
 * 示例 2：
 * 输入： nums = [1,2,3,3,4,5,7]
 * 输出： [3, 6]
 * <p>
 * 注意:
 * 给定数组的长度范围是 [2, 10000]。
 * 给定的数组是无序的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/set-mismatch
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mac
 * @create: 2020/09/11 17:43
 */
public class FindErrorNumSolution {

    public static int[] findErrorNum(int[] nums) {

        //排序
        Arrays.sort(nums);

        int dup = -1, missing = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                dup = nums[i];
            } else if (nums[i] > nums[i - 1] + 1) {
                missing = nums[i - 1] + 1;
            }
        }
        //数组是从一开始的，如果丢的不是最后一个元素的话，则此时数组最后一个元素的值等于数组长度
        //如果不等于的话说明丢的是最后一个元素，也就是丢的nums.length
        //如果相等的话说明丢的不是最后一个元素，丢的是定义的missing
        return new int[] {dup, nums[nums.length - 1] != nums.length ? nums.length : missing};
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 11, 12};
        System.out.println(findErrorNum(nums));

        // 打印出数组
        for(int i=0; i<findErrorNum(nums).length; i++){
            System.out.print(findErrorNum(nums)[i]+"\t");
        }
    }
}
