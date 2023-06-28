// package shoppingmall;

// import java.io.*;
// import java.util.ArrayList;
// import java.util.Scanner;

// import shoppingmall.Account.SignUp;
// import shoppingmall.services.productService.ProductService;
// import shoppingmall.models.Product;

// import static shoppingmall.utils.ValidationUtil.*;

// class FilterProduct extends ProductService {
//     private Scanner scanner = new Scanner(System.in);
//     private ProductService newList = new ProductService();
//     FilterProduct(ProductService listProduct1) {
//         this.listProduct = listProduct1.getListProduct();
//         System.out.println("+----------------------------------------+");
//         System.out.println("|   Nhập 0 để trở về menu.               |");
//         System.out.println("|   Nhập 1 để lọc sản phẩm theo số lượng.|");
//         System.out.println("|   Nhập 2 để lọc sản phẩm theo giá.     |");
//         System.out.println("|   Nhập 3 để lọc sản phẩm theo loại.    |");
//         System.out.println("+----------------------------------------+");
//         System.out.print("Sự lựa chọn của bạn: ");
//         int choice = Integer.parseInt(scanner.nextLine());
        
//         if(choice == 0) {
//             return;
//         }
//         else if(choice == 1) {
//             filterCount();
//         }
//         else if(choice == 2) {
//             filterPrice();
//         }
//         else {
//             filterType();
//         }
//         newList.showListProduct();
//         new FilterProduct(newList);
//     }

//     private void filterCount() {
//         System.out.print("Nhập số lượng tối thiểu bạn muốn: ");
//         int count = Integer.parseInt(scanner.nextLine());
//         for(Product product : listProduct) {
//             if(product.getCount() >= count) {
//                 newList.addProduct(product);
//             }
//         }
//     }
//     private void filterPrice() {
//         System.out.print("Nhập giá thấp bạn muốn: ");
//         float minPrice = Float.parseFloat(scanner.nextLine());
//         System.out.print("Nhập giá cao nhất bạn muốn: ");
//         float maxPrice = Float.parseFloat(scanner.nextLine());
//         for(Product product : listProduct) {
//             if(product.getPrice() >= minPrice && product.getPrice() <= maxPrice) {
//                 newList.addProduct(product);
//             }
//         }
//     }
//     private void filterType() {
//         System.out.print("Nhập loại hàng bạn muốn: ");
//         String type = scanner.nextLine();
//         for(Product product : listProduct) {
//             if(product.getType().equals(type)) {
//                 newList.addProduct(product);
//             }
//         }
//     }
// }

// class EditInfo extends SignUp {
//     private Scanner scanner = new Scanner(System.in);
//     private String filename;
//     private boolean isChangeUserName = false;
//     private boolean isChangeEmail = false;
//     EditInfo (InfoUser user, String file) {
//         this.info = user;
//         this.filename = file;
//         while (true) {
//             System.out.println("+----------------------------------------+");
//             System.out.println("|   Nhập 0 để trở về menu.               |");
//             System.out.println("|   Nhập 1 để thay đổi tên đăng nhập.    |");
//             System.out.println("|   Nhập 2 để thay đổi password.         |");
//             System.out.println("|   Nhập 3 để thay đổi số điện thoại.    |");
//             System.out.println("|   Nhập 4 để thay đổi email.            |");
//             System.out.println("|   Nhập 5 để thay dồi họ và tên.        |");
//             System.out.println("|   Nhập 6 để thay đổi CMND.             |");
//             System.out.println("+----------------------------------------+");
//             System.out.print("Sự lựa chọn của bạn: ");
//             int choice = Integer.parseInt(scanner.nextLine());
//             if (choice == 0) {
//                 return;
//             } else if(choice == 1) {
//                 //Function to edit user name
//                 editUserName();
//             } else if(choice == 2) {
//                 //Function to edit password
//                 editPassword();
//             } else if (choice == 3) {
//                 //Function to edit phone number
//                 editPhoneNumber();
//             } else if (choice == 4) {
//                 //Function to edit email
//                 editEmail();
//             } else if (choice == 5) {
//                 //Function to edit full name
//                 editFullName();
//             } else if (choice == 6) {
//                 //Function to edit identity Number
//                 editIdentityNumber();
//             } else {
//                 System.out.println("Lựa chọn không hợp lệ.");
//             }
//             if (checkExistUser()) {
//                 System.out.println("Đổi thông tin tài khoảng thành công !!");
//                 return;
//             }
//             else {
//                 System.out.println("Thông tin không hợp lệ!!");
//                 isChangeUserName = false;
//                 isChangeEmail = false;
//             }
//         }

