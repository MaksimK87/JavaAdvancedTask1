package org.module.dto;

import java.time.LocalDate;

public class Subscription {

    private BankCard bankcard;
    private LocalDate startDate;

    public Subscription(BankCard bankcard, LocalDate startDate) {

        this.bankcard = bankcard;
        this.startDate = startDate;
    }

    public BankCard getBankcard() {

        return bankcard;
    }

    public void setBankcard(BankCard bankcard) {

        this.bankcard = bankcard;
    }

    public LocalDate getStartDate() {

        return startDate;
    }

    public void setStartDate(LocalDate startDate) {

        this.startDate = startDate;
    }

    @Override
    public String toString() {

        return "Subscription{" +
                "bankcard=" + bankcard +
                ", startDate=" + startDate +
                '}';
    }
}