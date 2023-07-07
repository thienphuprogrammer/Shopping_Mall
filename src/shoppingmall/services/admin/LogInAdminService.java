package shoppingmall.services.admin;

public class LogInAdminService extends AdminService {

    public LogInAdminService(String filename) {
        super();
    }
    public AdminService logIn(String str, String password) { //str is user name or email
        this.admin = checkAccount(str, password);
        if (admin!= null) {
            return this;
        }
        return null;
    }

}
