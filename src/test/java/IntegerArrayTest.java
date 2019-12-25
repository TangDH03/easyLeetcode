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
