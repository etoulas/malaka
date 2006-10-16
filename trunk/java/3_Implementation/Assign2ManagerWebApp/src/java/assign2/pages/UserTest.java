/*
 * UserTest.java
 *
 * Created on 16 October 2006, 16:52
 */

package assign2.pages;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;
import assign2.users.UserManagerRemote;
import java.io.*;
import java.net.*;
import javax.ejb.EJB;

/**
 *
 * @author Gerard Gigliotti
 * @version
 */
public class UserTest extends HttpServlet
{
    @EJB
    private UserManagerRemote um;
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
      
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet UserTest</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet UserTest at " + request.getContextPath () + "</h1>");
        out.println(um.testEm());
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
    {
        processRequest(request, response);
    }
    
    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
    {
        processRequest(request, response);
    }
    
    /** Returns a short description of the servlet.
     */
    public String getServletInfo()
    {
        return "Short description";
    }
    // </editor-fold>
}
