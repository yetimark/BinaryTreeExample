package com.example.blaine.binarytreeexample;

public class TreeStack {
    private TreeNode top;
    private int count;

    public TreeStack()
    {
        this.top = null;
        this.count = 0;
    }

    public void push(BinaryTree2 bt)
    {
        TreeNode tn = new TreeNode(bt);
        tn.setNext(this.top);
        this.top = tn;
        this.count++;
    }

    public BinaryTree2 pop()
    {
        TreeNode returning = this.top;
        this.top = this.top.getNext();
        returning.setNext(null);
        this.count--;
        return returning.getPayload();
    }

    public TreeNode peek()
    {
        return this.top;
    }

    public int getCount() {
        return count;
    }
}
