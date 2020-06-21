package sample.web.ui.facade;

import sample.web.ui.domain.Product;
import sample.web.ui.service.InventoryService;
import sample.web.ui.service.PaymentService;
import sample.web.ui.service.ShippingService;

public class OrderServiceFacadeImpl implements OrderServiceFacade {
    public boolean placeOrder(int pId) {
        boolean orderFulfilled = false;
        Product product = new Product("4MM schroeven", 23);

        if (InventoryService.isAvailable(product)) {
            System.out.println("Product with name: " + product.getProductName() + " is available.");
            boolean paymentConfirmed = PaymentService.makePayment();
            if (paymentConfirmed) {
                System.out.println("Payment confirmed...");
                ShippingService.shipProduct(product);
                System.out.println("Product shipped...");
                orderFulfilled = true;
            }
        }
        return orderFulfilled;
    }
}
