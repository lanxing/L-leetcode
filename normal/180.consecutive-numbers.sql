--
-- @lc app=leetcode.cn id=180 lang=mysql
--
-- [180] 连续出现的数字
--
-- https://leetcode-cn.com/problems/consecutive-numbers/description/
--
-- database
-- Medium (41.34%)
-- Total Accepted:    11.5K
-- Total Submissions: 25.4K
-- Testcase Example:  '{"headers": {"Logs": ["Id", "Num"]}, "rows": {"Logs": [[1, 1], [2, 1], [3, 1], [4, 2], [5, 1], [6, 2], [7, 2]]}}'
--
-- 编写一个 SQL 查询，查找所有至少连续出现三次的数字。
-- 
-- +----+-----+
-- | Id | Num |
-- +----+-----+
-- | 1  |  1  |
-- | 2  |  1  |
-- | 3  |  1  |
-- | 4  |  2  |
-- | 5  |  1  |
-- | 6  |  2  |
-- | 7  |  2  |
-- +----+-----+
-- 
-- 
-- 例如，给定上面的 Logs 表， 1 是唯一连续出现至少三次的数字。
-- 
-- +-----------------+
-- | ConsecutiveNums |
-- +-----------------+
-- | 1               |
-- +-----------------+
-- 
-- 
--
# Write your MySQL query statement below

select distinct l1.Num ConsecutiveNums from Logs l1
left join Logs l2 on l1.Id = l2.Id - 1
left join Logs l3 on l1.Id = l3.Id - 2
where l1.Num = l2.Num and l2.Num = l3.Num;
