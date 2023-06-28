package shoppingmall.views;

import static shoppingmall.utils.InputUtil.*;

public class StandardView {
    public static void waitForInput() {
        System.out.println("+------------------------------------------------------+");
        System.out.println("Nhấn phím bất kỳ để trở về menu.");
        readString("");
        for(int i = 0; i < 100; i++) System.out.println(" ");
    }
}
