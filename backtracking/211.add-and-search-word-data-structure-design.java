import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/*
 * @lc app=leetcode id=211 lang=java
 *
 * [211] Add and Search Word - Data structure design
 *
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/description/
 *
 * algorithms
 * Medium (29.03%)
 * Total Accepted:    104K
 * Total Submissions: 357.9K
 * Testcase Example:  '["WordDictionary","addWord","addWord","addWord","search","search","search","search"]\n[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]'
 *
 * Design a data structure that supports the following two operations:
 * 
 * 
 * void addWord(word)
 * bool search(word)
 * 
 * 
 * search(word) can search a literal word or a regular expression string
 * containing only letters a-z or .. A . means it can represent any one
 * letter.
 * 
 * Example:
 * 
 * 
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * 
 * 
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 * 
 */
class WordDictionary {

    private SortedSet<String> orderedSet;
    private SortedSet<String> reverseSet;

    /** Initialize your data structure here. */
    public WordDictionary() {
        orderedSet = new TreeSet<>();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        orderedSet.add(word);
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if (word == null){
            return false;
        }
        if ("..".equals(word)){
            return true;
        }
        //正常搜索
        int index = 0;
        String search;
        if (!word.contains(".")){
            return orderedSet.contains(word);
        }else if ((index = word.indexOf("..")) != -1){
            //包含".."
            if (index == 0){
                //..在前面
                search = word.substring(2);
                for (String str : orderedSet){
                    if (str.indexOf(search) == str.length() - search.length()){
                        return true;
                    }
                }
                return false;
            }else {
                //..在后边
                search = word.substring(0, word.length() - 2);
                for (String str : orderedSet){
                    if (str.indexOf(search) == 0){
                        return true;
                    }
                }
                return false;
            }
        }else {
            //包含一个.
            index = word.indexOf(".");
            if (index == 0){
                //.在前面
                search = word.substring(1);
                for (String str : orderedSet){
                    if (str.length() > 0 && str.substring(1).equals(search)){
                        return true;
                    }
                }
                return false;
            }else {
                //.在后边
                search = word.substring(0, word.length() - 1);
                for (String str : orderedSet){
                    if (str.length() > 0 && str.substring(0, str.length() - 1).equals(search)){
                        return true;
                    }
                }
                return false;
            }
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
