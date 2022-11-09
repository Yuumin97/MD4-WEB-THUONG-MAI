package threephone.group.dto.response;

import lombok.Data;
import threephone.group.model.product.Product;

import java.util.List;
@Data
public class CategoryResponse {
    private Long id;
    private String name;
    private List<Product> products;
}
