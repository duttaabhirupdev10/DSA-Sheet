/*
Given the head of a linked list, rotate the list to the right by k places.
Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]
*/

//one and only approach
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
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0 || head==null)
            return head;
        ListNode curr=head;
        int len=1;
        // find the length of the linkedlist
        while(curr.next != null){
            curr=curr.next;
            len++;
        }
        //for large value of k ,k=k%len
        k=k%len;
        if(k==0)
            return head;
        //make the ll circular
        curr.next=head;
        // traverse the ll to find the kth node
        curr=head;
        for(int i=1;i<len-k;i++){
            curr=curr.next;
        }  
        //update the (k+1)th node as the new head
        head=curr.next;
        //break the loop by updating next pointer of kth node
        curr.next=null;
        return head;
    }
}
// TC--->O(N+N )   , SC --->O(1)
