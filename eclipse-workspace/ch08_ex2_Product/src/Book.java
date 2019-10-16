public class Book extends Product {

    private String author;

    public Book() {
        super();
        author = "";
        count++;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }
      
    @Override
    public final String getDisplayText() {
        return super.toString() + " by " + author;
    }
}
