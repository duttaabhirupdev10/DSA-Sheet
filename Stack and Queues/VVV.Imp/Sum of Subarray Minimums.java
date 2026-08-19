/*
Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.

Example 1:

Input: arr = [3,1,2,4]
Output: 17
Explanation: 
Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. 
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
Sum is 17.
*/

//brute force
 class Solution {
    public int sumSubarrayMins(int[] arr) {
        int sum=0,n=arr.length;
        int mod=(int) 1e9+7;
        for(int i=0;i<n;i++){
            int mini=arr[i];
            for(int j=i;j<n;j++){
                mini=Math.min(mini,arr[j]);
                sum=(sum+mini)%mod;
            }
        }
        return sum;
    }
}    // TC-->O(N^2)   , SC-->O(1)
