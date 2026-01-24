class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        //find the 1st index having 0 and store it in the j
        int i,j;
        j=-1;
        for(i=0;i<nums.size();i++){
            if(nums[i]==0){
                j=i;
                break;
            }
        }

          // if no zero found, nothing to do
        if(j == -1) return;
        //swap the j th index having 0 with the i th index having nonzero
        for(i=j+1;i<nums.size();i++){
            if(nums[i]!=0){
                swap(nums[j],nums[i]);
                j++;
            }
        }
    }
};
