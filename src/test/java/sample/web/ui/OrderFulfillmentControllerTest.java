package sample.web.ui;

import org.junit.Test;
import sample.web.ui.controller.OrderFulfillmentController;
import sample.web.ui.facade.OrderServiceFacadeImpl;

import static org.junit.Assert.assertTrue;

public class OrderFulfillmentControllerTest {
    @Test
    public void testOrderProduct() {
        OrderFulfillmentController controller = new OrderFulfillmentController();
        controller.facade = new OrderServiceFacadeImpl();
        controller.orderProduct(9);
        boolean result = controller.orderFulfilled;
        assertTrue(result);
    }
}