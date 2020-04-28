package TrienKhaiLinkList;

import javax.xml.soap.Node;
import java.util.LinkedList;

public class MyLinkedList<E> {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(6);
    }

    private Node head;
    private int numNodes = 0;

    public MyLinkedList( Object data){
        head = new Node(data);
    } 

    private class Node {
        private Node node;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }

    public void add(int index, Object data) {
        Node temp = head;
        Node holder;

        for(int i=0; i < index-1 && temp.node != null; i++) {
            temp = temp.node;
        }
        holder = temp.node;
        temp.node = new Node(data);
        temp.node.node = holder;
        numNodes++;
    }
}
