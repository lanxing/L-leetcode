import java.util.Stack;

/*
 * @lc app=leetcode id=71 lang=java
 *
 * [71] Simplify Path
 *
 * https://leetcode.com/problems/simplify-path/description/
 *
 * algorithms
 * Medium (28.06%)
 * Total Accepted:    141.4K
 * Total Submissions: 502.3K
 * Testcase Example:  '"/home/"'
 *
 * Given an absolute path for a file (Unix-style), simplify it. Or in other
 * words, convert it to the canonical path.
 * 
 * In a UNIX-style file system, a period . refers to the current directory.
 * Furthermore, a double period .. moves the directory up a level. For more
 * information, see: Absolute path vs relative path in Linux/Unix
 * 
 * Note that the returned canonical path must always begin with a slash /, and
 * there must be only a single slash / between two directory names. The last
 * directory name (if it exists) must not end with a trailing /. Also, the
 * canonical path must be the shortest string representing the absolute
 * path.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "/home/"
 * Output: "/home"
 * Explanation: Note that there is no trailing slash after the last directory
 * name.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "/../"
 * Output: "/"
 * Explanation: Going one level up from the root directory is a no-op, as the
 * root level is the highest level you can go.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "/home//foo/"
 * Output: "/home/foo"
 * Explanation: In the canonical path, multiple consecutive slashes are
 * replaced by a single one.
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: "/a/./b/../../c/"
 * Output: "/c"
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: "/a/../../b/../c//.//"
 * Output: "/c"
 * 
 * 
 * Example 6:
 * 
 * 
 * Input: "/a//b////c/d//././/.."
 * Output: "/a/b/c"
 * 
 * 
 */
class Solution {
    private static final String lastLayer = "../";
    public String simplifyPath(String path) {
        if (path.charAt(path.length() - 1) != '/'){
            path = path + '/';
        }
        Stack<String> stack = new Stack<>();
        StringBuilder dirBuilder = new StringBuilder();
        StringBuilder layerBuilder = new StringBuilder();
        int len = path.length();
        for (int i = 0; i < len; ++i){
            Character character = path.charAt(i);
            if (Character.isLetter(character) || Character.isDigit(character)){
                if (layerBuilder.length() > 0){
                    dirBuilder.append(layerBuilder.toString());
                    layerBuilder.delete(0, layerBuilder.length());
                }
                dirBuilder.append(character);
            }else if (character != '/'){
                layerBuilder.append(character);
            }else {
                //character='/'
                if (dirBuilder.length() > 0){
                    stack.add(dirBuilder.toString());
                    dirBuilder.delete(0, dirBuilder.length());
                }
                if (layerBuilder.length() >= 3){
                    dirBuilder.append(layerBuilder.toString());
                    layerBuilder.delete(0, layerBuilder.length());
                }else if(layerBuilder.length() > 0){
                    layerBuilder.append(character);
                    String tmp = layerBuilder.toString();
                    if (tmp.equals(lastLayer) && stack.size() > 0){
                        stack.pop();
                    }
                    layerBuilder.delete(0, layerBuilder.length());
                }
            }
        }
        if (dirBuilder.length() > 0){
            stack.add(dirBuilder.toString());
        }
        if (stack.isEmpty()){
            return "/";
        }else {
            StringBuilder builder = new StringBuilder();

            for (String str : stack){
                builder.append("/" + str);
            }
            return builder.toString();
        }
    }
}
