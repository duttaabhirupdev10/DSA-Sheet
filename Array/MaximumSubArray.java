//brute
class Solution {
    public int maxSubArray(int[] nums) {
        int maxi=Integer.MIN_VALUE;
        int n=nums.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int sum=0;
                for(int k=i;k<j;k++){
                sum+=nums[k];
                maxi=Math.max(sum,maxi);}
            }
        }
        return maxi;
    }
}    // TC-->O(n^3),SC-->O(1)


//better
class Solution {
    public int maxSubArray(int[] nums) {
        int maxi=Integer.MIN_VALUE;
        int n=nums.length;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum+=nums[j];
                maxi=Math.max(sum,maxi);
            }
        }
        return maxi;
    }
}   //TC--->O(n^2)  , SC--->O(1)

//optimal( KADANE'S ALGORITHM)
