/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.webapis;

import bookstore.beans.Book;
import bookstore.main.BookStore;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Saiteja
 */

@Path("/getbooks")
public class Books {
    
    @Path("/jsonData/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Book> getbooksJson(@PathParam("id") Long id){
        BookStore bs =  new BookStore();
        ArrayList<Book> booklist=bs.init();
        for(Book book : booklist){
            if(id==book.getBookId()){
                ArrayList<Book> newlist =new ArrayList();
                newlist.add(book);
                return newlist;
            }
        }
        return booklist;
    }
    @Path("/jsonData")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Book> getbooksJson(){
        BookStore bs =  new BookStore();
        ArrayList<Book> booklist=bs.init();
        return booklist;
    }
    
    @Path("/jsonData/save")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ArrayList<Book> persistbooksJson(Book book){
        BookStore bs =  new BookStore();
        bs.persist(book);
        ArrayList<Book> booklist=bs.init();
        return booklist;
    }
    
    @Path("/xmlData")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public ArrayList<Book> getbooksXml(){
        BookStore bs =  new BookStore();
        ArrayList<Book> b=bs.init();
        return b;
    }

}
