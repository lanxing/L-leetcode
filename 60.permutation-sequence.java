import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=60 lang=java
 *
 * [60] Permutation Sequence
 *
 * https://leetcode.com/problems/permutation-sequence/description/
 *
 * algorithms
 * Medium (32.15%)
 * Total Accepted:    129.2K
 * Total Submissions: 400.3K
 * Testcase Example:  '3\n3'
 *
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 * 
 * By listing and labeling all of the permutations in order, we get the
 * following sequence for n = 3:
 * 
 * 
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 
 * 
 * Given n and k, return the k^th permutation sequence.
 * 
 * Note:
 * 
 * 
 * Given n will be between 1 and 9 inclusive.
 * Given k will be between 1 and n! inclusive.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 3, k = 3
 * Output: "213"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 4, k = 9
 * Output: "2314"
 * 
 * 
 */
class Solution {
    public String getPermutation(int n, int k) {
        return firstSoluton(n, k);
    }

    private String firstSoluton(int n, int k){
        List<Integer> tmp = new ArrayList<>();
        backTracing(n, k, tmp, 0, new HashSet<>());
        StringBuilder builder = new StringBuilder();
        tmp.forEach(builder::append);
        return builder.toString();
    }


    private int backTracing(int n, int k, List<Integer> tmpResult, int index, Set<Integer> usedSet){
        if (tmpResult.size() == n){
            index++;
            return index;
        }
        for (int i = 1; i <=n; ++i){
            if (usedSet.contains(i)){
                continue;
            }
            if (index < k) {
                tmpResult.add(i);
                usedSet.add(i);
                index = backTracing(n, k, tmpResult, index, usedSet);
                if (index == k){
                    return index;
                }
                tmpResult.remove(tmpResult.size() - 1);
                usedSet.remove(i);
            }
        }
        return index;
    }
}