//     }

//     private boolean checkExistUser() {
//         try {
//             ArrayList<InfoUser> listInfo = new ArrayList<InfoUser>();

//             File file = new File(filename);
//             if (file.exists()) {
//                 FileInputStream fis = new FileInputStream(file);
//                 if(fis.available() != 0) {
//                     ObjectInputStream ois = new ObjectInputStream(fis);

//                     listInfo = (ArrayList<InfoUser>) ois.readObject();
//                     ois.close();
//                 }
//             }

//             for (InfoUser infoUser : listInfo) {
//                 if ((infoUser.getUsername().equals(info.getUsername()) && isChangeUserName)
//                         || (infoUser.getEmail().equals(info.getEmail()) && isChangeEmail)) {
//                     return false;
//                 }
//             }
//             listInfo.set(info.getCustomerId(), info);

//             FileOutputStream fos = new FileOutputStream(file);
//             ObjectOutputStream oos = new ObjectOutputStream(fos);
//             oos.writeObject(listInfo);
//             oos.close();
//             return true;

//         } catch (IOException e) {
//             e.printStackTrace();
//         } catch (ClassNotFoundException e) {
//             throw new RuntimeException(e);
//         }
//         return false;
//     }
//     private void editUserName() {
//         System.out.print("Tên đăng nhập: ");
//         String username = scanner.nextLine();
//         info.setUsername(username);
//         isChangeUserName = true;
//     }
//     private void editPassword() {
//         String password = "";
//         while(true) {
//             System.out.print("Mật khẩu: ");
//             password = scanner.nextLine();

//             if(isValidPassword(password)) {
//                 break;
//             }
//             System.out.println("Mật khẩu phải có ít nhất 8 kí tự.");
//         }
//         info.setPassword(password);
//     }
//     private void editPhoneNumber() {
//         String phoneNumber = "";
//         while (true) {
//             System.out.print("Số điện thoại: ");
//             phoneNumber = scanner.nextLine();
//             if (isValidPhoneNumber(phoneNumber)) {
//                 break;
//             }
//             System.out.println("Số điện thoại không hợp lệ.");
//         }
//         info.setPhoneNumber(phoneNumber);
//     }
//     private void editEmail() {
//         String email = "";
//         while(true) {
//             System.out.print("Email: ");
//             email = scanner.nextLine();
//             if(isValidEmail(email)) {
//                 break;
//             }
//             System.out.println("Email không hợp lệ.");
//         }
//         info.setEmail(email);
//         isChangeEmail = true;
//     }
//     private void editFullName() {
//         System.out.print("Họ và tên: ");
//         String fullName = scanner.nextLine();
//         info.setFullName(fullName);
//     }
//     private void editIdentityNumber() {
//         System.out.print("Số CMND: ");
//         String identityNumber = scanner.nextLine();
//         info.setIdentityNumber(identityNumber);
//     }
// }
// public class MenuUser {
//     private Scanner scanner = new Scanner(System.in);

//     private ProductService listProduct = new ProductService();
//     private ShoppingCart listCart = new ShoppingCart();
//     private ShoppingCart listBoughtHistory = new ShoppingCart();
//     private ShoppingCart listProductBuying = new ShoppingCart();
//     private InfoUser accUser;


//     public ProductService getListProduct() {
//         return listProduct;
//     }

//     public void setListProduct(ProductService listProduct) {
//         this.listProduct = listProduct;
//     }

//     public ShoppingCart getListCart() {
//         return listCart;
//     }

//     public void setListCart(ShoppingCart listCart) {
//         this.listCart = listCart;
//     }

