package cn.majs.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * @program leetcode
 * @description: 414. 第三大的数
 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 *
 * 示例 1:
 * 输入: [3, 2, 1]
 * 输出: 1
 * 解释: 第三大的数是 1.
 *
 * 示例 2:
 * 输入: [1, 2]
 * 输出: 2
 * 解释: 第三大的数不存在, 所以返回最大的数 2 .
 *
 * 示例 3:
 * 输入: [2, 2, 3, 1]
 * 输出: 1
 * 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
 * 存在两个值为2的数，它们都排第二。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/third-maximum-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: mac
 * @create: 2020/08/21 17:49
 */
public class ThirdMaxSolution {

    /**
     * 排序 去重 输出
     * @param nums
     * @return
     */
    public static int thridMax01(int[] nums){

        //升序排序
        Arrays.sort(nums);

        //去重
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++){
            if(!list.contains(nums[i])){
                list.add(nums[i]);
            }
        }
        if (list.size() < 3){
            return list.get(list.size()-1);
        }else {
            return list.get(list.size() -3);
        }
    }

    /**
     * 维护三个有序set  Treeset  set.first()是第一个，最小的数，set.last是最后一个，最大的
     * @param nums
     * @return
     */
    public static int thridMax02(int[] nums){

        if (nums == null || nums.length == 0 ) throw new RuntimeException("非法数组（为空或长度为0）") ;

        TreeSet<Integer> set = new TreeSet<Integer>();
        for(Integer elem : nums){
            set.add(elem);
            if(set.size() > 3) set.remove(set.first());
        }
        return set.size() < 3 ? set.last() : set.first();
    }

    public static void main(String[] args) {
        int[] nums = {1, 7, 8, 4, 9, 2, 5, 7, 9, 0} ;
        System.out.println(ThirdMaxSolution.thridMax02(nums));
    }
}
