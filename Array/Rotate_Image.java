// concept of swapping  (   Optimal   )
class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        for(int i=0;i<(n+1)/2;i++){ // i=0-->outer ring, i=1--->just inner ring
            for(int j=0;j< n/2;j++){
                //start 4 way swap
                //temp=bottom left
                int temp=matrix[n-1-j][i];
                //bottom left=bottom right
                matrix[n-1-j][i]=matrix[n-1-i][n-j-1];
                //bottom right=top right
                matrix[n-1-i][n-j-1]=matrix[j][n-1-i];
                //top right=top left
                matrix[j][n-1-i]=matrix[i][j];
                //top left=temp
                matrix[i][j]=temp;
            }
        }
    }
}

// TC--->O(n^2)
//SC-->o(1)
