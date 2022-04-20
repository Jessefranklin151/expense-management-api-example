package com.jessefranklin.example.expensemanagement.dto;

import com.jessefranklin.example.expensemanagement.models.enumerations.TagEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateExpenseDTO {

    private String personName;

    private String description;

    private BigDecimal value;

    private List<TagEnum> tags;

}

