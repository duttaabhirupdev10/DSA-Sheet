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


//optimal
class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        int[] left=new int[n];
        int[] right=new int[n];

        Stack<Integer> s1=new Stack<>();
        Stack<Integer> s2=new Stack<>();

        //previous smalller elements in the array. s1 stack store indices
        for(int i=0;i<n;i++){
            //remove the greater elements form the current element from the stack
            while(!s1.isEmpty() && arr[s1.peek()] > arr[i]){
                s1.pop();
            }
            //number of possible starting positions
            left[i]=s1.isEmpty()?(i+1):(i-s1.peek());
            s1.push(i);
        }

        //next smalller elements in the array. s2 stack store indices
        for(int i=n-1;i>=0;i--){
            //remove all the greter elemnts or equal elements from the stack
            while(!s2.isEmpty() && arr[s2.peek()]>= arr[i]){
                s2.pop();
            }
            //number of possible ending position
            right[i]=s2.isEmpty() ? (n-i) :(s2.peek()-i);
            s2.push(i);
        }

        long result=0;
        long mod=1000000007L;
        for(int i=0;i<n;i++){
            long count=(long) left[i]*right[i];
            long contribution=(arr[i] * count)%mod;
            result=(result + contribution)%mod;
        }
        return(int) result;
    }
}         //TC-->O(N)  ,    Sc--->O(N)
