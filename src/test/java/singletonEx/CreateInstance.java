package singletonEx;

import org.apache.commons.lang3.StringUtils;

public class CreateInstance {

    private static ThreadLocal<ZipResponse> response=new ThreadLocal<>();
    private static ZipResponse zipResponse;
    private static String zipCode;

    private CreateInstance(){}

    public static ZipResponse getInstance(String zipcode){
        if(zipCode==null){
            zipCode = zipcode;
            zipResponse=zipResponse==null?new ZipResponse(zipcode):zipResponse;
            response.set(zipResponse);
           return response.get();
        }
        else if(!zipcode.equalsIgnoreCase(zipCode)){
            zipCode=zipcode;
            zipResponse= new ZipResponse(zipcode);
            response.set(zipResponse);
            return response.get();
        }
        return response.get();
    }
}
