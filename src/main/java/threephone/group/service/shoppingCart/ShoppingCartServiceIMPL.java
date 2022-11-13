package threephone.group.service.shoppingCart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import threephone.group.model.cart.Order;
import threephone.group.repository.IProductRepository;
import threephone.group.repository.OrderRepository;

import java.util.Optional;

@Service
public class ShoppingCartServiceIMPL {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private IProductRepository productRepository;

    public ShoppingCartServiceIMPL(OrderRepository orderRepository, IProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }
    public Order getOrderDetail(Long id){
        Optional<Order> order = this.orderRepository.findById(id);
        return order.isPresent() ? order.get() : null;
    }
//    public int getCartAmount(List<ShoppingCart> shoppingCarts) {
//        float totalCartAmount = 0f;
//        float singleCartAmount = 0f;
//        int availableQuantity = 0;
//        for (ShoppingCart cart : shoppingCarts) {
//            Long productId = cart.getProductId();
//            Optional<Product> product = productRepository.findById(productId);
//            if (product.isPresent()) {
//                Product product1 = product.get();
//                if (product1.getAvailableQuantity() < cart.getQuantity()) {
//                    singleCartAmount = product1.getPrice() * product1.getAvailableQuantity();
//                    cart.setQuantity(product1.getAvailableQuantity());
//                } else {
//                    singleCartAmount = cart.getQuantity() * product1.getPrice();
//                    availableQuantity = product1.getAvailableQuantity() - cart.getQuantity();
//                }
//                totalCartAmount = totalCartAmount + singleCartAmount;
//                product1.setAvailableQuantity(availableQuantity);
//                availableQuantity = 0;
//                cart.setProductName(product1.getName());
//                cart.setAmount((int) singleCartAmount);
//                productRepository.save(product1);
//            }
//        }
//        return (int) totalCartAmount;
//    }
    public Order save(Order order){
        return orderRepository.save(order);
    }
}
