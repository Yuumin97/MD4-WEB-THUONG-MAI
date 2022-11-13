package threephone.group.service.order;

import threephone.group.model.User;
import threephone.group.model.cart.Order;

import java.util.List;
import java.util.Optional;

public interface IOderService {
    List<Order> findAll();
    void save(Order order);
    void deleteById(Long id);
    Optional<Order> findById(Long id);
    List<Order> findByUser(User user);
}
