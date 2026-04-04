package com.bezkoder.spring.datajpa.allLeetExamples;

import com.fasterxml.jackson.core.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
BFS Technique
Add all then node values to the Arraylist.
Add the Average to the list.
*/

public class LevelsBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> average = new ArrayList<Double>(); // array list for calculating the value
        Queue<TreeNode> queue = new LinkedList<>(); // linked list for the tree node
        if(root == null) return average;
        queue.add(root); // root in the queue
        while(!queue.isEmpty()){  //  iterate the queue
            double sum = 0.0;
            int size = queue.size();
            for(int i=0; i < queue.size(); i++) {
                TreeNode node = queue.poll();
            /*  sum += node.val;
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right); */
            }
            average.add(sum / size);
        }
        return average;
    }
}