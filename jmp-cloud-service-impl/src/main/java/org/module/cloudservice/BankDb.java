package org.module.cloudservice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.module.dto.BankCard;
import org.module.dto.CreditBankCard;
import org.module.dto.DebitBankCard;
import org.module.dto.Subscription;
import org.module.dto.User;

public class BankDb {

    private Set<User> users = new HashSet<>();
    private Map<String, Optional<Subscription>> cardSubscribers = new HashMap<>();


    public BankDb getBankDb() {

        var user1 = new User("Alex", "Ivanov", LocalDate.of(1991, 2, 10));
        var user2 = new User("Nick", "Petrov", LocalDate.of(1988, 3, 19));
        var user3 = new User("Max", "Sidorov", LocalDate.of(1993, 12, 31));
        var bankCard1 = new DebitBankCard("1233765322219999", user1);
        var bankCard2 = new CreditBankCard("3333111144448888", user2);
        var bankCard3 = new BankCard("9999444467773333", user3);
        var subscription1 = new Subscription(bankCard1, LocalDate.of(2022, 11, 19));
        var subscription2 = new Subscription(bankCard2, LocalDate.of(2023, 1, 1));
        var subscription3 = new Subscription(bankCard3, LocalDate.of(2023, 7, 8));
        users.add(user1);
        users.add(user2);
        users.add(user3);
        cardSubscribers.put(subscription1.getBankcard().getNumber(), Optional.of(subscription1));
        cardSubscribers.put(subscription2.getBankcard().getNumber(), Optional.of(subscription2));
        cardSubscribers.put(subscription3.getBankcard().getNumber(), Optional.of(subscription3));
        return this;
    }

    public void subscribe(String cardNumber, Subscription subscription) {

        users.add(subscription.getBankcard().getUser());
        cardSubscribers.put(cardNumber, Optional.of(subscription));
    }

    public Optional<Subscription> getSubscriptionByBankCardNumber(String cardNumber) {

        return cardSubscribers.get(cardNumber);
    }

    public List<User> getAllUsers() {

        return new ArrayList<>(users);
    }

    public List<Subscription> getAllSubscriptions() {

        return cardSubscribers.values().stream()
                .map(subscription -> subscription.orElse(null))
                .filter(Objects::nonNull).collect(Collectors.toList());
    }
}
