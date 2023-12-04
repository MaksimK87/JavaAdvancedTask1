package org.module.task;

import org.module.cloudservice.ServiceImpl;
import org.module.serviceapi.Service;

public class Main {

    public static void main(String[] args) {
        Service service = new ServiceImpl();
        System.out.println(service.getAverageUsersAge());
    }
}