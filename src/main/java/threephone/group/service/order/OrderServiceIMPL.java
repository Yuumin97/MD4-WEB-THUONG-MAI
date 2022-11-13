package threephone.group.service.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import threephone.group.model.User;
import threephone.group.model.cart.Order;
import threephone.group.repository.OrderRepository;
import threephone.group.security.userprincipal.UserDetailService;

import java.util.List;
import java.util.Optional;
@Service
public class OrderServiceIMPL implements IOderService{
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserDetailService userDetailService;
    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public void save(Order order) {
        User user = userDetailService.getCurrentUser();
        order.setUser(user);
        orderRepository.save(order);
    }

    @Override
    public void deleteById(Long id) {
orderRepository.deleteById(id);
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public List<Order> findByUser(User user) {
        return orderRepository.findByUser(user);
    }
}
