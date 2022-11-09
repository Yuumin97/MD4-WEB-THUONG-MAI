package threephone.group.dto.shoppingCart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import threephone.group.model.cart.ShoppingCart;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDTO {
    private String orderDescription;
    private List<ShoppingCart> cartItems;
    private String userEmail;
    private String username;
}
