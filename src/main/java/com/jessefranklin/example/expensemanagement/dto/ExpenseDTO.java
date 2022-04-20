package com.jessefranklin.example.expensemanagement.dto;

import com.jessefranklin.example.expensemanagement.models.Expense;
import com.jessefranklin.example.expensemanagement.models.Tag;
import com.jessefranklin.example.expensemanagement.models.enumerations.TagEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseDTO {

    private Long id;

    private String personName;

    private String description;

    private Date timestamp;

    private BigDecimal value;

    private List<TagEnum> tags;

    public static ExpenseDTO toDTO(Expense expense) {
        return ExpenseDTO.builder()
                .id(expense.getId())
                .personName(expense.getPersonName())
                .description(expense.getDescription())
                .timestamp(expense.getTimestamp())
                .value(expense.getValue())
                .tags(expense.getTags().stream().map(Tag::getTagEnum).collect(Collectors.toList()))
                .build();
    }

    @Override
    public String toString() {
        return "ExpenseDTO{" +
                "id=" + id +
                ", name='" + personName + '\'' +
                ", description='" + description + '\'' +
                ", timestamp=" + timestamp +
                ", value=" + value +
                ", tags=" + tags +
                '}';
    }
}
