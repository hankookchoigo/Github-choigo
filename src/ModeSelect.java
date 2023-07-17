import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ModeSelect extends JFrame {
    public ModeSelect() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        
        setTitle("Login");
        setBounds(600, 200, 500, 500);
        setResizable(true);
        
        JLabel label = new JLabel("비밀번호를 입력해 로그인해주세요.");
        label.setBounds(100, 80, 400, 50);
        contentPane.add(label);
        
        JButton loginButton = new JButton("로그인");
        loginButton.setBounds(149, 250, 100, 20);
        contentPane.add(loginButton);
        
        JTextField textField = new JTextField();
        textField.setBounds(149, 200, 100, 30);
        contentPane.add(textField);
        textField.setVisible(true);
        
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(149, 200, 100, 30);
        contentPane.add(passwordField);
        passwordField.setVisible(false);
        
        String switchToPw = "가리기";
        String switchToText = "보이기";
        
        JButton switchButton = new JButton(switchToPw);
        switchButton.setBounds(251, 200, 100, 30);
        contentPane.add(switchButton);
        
        String Mpw = "11111";
        String Upw ="24244";
        
        ActionListener loginListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(switchButton.getText().equals(switchToPw)) {
                    if(textField.getText().equals(Mpw)) {
                        label.setText("관리자로 로그인합니다.");
                        Managermode managermode = new Managermode();
                        dispose();
                    } else if(textField.getText().equals(Upw)) {
                        label.setText("사용자로 로그인합니다.");
                        Usermode usermode = new Usermode();
                        dispose();
                    } else {
                        label.setText("비밀번호가 일치하지 않습니다.");
                        textField.setText("");
                    }
                } else if(switchButton.getText().equals(switchToText)) {
                    if (passwordField.getText().equals(Mpw)) {
                        label.setText("관리자로 로그인합니다.");
                    } else if(passwordField.getText().equals(Upw)) {
                        label.setText("사용자로 로그인합니다.");
                    } else {
                        label.setText("비밀번호가 일치하지 않습니다.");
                        textField.setText("");
                    }
                }
            }
        };
        loginButton.addActionListener(loginListener);
        
        ActionListener switchlistener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(switchButton.getText().equals(switchToPw)) {
                    switchButton.setText(switchToText);
                    textField.setVisible(false);
                    passwordField.setVisible(true);
                    passwordField.setText(textField.getText());
                 } else if(switchButton.getText().equals(switchToText)) {
                    switchButton.setText(switchToPw);
                    textField.setVisible(true);
                    passwordField.setVisible(false);
                    textField.setText(passwordField.getText());
                }
            }
        };
        switchButton.addActionListener(switchlistener);
        
        setVisible(true);
    }
}
