import Shopping_Mall.CommonFunction.ListProduct;
import Shopping_Mall.CommonFunction.Product;

public class Main {
    public static void main(String[] args) {
        ListProduct listProduct = new ListProduct();
//        listProduct.addProduct(new Product("", "","", "", (float) 0.0F, 0));

        listProduct.loadListProduct("product.bin");
        listProduct.showListProduct();
        listProduct.saveListProduct("product.bin");
    }
}