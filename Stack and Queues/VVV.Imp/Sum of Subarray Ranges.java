/*
You are given an integer array nums. The range of a subarray of nums is the difference between the largest and smallest element in the subarray.
Return the sum of all subarray ranges of nums
A subarray is a contiguous non-empty sequence of elements within an array.

Example 1:

Input: nums = [1,2,3]
Output: 4
Explanation: The 6 subarrays of nums are the following:
[1], range = largest - smallest = 1 - 1 = 0 
[2], range = 2 - 2 = 0
[3], range = 3 - 3 = 0
[1,2], range = 2 - 1 = 1
[2,3], range = 3 - 2 = 1
[1,2,3], range = 3 - 1 = 2
So the sum of all ranges is 0 + 0 + 0 + 1 + 1 + 2 = 4.
Example 2:

Input: nums = [1,3,3]
Output: 4
Explanation: The 6 subarrays of nums are the following:
[1], range = largest - smallest = 1 - 1 = 0
[3], range = 3 - 3 = 0
[3], range = 3 - 3 = 0
[1,3], range = 3 - 1 = 2
[3,3], range = 3 - 3 = 0
[1,3,3], range = 3 - 1 = 2
So the sum of all ranges is 0 + 0 + 0 + 2 + 0 + 2 = 4.
*/

//BRUTE 
class Solution {
    public long subArrayRanges(int[] nums) {
        int n=nums.length;
        int totalSum=0;
        //generate the sub-array using nested loop
        for(int i=0;i<nums.length;i++){
            int currMin=Integer.MAX_VALUE;
            int currMax=Integer.MIN_VALUE;
            for(int j=i;j<nums.length;j++){
                //update the currMin and currMax for this subarray
                currMin=Math.min(currMin,nums[j]);
                currMax=Math.max(currMax,nums[j]);

                //add range of this subarray to totalSum
                totalSum += (currMax-currMin); 
            }
        }
        return totalSum;
    }
}    //TC-->O(N^2)    ,     SC-->O(1)

//OPTIMAL-----> using monotonic stack
class Solution {
    public long subArrayRanges(int[] nums) {
        int n=nums.length;
        int[] leftMin=new int[n] , rightMin=new int[n];
        int[] leftMax=new int[n] , rightMax=new int[n];
        Stack<Integer> st=new Stack<>();

        //previous smaller element(leftMin)
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()] > nums[i])
            st.pop();
            leftMin[i]=st.isEmpty() ? i+1 : i-st.peek();
            st.push(i);
        }
        st.clear();

        //next smaller element(rightMin)
        for(int i=n-1;i >= 0;i--){
            while(!st.isEmpty() && nums[st.peek()] >= nums[i])
            st.pop();
            rightMin[i]=st.isEmpty() ? n-i : st.peek()-i;
            st.push(i);
        }
        st.clear();

        //previous Greater Element(leftMax)
        for(int i=0;i<n;i++){
            while(!st.isEmpty()  && nums[st.peek()] < nums[i])
            st.pop();
            leftMax[i]=st.isEmpty() ? i+1 :i-st.peek();
            st.push(i);
        }
        st.clear();

        //next greater element(rightMax)
        for(int i=n-1;i >=0;i--){
            while(!st.isEmpty() && nums[st.peek()] <= nums[i])
            st.pop();
            rightMax[i] = st.isEmpty()? n-i : st.peek()-i;
            st.push(i);
        }

        //calculate total contribution
        long totalSum = 0;

        for(int i = 0; i < n; i++) {

        long maxContri = (long) leftMax[i] * rightMax[i] * nums[i];
        long minContri = (long) leftMin[i] * rightMin[i] * nums[i];

        totalSum += maxContri - minContri;
        }

        return totalSum;
    }
}//          TC--->O(N)     ,     SC--->O(N)
