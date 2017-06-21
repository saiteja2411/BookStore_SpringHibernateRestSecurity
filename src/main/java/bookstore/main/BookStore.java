/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.main;

import bookstore.Dao.BaseDao;
import bookstore.Dao.BaseDaoImpl;
import bookstore.beans.Book;
import java.util.ArrayList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Saiteja
 */
@Controller
public class BookStore {
    
    @RequestMapping(value="/books" , method = RequestMethod.GET)
    public ModelAndView initialize(@ModelAttribute Book book, @RequestParam("title") String bookName ){
        
       // System.out.println("bookstore.mai--------------------n.BookStore.initialize()-----"+book.getTitle());
        ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
        //Book book= (Book)context.getBean("book");
        BaseDao bookDao=(BaseDaoImpl)context.getBean("bookDao");
        bookDao.persist(book);
        ArrayList<Book> al= bookDao.getAll();
//        for(Book b:al){
//           System.out.println("Title = "+b.getTitle()+" Price="+b.getPrice());
//        }
        ModelAndView mv= new ModelAndView("welcome");
        mv.addObject("booklist", al);
        return mv;
    }
    public ArrayList<Book> init(){
        ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
        
        BaseDao bookDao=(BaseDaoImpl)context.getBean("bookDao");
        
        return bookDao.getAll();
    }
    public void persist(Book book){
        ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
        BaseDao bookDao=(BaseDaoImpl)context.getBean("bookDao");
        bookDao.persist(book);
    }
    
//    @RequestMapping(value="/index" , method = RequestMethod.GET)
//    public ModelAndView handler(){
//        ModelAndView mv= new ModelAndView("welcome");
//        return mv;
//    }
}
