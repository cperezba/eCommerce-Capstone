package com.teksystems.capstone.database.entrybeans;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
public class ProductEntryBean {

    private Integer id;

    @NotBlank(message = "Title is required")
    private String title;

    private String author;

    private String description;

    private String image;

    private String publisher;

    private Integer isbn10;

    private Integer isbn13;

    private Float price;

    private Float discount;

    private String status;

    private Integer quantity;

//    private String tags;

    private String itemCondition;
}
