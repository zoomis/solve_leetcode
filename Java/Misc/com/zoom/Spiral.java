package com.zoom;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
        left = null;
        right = null;
    }

    public TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

public class Spiral {

    public static void printSpiral(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        stack.push(root);

        // TODO(joon): How to do it?
        while (!stack.empty() || queue.peek() != null) {
            if (!stack.empty()) {
                while (!stack.empty()) {
                    TreeNode node = stack.pop();
                    System.out.println(node.val);
                    if (node.left != null)
                        queue.add(node.left);
                    if (node.right != null)
                        queue.add(node.right);
                }
            } else if (queue.peek() != null) {
                while (queue.peek()!=null) {
                    TreeNode node = queue.remove();
                    System.out.println(node.val);
                    if (node.left != null)
                        stack.push(node.left);
                    if (node.right != null)
                        stack.push(node.right);
                }
            }
        }
    }
    
    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        printSpiral(root);
    }
}
