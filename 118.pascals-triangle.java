import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=118 lang=java
 *
 * [118] 杨辉三角
 *
 * https://leetcode-cn.com/problems/pascals-triangle/description/
 *
 * algorithms
 * Easy (60.31%)
 * Total Accepted:    23.5K
 * Total Submissions: 37.9K
 * Testcase Example:  '5'
 *
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 
 * 
 * 
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 
 * 示例:
 * 
 * 输入: 5
 * 输出:
 * [
 * ⁠    [1],
 * ⁠   [1,1],
 * ⁠  [1,2,1],
 * ⁠ [1,3,3,1],
 * ⁠[1,4,6,4,1]
 * ]
 * 
 */
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows <= 0){
            return result;
        }
        for (int i = 0; i < numRows; ++i){
            List<Integer> tmp = new ArrayList<>(i);
            if (i - 1 < 0){
                tmp.add(1);
            }else {
                List<Integer> last = result.get(i - 1);
                for (int j = 0; j <= i; ++j){
                    int first = j - 1 < 0 ? 0 : last.get(j - 1);
                    int second = j == last.size() ? 0 : last.get(j);
                    tmp.add(first + second);
                }
            }
            result.add(tmp);
        }
        return result;
    }
}
