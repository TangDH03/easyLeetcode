package com.tangdh.easyLeetcode.Model;
public class DoubleListNode extends ListNode {
    public ListNode next;
    public double val;
    public DoubleListNode(double x){
        val = x;
        next=null;
    }

    public DoubleListNode(){next=null;}
    public static DoubleListNode makeList(Object[] arrays, int index){
        if(index>=arrays.length)
            return null;
        DoubleListNode re =new DoubleListNode((Double) arrays[index]);
        re.next = makeList(arrays,index+1);
        return re;
    }
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
