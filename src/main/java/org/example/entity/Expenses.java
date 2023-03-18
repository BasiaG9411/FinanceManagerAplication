package org.example.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.entity.Category;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Expenses {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private BigDecimal amount;

    private LocalDate date;

    private String commentary;
    @JoinColumn(name = "category_id")
    @ManyToOne
    private Category category;

    @Override
    public String toString() {
        return "Expenses{" +
                "id= " + id +
                ", amount= " + amount +
                ", date= " + date +
                ", commentary= '" + commentary + '\'' +
                ", category_id =" + category.getId() +
                '}';
    }
}
