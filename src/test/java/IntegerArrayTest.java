import com.tangdh.easyLeetcode.Annotation.Input;
import com.tangdh.easyLeetcode.Annotation.Output;
import com.tangdh.easyLeetcode.Annotation.Solution;
import com.tangdh.easyLeetcode.easyLeetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class IntegerArrayTest {
    //1-D int array pass
    //1-D String array pass
    @Output
    @Input(value = "[1,2,3]",container = "array",type = "int")
    @Solution
    public void IntegerarrayTest(int[] nums){
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args){
        easyLeetcode.Run(IntegerArrayTest.class);
    }





}
