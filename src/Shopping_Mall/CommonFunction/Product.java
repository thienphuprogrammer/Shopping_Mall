package Shopping_Mall.CommonFunction;

import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialVersionUID = 1L; // added serialVersionUID field
    private String name;
    private String type;
    private String description;
    private int id;
    private float price;
    private int count;

    public Product() {
        // Default constructor with default values
        this("", "", "", 0, 0.0f, 0);
    }

    public Product(String name, String type, String description, int id, float price, int count) {
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
        System.out.println("+----------------------------------------+");
        System.out.println("| Name        | " + name + " ".repeat(25 - String.valueOf(name).length()) + "|");
        System.out.println("| id          | " + id + " ".repeat(25 - String.valueOf(id).length()) + "|");
        System.out.println("| Type        | " + type + " ".repeat(25 - type.length()) + "|");
        System.out.println("| Price       | " + price + " ".repeat(25 - String.valueOf(price).length()) + "|");
        System.out.println("| Count       | " + count + " ".repeat(25 - String.valueOf(count).length()) + "|");

        // Xử lý mô tả nếu vượt quá kích thước cột
        if (description.length() > 25) {
            String truncatedDescription = description.substring(0, 22) + "...";
            System.out.println("| Description | " + truncatedDescription + " ".repeat(25 - truncatedDescription.length()) + "|");
        } else {
            System.out.println("| Description | " + description + " ".repeat(25 - description.length()) + "|");
        }

        System.out.println("+----------------------------------------+\n");
    }
}