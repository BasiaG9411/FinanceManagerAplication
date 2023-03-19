package org.example.main;

import org.example.Connection;
import org.example.Dao.CategoryDao;
import org.example.entity.Category;
import org.example.entity.Expenses;
import org.example.entity.Income;
import org.example.service.CategoryService;
import org.example.service.ExpenseService;
import org.example.service.IncomeService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class FinanceManagerAppMain {

    private static final Scanner scanner = new Scanner(System.in);

    private static final CategoryService categoryService = new CategoryService();

    private static final ExpenseService expenseService = new ExpenseService();

    private static final IncomeService incomeService = new IncomeService();

    public static void main(String[] args) {

        int choose;


        do {
            System.out.println("Wybierz opcję: ");
            System.out.println("0 - zakończ");
            System.out.println("1 - Dodaj wydatek: ");
            System.out.println("2 - Dodaj przychód: ");
            System.out.println("3 - Usuń wydatek: ");
            System.out.println("4 - Usuń przychód: ");
            System.out.println("6 - Wyświetl wszystkie wydatki: ");
            System.out.println("8 - Wyświetl wszystkie wydatki na podstawie kategorii: ");
            //System.out.println("9 - Wyświetl wydatki na podstawie kategorii: ");
            System.out.println("10 - Wyświetl wszystkie przychody: ");
            System.out.println("11 - Saldo: ");
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
                        List<Category> categories = categoryService.showAllCategories();
                        System.out.println("Wprowadz kwotę wydatku: ");
                        BigDecimal ammount = scanner.nextBigDecimal();
                        scanner.nextLine();
                        System.out.println("Wprowadz komentarz: ");
                        String commentary = scanner.nextLine();
                        System.out.print("Dostępne kategorie: ");
                        for (Category category : categories) {
                            System.out.print(category.getName() + " ");
                        }
                        System.out.println();
                        System.out.println("Wybierz dostępną kategorię: ");

                        String categoryName = scanner.nextLine();
                        expenseService.addExpense(ammount, commentary, LocalDate.now(), CategoryDao.getByName(categoryName));

                    } catch (NullPointerException e) {
                        System.err.println("Podana kategoria nie istnieje. Musisz stowrzyć nową kategorię wybierz 12.");
                    }
                }
                case 2 -> {
                    try {
                        System.out.println("Wprowadz kwotę przychodu: ");
                        BigDecimal ammount = scanner.nextBigDecimal();
                        scanner.nextLine();
                        System.out.println("Wprowadz komentarz: ");
                        String commentary = scanner.nextLine();

                        incomeService.addIncome(ammount, commentary, LocalDate.now());

                    } catch (NoSuchElementException e) {
                        System.err.println("Wprowadz prawidłową kwotę: ");
                    }
                }

                case 3 -> {
                    try {
                        System.out.println("Podaj id wydatku do usunięcia: ");
                        scanner.nextLine();
                        Integer id = scanner.nextInt();
                        expenseService.deleteExpense(id);
                    } catch (IllegalArgumentException e) {
                        System.err.println("Wydatek o podanym id nie istnieje. Wprowadz prawidłowy nr id.");
                    }

                }
                case 4 -> {
                    try {
                        System.out.println("Podaj id przychodu do usunięcia: ");
                        scanner.nextLine();
                        Integer id = scanner.nextInt();
                        incomeService.deleteIncome(id);
                    } catch (IllegalArgumentException e) {
                        System.err.println("Dochód o podanym id nie istnieje. Wprowadz prawidłowy nr id.");
                    }

                }

                case 6 -> {
                    List<Expenses> expense = expenseService.showAllExpenses();
                    System.out.println("Lista wszystkich wydatków: \t");
                    scanner.nextLine();
                    for (Expenses expenses : expense) {
                        System.out.printf("Wydatek o id: %s, Amount: %s, Date: %s, Comment: %s, Category: %s",
                                expenses.getId(), expenses.getAmount(), expenses.getAddDate(),
                                expenses.getCommentary(), expenses.getCategory().getName() + "\n");
                    }
                }

                case 8 -> {
                    try {
                        System.out.println("Podaj id kategorii: ");
                        Integer id = scanner.nextInt();
                        List<Expenses> expensesByCategories = expenseService.showSumOfAllExpensesSortedByCategory(id);
                        for (Expenses expenses : expensesByCategories) {
                            System.out.printf("Wydatek o id: %s, Amount: %s, Date: %s, Comment: %s, Category: %s",
                                    expenses.getId(), expenses.getAmount(), expenses.getAddDate(),
                                    expenses.getCommentary(), expenses.getCategory().getName() + "\n");
                        }

                    } catch (IllegalArgumentException e) {
                        System.err.println(e.getMessage());
                    }
                }

                case 10 -> {
                    List<Income> incomes = incomeService.showAllIncomes();
                    System.out.println("Lista wszystkich przychodów: \t");
                    scanner.nextLine();
                    for (Income income : incomes) {
                        System.out.printf("Przychód o id: %s, Amount: %s, Date: %s, Comment: %s",
                                income.getId(), income.getAmount(), income.getAddDate(), income.getCommentary() + "\n");
                    }
                }

                case 11 -> {
                    System.out.println("Aktualne saldo wynosi: " + expenseService.showSaldo());
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
                        List<Category> categories = categoryService.showAllCategories();
                        System.out.print("Lista kategorii do wyboru: ");
                        for (Category category : categories) {
                            System.out.print(category.getName() + ", ");
                        }
                        System.out.println();
                        System.out.println("Podaj nazwę kategorii do usunięcia: ");
                        scanner.nextLine();
                        String categoryName = scanner.nextLine();
                        categoryService.deleteCategory(categoryName);
                    } catch (IllegalArgumentException e) {
                        System.err.println("Wybrana kategoria nie istnieje. Wprowadź prawidłową nazwę.");
                    }

                }
            }
        }
        while (true);
    }
}







