public class Software extends Product {

    private String version;

    public Software() {
        super();
        version = "";
        count++;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    @Override
<<<<<<< HEAD
    public String toString() {
=======
    public String getDisplayText() {
>>>>>>> a953b95255c11f4329a7651e4f3ab5096c3bdb34
        return super.toString() + " " + version;
    }
}