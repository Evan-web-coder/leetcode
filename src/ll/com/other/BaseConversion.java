package ll.com.other;

import java.util.Scanner;

/**
 * 进制转换
 * 把十六进制字符串转化成十进制整数并输出
 */
public class BaseConversion {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			String str = sc.next().substring(2);
			System.out.println(Integer.parseInt(str, 16));
		}
	}
}