/*
You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.

You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:

You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
Given the integer array fruits, return the maximum number of fruits you can pick.

Example 1:

Input: fruits = [1,2,1]
Output: 3
Explanation: We can pick from all 3 trees.
Example 2:

Input: fruits = [0,1,2,2]
Output: 3
Explanation: We can pick from trees [1,2,2].
If we had started at the first tree, we would only pick from trees [0,1].
*/

class Solution {
    public int totalFruit(int[] fruits) {

        int left = 0;
        int maxLength = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int right = 0; right < fruits.length; right++) {

            // Add the current fruit to the window
            map.put(
                fruits[right],
                map.getOrDefault(fruits[right], 0) + 1
            );

            // More than 2 fruit types -> shrink the window
            while (map.size() > 2) {

                int fruit = fruits[left];

                // Remove one occurrence of fruits[left]
                map.put(fruit, map.get(fruit) - 1);

                // If no fruit of this type remains,
                // remove the type from the map
                if (map.get(fruit) == 0) {
                    map.remove(fruit);
                }

                // Move left pointer
                left++;
            }

            // Current window contains at most 2 types
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}              //    TC-->O(N)    ,      SC-->O(N)
