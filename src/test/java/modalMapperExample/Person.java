package modalMapperExample;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Person {
    private Address address;
}
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
class Address{
    private String street;
    private String city;
}
