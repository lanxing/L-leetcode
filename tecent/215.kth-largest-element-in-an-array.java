/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 *
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/description/
 *
 * algorithms
 * Medium (56.56%)
 * Total Accepted:    33K
 * Total Submissions: 57.3K
 * Testcase Example:  '[3,2,1,5,6,4]\n2'
 *
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 
 * 示例 1:
 * 
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 
 * 
 * 示例 2:
 * 
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 
 * 说明: 
 * 
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 * 
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, nums.length - k + 1);
    }

    private int quickSort(int[] nums, int i, int j, int k){
        if (i > j){
            return 0;
        }
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
        if (start == k - 1){
            return nums[start];
        }
        if (start < k - 1){
            return 	quickSort(nums, start + 1, j, k);
        }
        return quickSort(nums, i, start - 1, k);
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
