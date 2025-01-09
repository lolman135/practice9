package se.practices.practice9.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalTime;

/**
 * Represents a customer order in the restaurant.
 */
@Entity
@Table(name = "orders")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_phone")
    private String customerPhone;

    @Column(name = "customer_address")
    private String customerAddress;

    @Column(name = "order_status")
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Column(name = "menu_items")
    private String menuItems;

    @Column(name = "quantities")
    private String quantities;

    @Column(name = "total_price")
    private double totalPrice;

    @Column(name = "created_at")
    private LocalTime createdAt;

    @PrePersist
    @PreUpdate
    public void truncatedCreatedAt(){
        if (createdAt != null){
            createdAt = createdAt.withNano(0);
        }
    }

    /**
     * Constructs a new Order with the specified details.
     *
     * @param customerName    the name of the customer
     * @param customerPhone   the phone number of the customer
     * @param customerAddress the address of the customer
     * @param orderStatus     the status of the order
     * @param menuItems       the menu items included in the order
     * @param totalPrice      the total price of the order
     * @param createdAt       the creation time of the order
     * @param quantities      the quantities of the menu items
     */
    public Order(String customerName, String customerPhone, String customerAddress,
                 OrderStatus orderStatus, String menuItems, double totalPrice,
                 LocalTime createdAt, String quantities) {
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerAddress = customerAddress;
        this.orderStatus = orderStatus;
        this.menuItems = menuItems;
        this.totalPrice = totalPrice;
        this.createdAt = createdAt.withNano(0);;
        this.quantities = quantities;
    }
}
