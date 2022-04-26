package com.teksystems.capstone.database.entrybeans;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.PositiveOrZero;

@Getter
@Setter
@ToString
public class OrderEntryBean {

    @PositiveOrZero
    private Float subTotal;

    @PositiveOrZero
    private Float total;


    private String paymentType;

    private String cardName;

    private Integer cardNumber;

    private Integer cardExpirationDate;

    private Integer cvsCode;
}
