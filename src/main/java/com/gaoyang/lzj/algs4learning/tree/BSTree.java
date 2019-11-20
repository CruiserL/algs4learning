package com.gaoyang.lzj.algs4learning.tree;

import java.util.List;
import java.util.Stack;

/**
 * Desc: 二叉搜索树
 *
 * @author Cruiser_L
 * @date 2019/11/13
 */
public class BSTree {

    private List<Integer> arr;

    private Stack<Integer> nodeStack;

    private TreeNode root;


    /**
     * 删除节点：
     * 注意每次递归时返回的都是当前子树的新的根节点，
     * 需要将当前子树挂在该子树的父节点上。
     *
     * @param root 根节点
     * @param key  要删除的节点的值
     * @return 新树的根节点
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        } else if (key < root.val) {
            // 这里不能直接return deleteNode(root.left, key);
            // 对root的左子树进行递归时，返回的是root左子树的根节点，
            // 如果直接将左子树的根节点返回，将得到错误结果
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            // 同理，不能直接return deleteNode(root.right, key);
            // 方法返回的是右子树的根节点，需要将之挂在root节点的right上
            root.right = deleteNode(root.right, key);
        } else {
            // 此时经过递归已经找到要删除的节点
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            //如果该节点左右节点都不为空，则从该节点的右子树中找到最小的节点
            TreeNode temp = root.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            // 此时temp即为右子树中最小的节点
            // 将根节点替换为右子树中最小的节点，然后将最小的节点删除
            root.val = temp.val;
            // 这里如果不将删除结果赋给root.right，
            // 则只是实现了在子树中的删除，并没有实现在原有树中的删除
            root.right = deleteNode(root.right, temp.val);
        }
        return root;
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode cur = null;
        TreeNode pre = null;
        return false;
    }

    public List<Integer> infixOrder(TreeNode root) {
        if (root.left != null) {
            infixOrder(root.left);
        }
        arr.add(root.val);
        nodeStack.push(root.val);
        if (root.right != null) {
            infixOrder(root.right);
        }
        return arr;
    }

    public void addNode(int val) {
        TreeNode newNode = new TreeNode(val);
        if (root == null) {
            root = newNode;
        } else {
            root.addNode(newNode);
        }
    }


    public boolean infixOrderStack(TreeNode root) {
        if (root.left != null) {
            infixOrderStack(root.left);
        }
        if (nodeStack.isEmpty() || nodeStack.peek() <= root.val) {
            nodeStack.push(root.val);
        } else {
            return false;
        }
        if (root.right != null) {
            infixOrderStack(root.right);
        }
        return false;
    }

    public void infixOrderEnumerate(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            infixOrderEnumerate(root.left);
        }
        System.out.println(root);
        if (root.right != null) {
            infixOrderEnumerate(root.right);
        }
    }

    public void recoverTree(TreeNode root) {
        TreeNode cur = root;
        TreeNode pre = null;
        TreeNode errPnt1 = null;
        TreeNode errPnt2 = null;
        TreeNode prev = null;
        // 莫里斯中序遍历
        while(cur!=null){
            if(cur.left == null){
                if(prev!=null && prev.val > cur.val){
                    if(errPnt1 == null){
                        errPnt1 = prev;
                        errPnt2 = cur;
                    }else{
                        errPnt2 = cur;
                    }
                }
                prev = cur;
                cur = cur.right;
            }
            else{
                pre = cur.left;
                while(pre.right != null && pre.right !=cur){
                    pre = pre.right;
                }

                if(pre.right == null){
                    pre.right = cur;
                    cur = cur.left;
                }else{
                    pre.right = null;
                    if(prev!=null && prev.val > cur.val){
                        if(errPnt1 == null){
                            errPnt1 = prev;
                            errPnt2 = cur;
                        }else{
                            errPnt2 = cur;
                        }
                    }
                    prev = cur;
                    cur = cur.right;
                }
            }
        }
        // 循环完毕后，errPnt1指向第一个错误点，errPnt2指向第二个错误点
        int temp = errPnt1.val;
        System.out.println(temp);
        errPnt1.val = errPnt2.val;
        System.out.println(errPnt2.val);
        errPnt2.val = temp;

    }

    /**
     * 莫里斯中序遍历
     * @param root 根节点
     */
    public void morrisInfixOrder(TreeNode root){
        TreeNode cur = root;
        TreeNode pre = null;
        // 莫里斯中序遍历
        while(cur!=null){
            if(cur.left == null){
                System.out.println(cur);
                cur = cur.right;
            }
            else{
                pre = cur.left;
                while(pre.right != null && pre.right !=cur){
                    pre = pre.right;
                }
                if(pre.right == null){
                    pre.right = cur;
                    cur = cur.left;
                }else{
                    pre.right = null;
                    System.out.println(cur);
                    cur = cur.right;
                }
            }
        }
    }

