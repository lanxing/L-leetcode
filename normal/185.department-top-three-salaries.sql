--
-- @lc app=leetcode.cn id=185 lang=mysql
--
-- [185] 部门工资前三高的员工
--
-- https://leetcode-cn.com/problems/department-top-three-salaries/description/
--
-- database
-- Hard (29.74%)
-- Total Accepted:    9.3K
-- Total Submissions: 26.5K
-- Testcase Example:  '{"headers": {"Employee": ["Id", "Name", "Salary", "DepartmentId"], "Department": ["Id", "Name"]}, "rows": {"Employee": [[1, "Joe", 85000, 1], [2, "Henry", 80000, 2], [3, "Sam", 60000, 2], [4, "Max", 90000, 1], [5, "Janet", 69000, 1], [6, "Randy", 85000, 1], [7, "Will", 70000, 1]], "Department": [[1, "IT"], [2, "Sales"]]}}'
--
-- Employee 表包含所有员工信息，每个员工有其对应的 Id, salary 和 department Id 。
-- 
-- +----+-------+--------+--------------+
-- | Id | Name  | Salary | DepartmentId |
-- +----+-------+--------+--------------+
-- | 1  | Joe   | 70000  | 1            |
-- | 2  | Henry | 80000  | 2            |
-- | 3  | Sam   | 60000  | 2            |
-- | 4  | Max   | 90000  | 1            |
-- | 5  | Janet | 69000  | 1            |
-- | 6  | Randy | 85000  | 1            |
-- +----+-------+--------+--------------+
-- 
-- 
-- Department 表包含公司所有部门的信息。
-- 
-- +----+----------+
-- | Id | Name     |
-- +----+----------+
-- | 1  | IT       |
-- | 2  | Sales    |
-- +----+----------+
-- 
-- 
-- 编写一个 SQL 查询，找出每个部门工资前三高的员工。例如，根据上述给定的表格，查询结果应返回：
-- 
-- +------------+----------+--------+
-- | Department | Employee | Salary |
-- +------------+----------+--------+
-- | IT         | Max      | 90000  |
-- | IT         | Randy    | 85000  |
-- | IT         | Joe      | 70000  |
-- | Sales      | Henry    | 80000  |
-- | Sales      | Sam      | 60000  |
-- +------------+----------+--------+
-- 
-- 
--
# Write your MySQL query statement below

Select d.Name as Department, e.Name as Employee, e.Salary
from Department d, Employee e
where e.DepartmentId = d.Id and (
    Select count(distinct Salary) From Employee where DepartmentId=d.Id and Salary > e.Salary
)<3
order by Department