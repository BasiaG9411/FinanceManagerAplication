package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    @Column (columnDefinition = "DECIMAL 8,2")
    private BigDecimal amount;
    @NonNull
    @Column(name = "add_date")
    private LocalDate addDate;
    @Column(length = 150)
    private String commentary;


}
