/*
Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:

Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3
*/

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new LinkedList<String>();
        if (root != null) {
            binaryTreePaths(root, paths, ""); 
        }
        return paths;
    }
    public void binaryTreePaths(TreeNode root, List<String> paths, String path) {
        StringBuilder pathb = new StringBuilder(path);
        pathb.append(root.val);
        if (root.left == null && root.right == null) {
            paths.add(pathb.toString());
        }
        else {
            pathb.append("->");
            String curPath = pathb.toString();
            if (root.left != null) {
                binaryTreePaths(root.left, paths, curPath);
            }
             if (root.right != null) {
                binaryTreePaths(root.right, paths, curPath);   
            }
        }
    }
}
