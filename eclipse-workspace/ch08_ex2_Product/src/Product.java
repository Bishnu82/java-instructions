import java.text.NumberFormat;

<<<<<<< HEAD
public class Product {
=======
public abstract class Product {
>>>>>>> a953b95255c11f4329a7651e4f3ab5096c3bdb34

    private String code;
    private String description;
    private double price;
    protected static int count = 0;

    public Product() {
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getPriceFormatted() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(price);
    }
<<<<<<< HEAD
=======
    
    abstract String getDisplayText();
>>>>>>> a953b95255c11f4329a7651e4f3ab5096c3bdb34

    @Override
    public String toString() {
        return description;
    }

    public static int getCount() {
        return count;
    }
}