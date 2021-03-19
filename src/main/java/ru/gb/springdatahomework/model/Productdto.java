package ru.gb.springdatahomework.model;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Productdto {
    private Long id;
    private String name;
    private int cost;

    public Productdto(Product p) {
        this.id = p.getId();
        this.name = p.getName();
        this.cost = p.getCost();
    }
}
