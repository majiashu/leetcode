package cn.majs.recursion;

/**
 * @program leetcode
 * @description: 有n步台阶，一次只能上1步或2步，共有多少种走法
 * @author: mac
 * @create: 2020/09/14 23:01
 */
public class StepProblem {

    public static void main(String[] args) {
        System.out.println("方法一：" + f(10));
        System.out.println("方法二：" + f2(10));
    }

    /**
     * 首先想到递归的方法
     * 优点：好理解
     * 缺点：算法复杂度高，有很多冗余计算
     *
     * @param n
     * @return
     */
    public static int f(int n) {
        if (n <= 2) return n;
        int x = f(n - 2) + f(n - 1);
        return x;
    }

    /**
     * 迭代
     * 优点：效率高
     * 缺点：可读性差
     *
     * @param n
     * @return
     */
    public static int f2(int n) {
        if (n <= 2) return n;
        int first = 1, second = 2;
        int third = 3;
        for (int i = 3; i <= n; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }


}
