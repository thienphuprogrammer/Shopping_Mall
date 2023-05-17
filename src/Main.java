import Shopping_Mall.CommonFunction.ListProduct;
//import Shopping_Mall.UserObject.User;
import CommonFunction.AdminObject;
import CommonFunction.LoginObject;

import java.util.Scanner;
import Shopping_Mall.UserObject.User;

public class Main {
    public static void main(String[] args) {
        ListProduct listProduct = new ListProduct();
        listProduct.loadListProduct("product.bin");


        new User();

        listProduct.saveListProduct("product.bin");
        Scanner sc = new Scanner(System.in);

        System.out.print("Username: ");
        String username = sc.next();

        System.out.print("Password: ");
        int password = sc.nextInt();

        LoginObject.Login(username, password);
    }
}