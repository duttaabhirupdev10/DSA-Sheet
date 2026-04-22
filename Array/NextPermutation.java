class Solution {
    public void nextPermutation(int[] nums) {
       int n=nums.length;
       // step 1 find the pivot element 
       int pivot=n-2;
       while(pivot >=0 && nums[pivot] >= nums[pivot +1]){
        pivot--;
       } 
       // step 2 if the pivot exist then find the next greatest element from the right side
       if(pivot >=0){
        int j=n-1;
        while(nums[j]<=nums[pivot]){
            j--;
        }
        //pivot swap with next greater element
        swap(nums,pivot,j);
       }
       // step 3 reverse the suffix (right side from the pivot)
       reverse(nums,pivot+1,n-1);

    }
    //swap helper function
    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    //reverse helper function
    private void reverse(int[] nums,int start,int end){
        while(start<end){
            swap(nums,start,end);
            start++;
            end--;
        }
    }
}

// Time Complexity--->O(N)
//Space complexity--->O(1)
