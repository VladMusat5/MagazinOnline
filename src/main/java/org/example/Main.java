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

        boolean continue1 = true;
        boolean continue2 = true;
        String userName = null;
        String userLastName = null;
        String userAddress = null;
        String verificare;
        String verificare2 = null;
        String product = null;

        System.out.println("If you want to register an user type yes");
        verificare = scanner.nextLine();

        if (verificare.equalsIgnoreCase("yes")) {
            while (continue1) {

                System.out.println("Enter user name.");
                userName = scanner.nextLine();
                System.out.println("Enter user lastname.");
                userLastName = scanner.nextLine();
                System.out.println("Enter user address.");
                userAddress = scanner.nextLine();

                String userResponse = scanner.nextLine();
                System.out.println(userResponse.length());
                System.out.println("If you want to stop adding users type no");
                if (userResponse.equalsIgnoreCase("no")) {
                    continue1 = false;
                }

            }
            System.out.println("Stoped adding users");
        }

        System.out.println("If you want to add a product type yes");
        verificare2 = scanner.nextLine();

        if (verificare2.equalsIgnoreCase("yes")) {
            while (continue2) {

                System.out.println("Enter product name");
                product = scanner.nextLine();

                System.out.println("If you want to stop adding products type no");
                String userResponse = scanner.nextLine();

                if (userResponse.equalsIgnoreCase("no")) {
                    continue2 = false;
                }
            }
        }
        System.out.println("Stop");
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(OrderEntity.class)
                .addAnnotatedClass(ProductEntity.class)
                .addAnnotatedClass(UserEntity.class)
                .buildSessionFactory();

        UserDAOImpl userDataAccessObject = new UserDAOImpl(sessionFactory);
        ProductDAOImpl productDataAccessObject = new ProductDAOImpl(sessionFactory);
        OrderDAOImpl orderDataAccessObject = new OrderDAOImpl(sessionFactory);

        ProductEntity product1 = new ProductEntity(product);


        // se creaza user/product/order entity de la tastatura
        UserEntity userFromKeyboard = new UserEntity(userName, userLastName, userAddress);
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