package org.sopt.carrot.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private int price;

    private String note;

    private String address;

    public static Product create(String title, int price, String note, String address){
        return Product.builder()
                .title(title)
                .price(price)
                .note(note)
                .address(address)
                .build();
    }

    @Builder
    public Product(String title, int price, String note, String address){
        this.title = title;
        this.price = price;
        this.note = note;
        this.address = address;
    }

}
