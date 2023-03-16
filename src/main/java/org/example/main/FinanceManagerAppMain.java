package org.example.main;

import org.example.Connection;
import org.example.entity.Expense;
import org.example.service.CategoryService;

import java.util.Scanner;

public class FinanceManagerAppMain {

    private static Scanner scanner = new Scanner(System.in);

    private static CategoryService categoryService = new CategoryService();

    public static void main(String[] args) {

        int choose;


        do {
            System.out.println("Wybierz opcję: ");
            System.out.println("0 - zakończ");
            System.out.println("12 - Dodaj kategorię: ");

            choose = scanner.nextInt();

            switch (choose) {

                case 0 -> {
                    Connection.closeSessionFactory();
                    System.exit(0);
                }
                case 12 -> {
                    try {
                        System.out.println("Podaj nazwę nowej kategorii: ");
                        scanner.nextLine();
                        String categoryName = scanner.nextLine();
                        categoryService.addNewCategory(categoryName);
                    } catch (IllegalArgumentException e) {
                        System.err.println(e.getMessage());
                    }
                }

            }
        } while (true);
    }
}







