import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=62 lang=java
 *
 * [62] Unique Paths
 *
 * https://leetcode.com/problems/unique-paths/description/
 *
 * algorithms
 * Medium (46.23%)
 * Total Accepted:    260.2K
 * Total Submissions: 561.1K
 * Testcase Example:  '3\n2'
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
 * the diagram below).
 * 
 * How many possible unique paths are there?
 * 
 * 
 * Above is a 7 x 3 grid. How many possible unique paths are there?
 * 
 * Note: m and n will be at most 100.
 * 
 * Example 1:
 * 
 * 
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the
 * bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: m = 7, n = 3
 * Output: 28
 * 
 */
class Solution {
    private Map<String, Integer> storeMap = new HashMap<>();
    public int uniquePaths(int m, int n) {
//        return dynamic(m, n);
        return gride(m, n);
    }

    public int gride(int m, int n){
        int[][] tmp = new int[m][n];
        for (int i = 0; i < m; ++i){
            for (int j = 0; j < n; ++j){
                if (i == 0 || j == 0){
                    tmp[i][j] = 1;
                }else {
                    tmp[i][j] = tmp[i - 1][j] + tmp[i][j - 1];
                }
            }
        }
        return tmp[m - 1][n - 1];
    }

    public int dynamic(int m, int n){
        if (m == 1 || n == 1){
            return 1;
        }
        Integer left = storeMap.get((m - 1) + "_" + n);
        Integer right = storeMap.get(m + "_" + (n - 1));
        if (left == null){
            left = dynamic(m - 1, n);
            storeMap.put((m - 1) + "_" + n, left);
        }
        if (right == null){
            right = dynamic(m, n - 1);
            storeMap.put(m + "_" + (n - 1), right);
        }
        return left + right;
    }
}
