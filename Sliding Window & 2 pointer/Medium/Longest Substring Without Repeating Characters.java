/*
Given a string s, find the length of the longest substring without duplicate characters.
Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
*/


//Brute
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int res=0;

        for(int i=0;i<n;i++){
            boolean[] vis=new boolean[26];
            for(int j=i;j<n;j++){
                //if the current element is visited, then break the loop
                if(vis[s.charAt(j)-'a'] == true)
                    break;
                //else update the result if this window
                //is larger,and mark current character as visited
                else{
                    res=Math.max(res, j-i+1);
                    vis[s.charAt(j) - 'a']=true;
                }
            }
        }
        return res;
    }
}    //   TC--->O(N^2)   ,    SC--->O(1)
