package com.tangdh.easyLeetcode.Model;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(Object x){
        val = (int)x;
        left=null;
        right = null;
    }
    public TreeNode(){
        left = null;
        right = null;
    }
    public static TreeNode makeTree(Object[] arrays){
        return makeTree(arrays,0);
    }

    private static TreeNode makeTree(Object[] arrays, int index) {
        if(index>=arrays.length)
            return null;
        if(!arrays[index].equals("null")) {
            TreeNode root = new TreeNode(Integer.valueOf((String)arrays[index]));
            root.left = makeTree(arrays, index * 2 + 1);
            root.right = makeTree(arrays, (index + 1) * 2);
            return root;
        }
        return null;
    }


}
