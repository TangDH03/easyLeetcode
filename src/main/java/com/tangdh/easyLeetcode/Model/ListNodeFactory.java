package com.tangdh.easyLeetcode.Model;

public class ListNodeFactory{
    public static ListNode GetListNode(Object[] values,String type){
        if(type.equals("int"))
            return IntegerListNode.makeList(values,0);
        else if(type.equals("float"))
            return FloatListNode.makeList(values,0);
        else if(type.equals("double"))
            return DoubleListNode.makeList(values,0);
        return null;
    }
}