package java8.stream;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class StreamExample4 {
    public static void main(String[] args) {
        List<Product> products =
                Arrays.asList(
                        new Product(1L, "A", new BigDecimal("100.50")),
                        new Product(2L, "B", new BigDecimal("23.00")),
                        new Product(3L, "C", new BigDecimal("31.45")),
                        new Product(4L, "D", new BigDecimal("80.20")),
                        new Product(5L, "E", new BigDecimal("7.50"))
                );

        System.out.println("Products.price >= 30 : " +
                products.stream()
                        .filter(product -> product.getPrice().compareTo(new BigDecimal("30.00"))>=0)
                        .collect(toList())
        );
        System.out.println("\n===================================");
        System.out.println("Products.price >= 30 (with joining) : \n" +
                products.stream()
                        .filter(product -> product.getPrice().compareTo(new BigDecimal("30.00"))>=0)
                        .map(product -> product.toString())
                        .collect(joining("\n"))
        );

        System.out.println("\n===================================");
        System.out.println("Total Price : \n" +
                products.stream()
                        .map(product -> product.getPrice())
                        .reduce(BigDecimal.ZERO, (price1, price2) -> price1.add(price2))
        );

        System.out.println("\n===================================");
        System.out.println("Total Price(filter) : \n" +
                products.stream()
                        .filter(product -> product.getPrice().compareTo(new BigDecimal("30.00"))>=0)
                        .map(product -> product.getPrice())
                        .reduce(BigDecimal.ZERO, (price1, price2) -> price1.add(price2))
        );

        System.out.println("\n===================================");
        System.out.println("# of Total Price >= 30 : \n" +
                products.stream()
                        .filter(product -> product.getPrice().compareTo(new BigDecimal("30.00"))>=0)
                        .count()
        );
        System.out.println("\n===================================");
        OrderItem item1 = new OrderItem(1L, products.get(0),1);
        OrderItem item2 = new OrderItem(2L, products.get(2),3);
        OrderItem item3 = new OrderItem(3L, products.get(4),10);

        Order order = new Order(1L, Arrays.asList(item1,item2,item3));
        System.out.println(order.getTotalPrice());
    }
}

class Product{
    private Long id;
    private String name;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public Product(Long id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    private BigDecimal price;
}

class OrderItem {
    private Long id;
    private Product product;
    private int quantity;

    public BigDecimal getTotalPrice() {
        return product.getPrice().multiply(new BigDecimal(quantity));
    }
    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", product=" + product +
                ", quantity=" + quantity +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public OrderItem(Long id, Product product, int quantity) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
    }
}

class Order{
    private Long id;
    private List<OrderItem> items;

    public BigDecimal getTotalPrice() {
        return items.stream()
                .map(item -> item.getTotalPrice())
                .reduce(BigDecimal.ZERO, (price1, price2)-> price1.add(price2));
    }
    @Override
    public String toString() {
        return "Order{" +
                "items=" + items +
                ", id=" + id +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public Order(Long id, List<OrderItem> items) {
        this.id = id;
        this.items = items;
    }


}


