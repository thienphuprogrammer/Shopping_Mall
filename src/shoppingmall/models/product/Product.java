package shoppingmall.models.product;

import java.io.Serializable;

public class Product implements Serializable {
    protected static final long serialVersionUID = 1L; // added serialVersionUID field
    protected String name;
    protected String type;
    protected String description;
    protected int id;
    protected float price;
    protected int count;
    protected float rate;

    public Product() {
        // Default constructor with default values
        this("", "", "", 0, 0.0f, 0, 0);
    }

    public Product(Product product) {
        this.name = product.name;
        this.type = product.type;
        this.description = product.description;
        this.id = product.id;
        this.price = product.price;
        this.count = product.count;
        this.rate = product.rate;
    }

    public Product(String name, String type, String description, int id, float price, int count, float rate) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.id = id;
        this.price = price;
        this.count = count;
        this.rate = rate;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
        System.out.print("| Name : " + name + " ".repeat(25 - String.valueOf(name).length()) + "|");
        System.out.print(" id : " + id + " ".repeat(25 - String.valueOf(id).length()) + "|");
        System.out.print(" Type : " + type + " ".repeat(25 - type.length()) + "|");
        System.out.print(" Price : " + price + " ".repeat(25 - String.valueOf(price).length()) + "|");
        System.out.print(" Count : " + count + " ".repeat(25 - String.valueOf(count).length()) + "|");

        // Xử lý mô tả nếu vượt quá kích thước cột
        if (description.length() > 25) {
            String truncatedDescription = description.substring(0, 22) + "...";
            System.out.println(
                    " Description : " + truncatedDescription + " ".repeat(25 - truncatedDescription.length()) + "|");
        } else {
            System.out.println(" Description : " + description + " ".repeat(25 - description.length()) + "|");
        }
    }
}