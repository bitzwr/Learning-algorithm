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
            throw new Exception("LinkedList do not contains any element");
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

    public void insert(T data, int i) {
        Node<T> newNode = new Node<T>(data);

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

    public static void main(String[] args) throws Exception {
        SinglyLinedList<Integer> list = new SinglyLinedList<Integer>();
        list.rearInsert(1);
        list.rearInsert(2);
        list.deleteElem(2);
        list.frontInsert(3);
        list.frontInsert(4);
        list.getElem(1);
    }
}
