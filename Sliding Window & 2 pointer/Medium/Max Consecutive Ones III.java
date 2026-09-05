/*
Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

 

Example 1:

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
*/

class Solution {
    public int longestOnes(int[] nums, int k) {
        int left=0;     //left boundary of our sliding window
        int zeroCount=0;//number of zeros inside the current window
        int maxLength=0;//maximum valid window length found so far

        //expand the window using right pointer
        for(int right=0;right<nums.length;right++){
            //if we include a zero, increase zeroCount
            if(nums[right]==0){
                zeroCount++;
            }
            //window is valid if zeros are more than k
            if(zeroCount > k){
                //shrink the window from the left
                //untill number of zeros becomes <= k
                while(zeroCount>k){
                    //if the element we remove is zero, decrease the count
                    if(nums[left]==0){
                        zeroCount--;
                    }
                    //move the left pointer rforward
                    left++;
                }
            }
            maxLength=Math.max(maxLength,right-left+1);
        }
        return maxLength;
    }
}      //   TC--->O(N^2)   ,   SC-->O(1)
