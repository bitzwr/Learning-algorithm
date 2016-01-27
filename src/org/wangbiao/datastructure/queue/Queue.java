package org.wangbiao.datastructure.queue;

/**
 * Created by Wang Biao on 16/1/16.
 */
public class Queue {
    private int MAX_SIZE = 8; // 队列的最大长度
    private int[] data = new int[MAX_SIZE]; // 数组模拟队列
    private int front = 0; // 头
    private int rear = 0; // 尾

    /**
     * 入队
     */
    public void enqueue(int t) throws Exception {
        if (isFull()) {
            throw new Exception("队列已满");
        }
        data[rear] = t;
        rear = (rear + 1) % MAX_SIZE;
    }

    /**
     * 出队
     */
    public int dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception("队列为空");
        }
        int temp = data[front];
        front = (front + 1) % MAX_SIZE;
        return data[temp];
    }

    /**
     * 查看对头
     */
    public int peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("队列为空");
        }
        return data[front];
    }

    /**
     * 判断是否为空
     */
    public boolean isEmpty() {
        if (front == rear) {
            return true;
        }
        return false;
    }

    /**
     * 判断队列是否满
     * 循环队列必须留一个空间,用于判断队列是否已满,
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


    public static void main(String[] args) throws Exception {
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.length());
        System.out.println(queue.dequeue());
        queue.enqueue(4);
        queue.enqueue(4);
        System.out.println(queue.dequeue());
        queue.enqueue(4);
        queue.enqueue(4);
        System.out.println(queue.dequeue());
        queue.enqueue(4);
        System.out.println(queue.dequeue());
        queue.enqueue(4);
        System.out.println();
    }
}
