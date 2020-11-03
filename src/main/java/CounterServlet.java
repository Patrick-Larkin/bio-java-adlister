import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CounterServlet", urlPatterns = "/count")
public class CounterServlet extends HttpServlet {

    private int number = 0;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        number++;
        try {
            response.getWriter().println("number: " +  number);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
