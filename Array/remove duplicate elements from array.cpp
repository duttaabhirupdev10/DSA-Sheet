//Remove the duplicate elements from array
class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
         int i = 0;
        for (int j = 1; j < nums.size(); j++) {
            if (nums[i] != nums[j]) {
                nums[i+1] = nums[j];
                i++;
            }
        }
        return i+1;
    }
};     // in Geeks for Geeks 
class Solution {
  public:
    // Function to remove duplicates from the given array.
    vector<int> removeDuplicates(vector<int> &arr) {
        // code here
        int i=0;
        for(int j=1;j<arr.size();j++){
            if(arr[i] != arr[j]){
                arr[i+1]=arr[j];
                i++;
            }
        }
        arr.resize(i+1);
        return arr;
    }
};
