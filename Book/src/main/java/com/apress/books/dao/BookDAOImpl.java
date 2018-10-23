package com.apress.books.dao;

import com.apress.books.model.Author;
import com.apress.books.model.Book;
import com.apress.books.model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImpl implements BookDAO {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (ClassNotFoundException ex) {
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost/books", "demo", "abc123");
    }

    private void closeConnection(Connection connection) {
        if (connection == null) {
            return;
        }
        try {
            connection.close();
        } catch (SQLException ex) {
        }
    }

    @Override
    public List<Book> findAllBooks() {
        List<Book> result = new ArrayList<>();
        List<Author> authorList = new ArrayList<>();

        String sql = "select* from BOOK inner join AUTHOR on BOOK.id = AUTHOR.book_id";
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Book book = new Book();
                Author author = new Author();
                book.setId(resultSet.getLong("id"));
                book.setBookTitle(resultSet.getString("book_title"));
                book.setCategoryId(resultSet.getLong("category_id"));
                author.setBookId(resultSet.getLong("book_id"));
                author.setFirstName(resultSet.getString("first_name"));
                author.setLastName(resultSet.getString("last_name"));
                authorList.add(author);
                book.setAuthors(authorList);
                book.setPublisherName(resultSet.getString("publisher"));
                result.add(book);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return result;
    }

    @Override
    public List<Book> searchBooksByKeyword(String keyWord) {
        List<Book> result = new ArrayList<>();
        List<Author> authorList = new ArrayList<>();

        String sql = "select* from BOOK inner join AUTHOR on BOOK.id = AUTHOR.book_id"
                + " where book_title like '%"  + keyWord.trim()  + "%'"
                + " or first_name like '%"  + keyWord.trim()  + "%'"
                + " or last_name like '%" + keyWord.trim() + "%'";
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Book book = new Book();
                Author author = new Author();
                book.setId(resultSet.getLong("id"));
                book.setBookTitle(resultSet.getString("book_title"));
                book.setPublisherName(resultSet.getString("publisher"));
                author.setFirstName(resultSet.getString("first_name"));
                author.setLastName(resultSet.getString("last_name"));
                author.setBookId(resultSet.getLong("book_id"));
                authorList.add(author);
                book.setAuthors(authorList);
                result.add(book);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return result;
    }

    @Override
    public List<Category> findAllCategories() {
        List<Category> result = new ArrayList<>();
        String sql = "select* from CATEGORY";
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Category category = new Category();
                category.setId(resultSet.getLong("id"));
                category.setCategoryDescription(resultSet.getString("category_description"));
                result.add(category);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return result;
    }

    @Override
    public void insert(Book book) {

    }

    @Override
    public void update(Book book) {

    }

    @Override
    public void delete(Long bookId) {

    }
}
