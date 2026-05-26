class Solution {
    public int upperBound(int[] nums, int x) {
        int low=0,high=nums.length;
        int ans=nums.length+1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid] > x){   // logic---> arr[mid] > x
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
//TC -->O(log N) ,  SC-->O(1)
