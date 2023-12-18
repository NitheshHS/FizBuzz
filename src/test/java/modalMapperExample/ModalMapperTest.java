package modalMapperExample;

import lombok.Builder;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;

public class ModalMapperTest {
    public static void main(String[] args) {
        Person person= Person.builder()
                .address(Address.builder().city("Alur").street("KEB").build())
                .build();
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.addMappings(new PropertyMap<Person, PersonDTO>() {
            @Override
            protected void configure() {
                map().setCity(source.getAddress().getCity());
                map().setStreet(source.getAddress().getStreet());
            }
        });

        PersonDTO personDto = modelMapper.map(person, PersonDTO.class);
        System.out.println(personDto.getCity());
        System.out.println(personDto.getStreet());


    }
}
