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
        int index = -1;
        User user = findByPassport(passport);
        if (findByPassport(passport) != null) {
            List<Account> accounts = users.get(user);
            index = accounts.indexOf(account);
            if (index == -1) {
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
        List<Account> account = users.get(user);
        int index = account.indexOf(new Account(requisite, -1));
                return account.get(index);
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        User userOne = findByPassport(srcPassport);
        User userTwo = findByPassport(destPassport);
        Account accountOne = findByRequisite(userOne.getPassport(), srcRequisite);
        Account accountsTwo = findByRequisite(userTwo.getPassport(), destRequisite);
        if (!(userOne.equals(null))
                && !(userTwo.equals(null))
                && !(accountOne.equals(null))
                && !(accountsTwo.equals(null))
                && (accountOne.getBalance() >= amount))
        {
        accountsTwo.setBalance(accountsTwo.getBalance() + amount);
        accountOne.setBalance(accountOne.getBalance() - amount);
        return true;
        }
        return false;
    }
}