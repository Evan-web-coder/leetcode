package ll.com.str;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 字符串排序
 */
public class StrOrder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String[] ss = new String[num];

        for (int i = 0; i < num; i++) {
            ss[i] = sc.next();
        }

        Arrays.sort(ss);
        for (String s : ss) {
            System.out.println(s);
        }
    }
}