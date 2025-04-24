package ll.com.other;

public class PerfectNumberCounter {
    public static int countPerfectNumbers(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (isPerfectNumber(i)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isPerfectNumber(int num) {
        if (num < 2) {
            return false;
        }
        int sum = 1; // 1始终是因子
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                sum += i;
                if (i != num / i) { // 避免平方根重复加两次
                    sum += num / i;
                }
            }
        }
        return sum == num;
    }
}
