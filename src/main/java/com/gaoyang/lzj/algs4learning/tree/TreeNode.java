package com.gaoyang.lzj.algs4learning.tree;

/**
 * Desc: 树节点
 *
 * @author Cruiser_L
 * @date 2019/11/13
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public void addNode(TreeNode node) {
        if (node == null) {
            return;
        } else if (node.val < this.val) {
            if (this.left == null) {
                this.left = node;
            } else {

                this.left.addNode(node);
            }
        } else if (node.val > this.val) {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.addNode(node);
            }
        }
        //如果添加后右子树高度大于左子树高度且不平衡，则左旋转
        if(height(this.right) - height(this.left) > 1){
            if(height(this.right.left) > height(this.right.right)){
                this.right.rightRotate();
            }
            leftRotate();
        }

        //如果添加后左子树高度大于右子树高度且不平衡，则右旋转
        if(height(this.left) - height(this.right) > 1){
            if(height(this.left.right) > height(this.left.left)){
                this.left.leftRotate();
            }
            rightRotate();
        }
    }


    public void leftRotate(){
        TreeNode newNode = new TreeNode(this.val);
        newNode.right = this.right.left;
        newNode.left = this.left;
        this.val = this.right.val;
        this.right = this.right.right;
        this.left = newNode;
    }

    public void rightRotate(){
        TreeNode newNode = new TreeNode(this.val);
        newNode.right = this.right;
        newNode.left = this.left.right;
        this.val = this.left.val;
        this.left = this.left.left;
        this.right = newNode;
    }


    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }

    public static int height(TreeNode root){
        if(root == null){
            return 0;
        }
        else{
            return Math.max(height(root.left), height(root.right))+1;
        }
    }
}
