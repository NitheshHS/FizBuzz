package mapTest;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MapCopy {

    public Map getData(){
        Map map=new HashMap();
        map.put("Customer Zipcode", 1234);
        map.put("Dealer Zipcode", 4567);
       return map;
    }

    public Object[][] getObjectArray(){
        Object[][] obj=new Object[][]{
                {getData()},
                {getData()}
                            };
        return obj;
    }

    @Test
    public void test(){
        MapCopy copy=new MapCopy();
        Map newMap=new HashMap();
        for(int i=0;i<copy.getObjectArray().length;i++){
            Map map=(Map)copy.getObjectArray()[i][0];
            String zip=System.getProperty("zip");
            if(zip!=null){
                map.put("Dealer Zipcode", zip);
                map.put("Customer Zipcode", zip);
                newMap.putAll(map);
            }
        }
        System.out.println(newMap);
    }

}
