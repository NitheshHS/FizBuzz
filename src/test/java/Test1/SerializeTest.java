package Test1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class SerializeTest {
    @Test
    public void convertToJson() throws IOException {
        User user=new User();
        user.setName("Nithesh");
        user.setAge("25");
        user.setStatus("200");
        ObjectMapper mapper=new ObjectMapper();
        mapper.writeValue(new File("./src/test/resources/user.json"), user);

        //error message
        User userError = new User(){
            {
                setErrorMessage("Unable to load info");
                setStatus("400");
            }
        };
        mapper.writeValue(new FileWriter("./src/test/resources/userError.json"), userError);

        User userErrorData = mapper.readValue(new File("./src/test/resources/userError.json"), User.class);
        System.out.println(userErrorData);
    }

    @Test
    public void test(){
        boolean flag = checkNullValue(new BigDecimal("123"), 123.0);
        System.out.println(flag);
    }


    public <T> boolean  checkNullValue(BigDecimal actual, T expected ){

        if( actual.compareTo(new BigDecimal(expected.toString()))==0){
            return true;
        }
        return false;
    }
}
