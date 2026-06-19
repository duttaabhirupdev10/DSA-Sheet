/* 
You are given an integer array bloomDay, an integer m and an integer k.
You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.
The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.
Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is impossible to make m bouquets return -1.

Example 1:

Input: bloomDay = [1,10,3,10,2], m = 3, k = 1
Output: 3
Explanation: Let us see what happened in the first three days. x means flower bloomed and _ means flower did not bloom in the garden.
We need 3 bouquets each should contain 1 flower.
After day 1: [x, _, _, _, _]   // we can only make one bouquet.
After day 2: [x, _, _, _, x]   // we can only make two bouquets.
After day 3: [x, _, x, _, x]   // we can make 3 bouquets. The answer is 3.
*/

//brute 
class Solution {
    private boolean possible(int[] bloomDay,int day,int m,int k){
        int count=0;
        int noofbouquet=0;
        int n=bloomDay.length;
        for(int i=0;i<n;i++){
            if(bloomDay[i] <= day)
                count++;
            else{
                noofbouquet+=(count/k);
                count=0;
            }
        }
        noofbouquet+=(count/k);
        if(noofbouquet >= m) return true;
        else return false;
    }
    public int minDays(int[] bloomDay, int m, int k) {

        if((long)m*k > bloomDay.length) return -1;  // bloomDay=[7,6,7] , m=2,k=3--->total flower required=2*3=6

        int min = Arrays.stream(bloomDay).min().getAsInt();
        int max = Arrays.stream(bloomDay).max().getAsInt();
        for(int i=min ; i<=max; i++){
            if(possible(bloomDay,i,m,k))
                return i;
        }
        return -1;
    }
}
///Even after fixing this, you'll likely get TLE (Time Limit Exceeded) because you're checking every day from min to max.

//optimal
class Solution {
    private boolean possible(int[] bloomDay,int day,int m,int k){
        int count=0;
        int noofbouquet=0;
        int n=bloomDay.length;
        for(int i=0;i<n;i++){
            if(bloomDay[i] <= day)
                count++;
            else{
                noofbouquet+=(count/k);
                count=0;
            }
        }
        noofbouquet+=(count/k);
        if(noofbouquet >= m) return true;
        else return false;
    }
    public int minDays(int[] bloomDay, int m, int k) {

        if((long)m*k > bloomDay.length) return -1;  // bloomDay=[7,6,7] , m=2,k=3--->total flower required=2*3=6

        int min=Arrays.stream(bloomDay).min().getAsInt();
        int max=Arrays.stream(bloomDay).max().getAsInt();
        int low=min,high=max,ans=high;
        while(low <= high){
            int mid=(low+high)/2;
            if(possible(bloomDay,mid,m,k)){
                ans=mid;
                high=mid-1;
            }
            else  low=mid+1;
        }
        return ans;
    }
} //TC--> O( N * log(max-min))
