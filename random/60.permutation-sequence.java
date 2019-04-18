import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=60 lang=java
 *
 * [60] 第k个排列
 *
 * https://leetcode-cn.com/problems/permutation-sequence/description/
 *
 * algorithms
 * Medium (45.13%)
 * Total Accepted:    7.1K
 * Total Submissions: 15.3K
 * Testcase Example:  '3\n3'
 *
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * 
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * 
 * 
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 
 * 
 * 给定 n 和 k，返回第 k 个排列。
 * 
 * 说明：
 * 
 * 
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 
 * 
 * 示例 1:
 * 
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 
 * 
 * 示例 2:
 * 
 * 输入: n = 4, k = 9
 * 输出: "2314"
 * 
 * 
 */

/**
 * n = 3, k = 3
 * 123
 * 132
 * 213
 * 231
 * 312
 * 321
 * 先获取每个数字的间距，n!/n,
 * 然后获取起始位置和数字在数组中的位置
 */
class Solution {
    public String getPermutation(int n, int k) {
        int total = 1;
        List<Integer> tmp = new ArrayList<>();
        for (int i = 1; i <=n; ++i){
            total *= i;
            tmp.add(i);
        }

        StringBuffer buffer = new StringBuffer();
        int start, pos;
        for (int i = n; i >= 1; --i){
            total = total / i;
            if (k % total == 0){
                start = (k / total - 1) * total;
                pos = k / total;
            }else {
                start = k / total * total;
                pos = k / total + 1;
            }
            buffer.append(tmp.get(pos - 1));
            tmp.remove(pos - 1);
            k -= start;
        }
        return buffer.toString();
    }
}
