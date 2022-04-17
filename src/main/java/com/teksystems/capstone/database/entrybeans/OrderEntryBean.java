package com.teksystems.capstone.database.entrybeans;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderEntryBean {

    private Float subTotal;

    private Float total;

    private String paymentType;

    private String cardName;

    private Integer cardNumber;

    private Integer cardExpirationDate;

    private Integer cvsCode;
}
