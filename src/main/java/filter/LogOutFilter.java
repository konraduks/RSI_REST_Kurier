/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
import javax.ws.rs.core.Response;

/**
 *
 * @author KonradD
 */
public class LogOutFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("LOG OUT FILTER");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        //res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        //res.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        //res.setDateHeader("Expires", -1); // Proxies.
        //filterChain.doFilter(request, response);
        /*Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                cookies[i].setValue("");
                cookies[i].setPath("/");
                cookies[i].setMaxAge(0);
                //System.out.println("ciasteczko " + cookies[i].getName());
                res.addCookie(cookies[i]);
            }
        }*/
        //res.sendError(401, "UNAUTHORIZED");
        //res.sendError(401, "SUCCESSFULLY LOG OUT");
        res.sendError(401);
        System.out.println("WYSLE CZY NIE?");
        //res.sendRedirect("../kurier/logout");
        java.net.URI location = null;
        try {
            location = new java.net.URI("../kurier/logout2");
        } catch (URISyntaxException ex) {
            System.out.println("BLADDD");
            Logger.getLogger(LogOutFilter.class.getName()).log(Level.SEVERE, null, ex);
        }
        Response.temporaryRedirect(location).build();
    }

    @Override
    public void destroy() {
    }

}
