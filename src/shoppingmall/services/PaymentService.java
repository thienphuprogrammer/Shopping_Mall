package shoppingmall.services;

import shoppingmall.models.Order;
import shoppingmall.models.Payment;
import shoppingmall.models.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import static shoppingmall.utils.FileUtil.loadFileObject;
import static shoppingmall.utils.FileUtil.saveFileObject;
import static shoppingmall.utils.OutputUtil.printValue;
import static shoppingmall.utils.OutputUtil.printValueln;

public class PaymentService {
    // -----------------Property------------------
    private ArrayList<Payment> listPayment = new ArrayList<>();
    private HashMap<Integer, ArrayList<Payment>> hashMap = new HashMap<>();
    private String filename;
    private int idUser;

    // -----------------Getter and setter--------------

    public ArrayList<Payment> getListPayment() {
        return listPayment;
    }

    public void setListPayment(ArrayList<Payment> listPayment) {
        this.listPayment = listPayment;
    }

    // -----------------Constructor-------------------
    public PaymentService(String filename, int idUser) {
        this.filename = filename;
        this.idUser = idUser;
        loadListPayment();
    }

    // -----------------Method-------------------
    public void buyProducts(ArrayList<Order> orders, int idUser) {
        for(Order order: orders) {
            String currentDate = LocalDate.now().toString();
            listPayment.add(new Payment(listPayment.size(), order.getProduct(), currentDate, idUser));
        }
        saveListPayment();
    }

    public void viewPayment() {
        if (listPayment.size() == 0) {
            printValueln("Danh sách hàng đang trống!!!");
        } else {
            for (Payment payment : listPayment) {
                printValue("| Payment ID : " + payment.getPaymentId() + " ".repeat(25 - String.valueOf(payment.getPaymentId()).length()) + "|");
                printValue("Customer ID : " + payment.getCustomerId() + " ".repeat(25 - String.valueOf(payment.getCustomerId()).length()) + "|");
                printValue("Product ID  : " + payment.getProduct().getId() + " ".repeat(25 - String.valueOf(payment.getProduct().getId()).length()) + "|");
                printValueln(" Date : " + payment.getPaymentDate() + " ".repeat(25 - payment.getPaymentDate().length()) + "|");
            }
        }
    }

    public void loadListPayment() {
        Object object = loadFileObject(filename);
        if (object != null) {
            this.hashMap = (HashMap<Integer, ArrayList<Payment>>) object;
            this.listPayment = hashMap.get(idUser);
        }
    }

    public void saveListPayment() {
        if (listPayment == null || listPayment.isEmpty() || idUser < 0) {
            return; // Nothing to save
        }

        if (filename != null && hashMap != null) {
            this.hashMap.put(idUser, listPayment);
            saveFileObject(filename, hashMap);
        }
    }
}
