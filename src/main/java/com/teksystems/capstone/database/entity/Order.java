package com.teksystems.capstone.database.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<OrderDetails> orderDetails;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "user_id", nullable = true)
    private User user;

    @Column(name = "sub_total")
    private Float subTotal;

    @Column(name = "total")
    private Float total;

    @Column(name = "payment_type")
    private String paymentType;

    @Column(name = "card_name")
    private String cardName;

    @Column(name = "card_number")
    private Integer cardNumber;

    @Column(name = "card_expiration_date")
    private Integer cardExpirationDate;

    @Column(name = "cvs_code")
    private Integer cvsCode;

    @Column(name = "order_status")
    private String orderStatus;

    @Column(name = "date_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated = new Date();

    @Column(name = "date_modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModified = new Date();


//    *** Should an 'orderStatus' be added to determine to which is a product be added.
}
