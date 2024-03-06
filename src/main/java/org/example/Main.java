package org.example;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import repository.dao.impl.UserDAOImpl;
import repository.entity.OrderEntity;
import repository.entity.ProductEntity;
import repository.entity.UserEntity;
import service.base.BaseService;
import service.impl.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(OrderEntity.class)
                .addAnnotatedClass(ProductEntity.class)
                .addAnnotatedClass(UserEntity.class)
                .buildSessionFactory();

//
//        System.out.println("What action do you want to take:");
//        System.out.println("1. ");
//        System.out.println("2. ");
//        System.out.println("3. ");

    UserDAOImpl user1 = new UserDAOImpl(sessionFactory);
    System.out.println("Enter user name");
        String userName = scanner.nextLine();

        System.out.println("Enter user lastname");
        String userLastName = scanner.nextLine();

        System.out.println("Enter user address");
        String userAddress = scanner.nextLine();
    user1.save(new UserEntity(" " + userName," " + userLastName," " + userAddress));



    }
}