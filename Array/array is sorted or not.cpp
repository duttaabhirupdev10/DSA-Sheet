//the array is sorted or not
class Solution {
  public:
    bool isSorted(vector<int>& arr) {
        // code here
        for(int i=1;i<arr.size();i++){   //don't need to check for the 1st element
            if(arr[i]<arr[i-1])
                return false;
        }
        return true;
    }
};
