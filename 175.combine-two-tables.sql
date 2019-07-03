--
-- @lc app=leetcode.cn id=175 lang=mysql
--
-- [175] 组合两个表
--
-- https://leetcode-cn.com/problems/combine-two-tables/description/
--
-- database
-- Easy (66.04%)
-- Total Accepted:    51K
-- Total Submissions: 73.9K
-- Testcase Example:  '{"headers": {"Person": ["PersonId", "LastName", "FirstName"], "Address": ["AddressId", "PersonId", "City", "State"]}, "rows": {"Person": [[1, "Wang", "Allen"]], "Address": [[1, 2, "New York City", "New York"]]}}'
--
-- 表1: Person
-- 
-- +-------------+---------+
-- | 列名         | 类型     |
-- +-------------+---------+
-- | PersonId    | int     |
-- | FirstName   | varchar |
-- | LastName    | varchar |
-- +-------------+---------+
-- PersonId 是上表主键
-- 
-- 
-- 表2: Address
-- 
-- +-------------+---------+
-- | 列名         | 类型    |
-- +-------------+---------+
-- | AddressId   | int     |
-- | PersonId    | int     |
-- | City        | varchar |
-- | State       | varchar |
-- +-------------+---------+
-- AddressId 是上表主键
-- 
-- 
-- 
-- 
-- 编写一个 SQL 查询，满足条件：无论 person 是否有地址信息，都需要基于上述两表提供 person 的以下信息：
-- 
-- 
-- 
-- FirstName, LastName, City, State
-- 
-- 
--
# Write your MySQL query statement below

select p.FirstName, p.LastName, a.City, a.State from Person p left join Address a on a.PersonId = p.PersonId