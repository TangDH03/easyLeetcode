import com.tangdh.easyLeetcode.Annotation.Input;
import com.tangdh.easyLeetcode.Annotation.Solution;
import com.tangdh.easyLeetcode.Model.TreeNode;
import com.tangdh.easyLeetcode.easyLeetcode;

public class TreeTest {
    @Solution
    @Input(value = "[1,2,null,4,5]",container = "tree",type = "int")
    public void tree(TreeNode node){
        System.out.println(node);
    }

    public static void main(String[] args) {
        easyLeetcode.Run(TreeTest.class);
    }
}
