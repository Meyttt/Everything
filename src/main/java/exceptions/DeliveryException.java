package exceptions;

/**
 * Created by Meyttt on 16.09.2017.
 */
public class DeliveryException extends Exception {
    Delievery delievery;
    String deliveryCustomer;

    public DeliveryException(Delievery delievery) {
        this.delievery = delievery;
        this.deliveryCustomer=delievery.customer;

    }

    @Override
    public String getMessage() {
        return "Sorry, we have problems with "+delievery;
    }

}
