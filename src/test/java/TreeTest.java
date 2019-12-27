import com.tangdh.easyLeetcode.Annotation.Input;
import com.tangdh.easyLeetcode.Annotation.Solution;
import com.tangdh.easyLeetcode.Model.DoubleTreeNode;
import com.tangdh.easyLeetcode.Model.FloatTreeNode;
import com.tangdh.easyLeetcode.Model.IntegerTreeNode;
import com.tangdh.easyLeetcode.Model.TreeNode;
import com.tangdh.easyLeetcode.easyLeetcode;

public class TreeTest {
    @Solution
    @Input(value = "[1.1,2.2,null,4.3,5.1]",container = "tree",type = "double")
    public void tree(DoubleTreeNode node){
        System.out.println(node.val);
    }

    public static void main(String[] args) {
        easyLeetcode.Run(TreeTest.class);
    }
}
