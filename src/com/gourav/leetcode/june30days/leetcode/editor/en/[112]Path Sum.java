//Given the root of a binary tree and an integer targetSum, return true if the t
//ree has a root-to-leaf path such that adding up all the values along the path eq
//uals targetSum. 
//
// A leaf is a node with no children. 
//
// 
// Example 1: 
//
// 
//Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
//Output: true
//Explanation: The root-to-leaf path with the target sum is shown.
// 
//
// Example 2: 
//
// 
//Input: root = [1,2,3], targetSum = 5
//Output: false
//Explanation: There two root-to-leaf paths in the tree:
//(1 --> 2): The sum is 3.
//(1 --> 3): The sum is 4.
//There is no root-to-leaf path with sum = 5.
// 
//
// Example 3: 
//
// 
//Input: root = [], targetSum = 0
//Output: false
//Explanation: Since the tree is empty, there are no root-to-leaf paths.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 5000]. 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
// Related Topics Tree Depth-First Search Binary Tree 
// 👍 4368 👎 715

package com.gourav.leetcode.june30days.leetcode.editor.en;
//leetcode submit region begin(Prohibit modification and deletion)


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    boolean flag = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {

          return root==null?false : sumPath(root, 0, targetSum);
    }
    public boolean sumPath(TreeNode root,int pathSum, int targetSum){
        if(root.left == null && root.right == null){
            pathSum = pathSum + root.val;
            if(pathSum==targetSum)
                    return true;
            else {
                pathSum=pathSum-root.val;
                return false;
            }
        }else{
            pathSum = pathSum + root.val;
            if(root.left!=null)
            if(sumPath(root.left, pathSum , targetSum)==true) flag=true;
            if(root.right!=null)
            if(sumPath(root.right,pathSum,targetSum)==true) flag=true;
        }
        return flag;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
