package com.tangdh.easyLeetcode.Model;

public class IntegerListNode extends ListNode {
    public ListNode next;
    public int val;
    public IntegerListNode(int x){
        val = x;
        next=null;
    }

    public IntegerListNode(){next=null;}
    public static IntegerListNode makeList(Object[] arrays, int index){
        if(index>=arrays.length)
            return null;
        IntegerListNode re =new IntegerListNode((Integer) arrays[index]);
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
