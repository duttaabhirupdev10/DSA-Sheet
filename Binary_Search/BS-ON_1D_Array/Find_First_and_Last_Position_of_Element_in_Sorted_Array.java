//Brute
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first=-1,last=-1;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==target){
                if(first==-1)
                first=i;
                last=i;
            }
        }
        return new int[]{first,last};
    }
}  //TC-->O(n)

//optimal
class Solution {
    
    // Function to find first position
    public int firstPosition(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int first = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                first = mid;
                high = mid - 1; // move left
            }
            else if (nums[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return first;
    }

    // Function to find last position
    public int lastPosition(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int last = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                last = mid;
                low = mid + 1; // move right
            }
            else if (nums[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return last;
    }

    public int[] searchRange(int[] nums, int target) {
        
        int first = firstPosition(nums, target);
        int last = lastPosition(nums, target);

        return new int[]{first, last};
    }
}   // TC--->O(log N)
