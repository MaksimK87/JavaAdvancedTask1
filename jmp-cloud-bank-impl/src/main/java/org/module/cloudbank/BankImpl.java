package org.module.cloudbank;

import org.module.bank.Bank;
import org.module.dto.BankCard;
import org.module.dto.BankCardType;
import org.module.dto.CreditBankCard;
import org.module.dto.DebitBankCard;
import org.module.dto.User;

public class BankImpl implements Bank {

    @Override
    public BankCard createBankCard(User user, BankCardType bankCardType) {

        BankCard bankCard;
        if (BankCardType.CREDIT == bankCardType) {
            bankCard = new CreditBankCard(String.valueOf(System.currentTimeMillis()), user);
        } else {
            bankCard = new DebitBankCard(String.valueOf(System.currentTimeMillis()), user);
        }
        return bankCard;
    }
}
