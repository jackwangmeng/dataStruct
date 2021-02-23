package com.wm.interview.hashMap.autoTest;

import javax.security.auth.login.CredentialNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;

public class MyHash {
    //hash数组的长度初始化为8
    private int size = 8;
    private int number = 0; //存储的节点的个数
    //hash数组
    private ArrayList<LinkedList> array_head = new ArrayList<>(size);

    //构造函数
    public MyHash() {
        for (int i = 0; i < size; ++i) {
            //hash数组中初始化存储的为空链表头
            LinkedList myList = new LinkedList();
            //初始化的时候就将空节点添加到数组中去
            array_head.add(myList);
        }
    }

    public void put(Object key, Object value) {
        if (number / size == 10) {
            reHash();
        }
        number++;
        Node new_node = new Node(key, value);
        int code = hashcode(key.toString());

        int position = locate(code);

        LinkedList list_head = array_head.get(position);

        list_head.add(new_node);

    }

    public Object get(Object key) {
        int code = hashcode(key.toString());
        int position = locate(code);

        LinkedList list_head = array_head.get(position);

        for (int i = 0; i < list_head.size(); ++i) {
            Node head = (Node) list_head.get(i);
            Node node = head;

            while (node != null) {
                if (node.getKey().equals(key)) {
                    return node.getValue();
                }
                node = node.getNext();
            }
        }
        return null;
    }

    public Object remove(Object key) {
        int code = hashcode(key.toString());
        int position = locate(code);

        LinkedList list_head = array_head.get(position);

        for (int i = 0; i < list_head.size(); ++i) {
            Node head = (Node) list_head.get(i);
            Node node = head;

            while (node != null) {
                if (node.getKey().equals(key)) {
                    Object value = node.getValue();
                    list_head.remove(node);
                    return value;
                }
                node = node.getNext();
            }
        }
        return null;
    }

    public Object replace(Object key, Object newValue) {
        int code = hashcode(key.toString());
        int position = locate(code);

        LinkedList list_head = array_head.get(position);

        for (int i = 0; i < list_head.size(); ++i) {
            Node head = (Node) list_head.get(i);
            Node node = head;

            while (node != null) {
                if (node.getValue().equals(newValue)) {
                    Object oldValue = node.getValue();
                    node.setValue(newValue);
                    return oldValue;
                }
                node = node.getNext();
            }
        }
        return null;
    }

    public Object containsVale(Object value) {
        for(int k=0;k<size;k++) {
            LinkedList list_head = (LinkedList) array_head.get(k);

            //从头遍历链表 ，找到与键key对应的节点的value值进行输出
            for(int i=0;i<list_head.size();i++) {
                //首先拿到头节点
                Node head = (Node) list_head.get(i);
                Node node = head;
                while(node!=null) {

                    //如果 键 相等
                    if(node.getValue().equals(value)) {
                        return true;
                    }
                    node = node.getNext();
                }
            }
        }
        return false;//否则返回空
    }

    public Object containsKey(Object key) {
        int code = hashcode(key.toString());
        int position = locate(code);

        LinkedList list_head = array_head.get(position);

        for (int i = 0; i < list_head.size(); ++i) {
            Node head = (Node) list_head.get(i);
            Node node = head;
            while (node != null) {
                if (node.getValue().equals(key)) {
                    return true;
                }
                node = node.getNext();
            }
        }
        return false;
    }

    public void show() {
        for (int i = 0; i < size; ++i) {
            LinkedList list_head = array_head.get(i);
            for (int j = 0; j < list_head.size(); ++j) {
                Node head = (Node) list_head.get(j);
                Node node = head;
                while (node != null) {
                    System.out.println("节点" + (j + 1) + ":(" + node.getKey() +":" + node.getValue());
                    node = node.getNext();
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public int size() {
        return number;
    }

    public void clear() {
        for (int i = 0; i < size; ++i) {
            LinkedList list_head = array_head.get(i);
            list_head.clear();;
        }
    }

    private int locate(int code) {
        int m = code % size;
        return m;
    }

    private int hashcode(String s) {
        int k = 0;
        for (int i = 0; i < s.length(); ++i) {
            k += s.charAt(i);
        }
        return k;
    }

    private void reHash() {
    }
}
