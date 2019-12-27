package com.tangdh.easyLeetcode.Model;

import sun.reflect.generics.tree.Tree;

public class TreeNodeFactory {
    public static TreeNode GetTreeNode(Object[] values,String type){
        if(type.equals("int"))
            return IntegerTreeNode.makeTree(values);
        else if(type.equals("float"))
            return FloatTreeNode.makeTree(values);
        else if(type.equals("double"))
            return DoubleTreeNode.makeTree(values);
            return null;
    }
}
