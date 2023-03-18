package org.example.entity;

import jakarta.persistence.*;
import lombok.*;
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

    @Column(name = "add_date")
    private LocalDate addDate;

    private String commentary;
    @JoinColumn(name = "category_id")
    @ManyToOne
    private Category category;


}
