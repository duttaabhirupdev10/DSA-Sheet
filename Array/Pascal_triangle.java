//optimal
class Solution {
    public List<List<Integer>> generate(int numRows) {
       List<List<Integer>> result=new ArrayList<>();
        for(int row=0;row<numRows;row++){
            List<Integer> currentRow= new ArrayList<>();
            int ans=1;
            for(int col=0;col<=row;col++){
                currentRow.add(ans);
                ans=ans*(row-col)/(col+1);
            }
            result.add(currentRow);
        }
        return result;
    }
}
//TC--->O(n^2)  , SC-->O(n^2)
