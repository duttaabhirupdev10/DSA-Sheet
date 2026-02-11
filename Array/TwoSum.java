//brute
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
}    //TC-->O(n ^2)
//SC--->O(1)

//better (Sorting + Two Pointer)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        int[][] arr = new int[n][2];  // value + original index
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        int left = 0, right = n - 1;

        while (left < right) {
            int sum = arr[left][0] + arr[right][0];

            if (sum == target) {
                return new int[]{arr[left][1], arr[right][1]};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }
}      //tc--->O(nlogn)  , SC--->O(n)

//Optimal (HashMap) ⭐ MOST IMPORTANT
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> mpp = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int moreNeeded = target - num;

            if (mpp.containsKey(moreNeeded)) {
                return new int[]{mpp.get(moreNeeded), i};
            }

            mpp.put(num, i);
        }

        return new int[]{-1, -1};
    }
}  //TC--->O(n)   , SC---->O(n)
