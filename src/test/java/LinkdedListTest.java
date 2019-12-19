import com.tangdh.easyLeetcode.Annotation.Input;
import com.tangdh.easyLeetcode.Annotation.Solution;
import com.tangdh.easyLeetcode.Model.ListNode;
import com.tangdh.easyLeetcode.easyLeetcode;

import java.util.Collections;

public class LinkdedListTest {
    //linked list pass
    @Input(value = "[1,2,3,4,5]",container = "linkedlist",type = "int")
    @Solution
    public void Test(ListNode listNode){
        System.out.println(listNode);
    }

    public static void main(String[] args) {
        easyLeetcode.Run(LinkdedListTest.class);
    }
}
