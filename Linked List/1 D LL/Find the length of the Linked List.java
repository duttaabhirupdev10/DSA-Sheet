class Solution {
    public int getLength(ListNode head) {
        // Your code goes here
        int count=0;
        ListNode temp=head;
        while(temp != null){
            count++;
            temp=temp.next;
        }
        return count;
    }
}
