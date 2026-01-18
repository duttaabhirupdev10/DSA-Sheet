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

