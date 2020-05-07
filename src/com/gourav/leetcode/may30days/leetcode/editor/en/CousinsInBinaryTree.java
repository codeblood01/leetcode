
//In a binary tree, the root node is at depth 0, and children of each depth k no
//de are at depth k+1. 
//
// Two nodes of a binary tree are cousins if they have the same depth, but have 
//different parents. 
//
// We are given the root of a binary tree with unique values, and the values x a
//nd y of two different nodes in the tree. 
//
// Return true if and only if the nodes corresponding to the values x and y are 
//cousins. 
//
// 
//
// Example 1: 
// 
//
// 
//Input: root = [1,2,3,4], x = 4, y = 3
//Output: false
// 
//
// 
// Example 2: 
// 
//
// 
//Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
//Output: true
// 
//
// 
// Example 3: 
//
// 
//
// 
//Input: root = [1,2,3,null,4], x = 2, y = 3
//Output: false 
//
// 
// 
// 
//
// Note: 
//
// 
// The number of nodes in the tree will be between 2 and 100. 
// Each node has a unique integer value from 1 to 100. 
// 
//
// 
// 
// 
// 
// Related Topics Tree Breadth-first Search

package com.gourav.leetcode.may30days.leetcode.editor.en;

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {

        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.add(root);
        que.add(null); // this is our level breaker;
        int level = 1;
        int firstInfo[] = new int[2];
        int secondInf[] = new int[2];
        while (!que.isEmpty()) {
            TreeNode node = que.poll();
            if (que.isEmpty())
                break;
            if (node == null) {
                level++;
                que.add(null);
            } else {
                if (node.left != null) {
                    que.add(node.left);
                    if (node.left.val == x) {
                        firstInfo[0] = level + 1;
                        firstInfo[1] = node.val;
                    }
                }
                if (node.right != null) {
                    que.add(node.right);
                    if (node.right.val == x) {
                        secondInf[0] = level + 1;
                        secondInf[1] = node.val;
                    }
                }
            }

        }
        if (firstInfo[0] == secondInf[0] &&
                firstInfo[1] == secondInf[1])
            return true;
        return false;


    }
}
// answer is true if and only if level are same and parent are diff;
// so fina out the values of both parent and level for both x and y;
// we can use any search here bfs or dfs, but iterative solution sounds more
// intutive than the recursive solution
// also check level wise print of a binary tree same as above implementation
//leetcode submit region end(Prohibit modification and deletion)
	