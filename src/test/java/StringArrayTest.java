import com.tangdh.easyLeetcode.Annotation.Input;
import com.tangdh.easyLeetcode.Annotation.Output;
import com.tangdh.easyLeetcode.Annotation.Solution;
import com.tangdh.easyLeetcode.easyLeetcode;

import java.util.Arrays;
import java.util.List;

public class StringArrayTest {
    @Output
    @Input(value = "[\"aewqddqw\",\"bqwd\",\"baqwdqwsa\"]",container = "array",type = "string")
    //@Input(value = "123332",container = "int",type = "int")
    @Solution
    public int[] StringarrayTest(String[] nums){
        System.out.println(Arrays.toString(nums));
        return new int[3];
    }

    public static void main(String[] args) {
        easyLeetcode.Run(StringArrayTest.class);
    }
}
