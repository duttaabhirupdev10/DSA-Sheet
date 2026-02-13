class Solution {
    public void moveZeroes(int[] nums) {
        int j = -1;

        // find first zero
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                j = i;
                break;
            }
        }

        // if no zero found, nothing to do
        if (j == -1) return;

        // swap jth zero with next non-zero
        for (int i = j + 1; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }
}

