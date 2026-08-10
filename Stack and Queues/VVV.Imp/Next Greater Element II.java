/*
Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.
The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.

Example 1:

Input: nums = [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2; 
The number 2 can't find next greater number. 
The second 1's next greater number needs to search circularly, which is also 2.
*/

//optimal
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;

        // Stores the next greater element for each position
        int[] ans = new int[n];

        // Stack to find the next greater element
        Stack<Integer> st = new Stack<>();

        // Traverse 2*n times to simulate ***circular array ****
        for (int i = 2 * n - 1; i >= 0; i--) {

            // Get the actual index in nums
            int ind = i % n;

            // Current element
            int currEle = nums[ind];

            // Remove smaller or equal elements
            while (!st.isEmpty() && st.peek() <= currEle) {
                st.pop();
            }

            // Fill answer only during the first pass
            if (i < n) {
                if (st.isEmpty()) {
                    ans[ind] = -1;
                } else {
                    ans[ind] = st.peek();
                }
            }

            // Push current element into stack
            st.push(currEle);
        }

        return ans;
    }
}   // TC--->O(n)    , SC--->O(n)
