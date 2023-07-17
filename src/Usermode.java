import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Usermode extends JFrame {
    ArrayList<Product> cart = new ArrayList<>();
    ArrayList<Product> productList = new ArrayList<>();
    public Usermode() {
        super("Kiosk");
        JLabel label = new JLabel("한예준");
        label.setSize(10, 20);
        label.setBounds(100, 200, 10, 20);
        add(label);
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
}

    public static void main(String[] rgs) {
        new Usermode();
    }
}
