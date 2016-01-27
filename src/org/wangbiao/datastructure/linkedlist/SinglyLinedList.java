package org.wangbiao.datastructure.linkedlist;

/**
 * Created by Wang Biao on 16/1/27.
 */
public class SinglyLinedList<T> {

    Node<T> head = new Node<T>();

    public void insert(T data) {
        Node<T> newNode = new Node<T>(data);
        if(this != null) {
            newNode.next = head.next;
            head.next = newNode;
        }
    }

    public static void main(String[] args) {
        SinglyLinedList<Integer> list = new SinglyLinedList<Integer>();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
    }
}
