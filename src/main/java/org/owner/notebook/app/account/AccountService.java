package org.owner.notebook.app.account;

import org.owner.notebook.app.account.core.Account;
import org.owner.notebook.app.account.core.AccountRepository;
import org.owner.notebook.app.account.core.AccountRequest;
import org.owner.notebook.app.user.core.User;
import org.owner.notebook.app.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService
{
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private UserService userService;

    public Account findAccountOrThrowError(Integer accountID, String username)
    {
        Account account = accountRepository.findByAccountIDAndUserUsername(accountID, username);
        if (account == null)
            throw new RuntimeException("");
        return account;
    }

    public Account consultAccount(AccountRequest accountRequest)
    {
        return findAccountOrThrowError(accountRequest.getAccountID(), accountRequest.getUsername());
    }

    // Account CRUD Methods

    public Account createAccount(AccountRequest accountRequest)
    {
        User user = userService.findUserOrThrowError(accountRequest.getUsername());

        Account account = new Account();
        account.setUser(user);
        account.setBalance(accountRequest.getBalance());
        account.setAccountAlias(accountRequest.getAccountAlias());
        return accountRepository.save(account);
    }

    public Account updateAccount(AccountRequest accountRequest)
    {
        Account account = findAccountOrThrowError(accountRequest.getAccountID(), accountRequest.getUsername());
        account.setAccountAlias(accountRequest.getAccountAlias());
        account.setBalance(accountRequest.getBalance());
        return accountRepository.save(account);
    }

    public Account deleteAccount(AccountRequest accountRequest)
    {
        Account account = findAccountOrThrowError(accountRequest.getAccountID(), accountRequest.getUsername());
        accountRepository.delete(account);
        return new Account();
    }
}
