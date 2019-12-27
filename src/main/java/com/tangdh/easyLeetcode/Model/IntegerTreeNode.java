package com.tangdh.easyLeetcode.Model;

public class IntegerTreeNode extends TreeNode<Integer>{
    public int val;
    public TreeNode<Integer> left;
    public TreeNode<Integer> right;

    public IntegerTreeNode(int x){
        val = x;
        left = null;
        right = null;
    }
    public IntegerTreeNode(){
        left = null;
        right = null;
    }
    public static TreeNode<Integer> makeTree(Object[] arrays){
        return makeTree(arrays,0);
    }

    private static TreeNode<Integer> makeTree(Object[] arrays, int index){
        if(index>=arrays.length)
            return null;
        if(!arrays[index].equals("_null_")){
            TreeNode<Integer> root = new IntegerTreeNode(
                    (Integer) arrays[index]);
            root.val = ((Integer) arrays[index]).intValue();
            root.left = makeTree(arrays,index*2+1);
            root.right = makeTree(arrays,(index+1)*2);
            return root;
        }
        return null;
    }


}
