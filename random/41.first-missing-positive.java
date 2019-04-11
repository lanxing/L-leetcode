/*
 * @lc app=leetcode.cn id=41 lang=java
 *
 * [41] 缺失的第一个正数
 *
 * https://leetcode-cn.com/problems/first-missing-positive/description/
 *
 * algorithms
 * Hard (35.60%)
 * Total Accepted:    11.2K
 * Total Submissions: 31.7K
 * Testcase Example:  '[1,2,0]'
 *
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,0]
 * 输出: 3
 * 
 * 
 * 示例 2:
 * 
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 
 * 
 * 示例 3:
 * 
 * 输入: [7,8,9,11,12]
 * 输出: 1
 * 
 * 
 * 说明:
 * 
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
 * 
 */
class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0){
            return 1;
        }
        int len = nums.length;
        int index = 0;
        while (index < len){
            if (nums[index] != index + 1){
                if ((nums[index] - 1 >= 0) && (nums[index] - 1 < len) && nums[nums[index] - 1] != nums[index]){
                    swap(nums, index, nums[index] - 1);
                }else {
                    index++;
                }
            }else {
                index++;
            }
        }
        boolean flag = nums[0] == 1;
        if (!flag){
            return 1;
        }
        for (int i = 0; i < len; ++i){
            //找到第一个不等于
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return len + 1;
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
