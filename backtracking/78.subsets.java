import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 *
 * https://leetcode.com/problems/subsets/description/
 *
 * algorithms
 * Medium (50.74%)
 * Total Accepted:    328.3K
 * Total Submissions: 646.1K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a set of distinct integers, nums, return all possible subsets (the
 * power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * Example:
 * 
 * 
 * Input: nums = [1,2,3]
 * Output:
 * [
 * ⁠ [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * 
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0){
            result.add(new ArrayList<>());
            return result;
        }
        result.add(new ArrayList<>());
        Stack<Integer> stack = new Stack<>();
        backTrace(nums, 0, stack, result);
        return result;
    }

    public void backTrace(int[] nums, int index, Stack<Integer> stack, List<List<Integer>> result){
        if (index >= nums.length){
            return;
        }
        for (int i = index; i < nums.length; ++i){
            stack.push(nums[i]);
            result.add(copyList(stack));
            backTrace(nums, i + 1, stack, result);
            stack.pop();
        }
    }
    public List<Integer> copyList(Stack<Integer> stack){
        List<Integer> tmp = new ArrayList<>();
        tmp.addAll(stack);
        return tmp;
    }
}
