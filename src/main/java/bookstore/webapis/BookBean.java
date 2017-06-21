/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.webapis;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Saiteja
 */
@XmlRootElement
public class BookBean {
    private int bookId;
    private String title;
    private double price;

    public BookBean() {
    }

    public BookBean(int bookId, String title, double price) {
        this.bookId = bookId;
        this.title = title;
        this.price = price;
    }
    
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
