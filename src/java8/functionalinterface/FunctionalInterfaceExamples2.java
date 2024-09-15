package java8.functionalinterface;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaceExamples2 {
    public static void main(String[] args) {
        Product productA = new Product(1L, "A", new BigDecimal("10.00"));
        Product productB = new Product(2L, "B", new BigDecimal("55.50"));
        Product productC = new Product(3L, "C", new BigDecimal("17.45"));
        Product productD = new Product(4L, "D", new BigDecimal("20.00"));
        Product productE = new Product(5L, "E", new BigDecimal("110.99"));
        List<Product> products = Arrays.asList(
                productA,
                productB,
                productC,
                productD,
                productE
        );
        System.out.println(filter(products, p -> p.getPrice().compareTo(new BigDecimal("10.00")) <= 0));

        List<Product> expensiveProducts = filter(products, product -> product.getPrice().compareTo(new BigDecimal("20")) > 0);
        List<DiscountProduct> discountedProducts =
                map(expensiveProducts, product ->
                        new DiscountProduct(product.getId(), product.getName(), product.getPrice().multiply(new BigDecimal("0.5"))));
        System.out.println(discountedProducts);

        System.out.println(
                filter(discountedProducts, product -> product.getPrice().compareTo(new BigDecimal("30"))<=0)
        );

        List<DiscountProduct> discountedProducts2 =
                map(filter(discountedProducts, product -> product.getPrice().compareTo(new BigDecimal("30"))<=0), product ->
                        new DiscountProduct(product.getId(), product.getName(), product.getPrice().multiply(new BigDecimal("0.5"))));
        System.out.println(discountedProducts2);

        List<BigDecimal> prices = map(products, product -> product.getPrice());
        System.out.println("total : " + total(products, product -> product.getPrice()));

        
    }

    private static <T,R> List<R> map(List<T> list, Function<T,R> function){
        List<R> result = new ArrayList<>();
        for(T t : list){
            result.add(function.apply(t));
        }
        return result;
    }

    private static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for(T t : list) {
            if(predicate.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

    private static <T> BigDecimal total(List<T> list, Function<T, BigDecimal> mapper) {
        BigDecimal total = BigDecimal.ZERO;
        for(T t : list) {
            total = total.add(mapper.apply(t));
        }
        return total;
    }
}


class Product{
    private Long id;
    private String name;
    private BigDecimal price;

    public Product(){}

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

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

class DiscountProduct extends Product{
    public DiscountProduct() {
    }

    public DiscountProduct(Long id, String name, BigDecimal price) {
        super(id, name, price);
    }
}

class OrderedItem{
    public OrderedItem(Long id, Product product, int quantity) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
    }

    private Long id;
    private Product product;
    private int quantity;

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
}

class Order {
    public Order(Long id, String orderNumber, List<OrderedItem> items) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.items = items;
    }


    private Long id;
    private String orderNumber;
    List<OrderedItem> items;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public List<OrderedItem> getItems() {
        return items;
    }

    public void setItems(List<OrderedItem> items) {
        this.items = items;
    }
}