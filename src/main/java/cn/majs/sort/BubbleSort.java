package cn.majs.sort;

/**
 * @program leetcode
 * @description: 冒泡排序
 *
 * 平均时间复杂度：O(n^2)， 最好情况 O(n)， 最坏情况O(n^2)
 * 空间复杂度O(1)
 * 稳定性：稳定
 * @author: mac
 * @create: 2020/09/15 21:00
 */
public class BubbleSort {

    /**
     * 冒泡排序
     * @param nums
     */
    public void bubbleSort(int[] nums){
        if(nums.length == 1) return;

        //外层这个for循环表示的是进行的第几轮比较，从第1轮开始到第nums.length
        //每一轮都会使一个元素移到正确的位置（最后一个元素）
        for(int i = 1; i < nums.length; i++){
            //内层的for循环表示比较的元素位置
            for(int j = 0; j < nums.length-i; j++){
                if(nums[j] > nums[j+1]){
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
        }
    }

    /**
     * 打印数组
     * @param nums
     */
    public void printArr(int[] nums){
        for(int i = 0; i<nums.length; i++){
            System.out.print(nums[i] + "\t");

        }
    }

    public static void main(String[] args) {
        BubbleSort pr = new BubbleSort();
        int[] nums = {2, 1, 6, 4, 5};
        pr.bubbleSort(nums);
        pr.printArr(nums);
    }

}
