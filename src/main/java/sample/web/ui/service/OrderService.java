package sample.web.ui.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.web.ui.domain.*;
import sample.web.ui.repository.BaseOrderRepository;
import sample.web.ui.repository.MessageRepository;
import sample.web.ui.repository.OrderOptionRepository;
import sample.web.ui.repository.ProductCatalogRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class OrderService implements IOrderService {
    private BaseOrderRepository baseOrderRepository;
    private ProductCatalogRepository productCatalogRepository;
    private OrderOptionRepository orderOptionRepository;
    private MessageRepository messageRepository;

    @Autowired
    public OrderService(BaseOrderRepository baseOrderRepository, ProductCatalogRepository productCatalogRepository) {
        this.baseOrderRepository = baseOrderRepository;
        this.productCatalogRepository = productCatalogRepository;
        this.orderOptionRepository = orderOptionRepository;
        this.messageRepository = messageRepository;
    }

    @Override
    public Order createOrder() {
        ProductCatalog productCatalog = productCatalogRepository.findById(1L).orElseThrow(() -> new RuntimeException("ProductCatalog with id 1 not found"));

        Product product = productCatalog.decrementStock(2L);

        Product copy = new Product(product);

        Order order = new Order();
        order = (Order) baseOrderRepository.save(order);
        order.add(copy);
        Message message = new Message();
        message.setSummary("New order");
        message.setText("New order is placed: " + order);
        messageRepository.save(message);
        return order;
    }

    private void decorateOrder() {
        Optional<Order> concreteOrder = baseOrderRepository.findById(4L);
        OrderOption decoratedOrder1 = new OrderOption("wrapping paper", 7, concreteOrder.get());
        orderOptionRepository.save(decoratedOrder1);
        OrderOption decoratedOrder2 = new OrderOption("nice box", 5, decoratedOrder1);
        orderOptionRepository.save(decoratedOrder2);
        OrderOption decoratedOrder3 = new OrderOption("fast delivery", 12, decoratedOrder2);
        orderOptionRepository.save(decoratedOrder3);
        System.out.println("***** content of the order: " + decoratedOrder3);
        System.out.println("***** price of the order: " + decoratedOrder3.price());
    }

    @Override
    public List<BaseOrder> findAll() {
        return (List<BaseOrder>) baseOrderRepository.findAll();
    }
}
