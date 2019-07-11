package lalgorithm.normal;

/*
 * @lc app=leetcode.cn id=137 lang=java
 *
 * [137] 只出现一次的数字 II
 *
 * https://leetcode-cn.com/problems/single-number-ii/description/
 *
 * algorithms
 * Medium (62.67%)
 * Total Accepted:    8.2K
 * Total Submissions: 12.9K
 * Testcase Example:  '[2,2,3,2]'
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 * 
 * 说明：
 * 
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * 
 * 示例 1:
 * 
 * 输入: [2,2,3,2]
 * 输出: 3
 * 
 * 
 * 示例 2:
 * 
 * 输入: [0,1,0,1,0,1,99]
 * 输出: 99
 * 统计每位上1的合，如果是3的倍数说明多余的一位是0，否则为1
 */
class Solution {
    public int singleNumber(int[] nums) {
        int tmp = 0;
        for (int i = 0; i < 32; ++i){
            int sum = 0;
            for (int num : nums){
                sum += (num >> i) & 1;
            }
            if (sum % 3 != 0){
                tmp |= (1<<i);
            }
        }
        return tmp;
    }
}
