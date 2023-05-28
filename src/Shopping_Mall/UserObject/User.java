package Shopping_Mall.UserObject;
import java.util.ArrayList;

import static Shopping_Mall.CommonFunction.Account.AccountUser.AccountUser;

public class User {
    private ArrayList<MenuProductUSer> menuProducts = new ArrayList<>();
    public User() {
        MenuProductUSer listProduct = new MenuProductUSer();
        listProduct.loadListProduct("src/Data/product.bin");

//        int statusLogIn = AccountUser();
        int statusLogIn = 0;
        if (statusLogIn != -1) {
            new MenuUser(statusLogIn);
        }
    }

    void menuChoice() {


    }

    private void LogOut() {
        ;
    }
}
