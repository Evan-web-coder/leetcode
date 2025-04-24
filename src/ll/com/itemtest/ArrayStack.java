package ll.com.itemtest;

// Write a class to implement a stack using arrays with methods for push, pop, and peek.
public class ArrayStack {
    private int[] stack;
    private int top;
    private int capacity;

    // 构造函数：初始化栈容量
    public ArrayStack(int size) {
        capacity = size;
        stack = new int[capacity];
        top = -1; // 栈空时 top 为 -1
    }

    // 推送元素入栈
    public void push(int val) {
        if (top == capacity - 1) {
            throw new StackOverflowError("栈已满");
        }
        stack[++top] = val;
    }

    // 弹出栈顶元素
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        return stack[top--];
    }

    // 查看栈顶元素（不移除）
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        return stack[top];
    }

    // 判断栈是否为空
    public boolean isEmpty() {
        return top == -1;
    }

    // 栈当前大小
    public int size() {
        return top + 1;
    }

    // 示例
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("当前栈顶元素: " + stack.peek()); // 30
        System.out.println("弹出元素: " + stack.pop());     // 30
        System.out.println("当前栈顶元素: " + stack.peek()); // 20
        System.out.println("栈是否为空: " + stack.isEmpty()); // false
    }
}
