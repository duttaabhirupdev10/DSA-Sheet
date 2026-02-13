class Solution {

    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        // reverse whole array
        reverse(nums, 0, n - 1);

        // reverse first k
        reverse(nums, 0, k - 1);

        // reverse remaining
        reverse(nums, k, n - 1);
    }
}



