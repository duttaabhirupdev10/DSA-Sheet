/*
Delete all occurrences of a key in DLL
Given the head of a doubly linked list and an integer target. Delete all nodes in the linked list with the value target and return the head of the modified linked list.

Example 1
Input: head -> 1 <-> 2 <-> 3 <-> 1 <-> 4, target = 1
Output: head -> 2 <-> 3 <-> 4
Explanation: All nodes with the value 1 were removed.
*/

//only one solution
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
    public ListNode deleteAllOccurrences(ListNode head, int target) {
        ListNode current = head;

        while (current != null) {

            // Store the next node before deleting
            ListNode nextNode = current.next;

            if (current.val == target) {

                // If the node is the head
                if (current == head) {
                    head = current.next;
                }

                // Update previous node's next pointer
                if (current.prev != null) {
                    current.prev.next = current.next;
                }

                // Update next node's prev pointer
                if (current.next != null) {
                    current.next.prev = current.prev;
                }
            }

            // Move to the next node
            current = nextNode;
        }

        return head;
    }
}
// TC-->O(n)  ,   sc-->O(1)
