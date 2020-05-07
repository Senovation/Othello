package Login;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Database.Database;
import Game_System.*;

public class LoginFrame extends JFrame{
	JTextField idTextField;
	JPasswordField passwordField;
	Label loginLabel;
	Label passwordLabel;
	JButton loginButton;
	JButton newMember;
	JButton find;
	
	Database data = new Database();
	
	
	LoginFrame(){
		
		
		setTitle("loginWindow");
		setSize(300,260); // JFrame 창 크기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 
		setResizable(false); // 창크기 조절 가불
		setLocationRelativeTo(null);
		//Layout 
		setLayout(null);
		JLayeredPane Layer = new JLayeredPane();
		Layer.setBounds(0,0,400,600);
		Layer.setLayout(null);
		
		idTextField = new JTextField(15);
		idTextField.setBounds(100,20,170,30);
		idTextField.setForeground(Color.black);
		
		passwordField = new JPasswordField(15);
		passwordField.setBounds(100,70,170,30);
		passwordField.setForeground(Color.black);
//		passwordField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		loginLabel = new Label();
//		loginLabel.setBackground(Color.GREEN);
		loginLabel.setBounds(30,20,50,30);
		loginLabel.setText("    ID");
		
		
		passwordLabel = new Label();
//		loginLabel.setBackground(Color.GREEN);
		passwordLabel.setBounds(12,70,80,30);
		passwordLabel.setText(" PASSWORD");
		
		Layer.add(loginLabel);
		Layer.add(passwordLabel);
		Layer.add(idTextField);
		Layer.add(passwordField);
		add(Layer);
		
		loginButton = new JButton("Login");			
		loginButton.setBounds(30, 120, 100, 40);
		add(loginButton);
		
		newMember = new JButton("Sign Up");			
		newMember.setBounds(30, 175, 230, 40);
		add(newMember);
		
		find = new JButton("Find ID");
		find.setBounds(160,120,100,40);
		add(find);
		
		setVisible(true);	// 실행
		
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Music clickmusic = new Music("클릭소리.mp3",false);
				clickmusic.start();
				if(data.Login(idTextField.getText(),passwordField.getText())) {
					Game_System.MainMenu main = new Game_System.MainMenu();
					dispose();
				}else {
					System.out.println("없는 id이거나 비밀번호가 틀립니다.");
//					LoginErrorFrame Errorframe = new LoginErrorFrame();
					JOptionPane.showMessageDialog(null, "없는 id이거나 비밀번호가 틀립니다.","Message",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		newMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Music clickmusic = new Music("클릭소리.mp3",false);
				clickmusic.start();
				newAccountFrame newAccount = new newAccountFrame();
			}
		});
		
		find.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IdFind idfind = new IdFind();
			}
		});
	}
}
