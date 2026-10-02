/*
Given a binary tree, determine if it is height-balanced.
*/

class Solution {
    int height(TreeNode root){
        if(root==null)
            return 0;
    
       int leftH=height(root.left);
       int rightH=height(root.right);

       return Math.max(leftH,rightH)+1; 
    }


    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        
        int leftH=height(root.left);
        int rightH=height(root.right);

        if(Math.abs(leftH-rightH) > 1){
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }
}  //TC=O(n^2)   , SC=O(n)   //recursion stack=n size
