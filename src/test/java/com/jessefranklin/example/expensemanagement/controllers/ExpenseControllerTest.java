package com.jessefranklin.example.expensemanagement.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jessefranklin.example.expensemanagement.dto.CreateExpenseDTO;
import com.jessefranklin.example.expensemanagement.dto.ExpenseDTO;
import com.jessefranklin.example.expensemanagement.models.enumerations.TagEnum;
import com.jessefranklin.example.expensemanagement.services.ExpenseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ExpenseController.class)
class ExpenseControllerTest {
    @MockBean
    private ExpenseService expenseService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnExpenseByIdTest() throws Exception {
        String description = "Expense description test";
        String name = "Expense name test";
        List<TagEnum> tags = Arrays.asList(TagEnum.DEBIT, TagEnum.PIX);

        ExpenseDTO expenseDTO = ExpenseDTO.builder()
                .id(1L)
                .description(description)
                .personName(name)
                .tags(tags)
                .timestamp(new Date())
                .value(new BigDecimal(2000.00))
                .build();

        when(expenseService.getExpenseById(anyLong())).thenReturn(expenseDTO);

        mockMvc.perform(get("/expense/1"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Expense name test")));
    }

    @Test
    public void shouldReturnCreatedExpenseTest() throws Exception {
        String description = "Expense description test";
        String name = "Expense name test";
        List<TagEnum> tags = Arrays.asList(TagEnum.DEBIT, TagEnum.PIX);
        CreateExpenseDTO createExpenseDTO = CreateExpenseDTO.builder()
                .description(description)
                .personName(name)
                .tags(tags)
                .build();

        ExpenseDTO expenseDTO = ExpenseDTO.builder()
                .id(1L)
                .description(description)
                .personName(name)
                .tags(tags)
                .timestamp(new Date())
                .value(new BigDecimal(2000.00))
                .build();

        when(expenseService.createExpense(createExpenseDTO)).thenReturn(expenseDTO);

        mockMvc.perform(post("/expense")
                        .contentType("application/json")
                        .content(new ObjectMapper().writeValueAsString(createExpenseDTO)))
                .andExpect(status().isCreated())
                .andExpect(content().string(containsString("Expense name test")));
    }

}