package com.tangdh.easyLeetcode.Model;

public class ListNode {
    public ListNode next;
    int val;
    public ListNode(Object x){val = (int)x;}
    public ListNode(){next=null;}

    @Override
    public String toString() {
        ListNode temp = this;
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        while(temp!=null){
            sb.append(temp.val);
            sb.append(',');
            temp = temp.next;
        }
        sb.setLength(sb.length()-1);
        sb.append(']');
        return sb.toString();
    }
}
