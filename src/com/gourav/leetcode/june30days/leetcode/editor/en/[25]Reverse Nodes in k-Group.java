//Given a linked list, reverse the nodes of a linked list k at a time and return
// its modified list. 
//
// k is a positive integer and is less than or equal to the length of the linked
// list. If the number of nodes is not a multiple of k then left-out nodes, in the
// end, should remain as it is. 
//
// You may not alter the values in the list's nodes, only nodes themselves may b
//e changed. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4,5], k = 2
//Output: [2,1,4,3,5]
// 
//
// Example 2: 
//
// 
//Input: head = [1,2,3,4,5], k = 3
//Output: [3,2,1,4,5]
// 
//
// Example 3: 
//
// 
//Input: head = [1,2,3,4,5], k = 1
//Output: [1,2,3,4,5]
// 
//
// Example 4: 
//
// 
//Input: head = [1], k = 1
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range sz. 
// 1 <= sz <= 5000 
// 0 <= Node.val <= 1000 
// 1 <= k <= sz 
// 
//
// 
//Follow-up: Can you solve the problem in O(1) extra memory space? Related Topic
//s Linked List Recursion 
// 👍 5527 👎 457

package com.gourav.leetcode.june30days.leetcode.editor.en;
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    static ListNode result = null;
    public static ListNode reverseKGroup(ListNode head, int k)
    {   if(k==1)
            return head;
        ListNode headNode = head;
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
    public static ListNode reverseLinkedList(ListNode node, int k, ListNode previousNode){
        ListNode current = node;
        ListNode prev = null;
        ListNode fwd=node.next;
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
    public static void printLL(ListNode head){
        while (head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
