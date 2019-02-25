import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 *
 * https://leetcode.com/problems/permutations/description/
 *
 * algorithms
 * Medium (53.19%)
 * Total Accepted:    336.3K
 * Total Submissions: 632.2K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a collection of distinct integers, return all possible permutations.
 * 
 * Example:
 * 
 * 
 * Input: [1,2,3]
 * Output:
 * [
 * ⁠ [1,2,3],
 * ⁠ [1,3,2],
 * ⁠ [2,1,3],
 * ⁠ [2,3,1],
 * ⁠ [3,1,2],
 * ⁠ [3,2,1]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        Set<Integer> usedSet = new HashSet<>();
        batckTrace(nums, result, tmp, usedSet);
        return result;
    }

    private void batckTrace(int[] nums, List<List<Integer>> result, List<Integer> tmp, Set<Integer> usedSet){
        if (tmp.size() == nums.length){
            List<Integer> tmpList = new ArrayList<>(tmp);
            result.add(tmpList);
            return;
        }
        for (int i = 0; i < nums.length; ++i){
            if (usedSet.contains(i)){
                continue;
            }
            tmp.add(nums[i]);
            usedSet.add(i);
            batckTrace(nums, result, tmp, usedSet);
            usedSet.remove(i);
            tmp.remove(tmp.size() - 1);
        }
    }
}
