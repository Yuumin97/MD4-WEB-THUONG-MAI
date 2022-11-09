package threephone.group.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import threephone.group.dto.response.ResponseMessage;
import threephone.group.dto.shoppingCart.OrderDTO;
import threephone.group.dto.shoppingCart.OrderResponseDTO;
import threephone.group.model.User;
import threephone.group.model.cart.Order;
import threephone.group.service.product.ProductService;
import threephone.group.service.shoppingCart.OrderServiceIMPL;
import threephone.group.service.user.UserServiceIMPL;
import threephone.group.util.DateUtil;

import java.util.Random;

@RestController
@RequestMapping("/api/shoppingCart")
@CrossOrigin
public class ShoppingCartController {
    @Autowired
    private OrderServiceIMPL orderServiceIMPL;
    @Autowired
    private UserServiceIMPL userServiceIMPL;


    private Logger logger = LoggerFactory.getLogger(ShoppingCartController.class);

    @GetMapping(value = "/order/{orderId}")
    public ResponseEntity<?> getOrderDetail(@PathVariable Long orderId){
        Order order = orderServiceIMPL.getOrderDetail(orderId);
        return ResponseEntity.ok(order);
    }
    @PostMapping("/placeOrder")
    public ResponseEntity<?> placeOrder(@RequestBody OrderDTO orderDTO){
        logger.info("Request Payload" + orderDTO.toString());
        OrderResponseDTO orderResponseDTO = new OrderResponseDTO();
        int amount = orderServiceIMPL.getCartAmount(orderDTO.getCartItems());
        User user = new User(orderDTO.getUsername(),orderDTO.getUserEmail());
        Long userID= userServiceIMPL.isUserPresent(user);
        if (userID!= null){
            user.setId(userID);
            logger.info("User already present in db with id: " + userID);
        }else{
            user = userServiceIMPL.save(user);
            logger.info("User saved.. with name : " + user.getName());
        }
        Order order = new Order(orderDTO.getOrderDescription(),user,orderDTO.getCartItems());
        order = orderServiceIMPL.save(order);
        logger.info("Oder processed successfully..");
        orderResponseDTO.setAmount(amount);
        orderResponseDTO.setDate(DateUtil.getCurrentDateTime());
        orderResponseDTO.setInvoiceNumber(new Random().nextInt(10000));
        orderResponseDTO.setOrderId(order.getId());
        orderResponseDTO.setOrderDescription(orderDTO.getOrderDescription());
        return ResponseEntity.ok(orderResponseDTO);
    }
}
