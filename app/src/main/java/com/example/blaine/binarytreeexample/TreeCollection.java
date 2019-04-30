package com.example.blaine.binarytreeexample;

import java.util.LinkedList;

public class TreeCollection
{
    private LinkedList<TreeValue> theMappings;

    public TreeCollection()
    {
        this.theMappings = new LinkedList<TreeValue>();
    }

    public void addTree(int secretCode, BinaryTree2 tree)
    {
        this.theMappings.add(new TreeValue(secretCode, tree));
    }

    public void removeTree()
    {
        this.theMappings.removeLast();
    }

    public BinaryTree2 getTreeWithSuperSecretCode(int secretCode)
    {
        for(TreeValue tv : this.theMappings)
        {
            if(tv.getSecretCode() == secretCode)
            {
                return tv.getTree();
            }
        }
        return null;
    }

    public void display()
    {
        String answer = "";
        for(TreeValue tv : this.theMappings)
        {
            answer += tv.getTree().getPayload() + " -> ";
        }
        System.out.println(answer);
    }
}
