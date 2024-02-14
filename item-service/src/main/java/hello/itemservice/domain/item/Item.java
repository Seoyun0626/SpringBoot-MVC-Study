package hello.itemservice.domain.item;

import lombok.Data;

//getter, setter
@Data
public class Item {

    private Long id;
    private String itemName;
    // Integer 사용 -> NULL 가능
    private Integer price;
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
