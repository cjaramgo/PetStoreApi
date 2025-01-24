package payloads;

import com.github.javafaker.Faker;
import model.Order;
import static utils.Utils.getCurrentDate;

public class OrderPayload {

    public static Faker fake = new Faker();
    public static Order order = new Order();

    public Order postOrder(){

        order.setId(fake.number().numberBetween(10,100));
        order.setPetId(fake.number().numberBetween(1, 10));
        order.setQuantity(fake.number().randomDigit());
        order.setShipDate(getCurrentDate());
        order.setStatus("approved");
        order.setComplete(fake.bool().bool());

        return order;
    }
}
