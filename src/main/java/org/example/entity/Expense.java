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
    private Integer expenseId;

    @Column (columnDefinition = "DECIMAL 8,2")
    private BigDecimal expenseAmount;

    private LocalDate expenseAddDate;
    @Column (length = 150)
    private String expenseCommentary;

    @ManyToOne
    private Category category;
}