//     public ShoppingCart getListBoughtHistory() {
//         return listBoughtHistory;
//     }

//     public void setListBoughtHistory(ShoppingCart listBoughtHistory) {
//         this.listBoughtHistory = listBoughtHistory;
//     }

//     public ShoppingCart getListProductBuying() {
//         return listProductBuying;
//     }

//     public void setListProductBuying(ShoppingCart listProductBuying) {
//         this.listProductBuying = listProductBuying;
//     }

//     public InfoUser getAccUser() {
//         return accUser;
//     }

//     public void setAccUser(InfoUser accUser) {
//         this.accUser = accUser;
//     }

//     public int getIdUser() {
//         return idUser;
//     }

//     public void setIdUser(int idUser) {
//         this.idUser = idUser;
//     }

//     public Scanner getScanner() {
//         return scanner;
//     }

//     public void setScanner(Scanner scanner) {
//         this.scanner = scanner;
//     }

//     public enum MENU_SHEET {
//         EXIST,
//         VIEW_INFO_ACC,
//         EDIT_INFO_ACC,
//         VIEW_PRODUCT,
//         SEARCH_PRODUCT,
//         FILTER_PRODUCT,
//         ADD_TO_CART,
//         VIEW_CART,
//         CLEAR_CART,
//         BUY_PRODUCT,
//         VIEW_PRODUCT_BUYING,
//         HISTORY_BOUGHT,
//         LOG_OUT()
//     }

//     private int idUser;
//     MenuUser(InfoUser accuser) {
//         initData();

//         saveData();
//     }

//     void initData() {
//         this.listProduct.loadListProduct("src/Data/product.bin");
//         this.listCart.setIdUser(idUser);
//         this.listCart.loadListProduct("src/Data/cart.bin");
//         this.listProductBuying.setIdUser(idUser);
//         this.listProductBuying.loadListProduct("src/Data/product_is_buying.bin");
//         this.listBoughtHistory.setIdUser(idUser);
//         this.listBoughtHistory.loadListProduct("src/Data/product_bought.bin");
//     }

//     void saveData() {
//         this.listProduct.saveListProduct("src/Data/product.bin");
//         this.listCart.saveListProduct("src/Data/cart.bin");
//         this.listProductBuying.saveListProduct("src/Data/product_is_buying.bin");
//         this.listBoughtHistory.saveListProduct("src/Data/product_bought.bin");
//     }

//     public int getUserChoice() {
//         System.out.println("+------------------------MENU--------------------------+");
//         System.out.println("|    Nhập " + MENU_SHEET.EXIST.ordinal() +               " để quay trở về trang chủ.                  |");
//         System.out.println("|    Nhập " + MENU_SHEET.VIEW_INFO_ACC.ordinal() +       " để xem thông tin tài khoản.                |");
//         System.out.println("|    Nhập " + MENU_SHEET.EDIT_INFO_ACC.ordinal() +       " để xem chỉnh sửa thông tin tài khoản.      |");
//         System.out.println("|    Nhập " + MENU_SHEET.VIEW_PRODUCT.ordinal() +        " xem hàng hóa.                              |");
//         System.out.println("|    Nhập " + MENU_SHEET.SEARCH_PRODUCT.ordinal() +      " tìm kiếm sản phẩm.                         |");
//         System.out.println("|    Nhập " + MENU_SHEET.FILTER_PRODUCT.ordinal() +      " lọc sản phẩm.                              |");
//         System.out.println("|    Nhập " + MENU_SHEET.ADD_TO_CART.ordinal() +         " thêm hàng vào giỏ.                         |");
//         System.out.println("|    Nhập " + MENU_SHEET.VIEW_CART.ordinal() +           " xem giỏ hàng.                              |");
//         System.out.println("|    Nhập " + MENU_SHEET.CLEAR_CART.ordinal() +          " làm mới giỏ hàng.                          |");
//         System.out.println("|    Nhập " + MENU_SHEET.BUY_PRODUCT.ordinal() +         " mua hàng.                                  |");
//         System.out.println("|    Nhập " + MENU_SHEET.VIEW_PRODUCT_BUYING.ordinal() + " xem hàng đang mua.                        |");
//         System.out.println("|    Nhập " + MENU_SHEET.HISTORY_BOUGHT.ordinal() +      " xem lịch sử mua hàng.                     |");
//         System.out.println("+------------------------------------------------------+");
//         System.out.print("Sự lựa chọn của bạn: ");
//         int choice = Integer.parseInt(scanner.nextLine());

