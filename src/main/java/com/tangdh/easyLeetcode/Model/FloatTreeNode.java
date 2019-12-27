package com.tangdh.easyLeetcode.Model;

public class FloatTreeNode extends TreeNode<Float>{

    public float val;
    public TreeNode<Float> left;
    public TreeNode<Float> right;

    public FloatTreeNode(float x){
        val = x;
        left = null;
        right = null;
    }
    public FloatTreeNode(){
        left = null;
        right = null;
    }
    public static TreeNode<Float> makeTree(Object[] arrays){
        return makeTree(arrays,0);
    }

    private static TreeNode<Float> makeTree(Object[] arrays, int index){
        if(index>=arrays.length)
            return null;
        if(!arrays[index].equals("_null_")){
            TreeNode<Float> root = new FloatTreeNode(
                    (Float) arrays[index]);
            root.val = ((Float) arrays[index]);
            root.left = makeTree(arrays,index*2+1);
            root.right = makeTree(arrays,(index+1)*2);
            return root;
        }
        return null;
    }
}
