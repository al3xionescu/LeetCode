/*
Two elements of a binary search tree (BST) are swapped by mistake.
Recover the tree without changing its structure.

EXAMPLE:
Input: [1,3,null,null,2]

   1
  /
 3
  \
   2

Output: [3,1,null,null,2]

   3
  /
 1
  \
   2
*/

class Solution {
    TreeNode prev = null;
    TreeNode first = null;
    TreeNode second = null;
    boolean flag = false;
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    private void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        if (prev != null) {
            if (prev.val > root.val) {
                if (!flag) {
                    first = prev;
                    flag = true;
                }
                second = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
}
