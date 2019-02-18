import java.util.*;

/*
 * @lc app=leetcode id=18 lang=java
 *
 * [18] 4Sum
 *
 * https://leetcode.com/problems/4sum/description/
 *
 * algorithms
 * Medium (29.48%)
 * Total Accepted:    208.1K
 * Total Submissions: 705.3K
 * Testcase Example:  '[1,0,-1,0,-2,2]\n0'
 *
 * Given an array nums of n integers and an integer target, are there elements
 * a, b, c, and d in nums such that a + b + c + d = target? Find all unique
 * quadruplets in the array which gives the sum of target.
 * 
 * Note:
 * 
 * The solution set must not contain duplicate quadruplets.
 * 
 * Example:
 * 
 * 
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 * 
 * A solution set is:
 * [
 * ⁠ [-1,  0, 0, 1],
 * ⁠ [-2, -1, 1, 2],
 * ⁠ [-2,  0, 0, 2]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int first, second, three, four;
        int left, right;
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> filterSet = new HashSet<>();
        for (int index = 0; index < len - 3; ++index){
            if (index > 0 && nums[index] == nums[index - 1]){
                continue;
            }
            first = nums[index];
            for (int i = index + 1; i < len - 2; ++i){
                filterSet.clear();
                if (i > index + 1 && nums[i] == nums[i - 1]){
                    continue;
                }
                second = nums[i];
                left = i + 1;
                right = len - 1;
                while (left < right){
                    if (filterSet.contains(nums[left])){
                        left++;
                        continue;
                    }
                    int tmpSum = first + second + nums[left] + nums[right];
                    if (tmpSum == target){
                        List<Integer> tmpList = new ArrayList<>();
                        tmpList.add(first);
                        tmpList.add(second);
                        tmpList.add(nums[left]);
                        tmpList.add(nums[right]);
                        result.add(tmpList);
                        filterSet.add(nums[left]);
                        left++;
                        right--;
                        continue;
                    }else if (tmpSum < target){
                        filterSet.add(nums[left]);
                        left++;
                    }else {
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
