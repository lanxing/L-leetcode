import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=75 lang=java
 *
 * [75] Sort Colors
 *
 * https://leetcode.com/problems/sort-colors/description/
 *
 * algorithms
 * Medium (41.23%)
 * Total Accepted:    292.5K
 * Total Submissions: 707.8K
 * Testcase Example:  '[2,0,2,1,1,0]'
 *
 * Given an array with n objects colored red, white or blue, sort them in-place
 * so that objects of the same color are adjacent, with the colors in the order
 * red, white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red,
 * white, and blue respectively.
 * 
 * Note: You are not suppose to use the library's sort function for this
 * problem.
 * 
 * Example:
 * 
 * 
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * 
 * Follow up:
 * 
 * 
 * A rather straight forward solution is a two-pass algorithm using counting
 * sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then
 * overwrite array with total number of 0's, then 1's and followed by 2's.
 * Could you come up with a one-pass algorithm using only constant space?
 * 
 * 
 */
class Solution {
    public void sortColors(int[] nums) {
        solution2(nums);
    }

    private void solution2(int[] nums){
        int start = -1;
        int end = nums.length;
        int index = 0;
        while (start < end && index < end){
            if (nums[index] == 0){
                ++start;
                if (index == start) {
                    ++index;
                }else {
                    swap(nums, index, start);
                }
                continue;
            }else if (nums[index] == 2){
                --end;
                swap(nums, index, end);
                continue;
            }
            ++index;
        }
    }
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void solution1(int[] nums){
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        List<Integer> third = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i){
            if (nums[i] == 0){
                first.add(nums[i]);
            }else if (nums[i] == 1){
                second.add(nums[i]);
            }else {
                third.add(nums[i]);
            }
        }
        first.addAll(second);
        first.addAll(third);
        int i = 0;
        for (Integer integer : first){
            nums[i++] = integer;
        }
    }
}
