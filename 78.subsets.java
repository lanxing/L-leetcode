import java.util.ArrayList;
import java.util.List;

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
        backTracing(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backTracing(int[] nums, int index, List<Integer> tmp, List<List<Integer>> result){

        result.add(new ArrayList<>(tmp));
        if (tmp.size() >= nums.length){
            return;
        }
        if (index > nums.length){
            return;
        }
        for (int i = index; i < nums.length; ++i){
            tmp.add(nums[i]);
            backTracing(nums, i + 1, tmp, result);
            tmp.remove(tmp.size() - 1);
        }
    }
}
