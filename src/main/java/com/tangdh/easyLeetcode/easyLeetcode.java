package com.tangdh.easyLeetcode;

import com.tangdh.easyLeetcode.Annotation.Input;
import com.tangdh.easyLeetcode.Annotation.Solution;
import com.tangdh.easyLeetcode.util.Converter;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class easyLeetcode {
    private static Method invokeMethod = null;
    private static final Converter conveter= new Converter();
    public static void Run(Class clazz){
        Method[] methods = clazz.getMethods();
        List<Object> objects = new ArrayList<>();
        List<Input> inputs = new ArrayList<>();
        //get Soultion methods,which means method to invoke
        for(Method method:methods){
            Annotation annotation = method.getAnnotation(Solution.class);
                if(annotation instanceof Solution){
                    invokeMethod = method;
                    break;
            }
        }
        Class[] parameterTypes = invokeMethod.getParameterTypes();
        //get Inputs
        Input[] annotations = invokeMethod.getAnnotationsByType(Input.class);
        for(Annotation annotation: annotations){
            if(annotation instanceof Input){
                inputs.add((Input) annotation);
            }
        }

        //convert annotation to valid input
        for(Input input:inputs){
            String type = input.type();
            String value = input.value();
            String container = input.container();
            //Object object = conveter.doChange(value,container,type);
            Object object = new int[]{1,2,3};
            objects.add(object);
            //objects.add(new Object[]{1,2,3,45});
        }

        //inVokeMethod

        try {
            invokeMethod.invoke(clazz.newInstance(),objects.toArray());
        } catch (IllegalAccessException e) {
            System.out.println("No permission");
            e.printStackTrace();
        } catch (InvocationTargetException | InstantiationException e) {
            System.out.println("Invoke Error");
            e.printStackTrace();
        }
    }
}
