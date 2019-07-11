package lalgorithm.normal;

/*
 * @lc app=leetcode id=41 lang=java
 *
 * [41] First Missing Positive
 *
 * https://leetcode.com/problems/first-missing-positive/description/
 *
 * algorithms
 * Hard (28.13%)
 * Total Accepted:    190.4K
 * Total Submissions: 676.2K
 * Testcase Example:  '[1,2,0]'
 *
 * Given an unsorted integer array, find the smallest missing positive
 * integer.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,2,0]
 * Output: 3
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [3,4,-1,1]
 * Output: 2
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: [7,8,9,11,12]
 * Output: 1
 * 
 * 
 * Note:
 * 
 * Your algorithm should run in O(n) time and uses constant extra space.
 * 思路：交换数组元素，使得数组中第i位存放数值(i+1)。最后遍历数组，寻找第一个不符合此要求的元素，返回其下标。整个过程需要遍历两次数组，复杂度为O(n)。
 * 
 */
class Solution {
    public int firstMissingPositive(int[] nums) {

        int i = 0;
        int len = nums.length;
        while(i < len){
            if (nums[i] >= 1 && (i + 1) != nums[i] && nums[i]  <= len && nums[nums[i] - 1] != nums[i]){
                int tmp = nums[i];
                nums[i] = nums[tmp - 1];
                nums[tmp - 1] = tmp;
            }else {
                ++i;
            }
        }
        int index = 0;
        for (; index < len; ++index){
            if (nums[index] == index + 1){
                continue;
            }else {
                return index + 1;
            }
        }
        return len + 1;

    }
}
