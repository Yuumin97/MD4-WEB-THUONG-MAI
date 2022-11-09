package threephone.group.repository;

import threephone.group.model.User;
import threephone.group.model.product.Product;

public interface CartRepository {
    Boolean exitsByProduct(Product product);
    Boolean exitsByUser(User user);
}
