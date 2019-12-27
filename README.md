## EasyLeetcode

Simplify the process of debuging leetcode problem in ide

## How to use
##### For Array
```java

public class IntegerArrayTest {
    //1-D int array pass
    //1-D String array pass

    @Input(value = "[[4.3,5.31],[6.2,7.3],[8.1,9.2]]",container = "array",type = "float")
    @Input(value = "[[[12,31,32],[12,32,32]],[[12,31,32],[12,32,32]]]",container = "array",type = "int")
    @Solution
    public void IntegerarrayTest(float[][] nums,int[][][] numm)
    {
        System.out.println("I'm in");
    }

    public static void main(String[] args){
        easyLeetcode.Run(IntegerArrayTest.class);
    }

}
```
All you need to do  is just paste the input into the value,and specify the container ie.array and type such as float double int.Then you could run the program just like in leetcode.EasyLeetCode could handle any dimension and you don't need to specify the number of dimension

##### For List
```java
public class listTest {
    @Solution
    @Input(value = "[1,2,3]",container = "list",type = "int")
    public void list(List<Integer> l){
        System.out.println(l.toString());
    }

    public static void main(String[] args) {
        easyLeetcode.Run(listTest.class);
    }
}
```

####For Tree
```java
    @Solution
    @Input(value = "[1.1,2.2,null,4.3,5.1]",container = "tree",type = "double")
    public void tree(DoubleTreeNode node){
        System.out.println(node.val);
    }

    public static void main(String[] args) {
        easyLeetcode.Run(TreeTest.class);
    }
```
value is just like leetcode,but you need to specify the argument according to the type
double ---> DoubleTreeNode
int --------->            IntegerTreeNode
float-------> FloatTreeNode
####For LinkedList
```java
public class LinkdedListTest {
    //linked list pass
    @Input(value = "[1.1,2.2,3.3,4.3,5.3]",container = "linkedlist",type = "float")
    @Solution
    public void Test(FloatListNode listNode){
        System.out.println(listNode.val);
    }

    public static void main(String[] args) {
        easyLeetcode.Run(LinkdedListTest.class);
    }
}
```
The use of LinkedList is similar to TreeNode
double ---> DoubleListNode
int --------->            IntegerListNode
float-------> FloatListNode

####Contribute
If you have some good idea you could raise a PR,
If you have some problem when you use it,raise a issue let me know
Welcome to contribute!!