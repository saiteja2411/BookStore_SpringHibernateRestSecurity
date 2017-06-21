/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.Dao;

import bookstore.beans.Book;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Saiteja
 */
@Repository
@Transactional
public class BaseDaoImpl implements BaseDao {

    @Autowired
    public SessionFactory sessionFactory;
    public Session session;

    //private EntityManager em ;
    @Override
    public void persist(Book obj) {
        session = sessionFactory.openSession();
        System.out.println("in persist basedaoimpl");
        session.beginTransaction();
        session.save(obj);
        session.getTransaction().commit();
    }

    @Override
    public ArrayList<Book> getAll() {
        System.out.println("bookstore.Dao.BaseDaoImpl.getAll()");
        
        session = sessionFactory.openSession();
       Query query = session.createQuery("from book");
        System.out.println(session);
       ArrayList<Book> al=(ArrayList<Book>) query.list();
       session.close();
       return al;
       
    }
}
