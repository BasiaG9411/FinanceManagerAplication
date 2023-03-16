package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Entity
@Getter
@Setter
public class Income {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int incomeId;
    private int incomeAmount;
    private LocalDate incomeAddDate;
    private String incomeCommentary;


}
