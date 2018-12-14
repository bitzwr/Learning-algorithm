package org.wangbiao.datastructure.tree;

/**
 * Created by Wang Biao on 16/2/1.
 */
public class Node<T> {
    Node<T> parent;
    Node<T> left;
    Node<T> right;
    T data;

    public Node() {
    }

    public Node(T data) {
        this.data = data;
    }
}
