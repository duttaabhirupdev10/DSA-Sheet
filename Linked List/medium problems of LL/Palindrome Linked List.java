/*
Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

Example 1:
Input: head = [1,2,2,1]
Output: true
*/

//brute force using stack
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
        Stack<Integer> st=new Stack<>();
        ListNode temp=head;
        while(temp != null){
            st.push(temp.val);
            temp=temp.next;
        }
        temp=head;
        while(temp != null){
            if(temp.val != st.peek())
                return false;
            temp=temp.next;
            st.pop();
        }
        return true;
    }
}      //  TC-->O(2N)    sc-->o(N)


// optimal
