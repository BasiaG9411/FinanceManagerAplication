package org.example.entity;

import com.mysql.cj.protocol.ColumnDefinition;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (columnDefinition = "DECIMAL 8,2")
    private BigDecimal amount;

    private LocalDate addDate;
    @Column (length = 150)
    private String commentary;
    @JoinColumn(name = "category_id")
    @ManyToOne
    private Category category;
}
