package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (findByPassport(passport) != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                users.get(user).add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            for (Account account : users.get(user)) {
                if (account.getRequisite().contains(requisite)) {
                return account;
                }
            }
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account accountOne = findByRequisite(srcPassport, srcRequisite);
        Account accountsTwo = findByRequisite(destPassport, destRequisite);
        if ((accountOne != null) && (accountsTwo != null)
                && (accountOne.getBalance() >= amount))
        {
        accountsTwo.setBalance(accountsTwo.getBalance() + amount);
        accountOne.setBalance(accountOne.getBalance() - amount);
        return true;
        }
        return false;
    }
}