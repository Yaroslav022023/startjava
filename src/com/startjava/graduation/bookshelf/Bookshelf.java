package com.startjava.graduation.bookshelf;

import java.util.Arrays;

public class Bookshelf {

    private static final int CAPACITY = 10;
    private final Book[] books = new Book[CAPACITY];
    private int quantityBooksInShelf;
    private int longestTitleBook;

    public int getQuantityBooksInShelf() {
        return quantityBooksInShelf;
    }

    public int getFreeBookshelves() {
        return CAPACITY - quantityBooksInShelf;
    }

    public void displayAllBooks() {
        String dashes = "-".repeat(longestTitleBook);
        char verticalBar = '|';

        for (int i = 0; i < quantityBooksInShelf; i++) {
            int quantitySpaces = longestTitleBook - books[i].getLengthBookData();
            String spaces = " ".repeat(quantitySpaces) + verticalBar;

            System.out.println(String.valueOf(verticalBar) + books[i] + spaces);
            System.out.println(verticalBar + dashes + verticalBar);

            if (i == quantityBooksInShelf - 1 && quantityBooksInShelf != CAPACITY) {
                spaces = " ".repeat(longestTitleBook) + verticalBar;
                System.out.println(verticalBar + spaces);
                System.out.println(verticalBar + dashes + verticalBar);
            }
        }
    }

    public void addBook(Book bookData) {
        books[quantityBooksInShelf] = bookData;
        quantityBooksInShelf++;
        if (bookData.getLengthBookData() > longestTitleBook) {
            checkLongestBookData();
        }
    }

    public String searchBook(String titleBook) {
        for (int i = 0; i < quantityBooksInShelf; i++) {
            if (titleBook.equals(books[i].getTitle())) {
                return books[i].toString();
            }
        }
        return "Entered title <" + titleBook + "> is not found";
    }

    public boolean deleteBook(String titleBook) {
        for (int i = 0; i < quantityBooksInShelf; i++) {
            if (titleBook.equals(books[i].getTitle())) {
                if (books[i].getLengthBookData() == longestTitleBook) {
                    longestTitleBook = 0;
                }

                books[i] = null;
                System.arraycopy(books, i + 1, books, i, books.length - (i + 1));
                books[quantityBooksInShelf - 1] = null;
                quantityBooksInShelf--;

                if (longestTitleBook == 0) {
                    checkLongestBookData();
                }
                return true;
            }
        }
        return false;
    }

    public void clearBooksShelf() {
        Arrays.fill(books, 0, quantityBooksInShelf, null);
        quantityBooksInShelf = 0;
        longestTitleBook = 0;
    }

    private void checkLongestBookData() {
        for (int i = 0; i < quantityBooksInShelf; i++) {
            if (books[i].getLengthBookData() > longestTitleBook) {
                longestTitleBook = books[i].getLengthBookData();
            }
        }
    }
}