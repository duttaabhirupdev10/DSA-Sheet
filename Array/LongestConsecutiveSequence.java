/*Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

 

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
*/

class Solution {
    public int longestConsecutive(int[] nums) {
                if (nums == null || nums.length == 0) return 0;

        HashSet<Integer> set = new HashSet<>();

        // Step 1: Add all elements to set
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        // Step 2: Find sequences
        for (int num : set) {
            // Only start when it's the beginning of a sequence
            if (!set.contains(num - 1)) {
                int current = num;
                int count = 1;

                // Count consecutive numbers
                while (set.contains(current + 1)) {
                    current++;
                    count++;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;
    }
}
