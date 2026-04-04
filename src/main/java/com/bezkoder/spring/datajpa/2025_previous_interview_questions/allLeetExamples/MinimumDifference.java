package com.bezkoder.spring.datajpa.previous_interview_questions.allLeetExamples;

import com.fasterxml.jackson.core.TreeNode;

import java.io.IOException;
import java.util.*;

/*
Apply BFS Technique,
add all elements in one arraylist,
Sort the ArrayList,
Compare the nearby elements and get the minimum difference.
*/
public class MinimumDifference {

    public int getMinimumDifference(TreeNode root) throws IOException {
        List<Integer> average = new ArrayList<Integer>(); // array list for calculating the value
        Queue<TreeNode> queueNode = new LinkedList<>(); // linked list for the tree node


        queueNode.add(root);
        while(!queueNode.isEmpty()){
            int queueNodeSize = queueNode.size();
            for(int i=0; i< queueNodeSize; i++){
                TreeNode currNode  = queueNode.poll();
                /*
                if(currNode.left != null) queueNode.add(currNode.left);
                if(currNode.right != null) queueNode.add(currNode.right);
                average.add(currNode.val); */
                average.add(currNode.traverse().getValueAsInt());
            }
        }

        Collections.sort(average);
        int diff = Integer.MAX_VALUE;
        System.out.println(" diff :: "+ diff);

        for(int i=0; i < average.size()-1; i++){
            diff = Math.min(diff, Math.abs(average.get(i) - average.get(i + 1)));
        }
        return diff;
    }
}