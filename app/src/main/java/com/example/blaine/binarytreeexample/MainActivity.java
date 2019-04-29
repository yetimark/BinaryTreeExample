package com.example.blaine.binarytreeexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /*  CLASS NOTES

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
    public BinaryTree2 myTree;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.payloadText = (TextView) findViewById(R.id.payloadTV);
        this.rightButton = (Button) findViewById(R.id.rightBTN);
        this.leftButton = (Button) findViewById(R.id.leftBTN);


        if(this.getIntent().hasExtra("myTree"))
        {
            this.myTree = (BinaryTree2)this.getIntent().getSerializableExtra("myTree");
        }
        else
        {
            // only when the first MainActivity launches
            this.myTree = new BinaryTree2(5);
            this.myTree.add(3);
            this.myTree.add(3);
            this.myTree.add(8);
            this.myTree.add(6);
        }


        this.payloadText.setText(Integer.toString(this.myTree.getPayload()));
        this.hideButtonsIfNecessary();
        System.out.println(this.myTree.visitInOrder());
    }

    // Changes View as if moving to the Right Tree
    public void onRightClick(View v)
    {
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("myTree", this.myTree.getRight());
        this.startActivity(i);
    }

    // Changes View as if moving to the Left Tree
    public void onLeftClick(View v)
    {
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("myTree", this.myTree.getLeft());
        this.startActivity(i);
    }

    // Makes buttons invisible when there is not a left or right tree
    private void hideButtonsIfNecessary()
    {
        // if left tree is null, then do not show button
        if(this.myTree.getLeft() == null)
        {
            this.leftButton.setVisibility(View.INVISIBLE);
        }

        // if right tree is null, then do not show button
        if(this.myTree.getRight() == null)
        {
            this.rightButton.setVisibility(View.INVISIBLE);
        }
    }
}
