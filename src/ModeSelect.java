import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModeSelect extends JFrame implements ActionListener {
    /*
    초기 비밀번호 창을 띄워서 관리자 혹은 사용자로 로그인하도록 하고
    비밀번호가 그 어느것에도 일치하지 않을 시 다시 입력하게 유도한다.
     */
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    // 각각 라벨 패널과 패스워드 패널을 생성
    
    JLabel label = new JLabel("아래 칸에 비밀번호를 입력해주세요.");
    JLabel pwdLabel = new JLabel("password: ");
    JTextField pwdField = new JTextField(15);
    public ModeSelect() {
        super("순자네 편의점");
        // 제목 설정
        
        Box labelBox = Box.createHorizontalBox();
        Box pwdBox = Box.createHorizontalBox();
        // 박스 설정
        
        labelBox.add(label);
        labelBox.add(Box.createVerticalStrut(10));
        // 라벨 박스에 컴포넌트 추가
        
        pwdBox.add(pwdLabel);
        pwdBox.add(pwdField);
        //
        
        setSize(250, 100);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
    }
    
    public static void main(String[] args) {
        ModeSelect modeSelect = new ModeSelect();
    }
}
