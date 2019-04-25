package com.example.blaine.binarytreeexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /*
        ***Binary Trees***
        A starting node or "root"
        If values added are less than or equal the value, it is added to the left
        If values added are greater than the current value, it is added to the right
        Each node can have at most two nodes it is linked to <binary trees>


        ***Tree Traversal***
        In Order - Visit left, visit yourself, visit right    ->  3, 3, 5, 6, 8  <- In order
        Pre Order - Visit yourself, visit left, visit right   ->  5, 3, 3, 8, 6  <- Shows halves
        Post Order - Visit left, visit right, visit yourself  ->  3, 3, 6, 8, 5  <- Shows leaves first

        Depth First - Goes down individual trees like the orders do (vertical)
        Breadth First - Goes down by level (horizontal)

        ***Traveling Salesman Problem***
        What is the most efficient route to visit your n cities in a day

        RECURSION is a programmatic entity that is defined in terms of itself

        4/23 good voice in video at 53min
     */


    private TextView payloadText;
    private Button rightButton, leftButton;
    public static BinaryTree2 currTree = new BinaryTree2(5);
    public static BinaryTree2 rootTree = MainActivity.currTree;
    public static String state = null;

    // to keep track of intents  -> probably can use the underlying stacks somehow but this works
    public static TreeStack currTrees = new TreeStack();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.payloadText = (TextView) findViewById(R.id.payloadTV);
        this.rightButton = (Button) findViewById(R.id.rightBTN);
        this.leftButton = (Button) findViewById(R.id.leftBTN);

        this.addTrees();

        // updates the new activity on the stack after each activity change
        this.payloadText.setText(Integer.toString(this.currTree.getPayload()));
        this.setButtonVisibility();


        System.out.println(this.currTree.visitInOrder());
    }

    private void addTrees()
    {
        if(MainActivity.state == null)
        {
            this.currTree.add(3);
            this.currTree.add(3);
            this.currTree.add(8);
            this.currTree.add(6);
            MainActivity.state = "Filled";
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("****** ON Destroy!!!!!!");

        // this is a band-aid fix
        // I'm pretty sure this could be fixed by using the stacks the same way we used sudo recursion with the trees
        if(this.currTrees.peek() != null) // prevents app from crashing when going beyond the root of the tree
        {
            this.currTree = this.currTrees.pop();
        }
    }

    // Changes View as if moving to the Right Tree
    public void onRightClick(View v)
    {
        this.currTrees.push(this.currTree);
        this.currTree = this.currTree.getRight();

        Intent i = new Intent(this, MainActivity.class);
        this.startActivity(i);
    }

    // Changes View as if moving to the Left Tree
    public void onLeftClick(View v)
    {
        this.currTrees.push(this.currTree);
        this.currTree = this.currTree.getLeft();

        Intent i = new Intent(this, MainActivity.class);
        this.startActivity(i);
    }

    // Makes buttons invisible when there is not a left or right tree
    private void setButtonVisibility()
    {
        // if left tree is null, then do not show button
        if(this.currTree.getLeft() == null)
        {
            this.leftButton.setVisibility(View.INVISIBLE);
        }
        else
        {
            this.leftButton.setVisibility(View.VISIBLE);
        }

        // if right tree is null, then do not show button
        if(this.currTree.getRight() == null)
        {
            this.rightButton.setVisibility(View.INVISIBLE);
        }
        else
        {
            this.rightButton.setVisibility(View.VISIBLE);
        }
    }
}
