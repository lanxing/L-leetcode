/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 求众数
 *
 * https://leetcode-cn.com/problems/majority-element/description/
 *
 * algorithms
 * Easy (58.15%)
 * Total Accepted:    48.8K
 * Total Submissions: 81.8K
 * Testcase Example:  '[3,2,3]'
 *
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * 
 * 示例 1:
 * 
 * 输入: [3,2,3]
 * 输出: 3
 * 
 * 示例 2:
 * 
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 * 
 * 
 */
class Solution {

    public int majorityElement(int[] nums) {
        int ctn = 0;
        int candi = 0;
        for (int num : nums){
            if (num == candi){
                ctn++;
            }else if (ctn == 0){
                candi = num;
            }else {
                ctn--;
            }
        }
        return candi;
    }

    public int majorityElement1(int[] nums) {
        return quiciSort(nums, 0, nums.length - 1, nums.length / 2);
    }

    private int quiciSort(int[] nums, int i, int j, int k){
        int start = i, end = j;
        int target = start;
        while (start < end){
            while (start < end && nums[end] >= nums[target]){
                end--;
            }
            while (start < end && nums[start] <= nums[target]){
                start++;
            }
            if (start < end){
                swap(nums, start, end);
            }
        }
        swap(nums, start, target);
        if (start == k){
            return nums[start];
        }
        if (start < k){
            return quiciSort(nums, start + 1, j, k);
        }else {
            return quiciSort(nums, i, start - 1, k);
        }
    }

    private void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
