/*
The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.
You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.
Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.

Example 1:

Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
Output: [-1,3,-1]
Explanation: The next greater element for each value of nums1 is as follows:
- 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
- 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
- 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
*/

//brute
        // Stores: number -> its next greater element
        HashMap<Integer, Integer> map = new HashMap<>();

        // Monotonic decreasing stack
        Stack<Integer> stack = new Stack<>();

        // Traverse nums2 from right to left
        for (int i = nums2.length - 1; i >= 0; i--) {

            // Remove all smaller or equal elements
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }

            // If stack is empty, there is no greater element
            if (stack.isEmpty()) {
                map.put(nums2[i], -1);
            } else {
                map.put(nums2[i], stack.peek());
            }

            // Push current element
            stack.push(nums2[i]);
        }

        // Find answers for nums1
        int[] answer = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            answer[i] = map.get(nums1[i]);
        }

        return answer;  /*


        1. What is the problem?

Suppose:

nums1 = [4, 1, 2]

nums2 = [1, 3, 4, 2]

For every element of nums1, we need to find the next greater element to its right in nums2.

For example:

4 → -1
1 → 3
2 → -1

So the answer is:

[-1, 3, -1]
2. Why do we use a HashMap?
HashMap<Integer, Integer> map = new HashMap<>();

We want to store:

number → next greater number

For our example:

1 → 3
3 → 4
4 → -1
2 → -1

Then when we see nums1[i], we can simply do:

map.get(nums1[i])
3. Why do we use a Stack?
Stack<Integer> stack = new Stack<>();

The stack helps us find the next greater element efficiently.

We maintain a decreasing monotonic stack.

That means elements in the stack are arranged roughly like:

5
4
2
1

from top to bottom.

4. Why do we traverse from RIGHT to LEFT?

This is very important.

for (int i = nums2.length - 1; i >= 0; i--)

We start from the rightmost element because we are looking for the next greater element on the right.

For:

1  3  4  2
         ↑

When processing 4, we already want to know what exists to its right.

So we process:

2 → 4 → 3 → 1
5. Process 2

Initially:

stack = []

Current element:

2

Check:

while (!stack.isEmpty() && stack.peek() <= nums2[i])

Stack is empty, so nothing happens.

Then:

if (stack.isEmpty()) {
    map.put(nums2[i], -1);
}

So:

2 → -1

Then:

stack.push(2);

Stack:

[2]
6. Process 4

Current:

4

Stack:

[2]

We check:

stack.peek() <= nums2[i]

That means:

2 <= 4

True.

So:

stack.pop();

Remove 2.

Stack becomes:

[]

Now there is no element greater than 4.

Therefore:

4 → -1

Then push 4:

[4]
7. Process 3

Current:

3

Stack:

[4]

Check:

4 <= 3

False.

So we don't pop 4.

Now stack is not empty:

map.put(nums2[i], stack.peek());

Therefore:

3 → 4

Then push 3.

Stack:

[4, 3]
8. Process 1

Current:

1

Stack:

[4, 3]

Check:

3 <= 1

False.

So 3 stays.

The top of stack is:

3

Therefore:

1 → 3

Push 1:

[4, 3, 1]
9. Final HashMap

We have:

1 → 3
3 → 4
4 → -1
2 → -1

Now we have solved the next-greater-element problem for every element of nums2.

10. Now process nums1

We create:

int[] answer = new int[nums1.length];

Then:

for (int i = 0; i < nums1.length; i++) {
    answer[i] = map.get(nums1[i]);
}

For:

nums1 = [4, 1, 2]
4
map.get(4)

gives:

-1
1
map.get(1)

gives:

3
2
map.get(2)

gives:

-1

Therefore:

answer = [-1, 3, -1]
The most important part

Remember this pattern:

while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
    stack.pop();
}

We're saying:

"If the element on the stack is smaller than or equal to the current element, it can never be the next greater element, so remove it."

Then:

map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());

means:

"After removing useless elements, whatever is on top of the stack is the next greater element."

And finally:

stack.push(nums2[i]);

means:

"Put the current element into the stack so it can potentially be the next greater element for an element on its left."

Overall flow
nums2
  ↓
Traverse RIGHT → LEFT
  ↓
Remove smaller/equal elements
  ↓
Stack top = Next Greater Element
  ↓
Store in HashMap
  ↓
Look up nums1 elements
  ↓
Return answer

Time: O(n + m)
Space: O(n) auxiliary space.
        */
