package com.startjava.graduation.bookshelf;

import java.util.Scanner;

public class BookshelfTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bookshelf bookshelf = new Bookshelf();
        boolean quit = true;

        while (quit) {
            if (bookshelf.getCountBooks() == 0) {
                System.out.print("The bookshelves are empty. You can add the first book to it.");
            } else {
                System.out.println("The bookshelf have " + bookshelf.getCountBooks() + " books"
                        + " and " + bookshelf.getFreeShelves() + " bookshelves are free:");
                printBookshelf(bookshelf);
            }

            if (!selectAction(bookshelf, scanner)) {
                quit = false;
            }
        }
    }

    public static void printBookshelf(Bookshelf bookshelf) {
        int countBooks = bookshelf.getCountBooks();
        int maxLength = bookshelf.getMaxLength();
        Book[] books = bookshelf.getBooks();
        String dashes = "-".repeat(bookshelf.getMaxLength());
        char verticalBar = '|';

        for (int i = 0; i < countBooks; i++) {
            int quantitySpaces = maxLength - books[i].getLength();
            String spaces = " ".repeat(quantitySpaces) + verticalBar;

            System.out.println(String.valueOf(verticalBar) + books[i] + spaces + "\n" +
                    verticalBar + dashes + verticalBar);

            if (i == countBooks - 1 && countBooks != Bookshelf.CAPACITY) {
                spaces = " ".repeat(maxLength) + verticalBar;
                System.out.println(verticalBar + spaces + "\n" +
                        verticalBar + dashes + verticalBar);
            }
        }
    }

    private static void printMenu() {
        System.out.println("""
                
                Menu:
                1. save <author> <title> <publishYear>
                2. search <title> of book
                3. delete <title>
                4. clear the bookshelf
                5. quit
                """);
    }

    private static boolean selectAction(Bookshelf bookshelf, Scanner scanner) {
        boolean acceptedNumber = false;
        int action = 0;

        while (!acceptedNumber) {
            printMenu();
            System.out.print("Select a number from the menu: ");
            try {
                action = scanner.nextInt();
                acceptedNumber = true;
            } catch (RuntimeException e) {
                System.out.println("You didn't entered a number :) Try again.");
            }
            scanner.nextLine();
        }

        switch (action) {
            case 1 -> {
                if (bookshelf.getFreeShelves() != 0) {
                    String errorInput = "Incorrectly entered data of the book.";
                    try {
                        System.out.println("Enter the book data in the format: author, name of book, 2023: ");
                        bookshelf.save(new Book(scanner.nextLine(), errorInput));
                        System.out.println(done() + "added.");
                    } catch (NumberFormatException ex) {
                        System.out.println(ex.getMessage());
                    }
                } else {
                    System.out.println("All the available bookshelves are over. You cannot add a new book.");
                }
            }
            case 2 -> {
                System.out.println("To search - " + enterTitleBook());
                String title = scanner.nextLine();
                if (bookshelf.search(title) != null) {
                    System.out.println(bookshelf.search(title));
                } else {
                    System.out.println(foundNot());
                }
            }
            case 3 -> {
                System.out.println("To delete - " + enterTitleBook());
                System.out.println(bookshelf.delete(scanner.nextLine()) ? done() + "deleted."
                        : foundNot());
            }
            case 4 -> {
                bookshelf.clearShelves();
                System.out.println("Bookshelf has been successfully cleaned.");
            }
            case 5 -> {
                return false;
            }
            default -> System.out.println("Select from numbers 1-5");
        }

        System.out.print("\nTo continue working press 'ENTER'");
        scanner.nextLine();
        System.out.println();
        return true;
    }

    private static String foundNot() {
        return "Entered title is not found.";
    }

    private static String enterTitleBook() {
        return "Enter the <title> of book:";
    }

    private static String done() {
        return "The book has been successfully ";
    }
}