package com.junjie.dao;
import com.junjie.pojo.Book;

import java.util.List;

public interface BookDao {
    public int addBook(Book book);

    public int deleteBookById(Integer id);

    public int updateBookById(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    public int queryForPageTotalCount();

    List<Book> queryForPageItems(int begin, int pageSize);
}
