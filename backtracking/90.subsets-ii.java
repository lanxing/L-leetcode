import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode id=90 lang=java
 *
 * [90] Subsets II
 *
 * https://leetcode.com/problems/subsets-ii/description/
 *
 * algorithms
 * Medium (41.31%)
 * Total Accepted:    187.6K
 * Total Submissions: 453.5K
 * Testcase Example:  '[1,2,2]'
 *
 * Given a collection of integers that might contain duplicates, nums, return
 * all possible subsets (the power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * Example:
 * 
 * 
 * Input: [1,2,2]
 * Output:
 * [
 * ⁠ [2],
 * ⁠ [1],
 * ⁠ [1,2,2],
 * ⁠ [2,2],
 * ⁠ [1,2],
 * ⁠ []
 * ]
 * 
 * 
 */
class Solution {
    public void backTracing(int[] nums, int index, Stack<Integer> subSet, List<List<Integer>> result){
        if (index >= nums.length){
            return;
        }
        for (int i = index; i < nums.length; ++i){
            if (i > index && nums[i] == nums[i - 1]){
                continue;
            }
            subSet.push(nums[i]);
            result.add(copyList(subSet));
            backTracing(nums, i + 1, subSet, result);
            subSet.pop();
        }
    }

    public List<Integer> copyList(Stack<Integer> stack){
        List<Integer> tmp = new ArrayList<>();
        tmp.addAll(stack);
        return tmp;
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        backTracing(nums, 0, stack, result);
        result.add(new ArrayList<>());
        return result;
    }
}
