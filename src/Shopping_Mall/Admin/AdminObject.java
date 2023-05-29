package Shopping_Mall.Admin;

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import Shopping_Mall.CommonFunction.Account.SignUp;
import Shopping_Mall.CommonFunction.ListProduct;
import Shopping_Mall.CommonFunction.Product;
import Shopping_Mall.CommonFunction.Account.InfoUser;


public class AdminObject {
        private static ArrayList<InfoUser> listUser = new ArrayList<>();

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

        private static void loadListUser(String filename) {
            try {
                FileInputStream fis = new FileInputStream(filename);

                if (fis.available() != 0) {
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    listUser = (ArrayList<InfoUser>) ois.readObject();

                    fis.close();
                    ois.close();

                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        // Hàm tính năng của Admin
        public static void ShowAdminMenu() {
            ListProduct listProduct = new ListProduct();
//        Product product = new Product();
            Scanner scanner = new Scanner(System.in);
            InfoUser infouser = new InfoUser();


            int option = 0;
            while (option != 5) {
                System.out.println("+----------------- Menu -----------------+");
                System.out.println("| [1] Hiển thị hàng hòa                  |");
                System.out.println("| [2] Thêm hàng hóa                      |");
                System.out.println("| [3] Xóa hàng hóa                       |");
                System.out.println("| [4] Hiển thị danh sách người dùng      |");
                System.out.println("| [5] Exit                               |");
                System.out.println("+----------------------------------------+");

                System.out.print("Nhập lựa chọn:");
                option = scanner.nextInt();
                System.out.println(" ");
                scanner.nextLine();

                // Chọn các option
                switch (option) {
                    case 1:
                        listProduct.loadListProduct("C:/codeN/Shopping_Mall/src/Data/product.bin");
                        System.out.print("Nhập ID sản phẩm: ");
                        int ID = scanner.nextInt();
                        listProduct.showListProduct(ID);
                        break;
                    case 2:
                        Product product = new Product();
                        System.out.print("Nhập tên sản phẩm:");
                        String productName = scanner.next();
                        System.out.print("Nhập ID sản phẩm:");
                        int productID = scanner.nextInt();
                        System.out.print("Nhập loại sản phẩm:");
                        String productType = scanner.next();
                        System.out.print("Nhập giá sản phẩm:");
                        Float productPrice = scanner.nextFloat();
                        System.out.print("Nhập số lượng sản phẩm:");
                        int productCount = scanner.nextInt();
                        System.out.print("Nhập mô tả sản phẩm:");
                        String productDescription = scanner.next();

                        product.setCount(productCount);
                        product.setType(productType);
                        product.setPrice(productPrice);
                        product.setId(productID);
                        product.setName(productName);
                        product.setDescription(productDescription);
                        listProduct.addProduct(product);
                        listProduct.saveListProduct("C:/codeN/Shopping_Mall/src/Data/product.bin");
                        break;
                    case 3:
                        listProduct.loadListProduct("C:/codeN/Shopping_Mall/src/Data/product.bin");
                        System.out.print("Nhập ID sản phẩm muốn xóa:");
                        int Remove_Product = scanner.nextInt();
                        listProduct.removeProduct(Remove_Product);
                        listProduct.saveListProduct("C:/codeN/Shopping_Mall/src/Data/product.bin");
                        break;
                    case 4:
                        listProduct.loadListProduct("C:/codeN/Shopping_Mall/src/Data/user.bin");
                        System.out.print("Nhập ID sản phẩm muốn xóa:");
                        int UserID = scanner.nextInt();
                        infouser.showInfo(UserID);
                        break;
                    case 5:
                        System.out.println("Đăng xuất thành công\n");
                        break;
                    default:
                        System.out.println("Lựa chọn không tồn tại, vui lòng chọn lại.\n");
                        break;
                }
            }
        }
}

