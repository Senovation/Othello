package Login;

import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class LoginErrorFrame extends JFrame{
	Label Error;
	
	LoginErrorFrame(){
		setSize(250,100);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 종료 
		setResizable(false); // 창크기 조절 가불
		setLocationRelativeTo(null);
		
		JLayeredPane Layer = new JLayeredPane();
		Layer.setBounds(0,0,400,600);
		Layer.setLayout(null);
		
		Error = new Label();
		Error.setBounds(25,10,210,60);
		Error.setText("없는 ID이거나 비밀번호가 틀립니다.");
		
		Layer.add(Error);
		add(Layer);
		setVisible(true);
	}
}
