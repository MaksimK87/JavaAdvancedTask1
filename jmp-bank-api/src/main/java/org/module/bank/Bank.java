package org.module.bank;

import org.module.dto.BankCard;
import org.module.dto.BankCardType;
import org.module.dto.User;

public interface Bank {

    BankCard createBankCard(User user, BankCardType bankCardType);
}
