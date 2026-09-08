/*
Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

Example 1:
Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
*/

//brute 
class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea=0;
        for(int i=0;i<heights.length;i++){
            int minHeight=Integer.MAX_VALUE;
            for(int j=i;j<heights.length;j++){
                minHeight=Math.min(minHeight,heights[j]);
                int weidth=j-i+1;
                int area=minHeight * weidth;
                maxArea=Math.max(maxArea,area);
            }
        }
        return maxArea;
    }
}           //      TC--->O(N^2)   ,    SC--->O(1)

//optimal-->monotonic stack

