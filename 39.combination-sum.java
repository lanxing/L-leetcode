import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 *
 * https://leetcode.com/problems/combination-sum/description/
 *
 * algorithms
 * Medium (46.24%)
 * Total Accepted:    301.8K
 * Total Submissions: 649.4K
 * Testcase Example:  '[2,3,6,7]\n7'
 *
 * Given a set of candidate numbers (candidates) (without duplicates) and a
 * target number (target), find all unique combinations in candidates where the
 * candidate numbers sums to target.
 * 
 * The same repeated number may be chosen from candidates unlimited number of
 * times.
 * 
 * Note:
 * 
 * 
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 * ⁠ [7],
 * ⁠ [2,2,3]
 * ]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmpResult = new ArrayList<>();
        backTree(candidates, target, 0, tmpResult, result);
        return result;
    }

    public void backTree(int[] candidates, int target, int index, List<Integer> tmpResult, List<List<Integer>> result){
        if (target == 0){
            result.add(new ArrayList<>(tmpResult));
            return;
        }
        for (int i = index; i < candidates.length; ++i){
            if (target < candidates[i]){
                return;
            }
            tmpResult.add(candidates[i]);
            backTree(candidates, target - candidates[i], i, tmpResult, result);
            tmpResult.remove(tmpResult.size() - 1);
        }


    }
}
