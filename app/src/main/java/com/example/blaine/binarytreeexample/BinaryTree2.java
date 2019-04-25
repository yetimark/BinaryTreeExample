package com.example.blaine.binarytreeexample;

public class BinaryTree2
{
    private int payload;
    private BinaryTree2 left;
    private BinaryTree2 right;

    public BinaryTree2(int payload)
    {
        this.payload = payload;
        this.left = null;
        this.right = null;
    }

    public void add(int payloadToAdd)
    {
        //chooses left or right
        if(payloadToAdd <= this.payload)
        {
            // add to the left
            if(this.left == null)
            {
                this.left = new BinaryTree2(payloadToAdd);
            }
            else
            {
                this.left.add(payloadToAdd);
            }
        }
        else
        {
            // add to the right
            if(this.right == null)
            {
                this.right = new BinaryTree2(payloadToAdd);
            }
            else
            {
                this.right.add(payloadToAdd);
            }
        }
    }

    public String visitInOrder()
    {
        String answer = "";
        if(this.left != null)
        {
            answer += this.left.visitInOrder(); // blocking call
        }
        answer += this.payload + ", ";
        if(this.right != null)
        {
            answer += this.right.visitInOrder(); // blocking call
        }
        return answer;
    }

    public String visitPreOrder()
    {
        String answer = "";
        answer += this.payload + ", ";
        if(this.left != null)
        {
            answer += this.left.visitPreOrder();
        }
        if(this.right != null)
        {
            answer += this.right.visitPreOrder();
        }
        return answer;
    }

    public String visitPostOrder()
    {
        String answer = "";
        if(this.left != null)
        {
            answer += this.left.visitPostOrder();
        }
        if(this.right != null)
        {
            answer += this.right.visitPostOrder();
        }
        answer += this.payload + ", ";
        return answer;
    }

    public int getPayload() {
        return payload;
    }

    public BinaryTree2 getLeft() {
        return left;
    }

    public BinaryTree2 getRight() {
        return right;
    }
}
