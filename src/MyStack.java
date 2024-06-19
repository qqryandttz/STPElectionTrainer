public class MyStack {

    private int[] a; // 存储数据
    private int size; // 当前元素的个数

    public MyStack(int capacity) {
        size = -1;
        a = new int[capacity];
    }

    public MyStack() {
        this(16); // 默认容量为16
    }

    // 判空
    public boolean isEmpty() {
        return size == -1;
    }

    // 判满
    public boolean isFull() {
        return size == a.length - 1;
    }

    // 入栈
    public boolean push(int value) {
        if (isFull()) {
            System.out.println("栈已满，无法入栈");
            return false;
        }
        a[++size] = value;
        return true;
    }

    // 出栈
    public int pop() {
        if (isEmpty()) {
            System.out.println("栈空，无法出栈");
            return -1;
        }
        return a[size--];
    }

    // 获取栈顶元素
    public int peek() {
        if (isEmpty()) {
            System.out.println("栈空，无法出栈");
            return -1;
        }
        return a[size];
    }

}
