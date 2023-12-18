package BuilderDesignPattern.CarEg;

public class Car {
    private String brand;
    private int hp;
    private int price;

    private Car(Builder builder){
        this.brand = builder.brand;
        this.hp = builder.hp;
        this.price = builder.price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", hp=" + hp +
                ", price=" + price +
                '}';
    }

    public static class Builder{
        private String brand;
        private int hp;
        private int price;

        public Builder brand(String brand){
            this.brand = brand;
            return this;
        }

        public Builder hp(int hp){
            this.hp = hp;
            return this;
        }

        public Builder price(int price){
            this.price = price;
            return this;
        }

        public Car build(){
            return new Car(this);
        }

    }

    public static void main(String[] args) {
        Car car=new Car.Builder()
                .brand("BMW")
                .hp(450)
                .price(1000000)
                .build();
        System.out.println(car);
    }
}
