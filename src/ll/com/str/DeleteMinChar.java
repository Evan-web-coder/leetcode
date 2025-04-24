package ll.com.str;

/**
 * 删除字符串中出现次数最少的字符
 */
public class DeleteMinChar {
	public static void deleteLeastChar(String s) {
		int[] c = new int[26];

		for (int i = 0; i < s.length(); i++) {
			c[s.charAt(i) - 'a']++;
		}
		int min = c[s.charAt(0) - 'a'];
		for (int i = 0; i < s.length(); i++) {
			int i1 = c[s.charAt(i) - 'a'];
			if (min > i1 && i1 != 0) {
				min = i1;
			}
		}
		for (int i = 0; i < s.length(); i++) {
			if (c[s.charAt(i) - 'a'] > min) {
				System.out.print(s.charAt(i));
			}
		}
		System.out.println();
	}
}