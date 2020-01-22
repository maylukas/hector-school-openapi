package org.hectorschool.accountservice.infrastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.hectorschool.accountservice.account.Account;
import org.hectorschool.accountservice.account.AccountRepository;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryAccountRepository implements AccountRepository {

  private List<Account> accounts = new ArrayList<>();

  @Override
  public Account get(String username) {
    for (Account account : accounts) {
      if (account.getName().equalsIgnoreCase(username)) {
        return account;
      }
    }
    return null;
  }

  @Override
  public Account add(Account account) {
    if (account.getId() == null) {
      account.setId(UUID.randomUUID());
    }
    accounts.add(account);
    return account;
  }
}
