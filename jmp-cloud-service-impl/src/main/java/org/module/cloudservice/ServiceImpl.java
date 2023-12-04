package org.module.cloudservice;


import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.module.dto.BankCard;
import org.module.dto.Subscription;
import org.module.dto.User;
import org.module.serviceapi.NoSubscribersException;
import org.module.serviceapi.Service;

public class ServiceImpl implements Service {

    private final BankDb bankDb;

    public ServiceImpl() {

        this.bankDb = new BankDb().getBankDb();
    }

    @Override
    public void subscribe(BankCard bankCard) {

        var subscription = new Subscription(bankCard, LocalDate.now());
        this.bankDb.subscribe(bankCard.getNumber(), subscription);
    }

    @Override
    public Subscription getSubscriptionByBankCardNumber(String cardNumber) throws NoSubscribersException {

        return this.bankDb.getSubscriptionByBankCardNumber(cardNumber)
                .orElseThrow(() -> new NoSubscribersException(cardNumber));
    }

    @Override
    public List<User> getAllUsers() {

        return this.bankDb.getAllUsers();
    }

    @Override
    public List<Subscription> getAllSubscriptionsByCondition(Predicate<Subscription> predicate) {

        return getAllSubscriptions().stream().filter(predicate).collect(Collectors.toList());
    }

    private List<Subscription> getAllSubscriptions() {

        return this.bankDb.getAllSubscriptions();
    }
}
