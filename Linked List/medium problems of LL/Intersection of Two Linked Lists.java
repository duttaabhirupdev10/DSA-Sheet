/*
Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.
For example, the following two linked lists begin to intersect at node c1:
The test cases are generated such that there are no cycles anywhere in the entire linked structure.
Note that the linked lists must retain their original structure after the function returns.
Custom Judge:
The inputs to the judge are given as follows (your program is not given these inputs):

intersectVal - The value of the node where the intersection occurs. This is 0 if there is no intersected node.
listA - The first linked list.
listB - The second linked list.
skipA - The number of nodes to skip ahead in listA (starting from the head) to get to the intersected node.
skipB - The number of nodes to skip ahead in listB (starting from the head) to get to the intersected node.
The judge will then create the linked structure based on these inputs and pass the two heads, headA and headB to your program. If you correctly return the intersected node, then your solution will be accepted.

Example 1:
Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
Output: Intersected at '8'
*/

// brute
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // iterate over second list and for each node
        //search it in first list
        while(headB != null){
            ListNode temp=headA;
            while(temp != null){
                //if both nodes are same
                if(temp == headB)
                    return headB;
                temp=temp.next;
            }
            headB=headB.next;
        }
        // intersection is not present
            return null;
    }
}   // TC--->O(m*n)  , SC-->O(m)

// better
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> visNodes=new HashSet<>();
        // traverse the first list and store all nodes in a set
        ListNode curr1=headA;
        while(curr1 != null){
            visNodes.add(curr1);
            curr1=curr1.next;
        } 

        //traverse the second list and check if any node is in the set
        ListNode curr2=headB;
        while(curr2 != null){
            if(visNodes.contains(curr2)){
                //intersection point found
                return curr2;
            }
            curr2=curr2.next;
        }
        return null;
    }
}    // TC--->O(m+n)  , SC-->O(m)

//optimal 1
public class Solution {
    //get the count of nodes in the linkedlist
    private int getCount(ListNode head){
        int cnt=0;
        ListNode curr=head;
        while(curr != null){
            cnt++;
            curr=curr.next;
        }
        return cnt;
    }

     // Function to get the intersection point of two
    // linked lists where headA has d more nodes than headB
    private ListNode getIntersectionByDiff(int diff,ListNode headA,ListNode headB){
        ListNode curr1=headA;
        ListNode curr2=headB;
        //move the pointer forward by d nodes
        for(int i=0; i<diff; i++){
            if(curr1==null)
                return null;
            curr1=curr1.next;
        }
        // move both pointer untill they intersect
            while(curr1!= null && curr2 !=null){
                if(curr1==curr2)
                    return curr1;
                curr1=curr1.next;
                curr2=curr2.next;
            }
            return null;
        }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // count the no. of nodes in the both linkedlist
        int len1=getCount(headA);
        int len2=getCount(headB);
        int diff=0;

        // if the first list is longer
        if(len1>len2){
            diff=len1-len2;
            return getIntersectionByDiff(diff,headA,headB);
        }
        else{
            diff=len2-len1;
            return getIntersectionByDiff(diff,headB,headA);
        }
        }
    }   /// TC--->O(M+N)  , SC-->O(1)




