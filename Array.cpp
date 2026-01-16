// Largest element in the array
class Solution {
  public:
    int largest(vector<int> &arr) {
        // code here
        int largest=arr[0];
        for (int i=0;i<arr.size();i++){
            if(arr[i]>largest)
                largest=arr[i];
         }
    return largest;
    }
};

//second largest and second lowest element in the array
class Solution {
  public:
    int getSecondLargest(vector<int> &arr) {
        // code here
        int largest=arr[0];
        int slargest=-1;
        for(int i=0;i<arr.size();i++){
            if(arr[i]>largest){
                slargest=largest;
                largest=arr[i];
            }
            else if(arr[i]<largest && arr[i]>slargest){
                slargest=arr[i];
            }
        }
        return slargest;
    }
};
// smallest and second smallest
class Solution {
  public:
    vector<int> minAnd2ndMin(vector<int> &arr) {
        int smallest = arr[0];
        int ssmallest = INT_MAX;

        for (int i = 1; i < arr.size(); i++) {
            if (arr[i] < smallest) {
                ssmallest = smallest;
                smallest = arr[i];
            }
            else if (arr[i] != smallest && arr[i] < ssmallest) {
                ssmallest = arr[i];
            }
        }

        if (ssmallest == INT_MAX)
            return {-1};

        return {smallest, ssmallest};
    }
};

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