    public TreeNode arr2BST(int[] nums, int low, int  high){
        if(low>=high){
            return new TreeNode(nums[low]);
        }

        int mid = low+(high-low)/2;
        TreeNode root = new TreeNode(nums[mid]);
        TreeNode leftRoot = arr2BST(nums, low, mid-1);
        TreeNode rightRoot = arr2BST(nums, mid+1, high);
        root.left = leftRoot;
        root.right = rightRoot;
        return root;
    }

    public boolean isBalanced(TreeNode root) {
        return checkBalance(root) != -1;
    }

    public int checkBalance(TreeNode root){
        if(root == null){
            return 0;
        }else if(root.left == null && root.right == null){
            return 1;
        }else{
            if(checkBalance(root.left) == -1){
                return -1;
            }else if(checkBalance(root.right) == -1){
                return -1;
            }else{
                if(Math.abs(checkBalance(root.left) - checkBalance(root.right))>1){
                    return -1;
                }else{
                    return Math.max(checkBalance(root.left), checkBalance(root.right)) + 1;
                }
            }
        }
    }

//    public boolean isBalanced(TreeNode root) {
//        return depth(root) != -1;
//    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        int left = depth(root.left);
        if(left == -1) return -1;
        int right = depth(root.right);
        if(right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }

    // 测试判断是否是平衡二叉树
    public static void main(String[] args) {
        BSTree bsTree = new BSTree();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(3);
        TreeNode root5 = new TreeNode(4);
        TreeNode root6 = new TreeNode(4);
//        root.left = node1;
//        root.right = root2;
//        node1.left = root3;
//        node1.right = root4;
//        root3.left = root5;
//        root3.right = root6;
        root.right = node1;
        node1.right = root3;

//        System.out.println(root);
        bsTree.infixOrderEnumerate(root);
        System.out.println(bsTree.isBalanced(root));
        System.out.println(bsTree.checkBalance(root.right));
        System.out.println(bsTree.checkBalance(root.left));
//        System.out.println(bsTree.checkBalance(root2));
    }

////     测试构建二叉平衡树
//    public static void main(String[] args) {
//        BSTree bsTree = new BSTree();
//        int[] arr = {-10,-3,0,5,9};
//        TreeNode root = bsTree.arr2BST(arr, 0, arr.length-1);
////        System.out.println(root);
//        bsTree.infixOrderEnumerate(root);
//
//    }

////    测试恢复二叉搜索树
//    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
////        TreeNode node1 = new TreeNode(1);
//        TreeNode node2= new TreeNode(2);
//        TreeNode node3 = new TreeNode(3);
//        root.left = node3;
////        root.right = node3;
//        node3.right = node2;
//
//        BSTree bsTree = new BSTree();
//        bsTree.morrisInfixOrder(root);
//        bsTree.recoverTree(root);
//        bsTree.morrisInfixOrder(root);
//
//    }


    // 测试二叉搜索树添加及删除节点
//    public static void main(String[] args) {
//        BSTree bsTree = new BSTree();
//        int[] arr = {5, 3, 6, 2, 4, 7};
//        for (int i = 0; i < arr.length; i++) {
//            bsTree.addNode(arr[i]);
//        }
//        bsTree.infixOrderEnumerate(bsTree.root);
//        bsTree.deleteNode(bsTree.root, 6);
//        System.out.println("删除后：");
//        bsTree.infixOrderEnumerate(bsTree.root);
//        System.out.println(bsTree.root);
//
//    }

    // 测试是否是二叉搜索树
//    public static void main(String[] args) {
//        TreeNode root = new TreeNode(5);
//        TreeNode node1 = new TreeNode(1);
//        TreeNode node2= new TreeNode(4);
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node4 = new TreeNode(6);
//        root.left = node1;
//        root.right = node2;
//        node2.left = node3;
//        node2.right = node4;
//
//        BSTree bsTree = new BSTree();
////        bsTree.arr = new ArrayList<>();
//        bsTree.nodeStack = new Stack<>();
//        System.out.println(bsTree.infixOrderStack(root));
//        long temp = Long.MIN_VALUE;
////        System.out.println(bsTree.infixOrder(root));
//    }

}
