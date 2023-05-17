import Shopping_Mall.CommonFunction.ListProduct;
import Shopping_Mall.UserObject.User;

public class Main {
    public static void main(String[] args) {
        ListProduct listProduct = new ListProduct();
        listProduct.loadListProduct("product.bin");


        new User();

        listProduct.saveListProduct("product.bin");
    }
}