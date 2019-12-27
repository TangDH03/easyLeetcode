package com.tangdh.easyLeetcode.Model;
public class FloatListNode extends ListNode {
    public ListNode next;
    public float val;
    public FloatListNode(float x){
        val = x;
        next=null;
    }

    public FloatListNode(){next=null;}
    public static FloatListNode makeList(Object[] arrays, int index){
        if(index>=arrays.length)
            return null;
        FloatListNode re =new FloatListNode((Float) arrays[index]);
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
