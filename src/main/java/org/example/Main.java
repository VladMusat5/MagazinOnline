package org.example;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import repository.dao.ProductDAO;
import repository.dao.impl.OrderDAOImpl;
import repository.dao.impl.ProductDAOImpl;
import repository.dao.impl.UserDAOImpl;
import repository.entity.OrderEntity;
import repository.entity.ProductEntity;
import repository.entity.UserEntity;


import java.util.List;
import java.util.Objects;
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

        UserDAOImpl userDataAccessObject = new UserDAOImpl(sessionFactory);
        ProductDAOImpl productDataAccessObject = new ProductDAOImpl(sessionFactory);
        OrderDAOImpl orderDataAccessObject = new OrderDAOImpl(sessionFactory);


        System.out.println("Enter user name");
        String userName = scanner.nextLine();
       System.out.println("Enter user lastname");
       String userLastName = scanner.nextLine();
       System.out.println("Enter user address");
       String userAddress = scanner.nextLine();
//        UserEntity user1 = new UserEntity(userName, userLastName, userAddress);
//        userDataAccessObject.save(user1);
//
//
       System.out.println("Enter product name");
       String product = scanner.nextLine();
       ProductEntity product1 = new ProductEntity(product);
//
//        OrderEntity orderEntity = new OrderEntity(1);
//        orderEntity.setUser(user1);
//        orderDataAccessObject.save(orderEntity);
//        product1.setOrder(orderEntity);
//        productDataAccessObject.save(product1);

        // se creaza user/product/order entity de la tastatura
        UserEntity userFromKeyboard = new UserEntity(userName,userLastName,userAddress);
        ProductEntity productFromKeyboard = new ProductEntity(product);
        OrderEntity orderFromKeyboard = new OrderEntity(1);

        userDataAccessObject.save(userFromKeyboard);
        addUserFromKeyboardToOrderFromKeyboard(userFromKeyboard, orderFromKeyboard);
        orderDataAccessObject.save(orderFromKeyboard);
        addOrderFromKeyboardToProductFromKeyboard(orderFromKeyboard, productFromKeyboard);
        productDataAccessObject.save(productFromKeyboard);

    }

    private static void addOrderFromKeyboardToProductFromKeyboard(OrderEntity orderFromKeyboard, ProductEntity productFromKeyboard) {
        productFromKeyboard.setOrder(orderFromKeyboard);
    }

    private static void addUserFromKeyboardToOrderFromKeyboard(UserEntity userFromKeyboard, OrderEntity orderFromKeyboard) {
        orderFromKeyboard.setUser(userFromKeyboard);
    }

    //salvam in baza de date product1
    //Creem order
    //Pe orderul respectiv adaugam produsul 1 in lista de produse
    // OrderEntity order1 = new OrderEntity();
    // adaugam valori pe celalte fielduri cu scanner de la tastatura
    //order1.getProductEntities().add(product1);
    //salvam in DB order1
}