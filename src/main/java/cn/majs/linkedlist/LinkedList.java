package cn.majs.linkedlist;

/**
 * @program leetcode
 * @description: 链表的实现及反转相关操作
 * @author: mac
 * @create: 2020/09/13 18:39
 */
public class LinkedList {

    /**
     * 链表的递归方式实现反转
     * @param head
     * @return
     */
    public static Node reverse(Node head){
        //空链表 或者 已经到了尾节点 不判断尾节点会空指针。
        if(head == null || !head.hasNext()){
            return head;
        }else{
            //取出下一个节点
            Node nextNode = head.getNext();
            //先作为下一次调用的参数传到下一个节点，切记不能先处理再传
            Node retNode = reverse(nextNode);
            nextNode.setNext(head); //下一节点连到当前节点
            head.setNext(null); //将当前操作节点与原有链表截断
            return retNode;
        }
    }

    public static void main(String[] args) {
        //头节点
        Node head = new Node();
        head.setValue(-1);
        head.setNext(null);
        //第一个节点
        Node firstNode = new Node();
        firstNode.setValue(0);
        firstNode.setNext(null);
        //链接
        head.setNext(firstNode);
        System.out.println(head.getValue() +
                " " +head.getNext().getValue());
    }
}
