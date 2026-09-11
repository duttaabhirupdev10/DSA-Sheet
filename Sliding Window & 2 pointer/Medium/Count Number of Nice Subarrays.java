/*
Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.
Return the number of nice sub-arrays.
Example 1:

Input: nums = [1,1,2,1,1], k = 3
Output: 2
Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
Example 2:

Input: nums = [2,4,6], k = 1
Output: 0
Explanation: There are no odd numbers in the array.
*/

//sliding window
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums,k)-atMost(nums,k-1);
    }
    private int atMost(int[] nums,int k){
        if(k<0){
            return 0;
        }
        int left=0;
        int oddCount=0;
        int count=0;

        for(int right=0;right<nums.length;right++){

            // count the odd no.
            if(nums[right] % 2!=0){
                oddCount++;
            }
            while(oddCount>k){
                if(nums[left] %2 !=0){
                    oddCount--;
                }
                left++;
            }
            count+=right-left+1;
        }
        return count;
    }
}           //     TC--->O(N) ,   SC--->O(1)
