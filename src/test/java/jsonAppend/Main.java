package jsonAppend;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        /*Map<String, Mapping> map1=new HashMap<>();
        Mapping mapping=new Mapping();
        mapping.setAmountFinanced(15000d);
        mapping.setFinanceCharge(777d);
        mapping.setMonthlyPayment(145.1);
        map1.put("IL_01_LOAN_12345", mapping);

        TestPojo pojo=new TestPojo();
        pojo.setMapper(map1);

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = null;
        System.out.println("Success");
        List<String> list = List.of("CASH_FL1_10001", "CASH_FL2_10001", "CASH_FL3_10001", "CASH_FL4_10001", "CASH_FL5_10001");
            node = createJsonObj(list);
        mapper.writeValue(new FileWriter("./testResult.json"), node);*/

        List<Map<String, ?>> list = convertJsonFileToCollection("testResult.json");
        //Map<String, ?> map = getValueFromList(list, "BasicDeal_Rebate_Fees_Accessories_Fni_Leased_Positive_TradeIn_CASH_30368");
       System.out.println(list);

    }

    private static <T> Map<String, ?> getValueFromList(T t, String testId) {
        Map<String, Object> map = null;
       if(t instanceof List<?>){
           System.out.println("Instance of list");
           return ((List<Map>)t).parallelStream()
                   .filter(entry->entry.get("testId").equals(testId))
                   .collect(Collectors.toMap(s->(String)s.get("key"),s->s.get("value")));
           /*for(Object m:(List<?>)t){
               if(((Map<String,?>)m).get("testId").equals(testId)){
                   Map<String, Object> m1 = (Map<String, Object>) m;
                   map.putAll(m1);
               }
           }*/
       }
        return map;
    }

    public static ObjectNode createJsonObj(List<String> testName) throws JsonProcessingException {
        ObjectMapper mapper=new ObjectMapper();
        ObjectNode root = mapper.createObjectNode();
        for(String str:testName) {
            ObjectNode mappingRoot = mapper.createObjectNode();
            mappingRoot.put("AmountFinanced", Math.random()*100);
            mappingRoot.put("FinanceCharge", Math.random()*10);
            mappingRoot.put("MonthlyPayment", Math.random()*5);
            mappingRoot.put("OutOfPocketCash", Math.random()*4);
            mappingRoot.put("TotalTax", Math.random());
            root.put(str, mappingRoot);
        }
        return root;
    }

    public static <T> T readJsonFile(String filePath){
        File jsonFile=new File(filePath);
        ObjectMapper mapper=new ObjectMapper();
        T jsonObj;
        try {
            jsonObj=mapper.readValue(jsonFile, new TypeReference<>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return jsonObj;
    }

    public static List<Map<String,?>> convertJsonFileToCollection(String filePath){
        File jsonFile=new File(filePath);
        ObjectMapper mapper=new ObjectMapper();
        List<Map<String,?>> jsonObj;
        try {
            jsonObj=mapper.readValue(jsonFile, new TypeReference<>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return jsonObj;
    }

}
