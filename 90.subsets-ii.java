import java.util.*;

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
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        backTracing(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backTracing(int[] nums, int index, List<Integer> tmp, List<List<Integer>> result){
        for (int i = index; i < nums.length; ++i){
            if (i > index && nums[i - 1] == nums[i]){
                continue;
            }
            tmp.add(nums[i]);
            result.add(new ArrayList<>(tmp));
            backTracing(nums, i + 1, tmp, result);
            tmp.remove(tmp.size() - 1);
        }
    }
}
