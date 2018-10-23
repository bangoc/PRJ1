package com.apress.books.dao;

import com.apress.books.model.Book;

import java.util.List;

public class BookApp {
    private static BookDAO bookDao = new BookDAOImpl();

    public static void main(String[] args) {
        System.out.println("Listing all books");
        findAllBooks();
        System.out.println();
        System.out.println("Search book by keyword in book title: Groovy:");

        searchBooks("Groovy");
        System.out.println();

        System.out.println("Search book by keyword in author's name: Josh: ");
        searchBooks("Josh");
    }

    private static void findAllBooks() {
        List<Book> books = bookDao.findAllBooks();
        for (Book book: books) {
            System.out.println(book);
        }
    }
    private static void searchBooks(String keyword) {
        List<Book> books = bookDao.searchBooksByKeyword(keyword);
        for (Book book: books) {
            System.out.println(book);
        }
    }
}
