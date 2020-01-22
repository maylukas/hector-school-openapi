package org.hectorschool.accountservice.account;

public interface AccountRepository {

  Account get(String username);
  Account add(Account account);
}
