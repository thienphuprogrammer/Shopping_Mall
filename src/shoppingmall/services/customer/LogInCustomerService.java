package shoppingmall.services.customer;

public class LogInCustomerService extends CustomerService {

    public LogInCustomerService(String file) {
        super(file);
    }
    public CustomerService logIn(String str, String password) { //str is user name or email
        this.customer = checkAccount(str, password);
        if (customer!= null) {
            return this;
        }
        return null;
    }

}
