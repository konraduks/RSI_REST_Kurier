/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

import com.konrad.webservices.server.entities.Client;
import com.konrad.webservices.server.entities.Employee;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import javax.ws.rs.ext.Provider;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import server.NewHibernateUtil;

/**
 *
 * @author KonradD
 */
@Provider
public class BasicAuthFilter implements Filter {

    /*@Override
    public void filter(ContainerRequestContext requestContext){
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

 /*@Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext response){
        System.out.println("requestCon: " + requestContext.getProperty("Username"));
        response.getHeaders().add("test", "test :-)");
    }*/
    //response.getHeaders().add("test", "test :-)");
    /**
     * Logger
     */
    private static final Logger LOG = LoggerFactory.getLogger(BasicAuthFilter.class);

    //private String username = "";

    //private String password = "";

    private String realm = "Protected";

//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        //username = filterConfig.getInitParameter("username");
//        //password = filterConfig.getInitParameter("password");
//        /*String paramRealm = filterConfig.getInitParameter("realm");
//        if (StringUtils.isNotBlank(paramRealm)) {
//            realm = paramRealm;
//        }*/
//    }
    
    /*public BasicAuthFilter(ServletResponse servletResponse){
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        try {
            unauthorized(response, "Bad credentials");
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(BasicAuthFilter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        System.out.println("SPRAWDZANIE UZYTKOWNIKA...");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String authHeader = request.getHeader("Authorization");
        if (authHeader != null) {
            StringTokenizer st = new StringTokenizer(authHeader);
            if (st.hasMoreTokens()) {
                String basic = st.nextToken();

                if (basic.equalsIgnoreCase("Basic")) {
                    try {
                        String credentials = new String(Base64.decodeBase64(st.nextToken()), "UTF-8");
                        LOG.debug("Credentials: " + credentials);
                        int p = credentials.indexOf(":");
                        if (p != -1) {
                            String _username = credentials.substring(0, p).trim();
                            String _password = credentials.substring(p + 1).trim();

                            //if (!username.equals(_username) || !password.equals(_password)) {
                            if (!findUser(_username, _password)) {
                                unauthorized(response, "Bad credentials");
                            }

                            filterChain.doFilter(servletRequest, servletResponse);
                        } else {
                            unauthorized(response, "Invalid authentication token");
                        }
                    } catch (UnsupportedEncodingException e) {
                        throw new Error("Couldn't retrieve authentication", e);
                    }
                }
            }
        } else {
            unauthorized(response);
        }
    }
    
    private boolean findUser(String login, String password){
        System.err.println(login + " " + password);
        Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();   
        Query query = session.createQuery("select employee from Employee employee where employee.login= :login and employee.password= :password");
        query.setParameter("login", login);
        query.setParameter("password", password);
        Employee employee = (Employee) query.uniqueResult();
        tx.commit();
        if (employee != null) {
            System.err.println("UZYSZKODNIK JEST");
            return true;
        } else {
            System.err.println("PUSTO BRAK UZYSZKODNIKA");
            return false;
        }
        //return true;
    }

    @Override
    public void destroy() {
    }

    private void unauthorized(HttpServletResponse response, String message) throws IOException {
        response.setHeader("WWW-Authenticate", "Basic realm=\"" + realm + "\"");
        response.sendError(401, message);
    }

    private void unauthorized(HttpServletResponse response) throws IOException {
        unauthorized(response, "Unauthorized");
    }
}
