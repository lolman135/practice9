package se.practices.practice9.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents an item in the restaurant menu.
 */
@Entity
@Table(name = "menu")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @Column(name = "image_url")
    private String imageUrl;

    /**
     * Constructs a new MenuItem with the specified details.
     *
     * @param name        the name of the menu item
     * @param description the description of the menu item
     * @param imageUrl    the URL of the menu item's image
     * @param price       the price of the menu item
     */
    public MenuItem(String name, String description, String imageUrl, double price) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.price = price;
    }
}
