package org.wangbiao.datastructure.queue;

/**
 * Created by Wang Biao on 16/1/16.
 */
public class Queue {
    private int MAX_SIZE = 8; // 队列的最大长度
    private int[] data = new int[MAX_SIZE]; // 数组模拟队列
    private int front = 0; // 头
    private int rear = 0; // 尾
    private int length = 0; // 长度

    /**
     * 入队
     */
    public void enqueue(int t) {
        if (!isFull()) {
            data[rear] = t;
            rear = (rear + 1) % MAX_SIZE;
            length++;
        }
    }

    /**
     * 出队
     */
    public int dequeue() throws Exception {
        if (length != 0) {
            int temp = front;
            length--;
            front = (front + 1) % MAX_SIZE;
            return data[temp];
        }
        throw new Exception("队列为空");
    }

    /**
     * 查看对头
     */
    public int peek() throws Exception {
        if (length != 0) {
            return data[front];
        }
        throw new Exception("队列为空");
    }


    /**
     * 判断队列是否满
     */
    public boolean isFull() {
        return (rear + 1) % MAX_SIZE == front;
    }

    /**
     * 队列长度
     */
    public int length() {
        return (rear - front + MAX_SIZE) % MAX_SIZE;
    }

    public void clear() {
        front = 0;
        rear = 0;
        length = 0;
    }

    public static void main(String[] args) throws Exception {
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        System.out.println();
    }
}
