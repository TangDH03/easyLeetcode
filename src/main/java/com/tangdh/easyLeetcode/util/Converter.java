package com.tangdh.easyLeetcode.util;

import com.tangdh.easyLeetcode.Enum.Type;
import com.tangdh.easyLeetcode.Model.ListNode;
import com.tangdh.easyLeetcode.Model.ListNodeFactory;
import com.tangdh.easyLeetcode.Model.TreeNode;
import com.tangdh.easyLeetcode.Model.TreeNodeFactory;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Converter {

    public Object doChange(String value,String container,String type){
        if(container.equals("array")){
            return ArrayChange(value,type);
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
        List arrays = ListChange(value,type);
        //return TreeNode.makeTree(ArrayChange(value,"string"));
        return ListNodeFactory.GetListNode(arrays.toArray(),type);
    }


    private Object ArrayChange(String value, String type){
        Class<?> value_type = Type.getType(type).getClazz();
        Object object = ListChange(value, type);
        int dimension = getListDimension(object);
        int[] sizes = getListSize(object);
        Object array = createArray(value_type,sizes.length,sizes,0);
        array = copyValue(array,object,sizes);
        return array;
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
        List arrays = ListChange(value,type);
        //return TreeNode.makeTree(ArrayChange(value,"string"));
        return TreeNodeFactory.GetTreeNode(arrays.toArray(),type);
    }

    private  Object getValue(String value,Class<?> clazz){
        Object object = null;
        if(value.equals("null"))
            return "_null_";
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
        else if("char".equals(type))
            return Character.class;
        return null;
    }


    private int[] getListSize(Object object){
        List<Integer> ans = new ArrayList<>();
        while (object instanceof List<?>){
            ans.add(((List<?>) object).size());
            object = ((List<?>) object).get(0);
        }
        return ans.stream().mapToInt(i->i).toArray();
    }

    private int getListDimension(Object object){
        if(object instanceof List<?>)
            return getListDimension (((List<?>) object).get(0))+1;
        else
            return 0;
    }

    private Object createArray(Class<?> componentType,
                               int dimension,int[] length,int index) {
        if (dimension == 0)
            return null;
        Object array = null;
        try {
            array = Array.newInstance(getArrayType(componentType
                    , dimension - 1), length[index]);
            for (int i = 0; i < length[index]&&index<length.length-1; i++) {
                Array.set(array, i, createArray(componentType,
                        dimension - 1, length, index + 1));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return array;
    }

    private Class<?> getArrayType(Class<?> componentType, int dimension) throws ClassNotFoundException {
        if(dimension==0){
            return componentType;
        }
        String rawName = componentType.getName();
        switch (rawName){
            case "char": rawName="C";break;
            case "double" : rawName="D";break;
            case "float" :rawName="F";break;
            case "int" :rawName="I";break;
            case "long": rawName="J";break;
            case "short":rawName="S";break;
            case "boolean":rawName="Z";break;
            default:
                rawName="L"+rawName+";";
                break;
        }
        for(int i=0;i<dimension;i++){
            rawName = "["+rawName;
        }
        return Class.forName(rawName);
    }
    private Object getListValue(Object list,int[] indexs){
        for(int i=0;i<indexs.length;i++){
            list = ((List<?>) list).get(indexs[i]);
        }
        return list;
    }
    private boolean CompareIndex(int[] now,int[] indexs){
        for(int i =0;i<now.length;i++){
            if(now[i]>indexs[i]||now[0]==indexs[0])
                return false;
            else if(now[i]<indexs[i])
                    return true;
        }
        return false;
    }

    private void SetArrayValue(Object array,Object value,int[] index){
        Object object = array;
        for(int i=0;i<index.length-1;i++){
            object = Array.get(object,index[i]);
        }
        Array.set(object,index[index.length-1],value);
    }
    private void increment(int[] indexs,int[] size){
        int add = 1;
        int dimension = size.length;
        for(int i=dimension-1;i>=1;i--){
            int index = indexs[i]+add;
            add = index/size[i];
            index = index%size[i];
            indexs[i] = index;
        }
        indexs[0]+=add;
    }
    private Object copyValue(Object array, Object object, int[] sizes) {
        int[] indexs = new int[sizes.length];
        while(CompareIndex(indexs,sizes)){
            SetArrayValue(array,getListValue(object,indexs),indexs);
            increment(indexs,sizes);
        }
        return array;
    }
}
