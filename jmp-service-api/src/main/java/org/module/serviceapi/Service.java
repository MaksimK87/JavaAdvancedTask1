package org.module.serviceapi;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.function.Predicate;

import org.module.dto.BankCard;
import org.module.dto.Subscription;
import org.module.dto.User;

public interface Service {

    void subscribe(BankCard bankCard);

    Subscription getSubscriptionByBankCardNumber(String cardNumber) throws NoSubscribersException;

    List<User> getAllUsers();

    List<Subscription> getAllSubscriptionsByCondition(Predicate<Subscription> predicate);

    default double getAverageUsersAge() {

        return getAllUsers().stream().mapToLong(user -> ChronoUnit.YEARS.between(LocalDate.now(), user.getBirthday()))
                .average().orElse(0);
    }

    static boolean isPayableUser(User user) {

        var currentDate = LocalDate.now();
        var userAge = ChronoUnit.YEARS.between(LocalDate.now(), user.getBirthday());
        return userAge > 18;
    }
}
