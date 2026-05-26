class Solution {
    public int[] getFloorAndCeil(int[] nums, int x) {

        int low = 0, high = nums.length - 1;
        int floor = -1, ceil = -1;

        // Find Floor
        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] <= x) {
                floor = nums[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // Reset pointers
        low = 0;
        high = nums.length - 1;

        // Find Ceil
        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] >= x) {
                ceil = nums[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return new int[]{floor, ceil};
    }
}
