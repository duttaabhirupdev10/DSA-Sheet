// optimal
class Solution {
    public int findMin(int[] nums) {
        int n=nums.length,low=0,high=n-1,ans=Integer.MAX_VALUE;
        while(low<=high){
            int mid=(low+high)/2;
            // if the whole array is sorted
            if(nums[low]<=nums[high]){
                ans=Math.min(ans,nums[low]);
                break;
            }
            //if the left portion ios sorted
            if(nums[low]<=nums[mid]){
                ans=Math.min(ans,nums[low]);
                low=mid+1;
            }
            //if the right part is sorted
            else{
                ans=Math.min(ans,nums[mid]);
                high=mid-1;
            }
        }
        return ans;
    }
} // TC__>O(log N)
