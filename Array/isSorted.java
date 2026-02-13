//the array is sorted or not
class Solution {
    public boolean isSorted(int[] arr) {
        // start from index 1, compare with previous
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
