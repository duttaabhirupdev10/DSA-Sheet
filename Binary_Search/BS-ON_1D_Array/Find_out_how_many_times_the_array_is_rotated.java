class Solution {
    public int findKRotation(ArrayList<Integer> nums) {
        int n = nums.size();
        int low = 0, high = n - 1;

        int ans = Integer.MAX_VALUE;
        int index = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            // Entire range is sorted
            if (nums.get(low) <= nums.get(high)) {
                if (nums.get(low) < ans) {
                    ans = nums.get(low);
                    index = low;
                }
                break;
            }

            // Left half sorted
            if (nums.get(low) <= nums.get(mid)) {
                if (nums.get(low) < ans) {
                    ans = nums.get(low);
                    index = low;
                }
                low = mid + 1;
            }
            // Right half contains minimum
            else {
                if (nums.get(mid) < ans) {
                    ans = nums.get(mid);
                    index = mid;
                }
                high = mid - 1;
            }
        }

        return index;
    }
}//  same as find min in the rotated sorted array.But here we have to return the index
