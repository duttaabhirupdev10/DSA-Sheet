/*
Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

 

Example 1:


Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 6
Explanation: The maximal rectangle is shown in the above picture.
Example 2:

Input: matrix = [["0"]]
Output: 0
*/


class Solution {

    public int maximalRectangle(char[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] height = new int[cols];

        int maxArea = 0;

        for (int i = 0; i < rows; i++) {

            // Build histogram
            for (int j = 0; j < cols; j++) {

                if (matrix[i][j] == '1') {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }

            maxArea = Math.max(maxArea, largestRectangleArea(height));
        }

        return maxArea;
    }


    public int largestRectangleArea(int[] heights) {

        int n = heights.length;

        int[] NSL = new int[n];
        int[] NSR = new int[n];

        Stack<Integer> st = new Stack<>();

        // NSL - Next Smaller Left
        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() &&
                   heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                NSL[i] = -1;
            } else {
                NSL[i] = st.peek();
            }

            st.push(i);
        }


        st.clear();


        // NSR - Next Smaller Right
        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() &&
                   heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                NSR[i] = n;
            } else {
                NSR[i] = st.peek();
            }

            st.push(i);
        }


        // Calculate maximum area
        int maxArea = 0;

        for (int i = 0; i < n; i++) {

            int width = NSR[i] - NSL[i] - 1;

            int area = heights[i] * width;

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}       //TC-->O(N^2)   ,    SC-->O(N)
