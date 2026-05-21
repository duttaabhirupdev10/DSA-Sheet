class Solution {
    public int search(int[] nums, int target) {
       int low=0;
       int high=nums.length-1;
       while(low<=high){
        int mid=(low+high)/2;
        if(nums[mid]==target) return mid;// target found
        else if(target>nums[mid]) low=(mid+1);// search in the right side
        else high=(mid-1);//search in the left side
       } 
       return -1;
    }
}  //TC--->O(log n), SC--->O(1)


//recursive
import java.util.*;

public class Solution {

    // Recursive Binary Search function
    public static int binarySearch(int[] nums, int low, int high, int target) {
        if (low > high) return -1; // Base case: target not found

        // Find middle index
        int mid = (low + high) / 2;

        // If target is found at mid
        if (nums[mid] == target) return mid;
        // If target is greater, search right half
        else if (target > nums[mid])
            return binarySearch(nums, mid + 1, high, target);
        // Otherwise, search left half
        return binarySearch(nums, low, mid - 1, target);
    }

    // Public function to initiate search
    public static int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    public static void main(String[] args) {
        int[] a = {3, 4, 6, 7, 9, 12, 16, 17}; // sorted array
        int target = 6; // target element to search

        int ind = search(a, target);

        if (ind == -1)
            System.out.println("The target is not present.");
        else
            System.out.println("The target is at index: " + ind);
    }
}  //TC-->O(log n),  SC-->O(1)
