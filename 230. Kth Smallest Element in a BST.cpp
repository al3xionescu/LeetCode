/*
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Example 1:

Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1

Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3
*/

class Solution {
public:
    int kthSmallest(TreeNode* root, int k) {
        int res = 0;
        int count = k;
        helper(root);
        return res;
    }
    void helper(TreeNode* root) {
        if (root == NULL) {
            return;
        }
        helper(root -> left);
        if (--count == 0) {
            res = root -> val;
        }
        helper(root -> right);
    }
};
