package lalgorithm.normal;

import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=77 lang=java
 *
 * [77] Combinations
 *
 * https://leetcode.com/problems/combinations/description/
 *
 * algorithms
 * Medium (45.81%)
 * Total Accepted:    186.3K
 * Total Submissions: 404.5K
 * Testcase Example:  '4\n2'
 *
 * Given two integers n and k, return all possible combinations of k numbers
 * out of 1 ... n.
 * 
 * Example:
 * 
 * 
 * Input: n = 4, k = 2
 * Output:
 * [
 * ⁠ [2,4],
 * ⁠ [3,4],
 * ⁠ [2,3],
 * ⁠ [1,2],
 * ⁠ [1,3],
 * ⁠ [1,4],
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backTracing(n, k, 1, new ArrayList<>(), result);
        return result;
    }
    private void backTracing(int n, int k, int index, List<Integer> tmp, List<List<Integer>> result){

        if (tmp.size() == k){
            result.add(new ArrayList<>(tmp));
            return;
        }
        if (index > n){
            return;
        }
        for (int i = index; i <= n; ++i){
            tmp.add(i);
            backTracing(n, k, i + 1, tmp, result);
            tmp.remove(tmp.size() - 1);
        }
    }
}
