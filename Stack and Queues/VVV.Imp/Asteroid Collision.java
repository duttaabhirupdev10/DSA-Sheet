/*
We are given an array asteroids of integers representing asteroids in a row. The indices of the asteroid in the array represent their relative position in space.
For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

Example 1:

Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
Example 2:

Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.
*/

//only one solution
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<asteroids.length;i++){
            //condition for collission
            while(!st.isEmpty() && asteroids[i]<0 && st.peek()>0){
                int sum=asteroids[i]+st.peek();
                //if st.peek is smaller
                if(sum<0){
                    st.pop();
                }
                else if(sum > 0){
                    asteroids[i]=0;
                }
                else{  //sum==0
                    st.pop();
                    asteroids[i]=0;
                }
            }
            if(asteroids[i] != 0){
                st.push(asteroids[i]);
            }
        }
        //convert the satck into result array
        int[] result=new int[st.size()];
        for(int i=0;i<st.size();i++){
            result[i]=st.get(i);
        }
        return result;
    }
}   //TC-->O(N)    , SC-->O(n)
