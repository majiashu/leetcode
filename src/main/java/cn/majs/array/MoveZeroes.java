package cn.majs.array;

/**
 * @program leetcode
 * @description: 283. 移动零
 * <p>
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * <p>
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: MaJiaShu
 * @create: 2020/11/03 16:31
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int length = nums.length;
        if (nums == null || length == 0) {
            return;
        }
        int j = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0){
                if (i > j){
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }


    }
}
