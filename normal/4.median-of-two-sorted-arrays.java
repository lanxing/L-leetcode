package lalgorithm.normal;

/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个有序数组的中位数
 *
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (33.82%)
 * Total Accepted:    40.5K
 * Total Submissions: 119.6K
 * Testcase Example:  '[1,3]\n[2]'
 *
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * 
 * 示例 1:
 * 
 * nums1 = [1, 3]
 * nums2 = [2]
 * 
 * 则中位数是 2.0
 * 
 * 
 * 示例 2:
 * 
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 
 * 则中位数是 (2 + 3)/2 = 2.5
 * 
 * 解析过程：https://zhuanlan.zhihu.com/p/39129143
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length){
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        int m = nums1.length;
        int n = nums2.length;

        int minI = 0, maxI = m, halfLen = (m + n + 1) / 2;
        while (minI <= maxI){
            int i = (minI + maxI) / 2;
            int j = halfLen - i;
            if (i < maxI && nums1[i] < nums2[j - 1]){
                //i太小
                minI = i + 1;
            }else if (i > minI && nums1[i - 1] > nums2[j]){
                //i太大
                maxI = i - 1;
            }else {
                int maxLeft = 0;
                if (i == 0){
                    maxLeft = nums2[j - 1];
                }else if (j == 0){
                    maxLeft = nums1[i - 1];
                }else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((m + n) % 2 == 1){
                    return maxLeft;
                }
                int minRight = 0;
                if (i == m){
                    minRight = nums2[j];
                }else if (j == n){
                    minRight = nums1[i];
                }else {
                    minRight = Math.min(nums1[i], nums2[j]);
                }
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0;
    }
}
