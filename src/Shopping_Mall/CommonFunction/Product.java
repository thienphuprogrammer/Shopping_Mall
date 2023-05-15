package Shopping_Mall.CommonFunction;

import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialVersionUID = 1L; // added serialVersionUID field
    private String name;
    private String type;
    private String description;
    private String id;
    private float price;
    private int count;

    public Product(String name, String type, String description, String id, float price, int count) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.id = id;
        this.price = price;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void showProduct() {
        System.out.println("Name: " + name);
        System.out.println("id: " + id);
        System.out.println("Type: " + type);
        System.out.println("Description: " + description);
        System.out.println("price: " + price);
        System.out.println("Count: " + count);
    }
}
