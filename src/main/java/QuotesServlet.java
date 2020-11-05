import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "QuotesServlet", urlPatterns = "/quotes")
public class QuotesServlet extends HttpServlet {
    private Quotes quotesManager;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("quotes", quotesManager.all());
        request.getRequestDispatcher("/quotes.jsp").forward(request, response);
    }

    @Override
    public void init(){
        quotesManager = QuotesDAOFactory.getQuotesManager();
    }
}
