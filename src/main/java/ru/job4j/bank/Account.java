package ru.job4j.bank;

import java.util.Objects;

/**
 * Данный класс содержит модель банковского счёта
 * @author Ruslan Shuyski
 * @version 1.0
 */
public class Account {
    /**
     * Поле реквизит
     */
    private String requisite;
    /**
     * Поле баланс счёта
     */
    private double balance;

    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    public String getRequisite() {
        return requisite;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
