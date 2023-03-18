package org.example.main;

import org.example.Connection;
import org.example.Dao.CategoryDao;
import org.example.entity.Category;
import org.example.service.CategoryService;
import org.example.service.ExpenseService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class FinanceManagerAppMain {

    private static Scanner scanner = new Scanner(System.in);

    private static CategoryService categoryService = new CategoryService();

    private static ExpenseService expenseService = new ExpenseService();

    public static void main(String[] args) {

        int choose;


        do {
            System.out.println("Wybierz opcję: ");
            System.out.println("0 - zakończ");
            System.out.println("1 - Dodaj wydatek: ");
            System.out.println("3 - Usuń wydatek: ");
            System.out.println("6 - Wyświetl wszystkie wydatki");
            System.out.println("12 - Dodaj kategorię: ");
            System.out.println("13 - Usuń kategorię: ");

            choose = scanner.nextInt();

            switch (choose) {


                case 0 -> {
                    Connection.closeSessionFactory();
                    System.exit(0);
                }
                case 1 -> {
                    try {
                        System.out.println("Wprowadz kwotę wydatku: ");
                        BigDecimal ammount = scanner.nextBigDecimal();
                        scanner.nextLine();
                        System.out.println("Wprowadz komentarz: ");
                        String commentary = scanner.nextLine();
                        System.out.println("Podaj kategorię: ");

                        String categoryName = scanner.nextLine();

                        //categoryService.addNewCategory(categoryName);
                        expenseService.addExpense(ammount, commentary, LocalDate.now(), CategoryDao.getByName(categoryName));

                    } catch (IllegalArgumentException e) {
                        System.err.println(e.getMessage());
                    }
                }

                case 3 -> {
                    try {
                        System.out.println("Podaj id wydatku do usunięcia: ");
                        scanner.nextLine();
                        Integer id = scanner.nextInt();
                        expenseService.deleteExpense(id);
                    } catch (IllegalArgumentException e) {
                        System.err.println(e.getMessage());
                    }

                }

                case 6 -> {
                    try {
                        System.out.println("Lista wszystkich wydatków: ");
                        scanner.nextLine();
                        expenseService.showAllExpenses();
                    } catch (IllegalArgumentException e) {
                        System.err.println(e.getMessage());
                    }

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
                case 13 -> {
                    try {
                        System.out.println("Podaj nazwę kategorii do usunięcia: ");
                        scanner.nextLine();
                        String categoryName = scanner.nextLine();
                        categoryService.deleteCategory(categoryName);
                    } catch (IllegalArgumentException e) {
                        System.err.println(e.getMessage());
                    }

                }
            }
        }
        while (true);
    }
}







