// Brute
class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            int cnt=0;
            for(int j=0;j<n;j++){
                if (nums[i]==nums[j])
                    cnt++;
            }
            if(cnt > n/2)
                return nums[i];
        }
        return -1;
    }
}    //TC-->O(n^2) , SC--->O(1)
//Better
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> mpp = new HashMap<>();

        // counting frequency
        for (int i = 0; i < nums.length; i++) {
            mpp.put(nums[i], mpp.getOrDefault(nums[i], 0) + 1);
        }

        // checking majority
        for (Map.Entry<Integer, Integer> it : mpp.entrySet()) {
            if (it.getValue() > nums.length / 2) {
                return it.getKey();
            }
        }

        return -1;
    }
}   //TC-->O(NlogN)  , SC-->O(N)

//Optimal ___->Moore's voting Algorithm
class Solution {
    public int majorityElement(int[] nums) {
        int cnt=0;
        int el=0;
        for(int i=0;i<nums.length;i++){
            if(cnt ==0){
                cnt=1;
                el=nums[i];
            }
            else if(nums[i]==el){
                cnt++;
            }
            else{
                cnt--;
            }
        }
        int cnt1=0;
        for(int i=0;i<nums.length; i++){
            if(nums[i]== el)
                cnt1++;
        }
        if(cnt1 > (nums.length/2))
            return el;
          return -1;
    }
}       // TC--->O(N)  ,  SC---->O(1)
