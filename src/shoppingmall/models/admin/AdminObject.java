//package shoppingmall.models.admin;
//
//import java.util.HashMap;
//import java.util.Scanner;
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//
//import shoppingmall.services.productService.ProductService;
//import shoppingmall.models.Product;
//
//
//class ListBuying extends ProductService {
//    private HashMap<Integer, ArrayList<Product>> hashMap = new HashMap<>();
//
//    public HashMap<Integer, ArrayList<Product>> getHashMap() {
//        return hashMap;
//    }
//
//    public void setHashMap(HashMap<Integer, ArrayList<Product>> hashMap) {
//        this.hashMap = hashMap;
//    }
//    public Scanner scanner = new Scanner(System.in);
//
//    public ListBuying() {
//        loadList("src/Data/product_is_buying.bin");
//        showList();
//        System.out.println();
//        System.out.println();
//        System.out.println("+--------------------------+");
//        System.out.println("|  [0] để trở về menu      |");
//        System.out.println("|  [1] đề duyệt sản phẩm   |");
//        System.out.println("+--------------------------+");
//        int choice = Integer.parseInt(scanner.nextLine());
//        if(choice == 0) {
//            System.out.println(".........");
//            return;
//        }
//        else if(choice == 1) {
//            saveList("src/Data/product_bought.bin");
//            System.out.println("Sản phẩm đã bán thành công!!!");
//            this.hashMap = new HashMap<>();
//        }
//        else {
//            System.out.println("Nhập không hợp lệ!!");
//        }
//        saveList("src/Data/product_is_buying.bin");
//    }
//    public void showList() {
//        for (Integer id : hashMap.keySet()) {
//            for (Product product: hashMap.get(id)) {
//                System.out.print("ID user: " + id + " ".repeat(9 - String.valueOf(id).length()));
//                product.showProduct();
//            }
//        }
//    }
//
//    public void loadList(String filename) {
//        try {
//            FileInputStream fis = new FileInputStream(filename);
//            if(fis.available() != 0) {
//                ObjectInputStream ois = new ObjectInputStream(fis);
//                hashMap = (HashMap<Integer, ArrayList<Product>>) ois.readObject();
//                ois.close();
//            }
//            fis.close();
//        } catch (IOException e) {
//            System.out.println("Lỗi khi đọc danh sách sản phẩm từ file.");
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public void saveList(String filename) {
//        try {
//            HashMap<Integer, ArrayList<Product>> Map;
//            FileInputStream fis = new FileInputStream(filename);
//            if(fis.available() != 0) {
//                ObjectInputStream ois = new ObjectInputStream(fis);
//                Map = (HashMap<Integer, ArrayList<Product>>) ois.readObject();
//                hashMap.putAll(Map);
//                ois.close();
//            }
//            fis.close();
//            if(listProduct.size() > 0) {
//                FileOutputStream fos = new FileOutputStream(filename);
//                ObjectOutputStream oos = new ObjectOutputStream(fos);
//                oos.writeObject(hashMap);
//                fos.close();
//                oos.close();
//            }
//        } catch (IOException e) {
//            System.out.println("Lỗi khi lưu danh sách sản phẩm vào file.");
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
//
//
//public class AdminObject {
//    private ArrayList<InfoUser> listUser = new ArrayList<>();
//    private ProductService listProduct = new ProductService();
//    //        Product product = new Product();
//    private Scanner scanner = new Scanner(System.in);
//    private InfoUser infouser = new InfoUser();
//
//    // Hàm xóa sản phẩm (RemoveProduct)
//    public void RemoveProduct(String productName) {
//        try {
//            File file = new File("src/Data/product.bin");
//
//            // Đọc danh sách sản phẩm từ tệp
//            List<Product> products = new ArrayList<>();
//            if (file.exists()) {
//                FileInputStream fileIn = new FileInputStream(file);
//                ObjectInputStream objectIn = new ObjectInputStream(fileIn);
//                products = (List<Product>) objectIn.readObject();
//                objectIn.close();
//                fileIn.close();
//            }
//
//            // Tìm và xóa sản phẩm
//            boolean found = false;
//            for (Product product : products) {
//                if (product.getName().equals(productName)) {
//                    found = true;
//                    break;
//                }
//            }
//
//            // Xác nhận xóa sản phẩm nếu tìm thấy
//            if (found) {
//                Scanner scanner = new Scanner(System.in);
//                System.out.println("items" + productName + "be found. You may want to delete? (Y/N)");
//                String confirm = scanner.nextLine();
//
//                if (confirm.equalsIgnoreCase("Y")) {
//                    products.removeIf(product -> product.getName().equals(productName));
//
//                    // Ghi lại danh sách sản phẩm sau khi xóa
//                    FileOutputStream fileOut = new FileOutputStream(file);
//                    ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
//                    objectOut.writeObject(products);
//                    objectOut.close();
//                    fileOut.close();
//
//                    System.out.println(productName + "successfully deleted.\n");
//                } else {
//                    System.out.println("Canceling product deletion:" + productName + "'.\n");
//                }
//            } else {
//                System.out.println("No products found:" + productName + ".\n");
//            }
//
//        } catch (IOException | ClassNotFoundException e) {
//            System.out.println("Error" + e.getMessage());
//        }
//    }
//
//    private void loadListUser(String filename) {
//        try {
//            FileInputStream fis = new FileInputStream(filename);
//
//            if (fis.available() != 0) {
//                ObjectInputStream ois = new ObjectInputStream(fis);
//                this.listUser = (ArrayList<InfoUser>) ois.readObject();
//
//                fis.close();
//                ois.close();
//
//            }
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//    public AdminObject() {
//        ShowAdminMenu();
//    }
//
//    // Hàm tính năng của Admin
//    public void ShowAdminMenu() {
//        enum MenuOption {
//            DISPLAY_PRODUCTS(1),
//            ADD_PRODUCT(2),
//            REMOVE_PRODUCT(3),
//            DISPLAY_USERS(4),
//            LIST_BOUGHT(5),
//            EXIT(6);
//
//            private final int value;
//
//            MenuOption(int value) {
//                this.value = value;
//            }
//
//            public int getValue() {
//                return value;
//            }
//        }
//
//        int option = 0;
//        while (true) {
//            System.out.println("+----------------- Menu -----------------+");
//            System.out.println("| [1] Hiển thị hàng hòa                  |");
//            System.out.println("| [2] Thêm hàng hóa                      |");
//            System.out.println("| [3] Xóa hàng hóa                       |");
//            System.out.println("| [4] Hiển thị danh sách người dùng      |");
//            System.out.println("| [5] Hiển thị danh sách mua hàng        |");
//            System.out.println("| [6] Exit                               |");
//            System.out.println("+----------------------------------------+");
//
//            System.out.print("Nhập lựa chọn:");
//            option = scanner.nextInt();
//            System.out.println(" ");
//            scanner.nextLine();
//
//            // Chọn các option
//            if(option == MenuOption.LIST_BOUGHT.getValue()) {
//                new ListBuying();
//            }
//            else if (option == MenuOption.DISPLAY_PRODUCTS.getValue()) {
//                listProduct.loadListProduct("src/Data/product.bin");
//                listProduct.showListProduct();
//            } else if (option == MenuOption.ADD_PRODUCT.getValue()) {
//                Product product = new Product();
//                System.out.print("Nhập tên sản phẩm:");
//                String productName = scanner.next();
//                System.out.print("Nhập loại sản phẩm:");
//                String productType = scanner.next();
//                System.out.print("Nhập giá sản phẩm:");
//                Float productPrice = scanner.nextFloat();
//                System.out.print("Nhập số lượng sản phẩm:");
//                int productCount = scanner.nextInt();
//                System.out.print("Nhập mô tả sản phẩm:");
//                String productDescription = scanner.next();
//
//                product.setCount(productCount);
//                product.setType(productType);
//                product.setPrice(productPrice);
//                product.setName(productName);
//                product.setDescription(productDescription);
//                product.setId(listProduct.getSize());
//                listProduct.addProduct(product);
//                listProduct.saveListProduct("src/Data/product.bin");
//            } else if (option == MenuOption.REMOVE_PRODUCT.getValue()) {
//                listProduct.loadListProduct("src/Data/product.bin");
//                System.out.print("Nhập ID sản phẩm muốn xóa:");
//                int Remove_Product = scanner.nextInt();
//                listProduct.removeProduct(Remove_Product);
//                listProduct.saveListProduct("src/Data/product.bin");
//            } else if (option == MenuOption.DISPLAY_USERS.getValue()) {
//                showListInfoUser();
//            } else if (option == MenuOption.EXIT.getValue()) {
//                System.out.println("Đăng xuất thành công\n");
//                break;
//            } else {
//                System.out.println("Lựa chọn không tồn tại, vui lòng chọn lại.\n");
//            }
//
//            System.out.println("+------------------------------------------------------+");
//            System.out.println("Nhấn phím bất kỳ để trở về menu.");
//            scanner.nextLine(); // Wait for user to press Enter
//            for(int i = 0; i < 100; i++) System.out.println("");
//        }
//    }
//    private void showListInfoUser() {
//        loadListUser("src/Data/user.bin");
//        for(InfoUser info: listUser) {
//            info.showInfo(info.getCustomerId());
//        }
//    }
//}
//
