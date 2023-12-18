package guice.dependecyInjection;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new DiscountGuiceModule());
        CheckoutService checkout = injector.getInstance(CheckoutService.class);
        checkout.checkout(1200d);
    }
}
