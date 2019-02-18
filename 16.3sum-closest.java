import java.util.Arrays;

/*
 * @lc app=leetcode id=16 lang=java
 *
 * [16] 3Sum Closest
 *
 * https://leetcode.com/problems/3sum-closest/description/
 *
 * algorithms
 * Medium (33.88%)
 * Total Accepted:    237.6K
 * Total Submissions: 693.6K
 * Testcase Example:  '[-1,2,1,-4]\n1'
 *
 * Given an array nums of n integers and an integer target, find three integers
 * in nums such that the sum is closest to target. Return the sum of the three
 * integers. You may assume that each input would have exactly one solution.
 * 
 * Example:
 * 
 * 
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 分析
 * 类似于15的3sum
 * 区别在于何时移动left和right指针
 * 比较三个数的和tmpTarget要在坐标轴上接近target，如果tmpTarget < target 则应该增大tmpTarget，否则减小
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diffValue = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < nums.length - 2; ++i){
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right){
                int tmpTarget = nums[i] + nums[right] + nums[left];
                int tmp = Math.abs(target - tmpTarget);
                if (tmp < diffValue){
                    diffValue = tmp;
                    result = nums[i] + nums[left] + nums[right];
                }
                if (tmpTarget < target){
                    left++;
                }else {
                    right--;
                }
                if (diffValue == 0){
                    break;
                }
            }
            if (diffValue == 0){
                break;
            }
        }
        return result;
    }
}
