class Solution {
    private int DaysNeeded(int[] weights, int capacity){
        int days=1;
        int load=0;
        for(int w:weights){
            if(load + w > capacity){
                days++;
                load=w;
            }
            else{
                load=load+w;
            }
        }
        return days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int low=Arrays.stream(weights).max().getAsInt();
        int high=Arrays.stream(weights).sum();
        while(low <= high){
            int mid=(low + high)/2;
            if(DaysNeeded(weights,mid) <= days){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}
// TC-->O(n log n)  , SC--->O(1)
