package shoppingmall.services;

import shoppingmall.models.Order;
import shoppingmall.models.Product;
import shoppingmall.services.productService.ProductService;

import static shoppingmall.utils.FileUtil.*;
import static shoppingmall.utils.InputUtil.*;
import static shoppingmall.views.StandardView.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class OrderService implements AutoCloseable{
    private String filename;
    private int idUser = -1;
    private HashMap<Integer, ArrayList<Order>> hashMap;
    private ArrayList<Order> listOrder = new ArrayList<>();

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public ArrayList<Order> getListOrder() {
        return listOrder;
    }

    public void setListOrder(ArrayList<Order> listOrder) {
        this.listOrder = listOrder;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public OrderService(String filename, int userID) {
        this.filename = filename;
        this.idUser = userID;
        loadListOrder();
    }

    public void addItem(Product product) {
        addItem(product, 1); // Call the overloaded method with a default value of 1
    }

    public void addItem(Product product, int totalAmount) {
        boolean isFound = false;
        for (Order order : listOrder) {
            if (product.getId() == order.getCustomerId()) {
                order.setTotalAmount(order.getTotalAmount() + 1);
                isFound = true;
            }
        }
        if (!isFound) {
            int orderId = listOrder.size();
            String currentDate = LocalDate.now().toString();
            this.listOrder.add(new Order(orderId, idUser, product, currentDate, totalAmount));
        }
    }

    public void clearProduct() {
        this.listOrder.clear();
    }
    public boolean updateItemQuantity(int quantity, int idProduct) {
        for (Order order : listOrder) {
            if (idProduct == order.getOrderId()
                    && idUser == order.getCustomerId()) {
                order.setTotalAmount(quantity);
                return true;
            }
        }
        return false;
    }

    public void viewOrder() {
        if (listOrder.size() == 0) {
            printValueln("Danh sách hàng mua đang trống!!!");
        }
        else {
            for (Order order : listOrder) {
                order.showOrder();
            }
        }
    }
    

    public void buyProducts(ProductService productService) {
        System.out.println("Mua hàng...");
        String question = readString("Bạn có chắc là muốn mua hàng không (Y/N): ");
        if (question.equals("Y") || question.equals("y")) {
            // Code for buying products
            for (Order product : listOrder) {
                // productService.
                // this.listProductBuying.addProduct(product);
            }
            this.listOrder.clear();
            System.out.println("Đã mua hàng thành công!!!");
        } else {
            System.out.println("Đã hủy mua hàng!!!");
        }
    }

    public void viewPurchaseHistory() {
        System.out.println("Xem lịch sử mua hàng...");
        // listBoughtHistory.showListProduct();
    }

    public void loadListOrder() {
        Object object = loadFileObject(filename);
        if (object != null) {
            this.hashMap = (HashMap<Integer, ArrayList<Order>>) object;
            this.listOrder = hashMap.get(idUser);
        }
    }

    public void saveListOrder(String filename) {
        if (listOrder.size() > 0) {
            this.hashMap.put(idUser, listOrder);
            saveFileObject(filename, hashMap);
        }
    }
}