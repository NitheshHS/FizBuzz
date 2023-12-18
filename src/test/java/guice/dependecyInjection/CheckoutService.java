package guice.dependecyInjection;


import com.google.inject.Inject;

public class CheckoutService {

    private Discountable discountable;

    @Inject
    public CheckoutService(Discountable discountable) {
        this.discountable = discountable;
    }

    public double checkout(double shoppingCartTotal){
        double afterDiscount = shoppingCartTotal - (shoppingCartTotal*discountable.getDiscount());
        String str = String.format("Total Amount: %.2f \nDiscount: %.2f \nNet Pay: %.2f",shoppingCartTotal, discountable.getDiscount() * 100, afterDiscount);
        System.out.println(str);
        return Math.round(afterDiscount);
    }
}
