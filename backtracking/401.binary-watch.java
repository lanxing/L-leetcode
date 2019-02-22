import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode id=401 lang=java
 *
 * [401] Binary Watch
 *
 * https://leetcode.com/problems/binary-watch/description/
 *
 * algorithms
 * Easy (45.03%)
 * Total Accepted:    59.6K
 * Total Submissions: 132.4K
 * Testcase Example:  '0'
 *
 * A binary watch has 4 LEDs on the top which represent the hours (0-11), and
 * the 6 LEDs on the bottom represent the minutes (0-59).
 * Each LED represents a zero or one, with the least significant bit on the
 * right.
 * 
 * For example, the above binary watch reads "3:25".
 * 
 * Given a non-negative integer n which represents the number of LEDs that are
 * currently on, return all possible times the watch could represent.
 * 
 * Example:
 * Input: n = 1Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04",
 * "0:08", "0:16", "0:32"]
 * 
 * 
 * Note:
 * 
 * The order of output does not matter.
 * The hour must not contain a leading zero, for example "01:00" is not valid,
 * it should be "1:00".
 * The minute must be consist of two digits and may contain a leading zero, for
 * example "10:2" is not valid, it should be "10:02".
 * 
 * 
 */
class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList<>();
        List<String> hourList = new ArrayList<>();
        List<String> minuteList = new ArrayList<>();
        for (int i = 0; i <= num; ++i){
            char[] hourchar = {'0', '0', '0', '0'};
            char[] minutechar = {'0', '0', '0', '0', '0', '0'};
            hourList.clear();
            minuteList.clear();
            minuteBackTree(minutechar, 0, i, minuteList);
            hourBackTree(hourchar, 0, num - i, hourList);
            tran(result, hourList, minuteList);
        }
        Collections.sort(result);
        return result;
    }

    private void tran(List<String> result, List<String> hourList, List<String> minuteList){
        for (String min : minuteList){
            for (String str : hourList){
                result.add(str + ":" + min);
            }
        }
    }

    public void minuteBackTree(char[] hourchar, int index, int hour, List<String> result){
        if (hour == 0){
            int tmp = Integer.parseInt(String.valueOf(hourchar), 2);
            if (tmp < 60) {
                if (tmp < 10){
                    result.add("0" + tmp);
                }else {
                    result.add(String.valueOf(tmp));
                }
            }
            return;
        }
        if (index >= 6 ){
            return;
        }
        for (int i = index; i < 6; ++i){
            hourchar[5 - i] = '1';
            minuteBackTree(hourchar, i  +1, hour - 1, result);
            hourchar[5 - i] = '0';
        }
    }

    public void hourBackTree(char[] hourchar, int index, int hour, List<String> result){

        if (hour == 0){
            int tmp = Integer.parseInt(String.valueOf(hourchar), 2);
            if (tmp < 12) {
                result.add(String.valueOf(tmp));
            }
            return;
        }
        if (index >= 4 ){
            return;
        }
        for (int i = index; i < 4; ++i){
            hourchar[3 - i] = '1';
            hourBackTree(hourchar, i  +1, hour - 1, result);
            hourchar[3 - i] = '0';
        }

    }
}
