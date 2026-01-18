class Solution {
public:
    void reverse(vector<int>& nums, int l, int r) {
        while (l < r) {
            swap(nums[l++], nums[r--]);
        }
    }

    void rotate(vector<int>& nums, int k) {
        int n = nums.size();
        k %= n;

        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
        reverse(nums, 0, n - 1);
    }
};

// leetcode 

class Solution {
public:
    void rever(vector<int>& nums, int start, int end){
        while (start<end){
            swap(nums[start], nums[end]);
            start+=1;
            end -= 1;
        }
    }
    
    void rotate(vector<int>& nums, int k) {
        int length = nums.size();

        k = k % length;
        if (k==0) return;

        int someMid = nums.size()-k;

        rever(nums, 0, someMid-1);
        rever(nums, someMid, length-1);
        rever(nums, 0, length-1);
    }
};
