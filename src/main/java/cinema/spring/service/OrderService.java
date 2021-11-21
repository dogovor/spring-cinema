package cinema.spring.service;

import java.util.List;
import cinema.spring.model.Order;
import cinema.spring.model.ShoppingCart;
import cinema.spring.model.User;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> getOrdersHistory(User user);
}
