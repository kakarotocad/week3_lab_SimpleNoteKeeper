package servlets;

import domain.Note;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 794980
 */
public class NoteServlet extends HttpServlet {

   

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String title;
        String content;
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        BufferedReader br = new BufferedReader(new FileReader(path));
        String edit = request.getParameter("edit");
        
        title = br.readLine();
        content = br.readLine();
        
        request.setAttribute("title", title);
        request.setAttribute("content", content);
        
        Note newnote = new Note(title,content);
        
        if(edit != null){
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
        }
        
        br.close();
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        
        request.setAttribute("title", title);
        request.setAttribute("content", content);
        
        PrintWriter pw = new PrintWriter(path);
        
        pw.println(title);
        pw.println(content);
        pw.close();
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        
    }


}
