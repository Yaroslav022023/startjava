package com.startjava.graduation.bookshelf;

import java.util.Arrays;

public class Bookshelf {

    private static final int CAPACITY = 10;
    private final Book[] books = new Book[CAPACITY];
    private int quantityBooksInShelf;
    private int longestNameBook;

    public int getQuantityBooksInShelf() {
        return quantityBooksInShelf;
    }

    public int getFreeBookshelves() {
        return CAPACITY - quantityBooksInShelf;
    }

    public void displayAllBooks() {
        String dashes = "-".repeat(longestNameBook);
        char verticalBar = '|';

        for (int i = 0; i < quantityBooksInShelf; i++) {
            int quantitySpaces = longestNameBook - books[i].getLengthOfBook();
            String spaces = " ".repeat(quantitySpaces) + verticalBar;

            System.out.println(String.valueOf(verticalBar) + books[i] + spaces);
            System.out.println(verticalBar + dashes + verticalBar);

            if (i == quantityBooksInShelf - 1 && quantityBooksInShelf != CAPACITY) {
                spaces = " ".repeat(longestNameBook) + verticalBar;
                System.out.println(verticalBar + spaces);
                System.out.println(verticalBar + dashes + verticalBar);
            }
        }
    }

    public void addBook(Book dataOfBook) {
        books[quantityBooksInShelf] = dataOfBook;
        quantityBooksInShelf++;
        if (dataOfBook.getLengthOfBook() > longestNameBook) {
            checkLongestNameBook();
        }
    }

    public String searchBook(String nameBook) {
        for (int i = 0; i < quantityBooksInShelf; i++) {
            if (nameBook.equals(books[i].getTitleBook())) {
                return books[i].toString();
            }
        }
        return "Entered title <" + nameBook + "> is not found";
    }

    public boolean deleteBook(String nameBook) {
        for (int i = 0; i < quantityBooksInShelf; i++) {
            if (nameBook.equals(books[i].getTitleBook())) {
                if (books[i].getLengthOfBook() == longestNameBook) {
                    longestNameBook = 0;
                }

                books[i] = null;
                System.arraycopy(books, i + 1, books, i, books.length - (i + 1));
                books[quantityBooksInShelf - 1] = null;
                quantityBooksInShelf--;

                if (longestNameBook == 0) {
                    checkLongestNameBook();
                }
                return true;
            }
        }
        return false;
    }

    public void clearBooksShelf() {
        Arrays.fill(books, 0, quantityBooksInShelf, null);
        quantityBooksInShelf = 0;
        longestNameBook = 0;
    }

    private void checkLongestNameBook() {
        for (int i = 0; i < quantityBooksInShelf; i++) {
            if (books[i].getLengthOfBook() > longestNameBook) {
                longestNameBook = books[i].getLengthOfBook();
            }
        }
    }
}