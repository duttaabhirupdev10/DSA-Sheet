/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
*/

//Better
class Solution {
    public int trap(int[] height) {

        int n = height.length;

        // If there are less than 3 bars, no water can be trapped
        if (n < 3) {
            return 0;
        }

        // prefixMax[i] = maximum height from index 0 to i
        int[] prefixMax = new int[n];

        // suffixMax[i] = maximum height from index i to n-1
        int[] suffixMax = new int[n];

        // -------------------------------
        // STEP 1: Build prefixMax array
        // -------------------------------

        // The maximum height till index 0 is height[0]
        prefixMax[0] = height[0];

        for (int i = 1; i < n; i++) {

            // Store the maximum height between:
            // 1. Previous maximum
            // 2. Current height
            prefixMax[i] = Math.max(prefixMax[i - 1], height[i]);
        }

        // -------------------------------
        // STEP 2: Build suffixMax array
        // -------------------------------

        // The maximum height from last index
        // to the end is height[n-1]
        suffixMax[n - 1] = height[n - 1];

        for (int i = n - 2; i >= 0; i--) {

            // Store the maximum height between:
            // 1. Maximum height on the right
            // 2. Current height
            suffixMax[i] = Math.max(suffixMax[i + 1], height[i]);
        }

        // -------------------------------
        // STEP 3: Calculate trapped water
        // -------------------------------

        int totalWater = 0;

        for (int i = 0; i < n; i++) {

            // Water level is decided by the shorter
            // boundary: min(left maximum, right maximum)
            int waterLevel = Math.min(prefixMax[i], suffixMax[i]);

            // Water above current bar
            int water = waterLevel - height[i];

            // Add it to total water
            totalWater += water;
        }

        return totalWater;
    }
}      //   TC----->O(2N)   ,SC----->O(N)


//Optimal

class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int left=0;
        int right=n-1;
        int maxLeft=0;
        int maxRight=0;
        int totalWater=0;
        while(left < right){
            if(height[left] <= height[right]){
                if(height[left] >= maxLeft){
                    maxLeft=height[left];
                }
                else{
                    totalWater+=maxLeft-height[left];
                }
                left++;
            }
            else{
                if(height[right] >= maxRight){
                    maxRight=height[right];
                }
                else{
                    totalWater+=maxRight-height[right];
                }
                right--;
            }
        }
        return totalWater;
    }
}       //    TC--->O(N)   ,   SC--->O(1)
