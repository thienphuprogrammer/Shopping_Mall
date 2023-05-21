package CommonFunction;

import java.awt.*;
import java.util.Scanner;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


import Shopping_Mall.CommonFunction.ListProduct;
import Shopping_Mall.CommonFunction.Product;



public class AdminObject {


        // Hàm xóa sản phẩm (RemoveProduct)
        public static void RemoveProduct(String productName) {
            try {
                File file = new File("product.bin");

                // Đọc danh sách sản phẩm từ tệp
                List<Product> products = new ArrayList<>();
                if (file.exists()) {
                    FileInputStream fileIn = new FileInputStream(file);
                    ObjectInputStream objectIn = new ObjectInputStream(fileIn);
                    products = (List<Product>) objectIn.readObject();
                    objectIn.close();
                    fileIn.close();
                }

                // Tìm và xóa sản phẩm
                boolean found = false;
                for (Product product : products) {
                    if (product.getName().equals(productName)) {
                        found = true;
                        break;
                    }
                }

                // Xác nhận xóa sản phẩm nếu tìm thấy
                if (found) {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("items" + productName + "be found. You may want to delete? (Y/N)");
                    String confirm = scanner.nextLine();

                    if (confirm.equalsIgnoreCase("Y")) {
                        products.removeIf(product -> product.getName().equals(productName));

                        // Ghi lại danh sách sản phẩm sau khi xóa
                        FileOutputStream fileOut = new FileOutputStream(file);
                        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
                        objectOut.writeObject(products);
                        objectOut.close();
                        fileOut.close();

                        System.out.println(productName + "successfully deleted.\n");
                    } else {
                        System.out.println("Canceling product deletion:" + productName + "'.\n");
                    }
                } else {
                    System.out.println("No products found:" + productName + ".\n");
                }

            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error" + e.getMessage());
            }
        }

        // Hàm tính năng của Admin
        public static void ShowAdminMenu() {
            ListProduct listProduct = new ListProduct();
//        Product product = new Product();
            Scanner scanner = new Scanner(System.in);


            int option = 0;
            while (option != 5) {
                System.out.println("+-------- Menu --------+");
                System.out.println("| [1] Show list goods  |");
                System.out.println("| [2] Add goods        |");
                System.out.println("| [3] Remove goods     |");
                System.out.println("| [4] Option           |");
                System.out.println("| [5] Exit             |");
                System.out.println("+----------------------+");

                System.out.print("Select an option:");
                option = scanner.nextInt();
                scanner.nextLine();

                // Chọn các option
                switch (option) {
                    case 1:
                        listProduct.showListProduct();
                        break;
                    case 2:
                        System.out.print("Nhập tên sản phẩm: ");
                        String productName = scanner.next();
                        Product product = new Product();
                        product.setName(productName);
                        listProduct.addProduct(product);
                        break;
                    case 3:
                        System.out.print("Nhập tên sản phẩm muốn xóa:");
                        String Remove_Product = scanner.next();
                        RemoveProduct(Remove_Product);
                        break;
                    case 4:
                        System.out.println("Coming soon...");
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.\n");
                        break;
                }
            }
        }
}

