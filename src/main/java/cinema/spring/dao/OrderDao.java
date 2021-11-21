package cinema.spring.dao;

import java.util.List;
import cinema.spring.model.Order;
import cinema.spring.model.User;

public interface OrderDao {
    Order add(Order order);

    List<Order> getOrdersHistory(User user);
}
