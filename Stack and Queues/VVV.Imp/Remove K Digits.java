/*
Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.
Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
*/

/*
The problem is that StringBuilder does NOT have push() and pop() methods in Java.

You are treating StringBuilder like a Stack.

❌ These lines are wrong
stack.pop();
stack.push(currentDigit);

StringBuilder provides methods such as:

append()
deleteCharAt()
charAt()
length()
substring()
*//

//using monotonic stack

class Solution {
    public String removeKdigits(String num, int k) {
        // Use StringBuilder as a stack to build the result
        StringBuilder stack = new StringBuilder();
      
        // Iterate through each digit in the input number
        for (char currentDigit : num.toCharArray()) {
            // Remove larger digits from the stack when a smaller digit is found
            // This ensures we get the smallest possible number
            while (k > 0 && stack.length() > 0 && stack.charAt(stack.length() - 1) > currentDigit) {
                stack.deleteCharAt(stack.length() - 1);
                k--;
            }
            // Add the current digit to the stack
            stack.append(currentDigit);
        }
      
        // If there are still digits to remove, remove them from the end
        // This handles cases where the number is already in ascending order
        while (k > 0) {
            stack.deleteCharAt(stack.length() - 1);
            k--;
        }
      
        // Remove leading zeros from the result
        int leadingZeroIndex = 0;
        while (leadingZeroIndex < stack.length() && stack.charAt(leadingZeroIndex) == '0') {
            leadingZeroIndex++;
        }
      
        // Extract the final result without leading zeros
        String result = stack.substring(leadingZeroIndex);
      
        // Return "0" if the result is empty, otherwise return the result
        return result.isEmpty() ? "0" : result;
    }
}
//    TC---->O(N)   ,     SC--->O(N)
