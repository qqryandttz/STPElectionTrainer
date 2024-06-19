public class MyQueue {

    private int[] a;
    private int front;
    private int rear;

    public MyQueue(int capacity) {
        a = new int[capacity + 1]; // 有一个位置不存储数据，为了区别空和满的状态，牺牲一个空间
        front = 0;
        rear = 0;
    }

    // 判空
    public boolean isEmpty() {
        return front == rear;
    }

    // 判满
    public boolean isFull() {
        return ((rear + 1) % a.length) == front;
    }

    // 入队
    public boolean add(int value) {
        if (isFull()) {
            System.out.println("队列满");
            return false;
        }
        rear = (rear + 1) % a.length;
        a[rear] = value;
        return true;
    }

    // 出队
    public int remove() {
        if (isEmpty()) {
            System.out.println("队列空");
            return -1;
        }
        front = (front + 1) % a.length;
        return a[front];
    }

    // 获取队头元素
    public int peek() {
        if (isEmpty()) {
            System.out.println("队列空");
            return -1;
        }
        return a[front];
    }

}
