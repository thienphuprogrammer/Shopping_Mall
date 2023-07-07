package shoppingmall.services.admin;

import shoppingmall.models.admin.BrowseProduct;
import shoppingmall.models.customer.Payment;
import shoppingmall.models.product.Product;
import shoppingmall.services.productService.ProductService;

import java.util.ArrayList;

import static shoppingmall.utils.FileUtil.loadFileObject;
import static shoppingmall.utils.FileUtil.saveFileObject;
import static shoppingmall.utils.OutputUtil.printValue;
import static shoppingmall.utils.OutputUtil.printValueln;

public class BrowseProductService {
    private ArrayList<BrowseProduct> listUnapprovedProduct = new ArrayList<>();
    private ArrayList<BrowseProduct> listApprovedProduct = new ArrayList<>();
    private String filenameUnapprovedProduct;
    private String filenameApprovedProduct;

    // -----------------Getter and setter--------------

    public ArrayList<BrowseProduct> getListUnapprovedProduct() {
        return listUnapprovedProduct;
    }

    public void setListUnapprovedProduct(ArrayList<BrowseProduct> listUnapprovedProduct) {
        this.listUnapprovedProduct = listUnapprovedProduct;
    }

    public String getFilenameUnapprovedProduct() {
        return filenameUnapprovedProduct;
    }

    public void setFilenameUnapprovedProduct(String filenameUnapprovedProduct) {
        this.filenameUnapprovedProduct = filenameUnapprovedProduct;
    }


    public ArrayList<BrowseProduct> getListApprovedProduct() {
        return listApprovedProduct;
    }

    public void setListApprovedProduct(ArrayList<BrowseProduct> listApprovedProduct) {
        this.listApprovedProduct = listApprovedProduct;
    }

    public String getFilenameApprovedProduct() {
        return filenameApprovedProduct;
    }

    public void setFilenameApprovedProduct(String filenameApprovedProduct) {
        this.filenameApprovedProduct = filenameApprovedProduct;
    }

    // -----------------Constructor-------------------


    public BrowseProductService(String filenameUnapprovedProduct, String filenameApprovedProduct) {
        this.filenameUnapprovedProduct = filenameUnapprovedProduct;
        this.filenameApprovedProduct = filenameApprovedProduct;
        loadListBrowseProduct();
    }

    // -----------------Method-------------------

    public void browseProduct(ProductService productService) {
        for(BrowseProduct browseProduct: listApprovedProduct) {
            for(int i = 0; i < productService.getListProduct().size(); i++) {
                if(browseProduct.getProduct().getId() == productService.getListProduct().get(i).getId()) {
                    productService.getListProduct().get(i).setCount(productService.getListProduct().get(i).getCount() - browseProduct.getProduct().getCount());
                }
            }
        }
        listApprovedProduct.addAll(listUnapprovedProduct);
        listUnapprovedProduct.clear();
        saveListBrowseProduct();
        productService.saveListProduct();
    }

    public void viewPendingApprovalProduct() {
        if (listUnapprovedProduct.size() == 0) {
            printValueln("Danh sách hàng đang trống!!!");
        } else {
            for (Payment payment : listUnapprovedProduct) {
                printValue("| Payment ID : " + payment.getPaymentId() + " ".repeat(25 - String.valueOf(payment.getPaymentId()).length()) + "|");
                printValue("Customer ID : " + payment.getCustomerId() + " ".repeat(25 - String.valueOf(payment.getCustomerId()).length()) + "|");
                printValue("Product ID  : " + payment.getProduct().getId() + " ".repeat(25 - String.valueOf(payment.getProduct().getId()).length()) + "|");
                printValue("Count  : " + payment.getProduct().getCount() + " ".repeat(25 - String.valueOf(payment.getProduct().getId()).length()) + "|");
                printValue("Price  : " + payment.getProduct().getPrice() + " ".repeat(25 - String.valueOf(payment.getProduct().getId()).length()) + "|");
                printValueln(" Date : " + payment.getPaymentDate() + " ".repeat(25 - payment.getPaymentDate().length()) + "|");
            }
        }
    }

    public void viewApprovedProduct() {
        if (listApprovedProduct.size() == 0) {
            printValueln("Danh sách hàng đang trống!!!");
        } else {
            for (Payment payment : listApprovedProduct) {
                printValue("| Payment ID : " + payment.getPaymentId() + " ".repeat(25 - String.valueOf(payment.getPaymentId()).length()) + "|");
                printValue("Customer ID : " + payment.getCustomerId() + " ".repeat(25 - String.valueOf(payment.getCustomerId()).length()) + "|");
                printValue("Product ID  : " + payment.getProduct().getId() + " ".repeat(25 - String.valueOf(payment.getProduct().getId()).length()) + "|");
                printValue("Count  : " + payment.getProduct().getCount() + " ".repeat(25 - String.valueOf(payment.getProduct().getId()).length()) + "|");
                printValue("Price  : " + payment.getProduct().getPrice() + " ".repeat(25 - String.valueOf(payment.getProduct().getId()).length()) + "|");
                printValueln(" Date : " + payment.getPaymentDate() + " ".repeat(25 - payment.getPaymentDate().length()) + "|");
            }
        }
    }

    public void loadListBrowseProduct() {
        Object object = loadFileObject(filenameUnapprovedProduct);
        if (object != null) {
            this.listUnapprovedProduct = (ArrayList<BrowseProduct>) object;
        }

        object = loadFileObject(filenameApprovedProduct);
        if (object != null) {
            this.listApprovedProduct = (ArrayList<BrowseProduct>) object;
        }
    }

    public void saveListBrowseProduct() {
        if (filenameUnapprovedProduct != null || listApprovedProduct != null) {
            saveFileObject(filenameUnapprovedProduct, listUnapprovedProduct);
            saveFileObject(filenameApprovedProduct, listApprovedProduct);
        }
    }
}
