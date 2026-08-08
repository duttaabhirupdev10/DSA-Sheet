/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
Implement the MinStack class:

MinStack() initializes the stack object.
void push(int value) pushes the element value onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.

Example 1:
Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]
*/

//brute-force
class Pair{
    int val;
    int min;
    Pair(int val,int min){
        this.val=val;
        this.min=min;
    }
}
class MinStack {
    Stack <Pair> st;
    public MinStack() {
       st=new Stack<>(); 
    }
    
    public void push(int value) {
        if(st.isEmpty()){
            st.push(new Pair(value,value));
        }
        else{
            st.push(new Pair(value,Math.min(value,st.peek().min)));
        }
    }
    
    public void pop() {
        if(!st.isEmpty()){
            st.pop();
        }
    }
    
    public int top() {
        return st.peek().val;
    }
    
    public int getMin() {
        return st.peek().min;
    }
}   //TC--->O(1)   ,  SC--->O(2N)

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

//optimal
class MinStack {
    private Stack<Long> st;
    private int minEle;

    public MinStack() {
        st=new Stack<>();
        minEle=-1;    
    }
    
    public void push(int value) {
        if(st.isEmpty()){
            minEle=value;
            st.push((long)value);
        }
        //if the new no. is less than the minimum element
        else if(value < minEle){
            st.push(2L*value-minEle);
            minEle=value;
        }
        // if the new no. is greater than the minimum element
        else{
            st.push((long)value);
        }
    }
    
    public void pop() {
        if(st.isEmpty()) return;
        long top=st.pop();

        //If top is an encoded value, minEle is the actual top and 
        //minimum will change if the min element is removed
        if(top < minEle){
            minEle=(int) (2L* minEle - top);
        }
    }
    
    public int top() {
        if(st.isEmpty()) return -1;
        long top=st.peek();
        //If top is an encoded value, minEle is the actual top
        return (minEle > top) ? (int)minEle:(int)top;
    }
    
    public int getMin() {
        if(st.isEmpty()) return -1;
        return (int)minEle;
    }
}                  ///TC---->O(1);      SC--->O(1)

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
