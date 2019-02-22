import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=38 lang=java
 *
 * [38] Count and Say
 *
 * https://leetcode.com/problems/count-and-say/description/
 *
 * algorithms
 * Easy (39.28%)
 * Total Accepted:    256.6K
 * Total Submissions: 651.3K
 * Testcase Example:  '1'
 *
 * The count-and-say sequence is the sequence of integers with the first five
 * terms as following:
 * 
 * 
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 
 * 
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * 
 * Given an integer n where 1 ≤ n ≤ 30, generate the n^th term of the
 * count-and-say sequence.
 * 
 * Note: Each term of the sequence of integers will be represented as a
 * string.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: 1
 * Output: "1"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 4
 * Output: "1211"
 * 思路：题意实在太难理解了，尤其是英文又不好，只能参看下别人的资料，理解下规则。终于理解，题意是n=1时输出字符串1；n=2时，数上次字符串中的数值个数，因为上次字符串有1个1，所以输出11；n=3时，由于上次字符是11，有2个1，所以输出21；n=4时，由于上次字符串是21，有1个2和1个1，所以输出1211。依次类推，写个countAndSay(n)函数返回字符串。
 */
class Solution {

    private static Map<Integer, String> pmap = new HashMap<>();
    static {
        pmap.put(1, "1");
        pmap.put(2, "11");
    }

    public String countAndSay(int n) {
        if (pmap.containsKey(n)){
            return pmap.get(n);
        }
        if (!pmap.containsKey(n - 1)){
            countAndSay(n - 1);
        }


        String result = count(pmap.get(n - 1));
        pmap.put(n, result);
        return result;
    }
    private String count(String s){
        int len = s.length();
        String result = "";
        int count = 1;
        for (int i = 1; i < len; ++i){
            if (s.charAt(i) == s.charAt(i  -1)){
                count++;
                continue;
            }
            result = result + count + s.charAt(i - 1);
            count = 1;
        }
        result = result + count + s.charAt(len - 1);
        return result;

    }
}
