package lalgorithm.normal;

import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 *
 * https://leetcode.com/problems/two-sum/description/
 *
 * algorithms
 * Easy (40.22%)
 * Total Accepted:    1.4M
 * Total Submissions: 3.5M
 * Testcase Example:  '[2,7,11,15]\n9'
 *
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * Example:
 * 
 * 
 * Given nums = [2, 7, 11, 15], target = 9,
 * 
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * 
 * 
 * 
 * 
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Set<Integer> tmpSet = new HashSet<>();
        int tmp = 0;
        int key1 = 0;
        for (int i = 0; i < nums.length; ++i){
            tmp = target - nums[i];
            if (tmpSet.contains(nums[i])){
                key1 = i;
                break;
            }else {
                tmpSet.add(tmp);
            }
        }
        int[] result = new int[2];
        for (int j = 0; j < nums.length; ++j){
            if (nums[j] == tmp){
                result[0] = j;
                break;
            }
        }
        result[1] = key1;
        return result;
    }
}
