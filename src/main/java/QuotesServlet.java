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
    private List<Quote> quotes;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("quotes", quotes);
        request.getRequestDispatcher("/quotes.jsp").forward(request, response);
    }

    public void init(){
        if (quotes == null) {
            quotes = new ArrayList<>();
        }
        if (quotes.isEmpty()) {
            quotes.add(new Quote("Douglas", "Adams",    "Time is an illusion. Lunchtime doubly so."));
            quotes.add(new Quote("Mark",    "Twain",    "Clothes make the man. Naked people have little or no influence on society."));
            quotes.add(new Quote("Kurt",    "Vonnegut", "The universe is a big place, perhaps the biggest."));
            quotes.add(new Quote("Iris",     "Gonzalez", "There will always be agendas. Whenever there''s data, there's always an agenda"));
            quotes.add(new Quote("Henry",   "Ford",      "Whether if you think you can... or if you think you can.. you're right!"));
            quotes.add(new Quote("Dwight",  "Eisenhower", "Plans are worthless, but planning is everything"));
            quotes.add(new Quote("Neil",     "Gaiman",   "The process of doing a second draft is the process of making it look like you knew what you were doing all along"));
            quotes.add(new Quote("Kathy" ,   "Sierra",   "It's not what you know, it's when you know it."));
        }

    }
}
