package com.tangdh.easyLeetcode.Model;

public class TreeNodetemp {
    int val;
    TreeNodetemp left;
    TreeNodetemp right;
    TreeNodetemp(Object x){
        val = (int)x;
        left=null;
        right = null;
    }
    public TreeNodetemp(){
        left = null;
        right = null;
    }
    public static TreeNodetemp makeTree(Object[] arrays){
        return makeTree(arrays,0);
    }

    private  static TreeNodetemp makeTree(Object[] arrays, int index) {
        if(index>=arrays.length)
            return null;
        if(!arrays[index].equals("null")) {
            TreeNodetemp root = new TreeNodetemp(Integer.valueOf((String)arrays[index]));
            root.left = makeTree(arrays, index * 2 + 1);
            root.right = makeTree(arrays, (index + 1) * 2);
            return root;
        }
        return null;
    }


}
