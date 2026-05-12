// Better
class Solution {
    public void setZeroes(int[][] matrix) {
        int rows=matrix.length;
        int columns=matrix[0].length;
        // array to mark the rows and columns
        int[]row=new int[rows];
        int[]cols=new int[columns];
        //mark the rows and columns having the 0's
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(matrix[i][j]==0){
                    row[i]=1;
                    cols[j]=1;
                }
            }
        }
        // set the matrix elemnet to 0's
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(row[i]==1 || cols[j]==1){
                    matrix[i][j]=0;
                }
            }
        }
    }
}
//TC ---> O(2*n*m)   SC--->O(n)+O(m)

//ooptimal
class Solution {
    public void setZeroes(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int col0=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    //mark the i-th row
                    matrix[i][0]=0;
                    //mark the j-th column
                    if(j!=0)
                         matrix[0][j]=0;
                    else
                        col0=0;
                }
            }
        }
        // traverse the array in the matrix
        //(1,1) to (n,m)
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }
         // Mark the first row
        if (matrix[0][0] == 0) {
            for (int j = 0; j < m; j++)
                matrix[0][j] = 0;
        } 
         // Mark the first column
        if (col0 == 0) {
            for (int i = 0; i < n; i++)
                matrix[i][0] = 0;
    }
    }}   //TC--->O(n*m)  SC--->O(1)
