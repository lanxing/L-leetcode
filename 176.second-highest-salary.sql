--
-- @lc app=leetcode.cn id=176 lang=mysql
--
-- [176] 第二高的薪水
--
-- https://leetcode-cn.com/problems/second-highest-salary/description/
--
-- database
-- Easy (28.72%)
-- Total Accepted:    35.7K
-- Total Submissions: 114.9K
-- Testcase Example:  '{"headers": {"Employee": ["Id", "Salary"]}, "rows": {"Employee": [[1, 100], [2, 200], [3, 300]]}}'
--
-- 编写一个 SQL 查询，获取 Employee 表中第二高的薪水（Salary） 。
-- 
-- +----+--------+
-- | Id | Salary |
-- +----+--------+
-- | 1  | 100    |
-- | 2  | 200    |
-- | 3  | 300    |
-- +----+--------+
-- 
-- 
-- 例如上述 Employee 表，SQL查询应该返回 200 作为第二高的薪水。如果不存在第二高的薪水，那么查询应返回 null。
-- 
-- +---------------------+
-- | SecondHighestSalary |
-- +---------------------+
-- | 200                 |
-- +---------------------+
-- 
-- 
--
# Write your MySQL query statement below

select IFNULL((select Distinct Salary from Employee order by Salary DESC limit 1,1),null) as SecondHighestSalary

