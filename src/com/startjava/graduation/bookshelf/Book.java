package com.startjava.graduation.bookshelf;

public class Book {

    private static final int QUANTITY_DATA_ABOUT_BOOK = 3;
    private final String author;
    private final String title;
    private final int yearPublication;
    private final int lengthBookData;

    public Book(String bookData) {
        String[] dataAboutBook = bookData.split(", |,");

        if (dataAboutBook.length != QUANTITY_DATA_ABOUT_BOOK) {
            throw new NumberFormatException();
        }
        author = dataAboutBook[0];
        title = dataAboutBook[1];
        yearPublication = Integer.parseInt(dataAboutBook[2]);
        lengthBookData = toString().length();

    }

    public String getTitle() {
        return title;
    }

    public int getLengthBookData() {
        return lengthBookData;
    }

    public String toString() {
        return author + ", " + title + ", " + yearPublication;
    }
}