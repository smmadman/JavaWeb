package com.junjie.test;

import com.junjie.dao.BookDao;
import com.junjie.dao.impl.BookDaoImpl;
import com.junjie.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookDaoTest {

    BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        bookDao.addBook(new Book(null, "嘿嘿", "李清照", new BigDecimal(66), 1000, 10000, null));
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(24);
    }

    @Test
    public void updateBookById() {
        bookDao.updateBookById(new Book(1, "java从入门到放弃", "国哥", new BigDecimal(33), 10, 990, null));
    }

    @Test
    public void queryBookById() {
        Book book = bookDao.queryBookById(3);
        System.out.println(book);
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookDao.queryBooks();

        for(Book book : books){
            System.out.println(book);
        }
    }

    @Test
    public void queryForPageTotalCount() {
        System.out.println(bookDao.queryForPageTotalCount());
    }

    @Test
    public void queryForPageItems() {
        List<Book> books = bookDao.queryForPageItems(8, 4);

        for(Book book : books){
            System.out.println(book);
        }
    }
}