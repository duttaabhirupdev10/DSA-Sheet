/*
Given the head of a linked list, remove the nth node from the end of the list and return its head.

Example 1:
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
*/

// brute
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)
            return null;
        int cnt=0;
        ListNode temp=head;
        while(temp!=null){
            cnt++;
            temp=temp.next;
        }
        if(cnt == n){
            return head.next;
        }
        int res=cnt-n;
        temp=head;
        while(temp != null){
            res--;
            if(res==0){
                break;
            }
            temp=temp.next;
        }
        temp.next=temp.next.next;
        return head;
    }
}//   Time Complexity: O(L)+O(L-N),  SC-->O(1)

//optimal
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast=head;
        ListNode slow=head;
        for(int i=0;i<n;i++)
            fast=fast.next;
        if(fast==null) return head.next;
        while(fast.next != null){
            slow=slow.next;
            fast=fast.next;
        }
        ListNode delNode=slow.next;
        slow.next=slow.next.next;
        return head;
    }
}// TC-->O(length)  , SC -->O(1)
