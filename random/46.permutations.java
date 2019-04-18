import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 *
 * https://leetcode-cn.com/problems/permutations/description/
 *
 * algorithms
 * Medium (66.78%)
 * Total Accepted:    21.2K
 * Total Submissions: 31.2K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * 
 * 示例:
 * 
 * 输入: [1,2,3]
 * 输出:
 * [
 * ⁠ [1,2,3],
 * ⁠ [1,3,2],
 * ⁠ [2,1,3],
 * ⁠ [2,3,1],
 * ⁠ [3,1,2],
 * ⁠ [3,2,1]
 * ]
 * 
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backTracing(result, new ArrayList<>(), new HashSet<>(), nums);
        return result;
    }

    private void backTracing(List<List<Integer>> result, List<Integer> tmp, Set<Integer> usedSet, int[] nums){
        int n = nums.length;
        if (n == tmp.size()){
            result.add(new ArrayList<>(tmp));
        }
        for (Integer val : nums){
            if (usedSet.contains(val)){
                continue;
            }
            usedSet.add(val);
            tmp.add(val);
            backTracing(result, tmp, usedSet, nums);
            tmp.remove(tmp.size() - 1);
            usedSet.remove(val);
        }
    }
}
