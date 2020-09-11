package cn.majs.array;

/**
 * @program leetcode
 * @description:4.寻找两个正序数组的中位数 给定两个大小为m和n的正序（从小到大）数组nums1和nums2
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为O（log（m+n））
 * <p>
 * 示例 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 则中位数是 2.0
 * <p>
 * 示例 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 则中位数是 (2 + 3)/2 = 2.5
 * @author: mac
 * @create: 2020/08/05 00:00
 */
public class FindMedianSortedArraysSolution {


    public static double findMedianSortedArray(int[] nums1, int[] nums2) {

        //保持第一个数组长度比第二个小
        if (nums1.length > nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }

        int m = nums1.length;
        int n = nums2.length;

        int totalLeft = (m + n + 1) / 2;

        //在nums1 的[0, m]区间查找合适的分割线
        //满足条件 num1[i - 1] < num2[j] && nums2[j - 1] < nums1[i]
        int left = 0;
        int right = m;

        while (left < right) {
            int i = left + (right - left + 1) / 2;
            int j = totalLeft - i;
            if (nums1[i - 1] > nums2[j]) {
                right = i - 1;
            } else {
                left = i;
            }
        }

        int i = left;
        int j = totalLeft - i;
        int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int nums1RightMin = i == m ? Integer.MAX_VALUE : nums1[i];
        int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int nums2rightMin = j == n ? Integer.MAX_VALUE : nums2[j];

        if ((m + n) % 2 == 1){
            return Math.max(nums1LeftMax, nums2LeftMax);
        }else{
            return (double) ((Math.max(nums1LeftMax, nums2LeftMax)) + (Math.min(nums1RightMin, nums2rightMin)))/2;
        }


    }
}
