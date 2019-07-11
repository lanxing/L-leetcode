package lalgorithm.normal;

import java.util.Arrays;

/*
 * @lc app=leetcode id=31 lang=java
 *
 * [31] Next Permutation
 *
 * https://leetcode.com/problems/next-permutation/description/
 *
 * algorithms
 * Medium (29.95%)
 * Total Accepted:    210.9K
 * Total Submissions: 703.3K
 * Testcase Example:  '[1,2,3]'
 *
 * Implement next permutation, which rearranges numbers into the
 * lexicographically next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest
 * possible order (ie, sorted in ascending order).
 * 
 * The replacement must be in-place and use only constant extra memory.
 * 
 * Here are some examples. Inputs are in the left-hand column and its
 * corresponding outputs are in the right-hand column.
 * 
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * 解法思路：
 * [4,2,0,2,3,2,0]
 * 从后向前遍历，数字从小到大，index = 4  0->2->3
 * 将index前的数字(2)和index后(3,2,0)中第一个大于该数字(3)的进行交换
 * 4 2 0 3 2 2 0
 * 将index后的数字逆序排列
 * 4 2 0 3 0 2 2
 *
 */
class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int index = len - 1;
        while (index > 0){
            if (nums[index - 1] >= nums[index]){
                index--;
            }else {
                break;
            }
        }
        if (index == 0){
            for (int i = 0, j = len - 1; i < j; i++, j--){
                swap(nums, i, j);
            }
        }else {
            for (int i = len - 1; i > index - 1; --i){
                if (nums[i] > nums[index - 1]){
                    swap(nums, i, index - 1);
                    break;
                }
            }
            Arrays.sort(nums, index, len);
        }
    }
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
