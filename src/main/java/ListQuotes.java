import java.util.ArrayList;
import java.util.List;

public class ListQuotes implements Quotes {
    private static List<Quote> quotes;

    public ListQuotes(){
        init();
    }

    @Override
    public List<Quote> all() {
        return quotes;
    }

    @Override
    public Quote findOne(long id) {
        for(Quote quote : quotes) {
            if (quote.getId() == id)
                return quote;
        }
        return null;
    }

    @Override
    public void insert(Quote quote) {
        quotes.add(quote);
    }

    @Override
    public void update(Quote quote) {
        // first look up quote from quotes (maybe by id)
        // then replace with new value
    }

    @Override
    public void destroy(Quote quote) {
        // first look up quote from quotes (maybe by id)
        // quotes.remove(quote)
    }

    private List<Quote> getQuotes() {
    // This is a Singleton Pattern
        if (quotes == null) {
            quotes = new ArrayList<>();
        }
        return quotes;
    }

    private void init() {
        if (getQuotes().isEmpty()) {
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
