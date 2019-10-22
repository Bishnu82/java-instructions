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
<<<<<<< HEAD

    @Override
    public String toString() {
=======
      
    @Override
    public final String getDisplayText() {
>>>>>>> a953b95255c11f4329a7651e4f3ab5096c3bdb34
        return super.toString() + " by " + author;
    }
}
