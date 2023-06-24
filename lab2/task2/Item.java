import java.util.*;

public class Item {
    private String name;
    private String code;
    private double price;

    Item(String name,String code, double price) {
        this.name = name;
        this.code = code;
        this.price = price;
    }
    
    Item(String content) {
        Scanner string = (new Scanner(content));
        code  = string.next();
        price = string.nextDouble();
        name  = string.nextLine();
        string.close();
    }

    public String getString() {
        return this.code+"|"+ this.price+"|"+this.name+"\n";
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return this.price;
    }

    public String getCode() {
        return this.code;
    }

    public void setName(String name) {
        if (!name.equals(""))
            this.name = name;
    }
    
    public void setPrice(Double price) {
            this.price = price;
    }

    public void setCode(String code) {
        this.code = code;
    }

}