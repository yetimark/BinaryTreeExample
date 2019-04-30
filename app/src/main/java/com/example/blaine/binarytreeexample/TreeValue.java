package com.example.blaine.binarytreeexample;

public class TreeValue
{
    private int secretCode;
    private BinaryTree2 tree;

    public TreeValue(int secretCode, BinaryTree2 tree)
    {
        this.secretCode = secretCode;
        this.tree = tree;
    }

    public int getSecretCode() {
        return secretCode;
    }

    public BinaryTree2 getTree() {
        return tree;
    }
}
