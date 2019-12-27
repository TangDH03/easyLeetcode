import com.tangdh.easyLeetcode.Annotation.Input;
import com.tangdh.easyLeetcode.Annotation.Solution;
import com.tangdh.easyLeetcode.Model.DoubleListNode;
import com.tangdh.easyLeetcode.Model.FloatListNode;
import com.tangdh.easyLeetcode.Model.ListNode;
import com.tangdh.easyLeetcode.easyLeetcode;

import java.util.Collections;

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
