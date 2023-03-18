package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    private List<Expenses> expenses;

    public List<Expenses> getExpenses() {
        return expenses == null ? new ArrayList<>() : expenses;
    }

    public Category(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
