package BuilderDesignPattern.personEg;

public class Person {
    private String name;
    private int age;
    private int phoneNumber;
    private String address;

    public Person(String name, int age, int phoneNumber, String address) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phoneNumber=" + phoneNumber +
                ", address='" + address + '\'' +
                '}';
    }
}
