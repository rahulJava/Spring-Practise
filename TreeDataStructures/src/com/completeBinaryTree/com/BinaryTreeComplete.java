package com.completeBinaryTree.com;

import java.util.LinkedList;
 
/**
 * <b>IDeserve <br>
 * <a href="<a class="vglnk" href="https://www.youtube.com/c/IDeserve" rel="nofollow"><span>https</span><span>://</span><span>www</span><span>.</span><span>youtube</span><span>.</span><span>com</span><span>/</span><span>c</span><span>/</span><span>IDeserve</span></a>"><a class="vglnk" href="https://www.youtube.com/c/IDeserve" rel="nofollow"><span>https</span><span>://</span><span>www</span><span>.</span><span>youtube</span><span>.</span><span>com</span><span>/</span><span>c</span><span>/</span><span>IDeserve</span></a></a>
 * Check if binary tree is a complete tree or not.
 * @author Nilesh
 */
 
public class BinaryTreeComplete {
 
    class QueueNode
    {
        TreeNode node;
 
        QueueNode(TreeNode node)
        {
            this.node = node;
        }
    }
     
    class TreeNode
    {
        TreeNode left;
        TreeNode right;
        int val;
     
        public TreeNode(int x)
        {
            this.val = x;
        }
    }
     
    TreeNode root;
 
     
    /*
                            1
                      2             3
                  4      5       6     
    */
 
    private TreeNode createCompleteTree()
    {
        this.root = new TreeNode(1);
        TreeNode n1   = new TreeNode(2);
        TreeNode n2   = new TreeNode(3);
        TreeNode n3   = new TreeNode(4);
        TreeNode n4   = new TreeNode(5);
        TreeNode n5   = new TreeNode(6);
         
        root.left  = n1;
        root.right = n2;
         
        n1.left  = n3;
        n1.right = n4;
         
        n2.left  = n5;
         
        return root;
    }
 
 
     
    /*
                            1
                      2             3
                  4      5        6     
                7  
    */
 
    private TreeNode createIncompleteTree()
    {
        this.root = new TreeNode(1);
        TreeNode n1   = new TreeNode(2);
        TreeNode n2   = new TreeNode(3);
        TreeNode n3   = new TreeNode(4);
        TreeNode n4   = new TreeNode(5);
        TreeNode n5   = new TreeNode(6);
        TreeNode n6   = new TreeNode(7);
         
        root.left  = n1;
        root.right = n2;
         
        n1.left  = n3;
        n1.right = n4;
         
        n2.left  = n5;
         
        n3.left  = n6;
         
        return root;
    }
 
 
    public boolean checkIfComplete()
    {
        if (root == null) return true;
         
        LinkedList<TreeNode> queue = new LinkedList();
        boolean nonFullNodeSeen = false;
         
        queue.add(root);
         
        while (!queue.isEmpty())
        {
            TreeNode currentNode = queue.remove();
             
            if ((currentNode.left != null) && (currentNode.right != null))
            {
                // there should not be any non-leaf node after first non full-node is seen
                if (nonFullNodeSeen)
                {
                    return false;
                }
                queue.add(currentNode.left);
                queue.add(currentNode.right);
            }
 
            if ((currentNode.left != null) && (currentNode.right == null))
            {
                // there should not be any non-leaf node after first non full-node is seen
                if (nonFullNodeSeen)
                {
                    return false;
                }
                 
                // this is the first non-full node seen
                nonFullNodeSeen = true;
                queue.add(currentNode.left);
            }
 
            // this should never be the case for a complete binary tree 
            if ((currentNode.left == null) && (currentNode.right != null))
            {
                return false;
            }
 
        }
        return true;
    }
     
    public static void main(String[] args)
    {
        BinaryTreeComplete tree = new BinaryTreeComplete();
         
        tree.createCompleteTree();
        System.out.println(tree.checkIfComplete());
         
        tree.createIncompleteTree();
        System.out.println(tree.checkIfComplete());
 
    }
}