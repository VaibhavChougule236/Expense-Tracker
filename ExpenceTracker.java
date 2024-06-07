package project3;

import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;


import java.time.LocalDate;

 class Expense {
    private String description;
    private double amount;
    private LocalDate date;

    public Expense(String description, double amount, LocalDate date) {
        this.description = description;
        this.amount = amount;
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "description='" + description + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }


      static class ExpenseTracker {
         private ArrayList<Expense> expenses;
         private Scanner scanner;

         public ExpenseTracker() {
             expenses = new ArrayList<>();
             scanner = new Scanner(System.in);
         }

         public void addExpense() {
             System.out.print("Enter description: ");
             String description = scanner.nextLine();

             System.out.print("Enter amount: ");
             double amount = scanner.nextDouble();

             System.out.print("Enter date (YYYY-MM-DD): ");
             String dateString = scanner.next();
             LocalDate date = LocalDate.parse(dateString);

             Expense expense = new Expense(description, amount, date);
             expenses.add(expense);
             System.out.println("Expense added successfully!");
         }

         public void viewExpenses() {
             if (expenses.isEmpty()) {
                 System.out.println("No expenses recorded.");
             } else {
                 for (Expense expense : expenses) {
                     System.out.println(expense);
                 }
             }
         }

         public void deleteExpense() {
             System.out.print("Enter the description of the expense to delete: ");
             String description = scanner.nextLine();

             Expense expenseToRemove = null;
             for (Expense expense : expenses) {
                 if (expense.getDescription().equals(description)) {
                     expenseToRemove = expense;
                     break;
                 }
             }

             if (expenseToRemove != null) {
                 expenses.remove(expenseToRemove);
                 System.out.println("Expense deleted successfully!");
             } else {
                 System.out.println("Expense not found.");
             }
         }

         public void showMenu() {
             while (true) {
                 System.out.println("Expense Tracker Menu:");
                 System.out.println("1. Add Expense");
                 System.out.println("2. View Expenses");
                 System.out.println("3. Delete Expense");
                 System.out.println("4. Exit");
                 System.out.print("Choose an option: ");

                 int choice = scanner.nextInt();
                 scanner.nextLine(); // consume the newline

                 switch (choice) {
                     case 1:
                         addExpense();
                         break;
                     case 2:
                         viewExpenses();
                         break;
                     case 3:
                         deleteExpense();
                         break;
                     case 4:
                         System.out.println("Exiting...");
                         return;
                     default:
                         System.out.println("Invalid option. Please try again.");
                 }
             }
         }

         public static void main(String[] args) {
             ExpenseTracker expenseTracker = new ExpenseTracker();
             expenseTracker.showMenu();
         }
     }

 }

