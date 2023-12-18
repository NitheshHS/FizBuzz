package BuilderDesignPattern.personEg;

public class ConcretePersonBuilder implements PersonBuilder{
    private String name;
    private int age;
    private int phoneNumber;
    private String address;
    @Override
    public PersonBuilder name(String name) {
        this.name = name;
        return this;
    }

    @Override
    public PersonBuilder age(int age) {
        this.age = age;
        return this;
    }

    @Override
    public PersonBuilder phoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    @Override
    public PersonBuilder address(String address) {
        this.address = address;
        return this;
    }

    @Override
    public Person build() {
        return new Person(name, age, phoneNumber, address);
    }
}
