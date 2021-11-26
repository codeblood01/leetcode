package com.gourav.leetcode.june30days.leetcode.editor.en;

public class ReverseLLAlternateK {



  class Node {
   int data;  // data field
   Node next;  // pointer to the next node

   Node() {}
   Node(int data) { this.data = data; }
   Node(int data, Node next) { this.data = data; this.next = next; }
  }

    static Node result = null;
    public static Node reverseAlternatingKNodes(Node head, int k)
    {
        Node headNode = head;
        boolean flag =true;
        int length=0;
        boolean flag2=true;
        while (head.next!=null){
            length++;
            if(flag==true){
                length = 0;
                flag=false;
                if(head==headNode) {
                    head = reverseLinkedList(head, k, null );
                    if (flag2==true)
                        headNode=head;
                }else{
                    head = reverseLinkedList(head.next,k,head);
                }
                if(head==null)
                    return result;
            }else{
                head=head.next;
            }
            flag2=false;
            if(length==k-1){
                length=0;
                flag=!flag;
            }
        }
        printLL(result);
        return result;
    }
    public static Node reverseLinkedList(Node node, int k, Node previousNode){
        Node current = node;
        Node prev = null;
        Node fwd=node.next;
        boolean flag =true;
        while (k>0&&current!=null){
            k--;
            if(k==0||current.next==null){
                if(previousNode!=null)
                    previousNode.next=current;
                node.next=current.next;
                current.next=prev;
                if(previousNode==null)
                    result = current;
                return node.next;
            }
            fwd = current.next;
            current.next = prev;
            prev = current;
            current=fwd;


        }
        return current;


    }
    public static void printLL(Node head){
        while (head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }
}
