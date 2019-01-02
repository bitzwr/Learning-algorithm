package org.wangbiao.datastructure.linkedlist;

/**
 * Created by Wang Biao on 16/1/27.
 */
public class SinglyLinedList<T> {

    private Node<T> head = new Node<T>();

    /**
     * 头插法
     */
    public void frontInsert(T data) throws Exception {
        if (head == null) {
            throw new Exception("LinkedList do not init");
        }
        Node<T> newNode = new Node<T>(data);
        newNode.next = head.next;
        head.next = newNode;
    }

    /**
     * 尾插法
     */
    public void rearInsert(T data) throws Exception {
        if (head == null) {
            throw new Exception("LinkedList do not init");
        }
        Node<T> node = head;
        Node<T> newNode = new Node<T>(data);
        while (node.next != null) {
            node = node.next;
        }
        node.next = newNode;
    }

    /**
     * 插入元素到指定位置
     */
    public void insert(T data, int i) throws Exception {
        if (head == null) {
            throw new Exception("LinkedList do not init");
        }
        if (i <= 0) {
            throw new IllegalArgumentException("i must be a positive integer");
        }
        Node<T> node = head;
        int j = 0;
        while (node.next != null && j < i - 1) { // 寻找第i - 1 个节点
            node = node.next;
            ++j;
        }
        if (node == null || j > i - 1) {
            throw new Exception("i greater than length + 1");
        }
        Node<T> newNode = new Node<T>(data);
        newNode.next = node.next;
        node.next = newNode;
    }

    /**
     * 删除第i个元素, 从1开始计数
     */
    public T deleteElem(int i) throws Exception {
        if (head == null) {
            throw new Exception("LinkedList do not init");
        }
        if (i <= 0) {
            throw new IllegalArgumentException("i must be a positive integer");
        }
        int j = 0;
        while (head.next != null && j < i - 1) { // 寻找第i个节点, 并令node指向其前驱
            head = head.next;
            ++j;
        }
        if (head.next == null || j > i - 1) {
            throw new Exception("ith element do not exist");
        }
        T elemValue = head.next.data;
        head.next = head.next.next;
        return elemValue;
    }

    /**
     * 获取元素中的数据,从1开始计数
     */
    public T getElem(int i) throws Exception {
        if (head == null) {
            throw new Exception("LinkedList do not init");
        }
        if (i <= 0) {
            throw new IllegalArgumentException("i must be a positive integer");
        }
        Node<T> node = head.next;
        int j = 1;
        while (node != null && j < i) {
            node = node.next;
            ++j;
        }
        if (node == null || j < i) {
            throw new Exception("ith element do not exist");
        }
        return node.data;
    }


    public static Node reverse(Node node) {
        Node head = new Node();
        Node next = null;
        while (node != null) {
            next = node.next; // 备份
            node.next = head.next;
            head.next = node;

            node = next;
        }
        return head.next;
    }

    public boolean hasCircle(Node node) {
        Node faster, slower;
        while (node != null && node.next != null) {

        }

        return false;
    }

    public static void main(String[] args) throws Exception {

    }
}
