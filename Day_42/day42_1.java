import java.util.*;

class day42_1{
    static class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }

    public static void main(String[] args){
        Node head = new Node(100);
        head.next = new Node(20);
        head.next.next = new Node(30);

        System.out.println("Original list:");
        printList(head);

        Stack<Node> s = new Stack<>();
        Node current = head;

        while(current != null){
            s.push(current);
            current = current.next;
        }

        if(!s.isEmpty()){
            head = s.pop();
            current = head;

            while(!s.isEmpty()){
                current.next = s.pop();
                current = current.next;
            }
            current.next = null;
        }

        System.out.println("Reversed list:");
        printList(head);
    }

    static void printList(Node head){
        Node current = head;
        while(current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}