package com.example.bankapi.controller;

import com.example.bankapi.model.Account;
import com.example.bankapi.model.Transaction;
import com.example.bankapi.repository.AccountRepository;
import com.example.bankapi.repository.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(AccountController.class)
public class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountRepository accountRepository;

    @MockBean
    private TransactionRepository transactionRepository;

    @BeforeEach
    void setup() {
        // Mock data setup if necessary
    }

    @Test
    public void testGetBalance() throws Exception {
        when(accountRepository.findByAccountId("12345")).thenReturn(new Account("12345", 1000.0));

        mockMvc.perform(get("/accounts/12345/balance"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(1000.0));
    }

    @Test
    public void testTransfer() throws Exception {
        when(accountRepository.findByAccountId("12345")).thenReturn(new Account("12345", 1000.0));
        when(accountRepository.findByAccountId("67890")).thenReturn(new Account("67890", 500.0));

        mockMvc.perform(post("/accounts/12345/transfer")
                        .param("targetAccountId", "67890")
                        .param("amount", "100.0")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("Transfer successful"));
    }
}
