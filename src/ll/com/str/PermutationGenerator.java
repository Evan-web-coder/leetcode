package ll.com.str;

import java.util.ArrayList;
import java.util.List;

public class PermutationGenerator {
    public static List<String> getPermutations(String input) {
        List<String> result = new ArrayList<>();
        if (input == null || input.length() == 0) {
            return result;
        }
        boolean[] used = new boolean[input.length()];
        backtrack(input.toCharArray(), new StringBuilder(), used, result);
        return result;
    }

    private static void backtrack(char[] chars, StringBuilder path, boolean[] used, List<String> result) {
        if (path.length() == chars.length) {
            result.add(path.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (used[i]) {
                continue;
            }

            // 去重（如果有重复字符）
            if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) {
                continue;
            }

            used[i] = true;
            path.append(chars[i]);
            backtrack(chars, path, used, result);
            path.deleteCharAt(path.length() - 1);
            used[i] = false;
        }
    }

    // 示例用法
    public static void main(String[] args) {
        String input = "aab";
        List<String> permutations = getPermutations(input);
        permutations.forEach(System.out::println);
    }
}
