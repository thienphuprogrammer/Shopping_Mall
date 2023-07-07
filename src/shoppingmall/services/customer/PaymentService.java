package shoppingmall.services.customer;

import shoppingmall.models.customer.Order;
import shoppingmall.models.customer.Payment;

import java.time.LocalDate;
import java.util.ArrayList;

import static shoppingmall.utils.FileUtil.loadFileObject;
import static shoppingmall.utils.FileUtil.saveFileObject;
import static shoppingmall.utils.OutputUtil.printValue;
import static shoppingmall.utils.OutputUtil.printValueln;

public class PaymentService {
    // -----------------Property------------------
    private ArrayList<Payment> listPayment = new ArrayList<>();
    private ArrayList <Payment> newListPayment = new ArrayList<>();
    private String filenameOrder;
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
        this.filenameOrder = filename;
        this.idUser = idUser;
        loadListPayment();
    }

    // -----------------Method-------------------
    public void buyProducts(ArrayList<Order> orders, int idUser) {
        for(Order order: orders) {
            String currentDate = LocalDate.now().toString();
            newListPayment.add(new Payment(newListPayment.size(), order.getProduct(), currentDate, idUser));
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
        Object object = loadFileObject(filenameOrder);
        if (object != null) {
            newListPayment = (ArrayList<Payment>) object;
        }

        for (Payment payment: newListPayment) {
            if (payment.getCustomerId() == idUser) {
                listPayment.add(payment);
            }
        }
    }

    public void saveListPayment() {
        if (idUser < 0) {
            return; // Nothing to save
        }

        if (filenameOrder != null) {
            saveFileObject(filenameOrder, newListPayment);
        }
    }
}
