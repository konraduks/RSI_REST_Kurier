/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import com.konrad.webservices.server.entities.Test;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author KonradD
 */
@Path("kurier")
public class ServerService {
    
    @Context
    private UriInfo context;   

    public ServerService() {
    }
    
    @GET
    @Path("/test")
    public String test() {
        return "kurier test";
    }
    
    @GET
    @Path("/testDB")    
    public List<Test> testDB() {  
    //public List<String> testDB() {      
    //public String testDB() {    
        List<Test> str;
        //List<String> str;
        Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        //Query query = session.createQuery("select name from Country country");
        //str = query.list();
        session.persist(new Test());
        //tx.commit();
        //session = NewHibernateUtil.getSessionFactory().getCurrentSession();
        //tx = session.beginTransaction();
        Query query = session.createQuery("select test from Test test");
        //Query query = session.createQuery("select concat(test.id, ' ', test.date) from Test test");
        str = query.list();
        tx.commit();          
        //return str.get(str.size()-1).toString();
        return str;
    }
    
    @GET
    @Path("/testSec")   
    public String testSec() {
        return "kurier test security";
    }
    
    @GET
    @Path("/logout")   
    public String logout() {        
        return "kurier test logout";
    }
    
    @GET
    @Path("/logout2")   
    public String logout2() {        
        return "kurier test logout";
    }
}
