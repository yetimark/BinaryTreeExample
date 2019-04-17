package com.example.blaine.binarytreeexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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

        ***Traveling Salesman Problem***
        What is the most efficient route to visit your n cities in a day
     */

    private BinaryTree myTree = new BinaryTree();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        char first = 'I';
        char second = 'z';
        char third = 'z';
        char fourth = 'y';
        String person = "Izzy";

        System.out.println(person);






    }

    public void tryThis()
    {
        String person = "Delaney";
    }
}
