//Given the root of a binary tree, imagine yourself standing on the right side o
//f it, return the values of the nodes you can see ordered from top to bottom. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,2,3,null,5,null,4]
//Output: [1,3,4]
// 
//
// Example 2: 
//
// 
//Input: root = [1,null,3]
//Output: [1,3]
// 
//
// Example 3: 
//
// 
//Input: root = []
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 100]. 
// -100 <= Node.val <= 100 
// 
// Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 
// 👍 5329 👎 292

package com.gourav.leetcode.june30days.leetcode.editor.en;
//leetcode submit region begin(Prohibit modification and deletion)


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new LinkedList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        TreeNode delimiter = new TreeNode(-1000);
        queue.add(delimiter);
        TreeNode current;
        while (!queue.isEmpty()){
            current = queue.poll();
            if(current == null)
                continue;
            if (current.val == -1000){

                if(queue.size()>=1)
                    queue.add(delimiter);

                continue;
            }
            if (queue.peek().val==-1000 ) {
                result.add(current.val);
                if(current.left!=null)
                    queue.add(current.left);
                if(current.right!=null)
                    queue.add(current.right);
                continue;
            }
            if (queue.peek().val!=-1000 ){
                if(current.left!=null)
                    queue.add(current.left);
                if(current.right!=null)
                    queue.add(current.right);
            }
        }
        return result;
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)
