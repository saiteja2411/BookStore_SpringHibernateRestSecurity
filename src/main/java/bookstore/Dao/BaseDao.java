/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.Dao;

import bookstore.beans.Book;
import java.util.ArrayList;

/**
 *
 * @author Saiteja
 */
public interface BaseDao {
    public void persist(Book obj);
    public ArrayList<Book> getAll();
}
