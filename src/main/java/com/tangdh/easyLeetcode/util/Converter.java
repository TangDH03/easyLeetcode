package com.tangdh.easyLeetcode.util;

import com.tangdh.easyLeetcode.Model.ListNode;
import com.tangdh.easyLeetcode.Model.TreeNode;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Converter {

    public Object doChange(String value,String container,String type){
        if(container.equals("array")){
            if(type.equals("int"))
                return Arrays.stream(ArrayChange(value, type)).
                        filter(t->t!=null).mapToInt(t-> (int) t).toArray();
            else if(type.equals("string")){
                Object[] ans = ArrayChange(value,type);
                return Arrays.copyOf(ans, ans.length, String[].class);
            }
            else
                throw new UnsupportedOperationException();
        }else if(container.equals("list")){
            return ListChange(value,type);
        }else if(container.equals("tree")){
            return TreeChange(value,type);
        }else if(container.equals("string")){
            return value;
        }else if(container.equals("int")){
            return Integer.valueOf(value);
        }else if(container.equals("float")){
            return Float.valueOf(value);
        }else if(container.equals("double")){
            return Double.valueOf(value);
        }else if(container.equals("linkedlist")){
            return LinkedListChange(value,type);
        }
        else{
            System.err.println("incorrect type in Annotation @Input");
        }
        return null;
    }

    private ListNode LinkedListChange(String value, String type) {
        Class<?> clazz = TypeHandler(type);
        ListNode dummy= new ListNode();
        ListNode now = dummy;
        StringBuilder sb = new StringBuilder();
        for(char c:value.toCharArray()){
            if(c=='['||c==' '||c=='\"'||c=='\'')
                continue;
            else if(c==','){
                now.next = new ListNode(getValue(sb.toString(),clazz));
                now = now.next;
                sb.setLength(0);
            }else  if(c==']'){
                if(sb.length()!=0)
                    now.next = new ListNode(getValue(sb.toString(),clazz));
            }else {
                sb.append(c);
            }
        }
        return dummy.next;
    }


    private Object[] ArrayChange(String value, String type){
        return ListChange(value,type).toArray();
    }

    private List<?> ListChange(String value,String type){
        Class<?> clazz = TypeHandler(type);
        ArrayDeque<Object> stack = new ArrayDeque<>();
        int depth = -1;
        int maxdepth = -1;
        char before = '$';
        StringBuilder sb = new StringBuilder();
        List<List<Object>> depthArray= new ArrayList<>();
        for(char c:value.toCharArray()){
            if(c=='['){
                depth++;
                if(maxdepth<depth){
                    depthArray.add(new ArrayList<>());
                    maxdepth = depth;
                }
                stack.push(String.valueOf(c));
            }else if(c==']'){
                if(sb.length()!=0)
                    stack.push(getValue(sb.toString(),clazz));
                sb.setLength(0);
                while (!stack.peek().equals("[")){
                    Object element = stack.pop();
                    depthArray.get(depth).add(0,element);
                }
                stack.pop();
                depth-=1;
                List<Object> finishedArray = depthArray.get(depth+1);
                if(depth>=0) {
                    depthArray.get(depth).add(finishedArray);
                    depthArray.set(depth + 1, new ArrayList<Object>());
                }
            }else if(c==','&&before!=']'){
                stack.push(getValue(sb.toString(),clazz));
                sb.setLength(0);
            }else if(c==','||c=='\"'){
                continue;
            }else{
                sb.append(c);
            }
            before = c;
        }
        return depthArray.get(0);
    }

    private Object TreeChange(String value,String type){
        return TreeNode.makeTree(ArrayChange(value,"string"));
    }

    private  Object getValue(String value,Class<?> clazz){
        Object object = null;
        try {
            if(clazz.equals(String.class)) {
                object = value;
                return object;
            }
            Method method = clazz.getMethod("valueOf",String.class);
            object = method.invoke(clazz,value);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }finally {
            return object;
        }
    }
    private  Class<?>  TypeHandler(String type){
        if("int".equals(type))
            return Integer.class;
        else if("string".equals(type))
            return String.class;
        else if("float".equals(type))
            return Float.class;
        else if("double".equals(type))
            return Double.class;
        else
            return null;
    }
}
