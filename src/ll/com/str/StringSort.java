package ll.com.str;

import java.util.Scanner;

/**
 * 字符串排序
 */
public class StringSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String s = sc.nextLine();
			char[] chArray = s.toCharArray();
			System.out.println(stringSort(chArray));
		}
	}

	public static String stringSort(char[] chArray) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 26; i++) {
			char ch = (char) ('a' + i);
            for (char c : chArray) {
                if (c == ch || c == (char) (ch + 'A' - 'a')) {
                    sb.append(c);
                }
            }
		}
		for (int i = 0; i < chArray.length; i++) {
			if (!(chArray[i] >= 'a' && chArray[i] <= 'z' || chArray[i] >= 'A' && chArray[i] <= 'Z')) {
				sb.insert(i, chArray[i]);
			}
		}
		return sb.toString();
	}
}