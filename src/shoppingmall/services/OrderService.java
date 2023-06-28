package shoppingmall.services;
import shoppingmall.models.Product;
import shoppingmall.services.productService.ProductService;

import static shoppingmall.utils.FileUtil.*;

import java.util.ArrayList;
import java.util.HashMap;


public class OrderService extends ProductService {
    private int idUser = -1;
    private HashMap<Integer, ArrayList<Product>> hashMap;
//    private ArrayList<Product> listCart = new ArrayList<>();

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void addItem(Product product) {
        boolean isFind = false;
        for (Product value : listProduct) {
            if (product.getId() == value.getId()) {
                value.setCount(value.getCount() + 1);
                isFind = true;
            }
        }
        if(!isFind) {
            this.listProduct.add(product);
        }
    }
    public boolean updateItemQuantity(int quantity, int idProduct) {
        for (Product product : listProduct) {
            if (idProduct == product.getId()) {
                product.setCount(quantity);
                return true;
            }
        }
        return false;
    }

//    public void addToCart() {
//        System.out.println("Thêm hàng vào giỏ...");
//        // Code for adding items to cart
//        int id = readInt("Nhập vào id của sản phẩm: ");
//        for(Product product: listProduct) {
//            if (product.getCount() > 0) {
//                if(product.getId() == id) {
//                    product.setCount(1);
//                    listCart.add(product);
//                    System.out.println("Đã thêm vào giỏ hàng. ");
//                    break;
//                }
//            }
//            else {
//                System.out.println("Sản phẩm đã hết hàng!!!");
//                break;
//            }
//
//        }
//    }

    public void viewCart() {
        System.out.println("Xem giỏ hàng...");
        // Code for viewing the cart
        showListProduct();
        float sumPrice = 0;
        for(Product product : listProduct) {
            sumPrice += product.getPrice() * product.getCount();
        }
        System.out.println("Tổng giá tiền của hóa đơn là: " + sumPrice);
    }

    public void clearCart() {
        System.out.println("Xóa giỏ hàng...");
        this.listProduct.clear();
        System.out.println("Giỏ hàng đã được làm mới!!");
    }

//    public void buyProducts() {
//        System.out.println("Mua hàng...");
//        String question = readString("Bạn có chắc là muốn mua hàng không (Y/N): ");
//        if (question.equals("Y") || question.equals("y")) {
//            // Code for buying products
//            for(Product product: listProduct) {
//                this.listProductBuying.addProduct(product);
//            }
//            this.listCart.clearCart();
//            System.out.println("Đã mua hàng thành công!!!");
//        } else {
//            System.out.println("Đã hủy mua hàng!!!");
//        }
//    }
//    public void viewPurchaseHistory() {
//        System.out.println("Xem lịch sử mua hàng...");
//        listBoughtHistory.showListProduct();
//    }

    public void loadListProduct() {
        Object object = loadFileObject(filename);
        if(object != null) {
            this.hashMap = (HashMap<Integer, ArrayList<Product>>) object;
            this.listProduct = hashMap.get(idUser);
        }
    }

    public void saveListProduct(String filename) {
        if(listProduct.size() > 0) {
            this.hashMap.put(idUser, listProduct);
            saveFileObject(filename, hashMap);
        }

    }
}