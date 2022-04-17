package com.teksystems.capstone.database.entity;

import lombok.*;
import javax.persistence.*;
import java.util.Set;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_ID")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "isbn_10")
    private Integer isbn10;

    @Column(name = "isbn_13")
    private Integer isbn13;

    @Column(name = "price")
    private Float price;

    @Column(name = "discount")
    private Float discount;

    @Column(name = "status")
    private String status;

    @Column(name = "quantity")
    private Integer quantity;

//    @Column(name = "tags")
//    private String tags;

    @Column(name = "item_condition")
    private String itemCondition;

//    @ManyToOne

    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<OrderDetails> orderDetails;

}
