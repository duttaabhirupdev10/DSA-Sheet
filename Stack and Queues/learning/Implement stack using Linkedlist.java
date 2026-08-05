class LinkedListStack {
    //Node class
    class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val=val;
            this.next=null;
        }
    }
    ListNode head;
    public LinkedListStack() {
        head=null;
    }

    public void push(int x) {
       ListNode node= new ListNode(x);
       node.next=head;
       head=node;
    }

    public int pop() {
      int number=head.val;
      head=head.next;
      return number;
    }

    public int top() {
        return head.val;
    }

    public boolean isEmpty() {
        return head==null;
    }
}
