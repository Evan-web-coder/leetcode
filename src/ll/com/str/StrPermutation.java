package ll.com.str;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 有重复字符串的排列组合
 */
public class StrPermutation {
    public String[] permutation(String S) {
        List<String> list = new ArrayList<>();
        char[] arr = S.toCharArray();
        backtrack(arr, 0, list);
        return list.toArray(new String[0]);
    }

    private void backtrack(char[] arr, int idx, List<String> list) {
        if (idx == arr.length - 1) {
            list.add(new String(arr));
            return;
        }

        Set<Character> set = new HashSet<>();
        for (int i = idx; i < arr.length; ++i) {
            if (!set.add(arr[i])) {
                continue;
            }

            char tmp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = tmp;
            backtrack(arr, idx + 1, list);
            tmp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = tmp;
        }
    }
}
