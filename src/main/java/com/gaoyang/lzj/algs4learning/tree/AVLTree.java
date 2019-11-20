package com.gaoyang.lzj.algs4learning.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import static com.gaoyang.lzj.algs4learning.tree.TreeNode.height;

/**
 * Desc: AVL树
 *
 * @author Cruiser_L
 * @date 2019/11/14
 */
public class AVLTree {

    public TreeNode root;

    /**
     * 中序遍历
     *
     * @param root 根节点
     */
    public void infixOrder(TreeNode root) {
        Stack<TreeNode> nodeStack = new Stack<>();
        while (root != null || !nodeStack.isEmpty()) {
            if (root != null) {
                while (root.left != null) {
                    nodeStack.push(root);
                    root = root.left;
                }
            } else {
                root = nodeStack.pop();
            }
            System.out.println(root.val);
            root = root.right;
        }
    }

    /**
     * 先输出右子树的中序遍历
     *
     * @param root 根节点
     */
    public void invertedInfixOrder(TreeNode root) {
        Stack<TreeNode> nodeStack = new Stack<>();
        while (root != null || !nodeStack.isEmpty()) {
            if (root != null) {
                while (root.right != null) {
                    nodeStack.push(root);
                    root = root.right;
                }
            } else {
                root = nodeStack.pop();
            }
            System.out.println(root.val);
            root = root.left;
        }
    }

    /**
     * 判断一棵树是否为对称树
     *
     * @param root 根节点
     * @return 是否对称
     */
    public boolean isSymmetric(TreeNode root) {

        Stack<TreeNode> nodeStack1 = new Stack<>();
        Stack<TreeNode> nodeStack2 = new Stack<>();
        TreeNode temp1 = root;
        TreeNode temp2 = root;
        while ((temp1 != null && temp2 != null) || !nodeStack1.isEmpty()) {
            if ((temp1 != null && temp2 != null)) {
                while (temp1.left != null && temp2.right != null) {
                    if (temp1.val == temp2.val) {
                        nodeStack1.push(temp1);
                        nodeStack2.push(temp2);
                        temp1 = temp1.left;
                        temp2 = temp2.right;
                    } else {
                        return false;
                    }
                }
                if (!(temp1.left == null && temp2.right == null)) {
                    return false;
                }
                if (temp1.val != temp2.val) {
                    return false;
                }
            } else {
                temp1 = nodeStack1.pop();
                temp2 = nodeStack2.pop();
            }

            temp1 = temp1.right;
            temp2 = temp2.left;
        }
        return (temp1 == null && temp2 == null);
    }

    /**
     * 向平衡二叉树中增加节点
     *
     * @param i 要增加的节点的value
     */
    public void add(int i) {
        if (root == null) {
            root = new TreeNode(i);
            return;
        }
        root.addNode(new TreeNode(i));
    }


    /**
     * 二叉树的层次遍历
     *
     * @param root 根节点
     * @return list
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        // 第一层：
//        List<Integer> level0 = new ArrayList<>();
//        level0.add(root.val);
//        res.add(level0);
//
//        // 第二层
//        List<Integer> level1 = new ArrayList<>();
//        level1.add(root.left.val);
//        level1.add(root.right.val);
//        res.add(level1);
//
//        // 第三层
//        List<Integer> level2 = new ArrayList<>();
//        level2.add(root.left.left.val);
//        level2.add(root.left.right.val);
//        level2.add(root.right.left.val);
//        level2.add(root.right.right.val);
//
//        res.add(level2);
        List<TreeNode> parentList = new ArrayList<>();
        parentList.add(root);
        List<Integer> rootList = new ArrayList<Integer>();
        rootList.add(root.val);
        res.add(rootList);
//        List<TreeNode> childList = getNextList(parentList);

        while(!parentList.isEmpty()){
//            List<Integer> intList = new ArrayList<>();
//            for (TreeNode treeNode : parentList) {
//                intList.add(treeNode.val);
//            }
//            res.add(intList);
            parentList = getNextList(parentList, res);
        }


        return res;
    }

    public List<TreeNode> getNextList(List<TreeNode> parentList, List<List<Integer>> res) {
        List<TreeNode> childList = new ArrayList<>();
        List<Integer> itemList = new ArrayList<>();
        for (TreeNode treeNode : parentList) {
            if (treeNode.left != null) {
                childList.add(treeNode.left);
                itemList.add(treeNode.left.val);
            }
            if (treeNode.right != null) {
                childList.add(treeNode.right);
                itemList.add(treeNode.right.val);
            }
        }
        if(!itemList.isEmpty()){
            res.add(itemList);
        }
        return childList;
    }


    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        List<TreeNode> parentList = new ArrayList<>();
        parentList.add(root);
        List<Integer> rootList = new ArrayList<Integer>();
        rootList.add(root.val);
        res.addFirst(rootList);

        while(!parentList.isEmpty()){
            parentList = getNextListBottom(parentList, res);
        }

        return res;
    }

    public List<TreeNode> getNextListBottom(List<TreeNode> parentList, LinkedList<List<Integer>> res) {
        List<TreeNode> childList = new ArrayList<>();
        List<Integer> itemList = new ArrayList<>();
        for (TreeNode treeNode : parentList) {
            if (treeNode.left != null) {
                childList.add(treeNode.left);
                itemList.add(treeNode.left.val);
            }
            if (treeNode.right != null) {
                childList.add(treeNode.right);
                itemList.add(treeNode.right.val);
            }
        }
        if(!itemList.isEmpty()){
            res.addFirst(itemList);
        }
        return childList;
    }




    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        int[] nums = {10, 11, 7, 6, 8, 9};

        for (int i : nums) {
            avlTree.add(i);
        }

        System.out.println(height(avlTree.root));
        System.out.println(height(avlTree.root.left));
        System.out.println(height(avlTree.root.right));
        TreeNode root = avlTree.root;
        System.out.println(root);
        System.out.println(root.left);
        System.out.println(root.left.left);
        System.out.println(root.right);
        System.out.println(root.right.right);
        System.out.println(root.right.left);

    }

    /**
     * 判断一棵树是否为对称二叉树测试
     * @param args 参数
     */
//    public static void main(String[] args) {
//        AVLTree avlTree = new AVLTree();
//        TreeNode root = new TreeNode(1);
//        TreeNode node1 = new TreeNode(2);
//        TreeNode root2 = new TreeNode(2);
//        TreeNode root3 = new TreeNode(3);
//        TreeNode root4 = new TreeNode(3);
//        TreeNode root5 = new TreeNode(4);
//        TreeNode root6 = new TreeNode(4);
//        root.left = node1;
//        root.right = root2;
////        node1.left = root3;
////        node1.right = root4;
////        root3.left = root5;
////        root3.right = root6;
////        avlTree.infixOrder(root);
////        System.out.println();
////        avlTree.invertedInfixOrder(root);
//
//        System.out.println(avlTree.isSymmetric(root));
//    }
}
