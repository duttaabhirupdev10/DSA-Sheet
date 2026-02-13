class Solution {
    public int appearsOnce(int[] nums) {
        int xor = 0;

        for (int i = 0; i < nums.length; i++) {
            xor = xor ^ nums[i];
        }

        return xor;
    }
}

// 1^1^2^3^3^4^4
//= 0^2^3^3^4^4    same no.^same no.= 0
//=2------> XOR result
