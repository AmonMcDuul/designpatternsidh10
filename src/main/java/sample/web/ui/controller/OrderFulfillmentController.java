package sample.web.ui.controller;

import sample.web.ui.facade.OrderServiceFacade;

public class OrderFulfillmentController {
    public OrderServiceFacade facade;
    public boolean orderFulfilled = false;

    public void orderProduct(int productId) {
        orderFulfilled = facade.placeOrder(productId);
        System.out.println("OrderFulfillmentController: Order fulfillment completed. ");
    }
}