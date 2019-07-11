package lalgorithm.normal;/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 *
 * https://leetcode.com/problems/merge-intervals/description/
 *
 * algorithms
 * Medium (34.70%)
 * Total Accepted:    306.2K
 * Total Submissions: 880K
 * Testcase Example:  '[[1,3],[2,6],[8,10],[15,18]]'
 *
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * Example 1:
 * 
 * 
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into
 * [1,6].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * 
 */


import java.util.Comparator;
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
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() < 2){
            return intervals;
        }
        List<Interval> result = new ArrayList();
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        Interval tmp = null;

        for (int i = 0; i < intervals.size(); ++i){
            if (tmp == null){
                tmp = intervals.get(i);
                continue;
            }
            Interval second = intervals.get(i);
            if (second.start <= tmp.end){
                tmp = new Interval(tmp.start, Math.max(second.end, tmp.end));
            }else {
                result.add(tmp);
                tmp = second;
            }
        }
        if (tmp != null){
            result.add(tmp);
        }
        return result;
    }
}
