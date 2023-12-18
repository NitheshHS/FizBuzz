package guice.dependecyInjection;

public class NightOwlDiscount implements Discountable{
    @Override
    public double getDiscount() {
        return 0.15;
    }
}
