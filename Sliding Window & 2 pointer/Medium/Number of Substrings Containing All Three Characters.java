/*
Given a string s consisting only of characters a, b and c.

Return the number of substrings containing at least one occurrence of all these characters a, b and c.

 

Example 1:

Input: s = "abcabc"
Output: 10
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again). 
*/

//brute
class Solution {
    public int numberOfSubstrings(String s) {
        int count=0;
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                String sub=s.substring(i,j+1);

                //whether the substring having a,b,c
                if(sub.contains("a") && sub.contains("b") && sub.contains("c"))
                    count++;
            }
        }
        return count++;
    }
}

//optimal
class Solution {
    public int numberOfSubstrings(String s) {
        int left=0;
        int right=0;
        int len=s.length();
        // to track the frequency of a,b,c
        int[] freq=new int[3];
        int count=0;

        while(right< len){
            // inctrease the freq of the char at right
            char curr=s.charAt(right);
            freq[curr - 'a']++;
            while(hasThreeChars(freq)){
                count+=len-right;
                freq[s.charAt(left) - 'a']--;
                left++;

            }
            right++;
        }
        return count;


    }
     private boolean hasThreeChars(int[] freq){
            return freq[0]>0 && freq[1]>0 && freq[2]>0;
        }
}
