//optimal

class Solution {
    private long totalHours(int[] piles, int speed) {
        long hours = 0;

        for (int bananas : piles) {
            //hours += (bananas + (long) speed - 1) / speed;
            hours+=(long)Math.ceil((double)bananas/speed);
        }

        return hours;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile=Arrays.stream(piles).max().getAsInt();
    //Array.stream---> converts the array in the stream, which use to store the private data 
        int low=1,high=maxPile;
        int ans=maxPile;
        while(low <= high){
            int mid = low+(high-low)/2;
            long totalhrs=totalHours(piles,mid);
            if(totalhrs<=h){
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

//TC--->O(N*log(max(a[])))
