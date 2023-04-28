package com.startjava.graduation.bookshelf;

import java.util.Arrays;

public class Bookshelf {

    private static final int CAPACITY = 10;
    private final Book[] books = new Book[CAPACITY];
    private int quantityBooksInShelf;
    private int longestTitle;

    public int getQuantityInShelf() {
        return quantityBooksInShelf;
    }

    public int getFreeShelves() {
        return CAPACITY - quantityBooksInShelf;
    }

    public void assemblingShelves() {
        String dashes = "-".repeat(longestTitle);
        char verticalBar = '|';

        for (int i = 0; i < quantityBooksInShelf; i++) {
            int quantitySpaces = longestTitle - books[i].getLengthBookData();
            String spaces = " ".repeat(quantitySpaces) + verticalBar;
            String bookData = String.valueOf(verticalBar) + books[i] + spaces;
            String shelfDesign = verticalBar + dashes + verticalBar;

            BookshelfTest.displayAll(bookData, shelfDesign);

            if (i == quantityBooksInShelf - 1 && quantityBooksInShelf != CAPACITY) {
                spaces = " ".repeat(longestTitle) + verticalBar;
                shelfDesign = verticalBar + spaces;
                String emptyShelf = verticalBar + dashes + verticalBar;

                BookshelfTest.displayAll(shelfDesign, emptyShelf);
            }
        }
    }

    public void save(Book bookData) {
        books[quantityBooksInShelf] = bookData;
        quantityBooksInShelf++;
        if (bookData.getLengthBookData() > longestTitle) {
            checkLongestBookData();
        }
    }

    public String search(String titleBook) {
        for (int i = 0; i < quantityBooksInShelf; i++) {
            if (titleBook.equals(books[i].getTitle())) {
                return books[i].toString();
            }
        }
        return "Entered title <" + titleBook + "> is not found";
    }

    public boolean delete(String titleBook) {
        for (int i = 0; i < quantityBooksInShelf; i++) {
            if (titleBook.equals(books[i].getTitle())) {
                if (books[i].getLengthBookData() == longestTitle) {
                    longestTitle = 0;
                }

                books[i] = null;
                System.arraycopy(books, i + 1, books, i, (quantityBooksInShelf - 1) - i);
                books[quantityBooksInShelf - 1] = null;
                quantityBooksInShelf--;

                if (longestTitle == 0) {
                    checkLongestBookData();
                }
                return true;
            }
        }
        return false;
    }

    public void clearAllShelves() {
        Arrays.fill(books, 0, quantityBooksInShelf, null);
        quantityBooksInShelf = 0;
        longestTitle = 0;
    }

    private void checkLongestBookData() {
        for (int i = 0; i < quantityBooksInShelf; i++) {
            if (books[i].getLengthBookData() > longestTitle) {
                longestTitle = books[i].getLengthBookData();
            }
        }
    }
}