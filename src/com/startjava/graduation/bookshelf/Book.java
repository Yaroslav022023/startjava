package com.startjava.graduation.bookshelf;

public class Book {

    private static final int COUNT_CHARACTERISTICS = 3;
    private final String author;
    private final String title;
    private final int yearPublication;
    private final int length;

    public Book(String bookData, String errorInput) {
        String[] characteristics = bookData.split(", |,");

        if (characteristics.length != COUNT_CHARACTERISTICS) {
            throw new NumberFormatException(errorInput);
        }
        author = characteristics[0];
        title = characteristics[1];
        yearPublication = Integer.parseInt(characteristics[2]);
        length = toString().length();

    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public String toString() {
        return author + ", " + title + ", " + yearPublication;
    }
}