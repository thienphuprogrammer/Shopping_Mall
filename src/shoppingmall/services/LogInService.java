package shoppingmall.services;

import shoppingmall.models.Customer;

public class LogInService extends CustomerService{

    public LogInService(String file) {
        super(file);
    }
    public CustomerService logInCustomer(String str, String password) { //str is user name or email
        this.customer = checkAccount(str, password);
        if (customer!= null) {
            return this;
        }
        return null;
    }

}
