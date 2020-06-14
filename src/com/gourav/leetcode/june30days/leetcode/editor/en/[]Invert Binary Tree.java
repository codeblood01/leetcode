//Invert a binary tree.
//
// Example:
//
// Input:
//
//
//     4
//   /   \
//  2     7
// / \   / \
//1   3 6   9
//
// Output:
//
//
//     4
//   /   \
//  7     2
// / \   / \
//9   6 3   1
//
// Trivia:
//This problem was inspired by this original tweet by Max Howell:
//
// Google: 90% of our engineers use the software you wrote (Homebrew), but you c
//an’t invert a binary tree on a whiteboard so f*** off.
// Related Topics Tree


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Deque;
import java.util.LinkedList;

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
    public TreeNode invertTree(TreeNode root) {
        Deque<TreeNode> snail = new LinkedList<>();
        snail.add(root);
        while (!snail.isEmpty()) {
            TreeNode current = snail.removeFirst();
            if (current == null && snail.isEmpty()) {
                break;
            } else {
                if (current == null) {
                    snail.addLast(null);
                } else {
                    TreeNode currentLeft = current.left;
                    current.left = current.right;
                    current.right = currentLeft;
                    if (current.left != null)=snail.addLast(current.left);
                    if (current.right != null)=snail.addLast(current.right);
                }

            }
        }
        return root;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
// dequeue
// Dequ