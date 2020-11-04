public class Quote {
    private long id;
    private String authorFirstName;
    private String authorLastName;
    private String content;

    public Quote(){}

    public Quote(String first, String last, String quote){
        this.authorFirstName = first;
        this.authorLastName = last;
        this.content = quote;
    }

    public long getId() {
        return id;
    }

    protected void setId(long id) {
        this.id = id;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
