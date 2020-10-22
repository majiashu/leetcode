package cn.majs.array;

import java.util.Arrays;

/**
 * @program leetcode
 * @description: 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 *
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: MaJiaShu
 * @create: 2020/10/22 22:19
 */
public class IsAnagram {

    // 用数组再利用数组的排序
    public boolean isAnagram(String s, String m){
        if(s.length() != m.length()){
            return false;
        }
        char[] arr1 = s.toCharArray();
        char[] arr2 = m.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }
}
