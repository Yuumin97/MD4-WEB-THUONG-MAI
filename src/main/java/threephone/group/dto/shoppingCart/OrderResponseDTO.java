package threephone.group.dto.shoppingCart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderResponseDTO {
    private int amount;
    private int invoiceNumber;
    private String date;
    private String OrderDescription;
    private Long orderId;
}
