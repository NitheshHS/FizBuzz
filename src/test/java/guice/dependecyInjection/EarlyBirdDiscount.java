package guice.dependecyInjection;

public class EarlyBirdDiscount implements Discountable{
    @Override
    public double getDiscount() {
        return 0.12;
    }
}
