package ru.job4j.bank;

import java.util.*;

public class BankService {
    /**
     * Хранение информации о пользователе и его банковских счетах
     * осуществляется в коллекции типа Map
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
     * @param passport пользователя находим по паспорту и
     *                 спользуя метод findByPassport
     * @param account параметр содержит аккаунт пользователя, который необходимо
     *                добавить, если его ещё не существует
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> accounts = users.get(user.get());
            if (!accounts.contains(account)) {
                users.get(user.get()).add(account);
            }
        }
    }

    /**
     * Осуществляет поиск пользователя по паспорту
     * @param passport пасспорт, по которому ищем пользователя
     * @return возвращает пользователя, если он существует, если нет, то null
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(u -> u.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод ищет счёт пользователя по реквизитам
     * @param passport сначала ищем пользователя по пасспорту
     * @param requisite номер счёта, который ищем
     * @return возвращет аккаунт пользователя по трубуемым реквизитам, если нет, то null
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
        return users.get(user.get())
                .stream()
                .filter(u -> u.getRequisite().equals(requisite))
                .findFirst();
        }
        return Optional.empty();
    }

    /**
     * Метод для перечисления денег с одного счёта на другой счёт
     * @param srcPassport пасспорт пользователя
     *                    с которого осуществляется перевод средств
     * @param srcRequisite номер банковского счёта пользователя
     *                     с которого осуществляется перевод средств
     * @param destPassport пасспорт пользователя
     *                     на который осуществляется перевод средств
     * @param destRequisite номер банковского счёта пользователя
     *                      на который осуществляется перевод средств
     * @param amount сумма, которую необходимо перевести
     * @return возвращает true. Если счёт не найден или не хватает денег
     * на счёте srcAccount, то возвращает false
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Optional<Account> accountOne = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> accountsTwo = findByRequisite(destPassport, destRequisite);
        if ((accountOne.isPresent()) && (accountsTwo.isPresent())
                && (accountOne.get().getBalance() >= amount)) {
        accountsTwo.get().setBalance(accountsTwo.get().getBalance() + amount);
        accountOne.get().setBalance(accountOne.get().getBalance() - amount);
        return true;
        }
        return false;
    }
}