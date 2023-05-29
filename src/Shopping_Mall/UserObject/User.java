package Shopping_Mall.UserObject;
import Shopping_Mall.CommonFunction.Account.InfoUser;

import java.util.ArrayList;

import static Shopping_Mall.CommonFunction.Account.AccountUser.AccountUser;

public class User {
    private ArrayList<MenuProductUSer> menuProducts = new ArrayList<>();
    public User() {
        MenuProductUSer listProduct = new MenuProductUSer();
        listProduct.loadListProduct("src/Data/product.bin");

        InfoUser statusLogIn = AccountUser();
//        int statusLogIn = 0;
        if (statusLogIn != null) {
            new MenuUser(statusLogIn);
        }
    }

    void menuChoice() {


    }

    private void LogOut() {
        ;
    }
}
