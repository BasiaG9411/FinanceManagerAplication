package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
@Entity
@Getter
@Setter
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    @Column (columnDefinition = "DECIMAL 8,2")
    private BigDecimal amount;
    @NonNull
    private LocalDate addDate;
    @Column(length = 150)
    private String commentary;


}
