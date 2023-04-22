package com.startjava.graduation.bookshelf;

public class Book {

    private static final int QUANTITY_WORDS_FOR_BOOK_DATA = 3;
    private static final int MISSING_SPACES = 4;
    private final String autor;
    private final String titleBook;
    private final int yearOfPublication;
    private final int lengthOfBook;

    public Book(String nameBook) {
        String[] word = nameBook.split(", |,");

        if (word.length != QUANTITY_WORDS_FOR_BOOK_DATA) {
            throw new NumberFormatException();
        }
        autor = word[0];
        titleBook = word[1];
        yearOfPublication = Integer.parseInt(word[2]);
        lengthOfBook = autor.length() + titleBook.length()
                + String.valueOf(yearOfPublication).length() + MISSING_SPACES;

    }

    public String getTitleBook() {
        return titleBook;
    }

    public int getLengthOfBook() {
        return lengthOfBook;
    }

    public String toString() {
        return autor + ", " + titleBook + ", " + yearOfPublication;
    }
}