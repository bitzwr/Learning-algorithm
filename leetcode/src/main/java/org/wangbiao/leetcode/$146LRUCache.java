package org.wangbiao.leetcode;

public class $146LRUCache {

    public static class LRUCache {
        private int capacity;
        private int size;

        private Node head;

        private static class Node {
            Node pre;
            Node next;
            int key;
            int value;

            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }

            void remove() {
               this.pre.next = this.next;
               this.next.pre = this.pre;
            }

            void  addBefore(Node node) {
                this.next = node;
                this.pre = node.pre;
                this.pre.next = this;
                this.next.pre = this;
            }

            void access(LRUCache cache) {
                this.remove();
                this.addBefore(cache.head);
            }

        }

        public LRUCache(int capacity) {
            this.capacity = capacity;
            head = new Node(-1, -1);
            head.pre = head.next = head; // 哨兵，减化边界判断
        }

        private Node getNode(int key) {
            Node node = head.next;
            while (node != null && node != head) {
                if (node.key == key) {
                    node.access(this);
                    return node;
                } else {
                    node = node.next;
                }
            }
            return null;
        }

        public int get(int key) {
            Node node = getNode(key);
            if (node != null) {
                return node.value;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            Node node = getNode(key);
            if (node != null) {
                node.value = value;
            } else {
                node = new Node(key, value);
                node.addBefore(head);
                size++;
                if (size > capacity) {
                    head.next.remove();
                }
            }
        }

    }


    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        System.out.println(cache.get(1));
        System.out.println(cache.toString());
        cache.put(2, 2);

        int i = cache.get(1);
        System.out.println(i);
        System.out.println(cache.toString());

        cache.put(3, 3);
        System.out.println(cache.toString());

        int i1 = cache.get(2);
        System.out.println(i1);
        System.out.println(cache.toString());

        cache.put(4, 4);
        System.out.println(cache.toString());
        int i2 = cache.get(1);
        System.out.println(i2);
        System.out.println(cache.toString());

        int i3 = cache.get(3);
        System.out.println(i3);
        System.out.println(cache.toString());

        int i4 = cache.get(4);
        System.out.println(i4);
        System.out.println(cache.toString());

    }

}
