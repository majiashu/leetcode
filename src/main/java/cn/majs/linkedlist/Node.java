package cn.majs.linkedlist;

/**
 * @program leetcode
 * @description:    链表的节点类
 * @author: mac
 * @create: 2020/09/13 18:52
 */

public class Node {
    //数据
    private int value;
    //下一节点
    private Node next;

    //构造方法
    public Node(int value,Node next){
        this.value =value;
        this.next = next;
    }

    public Node(int value){
        this.value = value;
    }

    public Node(){}

    public int getValue() {
        return value;
    }

    public Node setValue(int value) {
        this.value = value;
        return this;
    }

    public Node getNext() {
        return next;
    }

    public Node setNext(Node next) {
        this.next = next;
        return this;
    }

    //
    public boolean hasNext(){
        return this.next == null ? false : true;
    }

    public Node addToNext(Node node){
        this.next = node;
        return node;
    }
}