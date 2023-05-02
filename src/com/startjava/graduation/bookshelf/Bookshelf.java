package com.startjava.graduation.bookshelf;

import java.util.Arrays;

public class Bookshelf {

    public static final int CAPACITY = 10;
    private final Book[] books = new Book[CAPACITY];
    private int countBooks;
    private int maxLength;

    public int getCountBooks() {
        return countBooks;
    }

    public int getFreeShelves() {
        return CAPACITY - countBooks;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public Book[] getBooks() {
        return Arrays.copyOf(books, countBooks);
    }

    public void save(Book newBook) {
        books[countBooks] = newBook;
        countBooks++;
        if (newBook.getLength() > maxLength) {
            calcMaxLength();
        }
    }

    public Book search(String title) {
        for (int i = 0; i < countBooks; i++) {
            if (title.equals(books[i].getTitle())) {
                return books[i];
            }
        }
        return null;
    }

    public boolean delete(String title) {
        for (int i = 0; i < countBooks; i++) {
            if (title.equals(books[i].getTitle())) {
                if (books[i].getLength() == maxLength) {
                    maxLength = 0;
                }
                countBooks--;
                System.arraycopy(books, i + 1, books, i, countBooks - i);
                books[countBooks] = null;

                if (maxLength == 0) {
                    calcMaxLength();
                }
                return true;
            }
        }
        return false;
    }

    public void clearShelves() {
        Arrays.fill(books, 0, countBooks, null);
        countBooks = 0;
        maxLength = 0;
    }

    private void calcMaxLength() {
        for (int i = 0; i < countBooks; i++) {
            if (books[i].getLength() > maxLength) {
                maxLength = books[i].getLength();
            }
        }
    }
}