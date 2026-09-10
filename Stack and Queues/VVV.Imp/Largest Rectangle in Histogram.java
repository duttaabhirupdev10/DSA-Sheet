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
class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea=0;
        //Stack stotres(startIndex,height)
        Stack<int[]> stack=new Stack<>();
        for(int i=0;i<heights.length;i++){
            int h=heights[i];
            int start=i;
            while(!stack.isEmpty() && stack.peek()[1]>h){
                int[] popped= stack.pop();
                int index=popped[0];
                int height=popped[1];

                maxArea=Math.max(maxArea,height*(i-index));
                start=index;
            }
            stack.push(new int[]{start,h});
        }
        //calculate remaining rectangles
        for(int[] item:stack){
            int index=item[0];
            int height=item[1];

            maxArea=Math.max(maxArea,height*(heights.length-index));
        }
        return maxArea;
    }
}            //    TC--->O(N)   ,    Sc--->O(n)
