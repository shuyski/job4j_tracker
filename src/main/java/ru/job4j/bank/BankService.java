package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс реализует работу банковского сервиса
 * @author Ruslan Shuyski
 * @version 1.0
 */

public class BankService {
    /**
     * Хранение информации о пользователе и его банковских счетах осуществляется в коллекции типа Map
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя в систему
     * @param user ФИО и пасспорт
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод добавляет новый счет к пользователю
     * @param passport пользователя находим по паспорту используя метод findByPassport
     * @param account параметр содержит аккаунт пользователя, который необходимо добавить, если его ещё не существует
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (findByPassport(passport) != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                users.get(user).add(account);
            }
        }
    }

    /**
     * Осуществляет поиск пользователя по паспорту
     * @param passport пасспорт, по которому ищем пользователя
     * @return возвращает пользователя, если он существует, если нет, то null
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод ищет счёт пользователя по реквизитам
     * @param passport сначала ищем пользователя по пасспорту
     * @param requisite номер счёта, который ищем
     * @return возвращет аккаунт пользователя по трубуемым реквизитам, если нет, то null
     */
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

    /**
     * Метод для перечисления денег с одного счёта на другой счёт
     * @param srcPassport пасспорт пользователя с которого осуществляется перевод средств
     * @param srcRequisite номер банковского счёта пользователя с которого осуществляется перевод средств
     * @param destPassport пасспорт пользователя на который осуществляется перевод средств
     * @param destRequisite номер банковского счёта пользователя на который осуществляется перевод средств
     * @param amount сумма, которую необходимо перевести
     * @return возвращает true. Если счёт не найден или не хватает денег на счёте srcAccount, то возвращает false
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account accountOne = findByRequisite(srcPassport, srcRequisite);
        Account accountsTwo = findByRequisite(destPassport, destRequisite);
        if ((accountOne != null) && (accountsTwo != null)
                && (accountOne.getBalance() >= amount)) {
        accountsTwo.setBalance(accountsTwo.getBalance() + amount);
        accountOne.setBalance(accountOne.getBalance() - amount);
        return true;
        }
        return false;
    }
}