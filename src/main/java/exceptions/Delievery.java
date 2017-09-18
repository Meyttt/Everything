package exceptions;

import java.util.Date;

/**
 * Created by Meyttt on 16.09.2017.
 */
public class Delievery {
    Date orderDate;
    Date deliveryDate;
    String customer;
    String deliveryAddress;

    public Delievery(Date orderDate, Date deliveryDate, String customer, String deliveryAddress) {
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.customer = customer;
        this.deliveryAddress = deliveryAddress;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public String getCustomer() {
        return customer;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public static void main(String[] args) throws DeliveryException {
        throw new DeliveryException(null);
    }
}
