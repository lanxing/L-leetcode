import java.util.*;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 *
 * https://leetcode-cn.com/problems/3sum/description/
 *
 * algorithms
 * Medium (21.32%)
 * Total Accepted:    48.6K
 * Total Submissions: 222.5K
 * Testcase Example:  '[-1,0,1,2,-1,-4]'
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0
 * ？找出所有满足条件且不重复的三元组。
 * 
 * 注意：答案中不可以包含重复的三元组。
 * 
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 
 * 满足要求的三元组集合为：
 * [
 * ⁠ [-1, 0, 1],
 * ⁠ [-1, -1, 2]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> usedSet = new HashSet<>();
        Set<Integer> filterSet = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        int left;
        int right;
        int target;
        int sum;
        for (int i = 0; i < nums.length; ++i){
            if (usedSet.contains(nums[i])){
                continue;
            }
            usedSet.add(nums[i]);
            filterSet.clear();
            left = i + 1;
            right = nums.length - 1;
            target = 0 - nums[i];
            while (left < right){
                if (filterSet.contains(nums[left])){
                    left++;
                    continue;
                }
                sum = nums[left] + nums[right];
                if (sum == target){
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    filterSet.add(nums[left]);
                    left++;
                    right--;
                }else if (sum < target){
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
