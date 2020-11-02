import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ShowStudentServlet", urlPatterns = "/users")
public class ShowStudentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        out.println("<h3>Hello " + name + "</h3>");

        int grade = Integer.parseInt(request.getParameter("grade"));
        out.println("<span>Grade: "+ grade +".00</span>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        out.println("<h1>As a post</h1>");
        out.println("<h3>Hello " + name + "</h3>");

        int grade = Integer.parseInt(request.getParameter("grade"));
        out.println("<span>Grade: "+ grade +".00</span>");
    }
}
