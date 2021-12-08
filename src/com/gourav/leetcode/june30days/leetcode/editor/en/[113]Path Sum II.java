//Given the root of a binary tree and an integer targetSum, return all root-to-l
//eaf paths where the sum of the node values in the path equals targetSum. Each pa
//th should be returned as a list of the node values, not node references. 
//
// A root-to-leaf path is a path starting from the root and ending at any leaf n
//ode. A leaf is a node with no children. 
//
// 
// Example 1: 
//
// 
//Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//Output: [[5,4,11,2],[5,8,4,5]]
//Explanation: There are two paths whose sum equals targetSum:
//5 + 4 + 11 + 2 = 22
//5 + 8 + 4 + 5 = 22
// 
//
// Example 2: 
//
// 
//Input: root = [1,2,3], targetSum = 5
//Output: []
// 
//
// Example 3: 
//
// 
//Input: root = [1,2], targetSum = 0
//Output: []
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
// Related Topics Backtracking Tree Depth-First Search Binary Tree 
// 👍 3959 👎 97

package com.gourav.leetcode.june30days.leetcode.editor.en;
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
    List<List<Integer>> result = new ArrayList<>();
    boolean flag = false;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        hasPathSum(root, targetSum);
        return result;
    }
    Stack <Integer> stack = new Stack<Integer>();

    public boolean hasPathSum(TreeNode root, int targetSum) {

        return root==null?false : sumPath(root, 0, targetSum);
    }
    public boolean sumPath(TreeNode root,int pathSum, int targetSum){
        stack.push(root.val);
        if(root.left == null && root.right == null){
            pathSum = pathSum + root.val;
            if(pathSum==targetSum) {
                result.add(new ArrayList<>(stack. subList(0 , stack.size())));
                stack.pop();
                return true;
            }
            else {
                pathSum=pathSum-root.val;
                stack.pop();
                return false;
            }
        }else{
            pathSum = pathSum + root.val;
            if(root.left!=null)
                if(sumPath(root.left, pathSum , targetSum)==true) flag=true;
            if(root.right!=null)
                if(sumPath(root.right,pathSum,targetSum)==true) flag=true;
        }
        stack.pop();
        return flag;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
