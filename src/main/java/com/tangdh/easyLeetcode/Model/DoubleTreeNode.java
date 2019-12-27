package com.tangdh.easyLeetcode.Model;

import sun.reflect.generics.tree.Tree;

public class DoubleTreeNode extends TreeNode<Double> {

    public double val;
    public TreeNode<Double> left;
    public TreeNode<Double> right;

    public DoubleTreeNode(double x){
        val = x;
        left = null;
        right = null;
    }
    public DoubleTreeNode(){
        left = null;
        right = null;
    }
    public static TreeNode<Double> makeTree(Object[] arrays){
        return makeTree(arrays,0);
    }

    private static TreeNode<Double> makeTree(Object[] arrays, int index){
        if(index>=arrays.length)
            return null;
        if(!arrays[index].equals("_null_")){
            TreeNode<Double> root = new DoubleTreeNode(
                    (Double) arrays[index]);
            root.val = ((Double) arrays[index]);
            root.left = makeTree(arrays,index*2+1);
            root.right = makeTree(arrays,(index+1)*2);
            return root;
        }
        return null;
    }
}
