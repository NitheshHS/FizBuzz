package BuilderDesignPattern.personEg;

public class MainClass {
    public static void main(String[] args) {
        PersonBuilder builder = new ConcretePersonBuilder();
        Person person = builder
                .name("Nithesh")
                .age(25)
                .phoneNumber(1234567890)
                .address("Main Street")
                .build();
        System.out.println(person);
        PersonBuilder builder2 = new ConcretePersonBuilder();
        Person person2 = builder2
                .name("Nithesh Gowda")
                .age(25)
                .build();
        System.out.println(person2);
    }
}
