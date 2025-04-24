package ll.com.other;

/**
 * 跳台阶
 */
public class JumpFloor {
    public int jumpFloor (int number) {
        // write code here
        if (number == 0) {
            return 0;
        }
        if (number == 1) {
            return 1;
        }
        if (number == 2) {
            return 2;
        }
        int one = 1;
        int two = 2;
        int result = 0;
        for (int i = 3; i <= number; i++) {
            result = one + two;
            one = two;
            two = result;
        }
        return result;
    }
}
