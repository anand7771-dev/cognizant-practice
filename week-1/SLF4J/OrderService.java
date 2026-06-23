package slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderService {

    Logger log = LoggerFactory.getLogger(OrderService.class);

    void order(String item, int qty) {

        if(qty <= 0) {
            log.warn("Quantity is not valid");
            return;
        }

        log.info("Order Placed : " + item);

        log.info("Quantity : " + qty);

        log.info("Order Completed");
    }

    public static void main(String[] args) {

        OrderService obj = new OrderService();

        obj.order("Laptop", 2);

        obj.order("Phone", 0);
    }
}