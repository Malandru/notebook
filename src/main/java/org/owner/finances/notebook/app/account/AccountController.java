package org.owner.finances.notebook.app.account;

import org.owner.finances.notebook.app.account.core.Account;
import org.owner.finances.notebook.app.account.core.AccountRequest;
import org.owner.finances.notebook.domain.request.types.CreateRequest;
import org.owner.finances.notebook.domain.request.types.DeleteRequest;
import org.owner.finances.notebook.domain.request.types.DetailsRequest;
import org.owner.finances.notebook.domain.request.types.UpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController
{
    @Autowired
    private AccountService accountService;

    @PostMapping("/accounts/details")
    public ResponseEntity<Account> accountDetails(@Validated({DetailsRequest.class}) @RequestBody AccountRequest accountRequest)
    {
        return ResponseEntity.ok(accountService.consultAccount(accountRequest));
    }

    @PostMapping("/accounts/create")
    public ResponseEntity<Account> createAccount(@Validated({CreateRequest.class}) @RequestBody AccountRequest accountRequest)
    {
        return ResponseEntity.ok(accountService.createAccount(accountRequest));
    }

    @PutMapping("/accounts/update")
    public ResponseEntity<Account> updateAccount(@Validated({UpdateRequest.class}) @RequestBody AccountRequest accountRequest)
    {
        return ResponseEntity.ok(accountService.updateAccount(accountRequest));
    }

    @DeleteMapping("/accounts/delete")
    public ResponseEntity<Account> deleteAccount(@Validated({DeleteRequest.class}) @RequestBody AccountRequest accountRequest)
    {
        return ResponseEntity.ok(accountService.deleteAccount(accountRequest));
    }
}
