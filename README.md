## EasyLeetcode

Simplify the process of debuging leetcode problem in ide

## How to use
```java

public class Leet {  
    @Input(value = "[1,2,3]",container = "array",type = "int")   
    @Solution
    public void IntegerarrayTest(int[] nums){
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args){
        easyLeetcode.Run(IntegerArrayTest.class);
    }

}
```
- There are two kinds of annotation
   1.   **@Input**
        - value is identical  to leetcode input
        - container means what kind of data structure you want to use
            + "array" means int[]
            + "tree"   means TreeNode 
            + "list"     means List<>
            + "linkedlist"  means  linkedlist ie. 1->2->3->4->null
            + the built-in type in java such as int,string,double....
        - type is what kind of data you store in container,only support int and String 
    2. **@Solution**
        - @Solution is an  identifier of the method you want to run


## Problem
- container array only support 1 dimension,but I don't know how to make it support  multi dimension(2-infinity),if you have some good idea ,welcome to raise a PR