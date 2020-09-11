package cn.majs.array;


import java.util.Arrays;

/**
 * @program leetcode
 * @description: 628. 三个数的最大乘积
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 *
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: 6
 *
 * 示例 2:
 * 输入: [1,2,3,4]
 * 输出: 24
 *
 * 注意:
 * 给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
 * 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-of-three-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mac
 * @create: 2020/09/10 23:55
 */
public class MaxThreeProductSolution {

    /**
     * 首先将数据升序排序
     * 如果数组中都是正数的话则选择最后三个元素
     * 如果数组中有多个负数，则可又能是选择前两个负数和最后一个正数
     * 如果只有一个负数则选择最后三个数
     * 如果全为负数则选择最后三个数（前三个数为负)
     * 综上  最大值在（前两个数跟最后一个数的乘积）与（最后三个数的乘积）中选择最大值
     *
     * 时间复杂度：O(N \log N)O(NlogN)，其中 NN 是数组的长度。
     * 空间复杂度：O(\log N)O(logN)，为排序使用的空间。
     *
     * @param nums
     * @return
     */
    public static int MaxThreeProduct01(int[] nums){

        //升序
        Arrays.sort(nums);

        return Math.max((nums[0]*nums[1]*nums[nums.length - 1]), (nums[nums.length - 1]*nums[nums.length - 2]*nums[nums.length - 3]));
    }

    /**
     * 由上面的方法分析可知，我们不必将整个数组排序，只需要找出 最小的两位数和最大的三位数，可以用现行扫描直接得到这三个数
     * 五个数的排序为  min1 min2    max3 max2 max1
     * 时间复杂度：O(N)O(N)。
     * 空间复杂度：O(1)O(1)。
     *
     * @param nums
     * @return
     */
    public static int MaxThreeProduct02(int[] nums){

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        for (int n : nums){

            if(n <= min1){
                min2 = min1;
                min1 = n;
            }else if(n <= min2){
                min2 = n;
            }

            if(n >= max1){
                max3 = max2;
                max2 = max1;
                max1 = n;
            }else if(n >= max2){
                max3 = max2;
                max2 = n;
            }else if(n >= max3){
                max3 = n;
            }

        }
        return Math.max(min1*min2*max1, max1*max2*max3);
    }

}
