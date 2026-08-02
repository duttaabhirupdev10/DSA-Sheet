/*
Given the head of a sorted doubly linked list of positive distinct integers, and a target integer, return a 2D array containing all unique pairs of nodes (a, b) such that a + b == target.
Each pair should be returned as a 2-element array [a, b] with a < b. The list is sorted in ascending order. If there are no such pairs, return an empty list.

Example 1
Input: head = [1, 2, 4, 5, 6, 8, 9], target = 7
Output: [[1, 6], [2, 5]]
Explanation:
1 + 6 = 7 and 2 + 5 = 7 are the valid pairs.
*/

// only one solution
/*
class ListNode {
    int val;
    ListNode next;
    ListNode prev;
    
    ListNode(int val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}
*/

class Solution {
    public List<List<Integer>> findPairsWithGivenSum(ListNode head, int target) {
        // Your code goes here
        List<List<Integer>> ans=new ArrayList<>();
        if(head==null) return ans;
        //find the last ListNode
        ListNode left=head;
        ListNode right=head;
        while(right.next != null){
            right=right.next;
        }
        //2 pointer approach
        while(left!=right && left.prev != right){
            int sum =left.val + right.val;
            if(sum==target){
                List<Integer> pair =new ArrayList<>();
                pair.add(left.val);
                pair.add(right.val);
                ans.add(pair);

                left=left.next;
                right=right.prev;
            }
            else if(sum < target){
                left=left.next;
            }
            else{
                right=right.prev;
            }
        }
        return ans;
    }
}// TC-->O(N)   ,   Sc-->O(1)
