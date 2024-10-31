package com.example.springdataexample1.controllers;

import com.example.springdataexample1.dto.TransferRequest;
import com.example.springdataexample1.models.Account;
import com.example.springdataexample1.services.TransferService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
public class AccountController {

    private final TransferService transferService;

    @PostMapping("/transfer")
    public void transferMoney(
            @RequestBody TransferRequest transferRequest
        ) {
        transferService.transferMoney(
                transferRequest.getSenderAccountId(),
                transferRequest.getReceiverAccountId(),
                transferRequest.getAmount());
    }

    @GetMapping("/accounts")
    public Iterable<Account> getAccounts(
            @RequestParam(required = false) String name
        ) {
        if (name == null) {
            return transferService.getAllAccounts();
        } else {
            return transferService.findAccountsByName(name);
        }
    }

}