package lalgorithm.normal;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿的个数
 *
 * https://leetcode-cn.com/problems/number-of-islands/description/
 *
 * algorithms
 * Medium (41.47%)
 * Total Accepted:    18.1K
 * Total Submissions: 40.5K
 * Testcase Example:  '[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]'
 *
 * 给定一个由 '1'（陆地）和
 * '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * 
 * 示例 1:
 * 
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 
 * 输出: 1
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 
 * 输出: 3
 * 
 * 
 */
class Solution {
    public int numIslands(char[][] grid) {
        char tmp = 'a';
        int row = grid.length;
        if (row == 0){
            return 0;
        }
        int col = grid[0].length;
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < row; ++i){
            for (int j = 0; j < col; ++j){
                if (grid[i][j] == '1'){
                    linkLands(grid, i, j, tmp++, visited);
                }
            }
        }
        return tmp - 'a';
    }
    private class Coord{
        int x;
        int y;
        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private void linkLands(char[][] grid, int i, int j, char c, Set<Integer> visited){
        int row = grid.length;
        int col = grid[0].length;
        Deque<Coord> deque = new ArrayDeque<>();
        deque.add(new Coord(i, j));
        while (!deque.isEmpty()){
            Coord coord = deque.pop();
            int x = coord.x;
            int y = coord.y;
            grid[x][y] = c;
            if (x - 1 >= 0 && !visited.contains((x - 1) * col + y) && grid[x - 1][y] == '1'){
                deque.add(new Coord(x - 1, y));
                visited.add((x - 1) * col + y);
            }
            if (x + 1 < row && !visited.contains((x + 1) * col + y) && grid[x + 1][y] == '1'){
                deque.add(new Coord(x + 1, y));
                visited.add((x + 1) * col + y);
            }
            if (y - 1 >= 0 && !visited.contains(x * col + y - 1) && grid[x][y - 1] == '1'){
                deque.add(new Coord(x, y - 1));
                visited.add(x * col + y - 1);
            }
            if (y + 1 < col && !visited.contains(x * col + y + 1) && grid[x][y + 1] == '1'){
                deque.add(new Coord(x, y + 1));
                visited.add(x * col + y + 1);
            }
        }
    }
}
