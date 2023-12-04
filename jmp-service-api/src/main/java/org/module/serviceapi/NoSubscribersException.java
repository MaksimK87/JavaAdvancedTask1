package org.module.serviceapi;

public class NoSubscribersException extends Exception {

    public NoSubscribersException(String cardNumber) {

        super("There are no subscribers for such card number:" + cardNumber);
    }
}
