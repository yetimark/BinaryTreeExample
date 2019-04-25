package com.example.blaine.binarytreeexample;

public class TreeNode {
    private TreeNode next;
    private BinaryTree2 payload;

    public TreeNode(BinaryTree2 bt)
    {
        this.payload = bt;
        this.next = null;
    }

    public BinaryTree2 getPayload() {
        return payload;
    }

    public TreeNode getNext() {
        return next;
    }

    public void setNext(TreeNode next) {
        this.next = next;
    }
}
