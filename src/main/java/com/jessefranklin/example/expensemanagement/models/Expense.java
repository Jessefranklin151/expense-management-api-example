package com.jessefranklin.example.expensemanagement.models;

import com.jessefranklin.example.expensemanagement.dto.CreateExpenseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String personName;

    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    private BigDecimal value;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_expense", nullable = false)
    private List<Tag> tags;

    public static Expense toEntity(CreateExpenseDTO createExpenseDTO) {
        return Expense.builder()
                .value(createExpenseDTO.getValue())
                .description(createExpenseDTO.getDescription())
                .tags(createExpenseDTO.getTags()
                        .stream()
                        .map(Tag::toEntity)
                        .collect(Collectors.toList()))
                .timestamp(new Date())
                .personName(createExpenseDTO.getPersonName())
                .build();
    }

}
