import java.util.*;

/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 *
 * https://leetcode.com/problems/3sum/description/
 *
 * algorithms
 * Medium (23.15%)
 * Total Accepted:    472.2K
 * Total Submissions: 2M
 * Testcase Example:  '[-1,0,1,2,-1,-4]'
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such
 * that a + b + c = 0? Find all unique triplets in the array which gives the
 * sum of zero.
 * 
 * Note:
 * 
 * The solution set must not contain duplicate triplets.
 * 
 * Example:
 * 
 * 
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * 
 * A solution set is:
 * [
 * ⁠ [-1, 0, 1],
 * ⁠ [-1, -1, 2]
 * ]
 * 分析：
 * 类似于2sum
 * 1. 将数组进行从小到大排序
 * 2. 固定一个游标index，然后对剩余的数使用双指针方法求合
 * 3. 双指针只需要在index右边即可，因为左边的index已经指定过
 * 4. 为了防止重复，对index进行去重，同时当index固定时，对第一个指针(left)进行去重
 * 
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        if (nums.length < 3){
            return Collections.EMPTY_LIST;
        }
        Set<Integer> fixSet = new HashSet<>();
        Set<Integer> filterSet = new HashSet<>();
        int left;
        int right;
        int target;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i){
            if (fixSet.contains(nums[i])){
                continue;
            }
            if (nums[i] > 0){
                break;
            }
            filterSet.clear();
            fixSet.add(nums[i]);
            target = 0 - nums[i];
            left = i + 1;
            right = nums.length - 1;
            while (left < right){
                if (filterSet.contains(nums[left])){
                    left++;
                    continue;
                }
                int tmpResult = nums[left] + nums[right];
                if (tmpResult == target){
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[left]);
                    tmp.add(nums[right]);
                    result.add(tmp);
                    filterSet.add(nums[left]);
                    left++;
                    right--;
                }else if (tmpResult < target){
                    filterSet.add(nums[left]);
                    left++;
                }else {
                    right--;
                }
            }
        }
        return result;
    }

}
