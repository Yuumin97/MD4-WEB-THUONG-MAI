package threephone.group.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import threephone.group.model.cart.Order;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
