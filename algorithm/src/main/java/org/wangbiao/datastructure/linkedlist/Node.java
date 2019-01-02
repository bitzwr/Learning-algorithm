package org.wangbiao.datastructure.linkedlist;

/**
 * Created by Wang Biao on 16/1/27.
 */
public class Node<T> {
    T data;
    Node<T> next;

    public Node() {
    }

    public Node(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data + (next != null ?  "->" + next : "");
    }
}
