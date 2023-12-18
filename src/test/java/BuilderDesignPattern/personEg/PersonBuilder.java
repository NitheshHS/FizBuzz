package BuilderDesignPattern.personEg;

public interface PersonBuilder {

    PersonBuilder name(String name);
    PersonBuilder age(int age);
    PersonBuilder phoneNumber(int phoneNumber);
    PersonBuilder address(String address);

    Person build();
}
