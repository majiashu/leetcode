package cn.majs.sort;

/**
 * @program leetcode
 * @description: 快速排序
 *              2, 5, 7, 1, 45, 12, 35, 32, 89, 30
 *            left                             right
 *             key
 * @author: mac
 * @create: 2020/09/29 08:54
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {34, 56, 12, 23, 45, 67, 97, 12, 90};
        sort(arr, 0, arr.length - 1);

        for (int a : arr) {
            System.out.print(a + "\t");
        }
    }

    /**
     * 快排核心算法 递归实现
     *
     * @param array
     * @param left
     * @param right
     */
    public static void sort(int[] array, int left, int right) {
        if (array == null || array.length == 0) {
            return;
        }
        if (left > right) {
            return;
        }
        // key 是基准数
        int key = array[left];
        int l = left;
        int r = right;

        // 移动指针操作
        while (l != r) {
            // 先移动右指针 r--
            while (array[r] >= key && r > l) {      // 注意此处>=
                r--;
            }
            // 移动左指针 l++
            while (array[l] <= key && r > l) {      // 注意此处<=
                l++;
            }
            // 指针都停止交换两个位置
            if (l < r) {
                int tmp = array[l];
                array[l] = array[r];
                array[r] = tmp;
            }
        }
        // while循环外此时 l=r 左右指针重叠 交换key与重叠值
        array[left] = array[l];
        array[l] = key;

        // 交换完位置，此时该数左边的都小于此数，该数右边的都大于此数，再完成两边的递归
        sort(array, left, l - 1);
        sort(array, l + 1, right);
    }
}
