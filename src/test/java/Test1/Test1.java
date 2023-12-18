package Test1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Test1 {




    @Test
    public void test(){
        Object[][] data = getData();
        System.out.println(Arrays.stream(data).map(arr-> Arrays.stream(arr)).collect(Collectors.toList()));
        /*System.out.println("hello world");
        String user=System.getProperty("user");
        System.out.println(user);*/
        Map<?, ?> map=new HashMap<>(){
            {
                put(1,1);
                put(2,2);
            }
        };

        map.forEach((k,v)-> System.out.println(k+"=="+v));

    }

    @DataProvider
    public Object[][] getData(){
        Object[][] data=new Object[][]{
                {"one"},{"two"},{"three"}
        };
        return data;
    }
}
