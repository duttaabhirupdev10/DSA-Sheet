/*
Given the head of a singly linked list, find the length of the loop in the linked list if it exists. Return the length of the loop if it exists; otherwise, return 0.
A loop exists in a linked list if some node in the list can be reached again by continuously following the next pointer. Internally, pos is used to denote the index (0-based) of the node from where the loop starts.
Note that pos is not passed as a parameter.


Example 1
Input: head -> 1 -> 2 -> 3 -> 4 -> 5, pos = 1

Output: 4

Explanation: 2 -> 3 -> 4 -> 5 - >2, length of loop = 4.
*/
// HASHING
/*Definition of singly linked list:
class ListNode {
    int val;
    ListNode next;

    ListNode() {
        val = 0;
        next = null;
    }

    ListNode(int data1) {
        val = data1;
        next = null;
    }

    ListNode(int data1, ListNode next1) {
        val = data1;
        next = next1;
    }
}
 */

class Solution {
    public int findLengthOfLoop(ListNode head) {
        HashMap<ListNode, Integer> visitedNodes = new HashMap<>();

        ListNode temp = head;
        int timer = 0;

        while (temp != null) {
            if (visitedNodes.containsKey(temp)) {
                return timer - visitedNodes.get(temp);
            }

            visitedNodes.put(temp, timer);
            temp = temp.next;
            timer++;
        }

        return 0;
    }
}

//OPTIMAL HARE AND TORTOISE
/*Definition of singly linked list:
class ListNode {
    int val;
    ListNode next;

    ListNode() {
        val = 0;
        next = null;
    }

    ListNode(int data1) {
        val = data1;
        next = null;
    }

    ListNode(int data1, ListNode next1) {
        val = data1;
        next = next1;
    }
}
 */

 class Solution {
     public int findLengthOfLoop(ListNode head) {
        ListNode slow= head;
        ListNode fast= head;
        while( fast != null && fast.next != null ){
            slow= slow.next;
            fast =fast.next.next;
            if(slow==fast)
                return findlength(slow,fast);
        }
        return 0;
     }
    
    private int findlength(ListNode slow,ListNode fast){
        int cnt=1;
        fast=fast.next;
        while(slow != fast){
            cnt++;
            fast=fast.next;
        }
        return cnt;
    }
 }
