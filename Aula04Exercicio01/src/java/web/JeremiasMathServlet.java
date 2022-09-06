/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rebec
 */
@WebServlet(name = "JeremiasMathServlet", urlPatterns = {"/jeremias-calc.html"})
public class JeremiasMathServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet JeremiasMathServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet JeremiasMathServlet at " + request.getContextPath() + "</h1>");
            out.println("<a href='index.html'><h4>Voltar<h4></a>");
            
            out.println("<h3>Calculadora</h3>");
            
                    out.println("<form>\n" +
                        "            <input type=\"number\" step=\"0.1\" name=\"n1\" value=\"0\"/>\n" +
                        "            <select name=\"operacao\">\n" +
                        "                <option value=\"+\">+</option>\n" +
                        "                <option value=\"-\">-</option>\n" +
                        "                <option value=\"x\">x</option>\n" +
                        "                <option value=\"/\">/</option>\n" +
                        "            </select>\n" +
                        "            <input type=\"number\" step=\"0.1\" name=\"n2\" value=\"0\"/>    \n" +
                        "            <input type=\"submit\" value=\" = \"/>    \n" +
                        "        </form>");
            double n1 = 1;
            double n2 = 1;
            try{
                String l1 = request.getParameter("n1");
                String l2 = request.getParameter("n2");
                String opera = request.getParameter("operacao");
                n1 = Double.parseDouble(l1);
                n2 = Double.parseDouble(l2);
                                
                if(null == opera){
                    out.println("Operador não pode ser nulo!");
                }
                else switch (opera) {
                    case "+":
                        out.println("<br>");
                        out.println(n1 + " + " + " " + n2 +  " = " + (n1 + n2)+ ". ");
                        break;
                    case "-":
                        out.println("<br>");
                        out.println(n1 + " - " + " " + n2 +  " = " + (n1 - n2)+ ". ");
                        break;
                    case "x":
                        out.println("<br>");
                        out.println(n1 + " x " + " " + n2 +  " = " + (n1 * n2)+ ". ");
                        break;
                    default:
                        out.println("<br>");
                        out.println(n1 + " / " + " " + n2 +  " = " + (n1 / n2)+ ". ");
                        break;
                }
            }
            catch(Exception ex){
                out.println("<br>");
                out.println("O resultado da sua operação aparecerá aqui! :)");
            }
           
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
