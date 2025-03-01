package com.practice.kafka_producer_practice.dto;

import java.math.BigDecimal;

//@Entity
//@Builder
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
public class CreateProductRestModel {

    private String title;
    private BigDecimal price;
    private Integer quantity;

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


}
