package quiz;

import java.util.HashMap;

/**
 * https://www.jianshu.com/p/62e829c37adf
 * LRU HashMap get/set + LinkedList Insert/Delete
 *
 * @author YoSaukit
 * @date 2020/4/2 17:34
 */
public class LRU {
    private class Node {
        Node prev;
        Node next;
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    private int capacity;
    private HashMap<Integer, Node> hm = new HashMap<>();
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);

    public LRU(int capacity) {
        this.capacity = capacity;
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {
        if (!hm.containsKey(key)) return -1;
        Node current = hm.get(key);
        current.prev.next = current.next;
        current.next.prev = current.prev;
        moveToTail(current);
        return hm.get(key).value;
    }

    public void set(int key, int value) {
        if (get(key) != -1) {
            hm.get(key).value = value;
            return;
        }
        if (hm.size() == capacity) {
            hm.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }
        Node insert = new Node(key,value);
        hm.put(key,insert);
        moveToTail(insert);
    }


    private void moveToTail(Node current) {
        current.next = tail;
        tail.prev.next = current;
        current.prev = tail.prev;
        tail.prev = current;
    }

}
