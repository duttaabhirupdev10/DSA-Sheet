/*
Given an array nums of size n, which denotes the positions of stalls, and an integer k, which denotes the number of aggressive cows, assign stalls to k cows such that the minimum distance between any two cows is the maximum possible. Find the maximum possible minimum distance.


Example 1

Input: n = 6, k = 4, nums = [0, 3, 4, 7, 10, 9]

Output: 3

Explanation:

The maximum possible minimum distance between any two cows will be 3 when 4 cows are placed at positions [0, 3, 7, 10]. Here the distances between cows are 3, 4, and 3 respectively.

In no manner can we increase the minimum distance beyond 3.
*/

class Solution {
    private boolean canWePlace(int[] nums,int dist,int k){
        int cntCows=1,last=nums[0];
        for(int i=1;i < nums.length;i++){
            if(nums[i]-last>=dist){
                cntCows++;
                last=nums[i];
            }
            if(cntCows >= k) return true;
        }
        return false;
    }
    public int aggressiveCows(int[] nums, int k) {
        Arrays.sort(nums);
        int low=1,high=nums[nums.length-1]-nums[0];
        int ans=0;
        while(low<= high){
            int mid=(low+high)/2;
            if(canWePlace(nums,mid,k)==true){
                ans=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
                }
            }
            return high;
    }
}
// TC--->O( n log N)
