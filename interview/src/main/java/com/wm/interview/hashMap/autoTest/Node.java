package com.wm.interview.hashMap.autoTest;

public class Node {
    private Object value;
    private Object key;
    private Node next;

    public Node(){}

    public Node(Object value, Object key) {
        this.value = value;
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
