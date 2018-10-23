package com.apress.bookweb.controller;

import com.apress.books.dao.BookDAO;
import com.apress.books.dao.BookDAOImpl;
import com.apress.books.model.Book;
import com.apress.books.model.Category;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

@WebServlet(name = "Book", urlPatterns = {"/Book"}, loadOnStartup = 1)
public class BookController extends HttpServlet {
    public BookController() {
        super();
    }

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        BookDAO bookDao = new BookDAOImpl();
        List<Category> categoryList = bookDao.findAllCategories();
        ServletContext context = config.getServletContext();
        context.setAttribute("categoryList", categoryList);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String base = "/jsp/";
        String url = base + "home.jsp";
        String action = request.getParameter("action");
        String category = request.getParameter("category");
        String keyWord = request.getParameter("keyWord");
        if (action != null) {
            switch (action) {
                case "allBooks":
                    findAllBooks(request, response);
                    url = base + "listOfBooks.jsp";
                    break;
                case "category":
                    findAllBooks(request, response);
                    url = base + "category.jsp?category=" + category;
                    break;
                case "search":
                    searchBooks(request, response, keyWord);
                    url = base + "searchResult.jsp";
                    break;
            }
        }
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(url);
        requestDispatcher.forward(request, response);
    }
    private void findAllBooks(HttpServletRequest request,
                              HttpServletResponse response) throws ServletException, IOException {
        try {
            BookDAO bookDao = new BookDAOImpl();
            List<Book> bookList = bookDao.findAllBooks();
            request.setAttribute("bookList", bookList);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void searchBooks(HttpServletRequest request,
                             HttpServletResponse response, String keyWord)
            throws ServletException, IOException {
        try {
            BookDAO bookDao = new BookDAOImpl();
            List<Book> bookList = bookDao.searchBooksByKeyword(keyWord);

            request.setAttribute("bookList", bookList);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
