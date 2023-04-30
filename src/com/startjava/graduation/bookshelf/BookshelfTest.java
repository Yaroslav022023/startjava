package com.startjava.graduation.bookshelf;

import java.util.Scanner;

public class BookshelfTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bookshelf bookshelf = new Bookshelf();
        boolean quit = true;

        while (quit) {
            if (bookshelf.getCountBooks() == 0) {
                System.out.println("The bookshelves are empty. You can add the first book to it.");
            } else {
                System.out.println("The bookshelf have " + bookshelf.getCountBooks() + " books"
                        + " and " + bookshelf.getFreeShelves() + " bookshelves are free:");
                displayAll(bookshelf);
            }

            showNavigation();
            if (!selectNumberFromNavigation(bookshelf, scanner)) {
                quit = false;
            }
        }
    }

    public static void displayAll(Bookshelf bookshelf) {
        int countBooks = bookshelf.getCountBooks();
        int maxLength = bookshelf.getMaxLength();
        Book[] books = bookshelf.getBooks();
        String dashes = "-".repeat(bookshelf.getMaxLength());
        char verticalBar = '|';

        for (int i = 0; i < countBooks; i++) {
            int quantitySpaces = maxLength - books[i].getLengthBookData();
            String spaces = " ".repeat(quantitySpaces) + verticalBar;

            System.out.println(String.valueOf(verticalBar) + books[i] + spaces);
            System.out.println(verticalBar + dashes + verticalBar);

            if (i == countBooks - 1 && countBooks != Bookshelf.CAPACITY) {
                spaces = " ".repeat(maxLength) + verticalBar;
                System.out.println(verticalBar + spaces);
                System.out.println(verticalBar + dashes + verticalBar);
            }
        }
    }

    private static void showNavigation() {
        String navigation = """
                Navigation:
                1. save <author> <title> <publishYear>
                2. search <title> of book
                3. delete <title>
                4. clear the bookshelf
                5. quit
                """;
        System.out.println(navigation);
        System.out.print("Select a number from the menu: ");
    }

    private static boolean selectNumberFromNavigation(Bookshelf bookshelf, Scanner scanner) {
        int action = 0;
        try {
            action = scanner.nextInt();
        } catch (RuntimeException e) {
            System.out.println("You didn't entered a number :)");
        }
        scanner.nextLine();

        switch (action) {
            case 1 -> {
                if (bookshelf.getFreeShelves() != 0) {
                    try {
                        System.out.println("Enter the book data in the format: author, name of book, 2023: ");
                        bookshelf.save(new Book(scanner.nextLine()));
                        System.out.println("The book has been added successfully.");
                    } catch (NumberFormatException e) {
                        System.out.println("Incorrectly entered data of the book.");
                    }
                } else {
                    System.out.println("All the available bookshelves are over. You cannot add a new book.");
                }
            }
            case 2 -> {
                System.out.println("Enter the <title> of book:");
                String title = scanner.nextLine();
                if (bookshelf.search(title) != null) {
                    System.out.println(bookshelf.search(title));
                } else {
                    System.out.println("Entered title is not found.");
                }
            }
            case 3 -> {
                System.out.println("Enter the <title> of book for delete:");
                System.out.println(bookshelf.delete(scanner.nextLine()) ? "The book was successfully deleted."
                        : "Entered title is not found.");
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
}