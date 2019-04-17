package com.example.blaine.binarytreeexample;

public class Node
{
    private int payload;
    private Node leftChild;
    private Node rightChild;

    public Node(int payload)
    {
        this.payload = payload;
        this.leftChild = null;
        this.rightChild = null;
    }

    public void addChild(Node n)
    {
        if(n.getPayload() <= this.payload)
        {
            if(this.leftChild == null)
            {
                this.leftChild = n;
            }
            else
            {
                this.leftChild.addChild(n);
            }
        }
        else if(n.getPayload() > this.payload)
        {
            if(this.rightChild == null)
            {
                this.rightChild = n;
            }
            else
            {
                this.rightChild.addChild(n);
            }
        }
    }

    public String displayChildenInOrder()
    {
        String answer = "";
        if(this.leftChild != null)
        {
            answer += this.leftChild.displayChildenInOrder();
        }
        answer += this.getPayload();
        if(this.rightChild != null)
        {
            answer += this.rightChild.displayChildenInOrder();
        }
        return answer;
    }


    public int getPayload() {
        return payload;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }
}