//         return choice;
//     }

//     public void waitForInput() {
//         Scanner scanner = new Scanner(System.in);
//         System.out.println("+------------------------------------------------------+");
//         System.out.println("Nhấn phím bất kỳ để trở về menu.");
//         scanner.nextLine(); // Wait for user to press Enter
//         for(int i = 0; i < 100; i++) System.out.println("");

//     }

//     public void returnToHomePage() {
//         System.out.println("Quay trở về trang chủ...");
//         // Code for returning to the home page
//     }

//     public void viewInfoAcc() {
//         accUser.showInfo(accUser.getCustomerId());
//     }

//     public void editInfoUser() {
//         accUser.showInfo(accUser.getCustomerId());
//         System.out.println("+----------------------------------------+");
//         new EditInfo(accUser, "src/Data/user.bin");
//     }

//     public void viewProducts() {
//         System.out.println("Xem hàng hóa...");
//         // Code for viewing products
//         listProduct.showListProduct();
//     }

//     public void searchProducts() {
//         System.out.println("Tìm kiếm sản phẩm...");
//         // Code for searching products
//         System.out.print("Tên hoặc id sản phẩm muốn tiềm kiếm: ");
//         String str = scanner.nextLine();
//         listProduct.searchProduct(str);
//     }

//     public void filterProducts() {
//         System.out.println("Lọc sản phẩm...");
//         // Code for filtering products
//         new FilterProduct(listProduct);
//     }

//     public void addToCart() {
//         System.out.println("Thêm hàng vào giỏ...");
//         // Code for adding items to cart
//         System.out.print("Nhập vào id của sản phẩm: ");
//         int id = Integer.parseInt(scanner.nextLine());
//         for(Product product: listProduct.getListProduct()) {
//             if (product.getCount() > 0) {
//                 if(product.getId() == id) {
//                     product.setCount(1);
//                     listCart.addItem(product);
//                     System.out.println("Đã thêm vào giỏ hàng. ");
//                     break;
//                 }
//             }
//             else {
//                 System.out.println("Sản phẩm đã hết hàng!!!");
//                 break;
//             }

//         }
//     }

//     public void viewCart() {
//         System.out.println("Xem giỏ hàng...");
//         // Code for viewing the cart
//         listCart.showListProduct();
//         float sumPrice = 0;
//         for(Product product : listCart.getListProduct()) {
//             sumPrice += product.getPrice() * product.getCount();
//         }
//         System.out.println("Tổng giá tiền của hóa đơn là: " + sumPrice);
//     }

//     public void clearCart() {
//         System.out.println("Xóa giỏ hàng...");
//         listCart.clearCart();
//         System.out.println("Giỏ hàng đã được làm mới!!");
//     }

//     public void viewListBuying() {
//         System.out.println("Xem danh sách hàng đang mua...");
//         listProductBuying.showListProduct();
//     }

//     public void buyProducts() {
//         System.out.println("Mua hàng...");
//         System.out.print("Bạn có chắc là muốn mua hàng không (Y/N): ");
//         String question = scanner.nextLine();
//         if (question.equals("Y") || question.equals("y")) {
//             // Code for buying products
//             for(Product product: listCart.getListProduct()) {
//                 this.listProductBuying.addProduct(product);
//             }
//             this.listCart.clearCart();
//             System.out.println("Đã mua hàng thành công!!!");
//         } else {
//             System.out.println("Đã hủy mua hàng!!!");
//         }
//     }

//     public void viewPurchaseHistory() {
//         System.out.println("Xem lịch sử mua hàng...");
//         listBoughtHistory.showListProduct();
//     }
// }
