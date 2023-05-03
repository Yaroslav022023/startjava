package com.startjava.graduation.bookshelf;

import java.util.Scanner;

public class BookshelfTest {

    private static final String NOT_FOUND = "Entered title is not found.";
    private static final String TITLE_BOOK = "Enter the <title> of book:";
    private static final String DONE = "The book has been successfully ";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bookshelf bookshelf = new Bookshelf();
        boolean quit = false;

        while (!quit) {
            if (bookshelf.getCountBooks() == 0) {
                System.out.print("The bookshelves are empty. You can add the first book to it.");
            } else {
                System.out.println("The bookshelf have " + bookshelf.getCountBooks() + " books"
                        + " and " + bookshelf.getFreeShelves() + " bookshelves are free:");
                printBookshelf(bookshelf);
            }

            if (!selectAction(bookshelf, scanner)) {
                quit = true;
            }
        }
    }

    public static void printBookshelf(Bookshelf bookshelf) {
        int countBooks = bookshelf.getCountBooks();
        int maxLength = bookshelf.getMaxLength();
        Book[] books = bookshelf.getBooks();
        String dashes = '|' + "-".repeat(bookshelf.getMaxLength()) + '|';

        for (int i = 0; i < countBooks; i++) {
            int amountSpaces = maxLength - books[i].getLength();
            String spaces = " ".repeat(amountSpaces) + '|';
            System.out.println(String.valueOf('|') + books[i] + spaces + "\n" + dashes);

            if (countBooks < Bookshelf.CAPACITY - 1) {
                spaces = " ".repeat(maxLength) + '|';
                System.out.println('|' + spaces + "\n" + dashes);
            }
        }
    }

    private static boolean selectAction(Bookshelf bookshelf, Scanner scanner) {
        int action = inputNumber(scanner);

        boolean result = switch (action) {
            case 1 -> save(bookshelf, scanner);
            case 2 -> search(bookshelf, scanner);
            case 3 -> delete(bookshelf, scanner);
            case 4 -> clearShelves(bookshelf);
            case 5 -> false;
            yield true;
        };

        System.out.print("\nTo continue working press 'ENTER'");
        scanner.nextLine();
        System.out.println();
        return result;
    }

    private static int inputNumber(Scanner scanner) {
        int amountNumbersMenu = 5;
        int action = 0;

        while (action < 1 || action > amountNumbersMenu) {
            printMenu();
            System.out.print("Select the number from the menu (1-5): ");
            try {
                action = scanner.nextInt();
            } catch (RuntimeException e) {
                System.out.println("You didn't entered a number :) Try again.");
            }
            scanner.nextLine();
        }
        return action;
    }

    private static void save(Bookshelf bookshelf, Scanner scanner) {
        if (bookshelf.getFreeShelves() != 0) {
            System.out.println("Enter the book data in the format: author, name of book, 2023: ");
            try {
                bookshelf.save(new Book(scanner.nextLine()));
                System.out.println(DONE + "added.");
            } catch (NumberFormatException ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            System.out.println("All the available bookshelves are over. You cannot add a new book.");
        }
    }

    private static void search(Bookshelf bookshelf, Scanner scanner) {
        System.out.println("To search - " + TITLE_BOOK);
        String title = scanner.nextLine();
        if (bookshelf.search(title) != null) {
            System.out.println(bookshelf.search(title));
        } else {
            System.out.println(NOT_FOUND);
        }
    }

    private static void delete(Bookshelf bookshelf, Scanner scanner) {
        System.out.println("To delete - " + TITLE_BOOK);
        System.out.println(bookshelf.delete(scanner.nextLine()) ? DONE + "deleted."
                : NOT_FOUND);
    }

    private static void clearShelves(Bookshelf bookshelf) {
        bookshelf.clearShelves();
        System.out.println("Bookshelf has been successfully cleaned.");
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
}