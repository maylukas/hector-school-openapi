package org.hectorschool.accountservice.resources;


import java.net.URI;
import org.hectorschool.accountservice.account.Account;
import org.hectorschool.accountservice.account.AccountRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountEndpoint {

  private final AccountRepository accountRepository;

  public AccountEndpoint(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  @GetMapping("/accounts/current")
  public ResponseEntity<Account> getCurrentAccount() {
    String currentUser = getCurrentUser();

    Account account = accountRepository.get(currentUser);
    return ResponseEntity.ok(account);
  }

  @PostMapping("/accounts")
  public ResponseEntity<Account> addAccount(@RequestBody Account account) {
    Account added = accountRepository.add(account);
    return ResponseEntity.created(URI.create("/accounts/" + added.getId()))
        .body(account);
  }

  private String getCurrentUser() {
    return "Lukas";
  }
}
