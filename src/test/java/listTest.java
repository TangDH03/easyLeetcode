import com.tangdh.easyLeetcode.Annotation.Input;
import com.tangdh.easyLeetcode.Annotation.Solution;
import com.tangdh.easyLeetcode.easyLeetcode;

import java.util.List;

public class listTest {
    @Solution
    @Input(value = "[[1,2,3],[3,4]]",container = "list",type = "int")
    public void list(List<Integer> l){
        System.out.println(l.toString());
    }

    public static void main(String[] args) {
        easyLeetcode.Run(listTest.class);
    }
}
