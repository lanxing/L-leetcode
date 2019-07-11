package lalgorithm.normal;/*
 * @lc app=leetcode id=57 lang=java
 *
 * [57] Insert Interval
 *
 * https://leetcode.com/problems/insert-interval/description/
 *
 * algorithms
 * Hard (30.68%)
 * Total Accepted:    164.3K
 * Total Submissions: 534.7K
 * Testcase Example:  '[[1,3],[6,9]]\n[2,5]'
 *
 * Given a set of non-overlapping intervals, insert a new interval into the
 * intervals (merge if necessary).
 * 
 * You may assume that the intervals were initially sorted according to their
 * start times.
 * 
 * Example 1:
 * 
 * 
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with
 * [3,5],[6,7],[8,10].
 * 
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList();
        if (intervals == null || intervals.size() == 0){
            result.add(newInterval);
            return result;
        }
        int start = newInterval.start;
        int end = newInterval.end;
        int sStart, sEnd;
        boolean insertSuccess = false;
        //{}表示要插入的区间,[]遍历的区间
        for (Interval interval : intervals){
            if (insertSuccess){
                result.add(interval);
                continue;
            }
            sStart = interval.start;
            sEnd = interval.end;
            //{}[]
            if (end < sStart){
                result.add(new Interval(start, end));
                result.add(interval);
                insertSuccess = true;
                continue;
            }
            //{[]}
            if (start <= sStart && sEnd <= end){
                continue;
            }
            //{[}]
            if (start <= sStart && sStart <= end && end <= sEnd){
                end = sEnd;
                continue;
            }
            //[{}]
            if (start >= sStart && end <= sEnd){
                result.add(interval);
                insertSuccess = true;
                continue;
            }
            //[{]}
            if (start >= sStart && end >= sEnd && start <= sEnd){
                start = sStart;
                continue;
            }
            result.add(interval);
        }
        if (!insertSuccess){
            result.add(new Interval(start, end));
        }
        return result;
    }
}
