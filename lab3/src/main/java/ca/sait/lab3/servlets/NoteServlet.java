package ca.sait.lab3.servlets;

import ca.sait.lab3.javabeans.Note;
import java.io.*;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gao Liu
 */
public class NoteServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
 
   
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
        
        String query = request.getQueryString();
        
        
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        
        String title=br.readLine();
        String contents=br.readLine();
        
        Note note = new Note(title, contents); 
        request.setAttribute("note", note);
        
        if(query!=null && query.contains("edit")){
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
        }else {
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response); 
        }
        
        
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
      
      String title = request.getParameter("title");
      String contents = request.getParameter("contents");
      String path = getServletContext().getRealPath("/WEB-INF/note.txt");
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false))); 
      pw.println(title);
      pw.println(contents);
      pw.close();
      
      Note note = new Note(title, contents);
      request.setAttribute("note", note);
      getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response); 
    }


}
