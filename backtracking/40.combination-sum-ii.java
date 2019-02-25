import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode id=40 lang=java
 *
 * [40] Combination Sum II
 *
 * https://leetcode.com/problems/combination-sum-ii/description/
 *
 * algorithms
 * Medium (39.97%)
 * Total Accepted:    199.6K
 * Total Submissions: 498.6K
 * Testcase Example:  '[10,1,2,7,6,1,5]\n8'
 *
 * Given a collection of candidate numbers (candidates) and a target number
 * (target), find all unique combinations in candidates where the candidate
 * numbers sums to target.
 * 
 * Each number in candidates may only be used once in the combination.
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
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 * ⁠ [1, 7],
 * ⁠ [1, 2, 5],
 * ⁠ [2, 6],
 * ⁠ [1, 1, 6]
 * ]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 * [1,2,2],
 * [5]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Stack<Integer> stack = new Stack<>();
        List<List<Integer>> result = new ArrayList<>();
        backTracing(candidates, target, 0, stack, result);
        return result;
    }

    public void backTracing(int[] candidates, int target, int index, Stack<Integer> stack, List<List<Integer>> result){

        if(target == 0){
            List<Integer> tmpResult = copyList(stack);
            result.add(tmpResult);
            return;
        }
        if (index >= candidates.length){
            return;
        }
        for (int i = index; i < candidates.length; ++i){
            if (i > index && candidates[i] == candidates[i - 1]){
                continue;
            }
            if (candidates[i] <= target){
                stack.push(candidates[i]);
                backTracing(candidates, target - candidates[i], i + 1, stack, result);
                stack.pop();
            }else {
                return;
            }
        }
    }

    public List<Integer> copyList(Stack<Integer> stack){
        List<Integer> tmp = new ArrayList<>();
        tmp.addAll(stack);
        return tmp;
    }
}
