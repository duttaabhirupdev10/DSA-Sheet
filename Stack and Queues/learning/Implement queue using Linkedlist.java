class LinkedListQueue {
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    Node front;
    Node rear;
    public LinkedListQueue() {
        front=null;
        rear=null;
    }
    //Enqueue
    public void push(int x) {
       Node newNode=new Node(x);
       if(front==null){
        front=newNode;
        rear=newNode;
       }
       else{
        rear.next=newNode;
        rear=newNode;
       }
    }
    //Dequeue
    public int pop() {
      if(isEmpty()){
        return -1;
      }
      int value=front.data;
      front=front.next;
      //Queue becomes isEmpty
      if(front == null){
        rear=null;
      }
      return value;
    }

    public int peek() {
        if(isEmpty()){
            return -1;
        }
        return front.data;
    }

    public boolean isEmpty() {
        return front==null;
    }
}
