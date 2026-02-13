// optimal ----> 2 pointer approach
class Solution {
    public static List<Integer> findArrayIntersection(int[] A, int n, int[] B, int m) {
        int i = 0;
        int j = 0;
        List<Integer> ans = new ArrayList<>();

        while (i < n && j < m) {
            if (A[i] < B[j]) {
                i++;
            } else if (A[i] > B[j]) {
                j++;
            } else {
                ans.add(A[i]);
                i++;
                j++;
            }
        }

        return ans;
    }
}
