package Shopping_Mall.Admin;

public class LoginObject {

    // Hàm đăng nhập
    public static final void Login(String Username, int Password) {
        while (true) {
            // Tài khoản Admin
            if (Username.equals("Admin") && Password == 123456789) {
                AdminObject.ShowAdminMenu();
             // tài khoản User
            } else if (Username.equals("User") && Password == 987654321) {
                System.out.println("None function");// thay thế ở đây
            } else {
                System.out.println("Your Username or Password is incorrect");
                break;
            } 
        }
    }
}
