package com.example.blaine.binarytreeexample;

public class BinaryTree
{
    private Node root;

    public BinaryTree()
    {
        this.root = null;
    }

    public void add(int payload)
    {
        Node n = new Node(payload);
        if(this.root == null)
        {
            this.root = n;
        }
        else
        {
            if(n.getPayload() <= this.root.getPayload())
            {
                //add to left
                if(this.root.getLeftChild() == null)
                {
                    this.root.setLeftChild(n);
                }
            }
            else if(n.getPayload() > this.root.getPayload())
            {
                //add to right
                if(this.root.getRightChild() == null)
                {
                    this.root.setRightChild(n);
                }
            }
        }
    }

    public void display()
    {
        System.out.println(this.root.displayChildenInOrder());
    }
}
