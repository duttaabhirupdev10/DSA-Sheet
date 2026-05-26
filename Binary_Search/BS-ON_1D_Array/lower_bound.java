class Solution {
    public int lowerBound(int[] nums, int x) {
       int low=0,high=nums.length;
       int ans=nums.length+1;
       while(low<=high){
        int mid=(low+high)/2;
        if(nums[mid]>=x){
            ans=mid;
            high=mid-1;
        }
        else{
            low=mid+1;
        }
       }
       return ans;
     }
}
//tc-->O(logN)
