package ll.com.str;

/**
 * 括号的最大镶嵌深度
 */
public class MaxDepth {
    public int maxDepth(String s) {
        int depth = 0;
        int max = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                depth++;
                max = Math.max(depth, max);
            } else if (c == ')') {
                depth--;
            }
        }
        return max;
    }
}
