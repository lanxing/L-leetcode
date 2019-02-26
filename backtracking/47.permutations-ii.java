import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=47 lang=java
 *
 * [47] Permutations II
 *
 * https://leetcode.com/problems/permutations-ii/description/
 *
 * algorithms
 * Medium (39.01%)
 * Total Accepted:    220.1K
 * Total Submissions: 563.4K
 * Testcase Example:  '[1,1,2]'
 *
 * Given a collection of numbers that might contain duplicates, return all
 * possible unique permutations.
 * 
 * Example:
 * 
 * 
 * Input: [1,1,2]
 * Output:
 * [
 * ⁠ [1,1,2],
 * ⁠ [1,2,1],
 * ⁠ [2,1,1]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<Integer> tmpResult = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> usedSet = new ArrayList<>();
        backTracking(nums, tmpResult, result, usedSet);
        return result;
    }

    public void backTracking(int[] nums, List<Integer> tmpResult, List<List<Integer>> result, List<Integer> usedSet){
        if (tmpResult.size() == nums.length){
            result.add(new ArrayList<>(tmpResult));
        }
        for (int i = 0; i < nums.length; ++i){
            if (i > 0 && nums[i - 1] == nums[i] && !usedSet.contains(i - 1)){
                continue;
            }
            if (usedSet.contains(i)){
                continue;
            }
            usedSet.add(i);
            tmpResult.add(nums[i]);
            backTracking(nums, tmpResult, result, usedSet);
            usedSet.remove(usedSet.size() - 1);
            tmpResult.remove(tmpResult.size() - 1);
        }
    }
}
