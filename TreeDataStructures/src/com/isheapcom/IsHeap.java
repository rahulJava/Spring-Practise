package com.isheapcom;

import java.util.LinkedList;
 
/**
 * <b>IDeserve <br>
 * <a href="<a class="vglnk" href="https://www.youtube.com/c/IDeserve" rel="nofollow"><span>https</span><span>://</span><span>www</span><span>.</span><span>youtube</span><span>.</span><span>com</span><span>/</span><span>c</span><span>/</span><span>IDeserve</span></a>"><a class="vglnk" href="https://www.youtube.com/c/IDeserve" rel="nofollow"><span>https</span><span>://</span><span>www</span><span>.</span><span>youtube</span><span>.</span><span>com</span><span>/</span><span>c</span><span>/</span><span>IDeserve</span></a></a>
 * Check if binary tree is a complete tree or not.
 * @author Nilesh
 */
 
public class IsHeap {
 
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
        this.root = new TreeNode(97);
        TreeNode n1   = new TreeNode(46);
        TreeNode n2   = new TreeNode(37);
        TreeNode n3   = new TreeNode(12);
        TreeNode n4   = new TreeNode(3);
        TreeNode n5   = new TreeNode(7);
         
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
        this.root = new TreeNode(5);
        TreeNode n1   = new TreeNode(3);
        TreeNode n2   = new TreeNode(3);
        TreeNode n3   = new TreeNode(1);
        TreeNode n4   = new TreeNode(0);
        TreeNode n5   = new TreeNode(1);
        TreeNode n6   = new TreeNode(0);
         
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
    boolean isHeap(TreeNode root) 
    { 
        if(root == null) 
            return true; 
          
        // These two are used in isCompleteUtil() 
        
        System.out.println("tree is complete or not:"+checkIfComplete());
        System.out.println("tree is heap:"+isHeapUtil(root));
          
        if(checkIfComplete()==true && isHeapUtil(root)==true) 
            return true; 
        return false; 
    } 
     
    boolean isHeapUtil(TreeNode root) 
    { 
        //  Base case : single node satisfies property 
        if(root.left == null && root.right==null) 
            return true; 
          
        //  node will be in second last level 
        if(root.right == null) 
        { 
            //  check heap property at Node 
            //  No recursive call , because no need to check last level 
            return root.val >= root.left.val; 
        } 
        else
        { 
            //  Check heap property at Node and 
            //  Recursive check heap property at left and right subtree 
            if(root.val >= root.left.val && root.val >= root.right.val) 
                return isHeapUtil(root.left) && isHeapUtil(root.right); 
            else
                return false; 
        } 
    } 
    
    public static void main(String[] args)
    {
        IsHeap tree = new IsHeap();
         
       TreeNode root = tree.createCompleteTree();
//        System.out.println(tree.checkIfComplete());
//        
//        tree.createIncompleteTree();
//        System.out.println(tree.checkIfComplete());
        
        System.out.println(tree.isHeap(root));
 
    }
}