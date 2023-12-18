package singletonEx;

import org.testng.annotations.Test;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InstanceTest {
    @Test
    public void instanceTest(){
        ZipResponse instance = CreateInstance.getInstance("1234");
         System.out.println(instance+"=="+instance.zipResponse());
        ZipResponse instance2 = CreateInstance.getInstance("1234");
        System.out.println(instance2+"=="+instance2.zipResponse());

        ZipResponse instance3 = CreateInstance.getInstance("5678");
        System.out.println(instance3+"=="+instance3.zipResponse());
        ZipResponse instance4 = CreateInstance.getInstance("5678");
        System.out.println(instance4+"=="+instance4.zipResponse());

        ZipResponse instance5 = CreateInstance.getInstance("57321");
        System.out.println(instance5+"=="+instance5.zipResponse());
        ZipResponse instance6=CreateInstance.getInstance("57321");
        System.out.println(instance6+"=="+instance6.zipResponse());

        /*String str="  Hello World!   ";
        str.lines().filter(val->val.equalsIgnoreCase("Hello World!")).forEach(System.out::println);
        String repeatedString = str.repeat(10);
        System.out.println(repeatedString);
        System.out.println(str);
        System.out.println(str.stripTrailing());
*/
        /*Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());

        IntStream.range(0,100)
                .filter(e->e%2==0)
                .peek(e-> System.out.println("Filtered value: " + e))
                .map(val->val*10)
                .peek(e-> System.out.println("Mapped value: "+e))
                .mapToObj(StringBuffer::new)
                .collect(Collectors.toList())
                ;*/

        /*IntStream.range(0,100)
                .takeWhile(value -> value<=20)
                .peek(e-> System.out.println("Filtered value: " +e))
                .mapToObj(StringBuffer::new)
                .collect(Collectors.toList());*/
    }
}
