//Given the head of a singly linked list, return true if it is a palindrome. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,2,1]
//Output: true
// 
//
// Example 2: 
//
// 
//Input: head = [1,2]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [1, 105]. 
// 0 <= Node.val <= 9 
// 
//
// 
//Follow up: Could you do it in O(n) time and O(1) space? Related Topics Linked 
//List Two Pointers Stack Recursion 
// 👍 7041 👎 488

package com.gourav.leetcode.june30days.leetcode.editor.en;
import java.util.*;
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
    public boolean isPalindrome(ListNode head) {
        int length = getLength(head);
         ListNode start = head;
         if(length==1)
             return true;
        if(length==2)
                return head.val==head.next.val;
        if(length==3)
            return  head.val==head.next.next.val;

         ListNode palinStart=reverseFromMiddle(head , length);

        for (int i = 0; i < length/2; i++) {
            if(start.val==palinStart.val){
                start=start.next;
                palinStart=palinStart.next;
            }
            else{
                reverseFromMiddle(head,length);
                return false;
            }
        }
        reverseFromMiddle(head,length);
        return true;
    }
    public ListNode reverseFromMiddle (ListNode head, int length){
        ListNode headNode = head;
        ListNode previous = null;
        ListNode current = null;
        if(length%2==0){
            for (int i = 0; i < length/2; i++) {
                if(i==(length/2)-1) {
                    previous = head;
                    current = head.next;
                }
                head=head.next;
            }
        }else{
            for (int i = 0; i <= length/2; i++) {
                if(i==(length/2)) {
                    previous = head;
                    current = head.next;
                }
                head=head.next;
            }
        }
        ListNode prev = previous;
        ListNode fwd = current;

        boolean flag=true;
        while (current!=null){
            if(current.next==null){
                previous.next=current;
                current.next=prev;
                break;
            }
            if(flag==true){
                    flag=false;
                    fwd= current.next;
                    prev = current;
                    current.next=null;
                    current = fwd;
            }else{
                fwd=current.next;
                current.next=prev;
                prev=current;
                current=fwd;
            }
        }
        System.out.println("merse compare kar "+current.val);
        return current;
    }
    public int getLength (ListNode head){
        int length =0;
        while (head!=null){
            length++;
            System.out.println(head.val+" "+length);
            head=head.next;
        }
        return length;
    }

    public void printLL(ListNode head){
        while (head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
