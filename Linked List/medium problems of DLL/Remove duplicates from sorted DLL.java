/*
Given the head of a doubly linked list with its values sorted in non-decreasing order. Remove all duplicate occurrences of any value in the list so that only distinct values are present in the list.
Return the head of the modified linked list.

Example 1
Input: head -> 1 <-> 1 <-> 3 <-> 3 <-> 4 <-> 5
Output: head -> 1 <-> 3 <-> 4 <-> 5
Explanation: head -> 1 <-> 1 <-> 3 <-> 3 <-> 4 <-> 5
The underlined nodes were deleted to get the desired result.
*/
//one and only solution
/*Definition of doubly linked list:
class ListNode {
    int val;
    ListNode next;
    ListNode prev;

    ListNode() {
        val = 0;
        next = null;
        prev = null;
    }

    ListNode(int data1) {
        val = data1;
        next = null;
        prev = null;
    }

    ListNode(int data1, ListNode next1, ListNode prev1) {
        val = data1;
        next = next1;
        prev = prev1;
    }
}
 */

class Solution {
    public ListNode removeDuplicates(ListNode head) {
        ListNode temp=head;
        ListNode nextNode;
        while(temp != null && temp.next != null){
            nextNode=temp.next;
            while(nextNode != null && nextNode.val==temp.val){
                nextNode=nextNode.next;
            }
            temp.next=nextNode;
            if(nextNode != null) nextNode.prev=temp;
            temp=temp.next;
        }
        return head;
    }
}    //TC-->O(N)   ,    SC-->O(1)
