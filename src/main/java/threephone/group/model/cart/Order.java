package threephone.group.model.cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import threephone.group.model.User;

import javax.persistence.*;
import java.util.List;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "myOrder")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderDescription;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL, targetEntity = ShoppingCart.class)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private List<ShoppingCart> cartItems;

    public Order(String orderDescription, User user, List<ShoppingCart> cartItems) {
        this.orderDescription = orderDescription;
        this.user = user;
        this.cartItems = cartItems;
    }
}
