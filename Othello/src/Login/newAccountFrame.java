package Login;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Database.Database;

public class newAccountFrame extends JFrame{
	Database data = new Database();
	
	JTextField idField;
	JTextField nickNameField;
	JTextField nameField;
	JTextField FirstemailField; JTextField secondemailField;
	JTextField FirstphoneField; JTextField secondphoneField;
	JTextField thirdphoneField;
	
	JPasswordField passwordField;
	JPasswordField RepasswordField;
	
	Label MainMenu;
	Label idLabel;
	Label passwordLabel;
	Label RepasswordLabel;
	Label nicknameLabel;
	Label nameLabel;
	Label phoneNumLabel;
	Label emailLabel;
	
	JButton ConfirmID;
	JButton ConfirmNickName;
	JButton SignUp;
	
	Boolean idJudge = false;
	Boolean nickNameJudge = false;
	String idBox = "";
	String nickNameBox = "";
	
	newAccountFrame(){
		setSize(400,600);
		setTitle("signUp");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		
		JLayeredPane Layer = new JLayeredPane();
		Layer.setBounds(0,0,400,600);
		Layer.setLayout(null);
		
		idField = new JTextField(15);
		idField.setBounds(130,100,150,30);
		idField.setForeground(Color.black);
	
		passwordField = new JPasswordField(15);
		passwordField.setBounds(130,160,150,30);
		passwordField.setForeground(Color.black);
		
		RepasswordField = new JPasswordField(15);
		RepasswordField.setBounds(130,220,150,30);
		RepasswordField.setForeground(Color.black);
		
		nickNameField = new JTextField(15);
		nickNameField.setBounds(130,280,150,30);
		nickNameField.setForeground(Color.black);
		
		nameField = new JTextField(15);
		nameField.setBounds(130,340,150,30);
		nameField.setForeground(Color.black);
		
		FirstphoneField = new JTextField(15);
		FirstphoneField.setBounds(130,400,50,30);
		FirstphoneField.setForeground(Color.black);
		
		secondphoneField = new JTextField(15);
		secondphoneField.setBounds(200,400,60,30);
		secondphoneField.setForeground(Color.black);
		
		thirdphoneField = new JTextField(15);
		thirdphoneField.setBounds(280,400,60,30);
		thirdphoneField.setForeground(Color.black);
		
		FirstemailField = new JTextField(15);
		FirstemailField.setBounds(130,460,100,30);
		FirstemailField.setForeground(Color.black);
		
		secondemailField = new JTextField(15);
		secondemailField.setBounds(250,460,100,30);
		secondemailField.setForeground(Color.black);
		
		Layer.add(idField);
		Layer.add(passwordField);
		Layer.add(RepasswordField);
		Layer.add(nickNameField);		
		Layer.add(nameField);
		Layer.add(FirstphoneField);
		Layer.add(secondphoneField);
		Layer.add(thirdphoneField);
		Layer.add(FirstemailField);
		Layer.add(secondemailField);
		//Label
		MainMenu = new Label("New Account");
		MainMenu.setBounds(120,20,360,60);
		MainMenu.setFont(new Font("Serif",Font.PLAIN,30));
		
		idLabel = new Label();
		idLabel.setBounds(30,100,80,30);
		idLabel.setText("I D");
		
		passwordLabel = new Label();
		passwordLabel.setBounds(30,160,80,30);
		passwordLabel.setText("PASSWORD");
		
		RepasswordLabel = new Label();
		RepasswordLabel.setBounds(30,220,100,30);
		RepasswordLabel.setText("ConfirmPass");
		
		nicknameLabel = new Label();
		nicknameLabel.setBounds(30,280,100,30);
		nicknameLabel.setText("NickName");
		
		nameLabel = new Label();
		nameLabel.setBounds(30,340,100,30);
		nameLabel.setText("Name");
		
		phoneNumLabel = new Label();
		phoneNumLabel.setBounds(30,400,100,30);
		phoneNumLabel.setText("PhoneNum");
		
		emailLabel = new Label();
		emailLabel.setBounds(30,460,100,30);
		emailLabel.setText("Email");
		
		Layer.add(MainMenu);
		Layer.add(idLabel);
		Layer.add(passwordLabel);
		Layer.add(RepasswordLabel);
		Layer.add(nicknameLabel);
		Layer.add(nameLabel);
		Layer.add(phoneNumLabel);
		Layer.add(emailLabel);
		
		ConfirmID = new JButton("Confirm");
		ConfirmID.setBounds(300,100,80,30);
		
		ConfirmNickName = new JButton("Confirm");
		ConfirmNickName.setBounds(300,280,80,30);
		
		SignUp = new JButton("Sign Up");
		SignUp.setBounds(50,520,300,40);
		
		Layer.add(ConfirmID);
		Layer.add(ConfirmNickName);
		Layer.add(SignUp);
		
		Label  phoneEffect = new Label("-");
		phoneEffect.setFont(new Font("Serif",Font.PLAIN,20));
		phoneEffect.setBounds(183,400,15,30);
		Layer.add(phoneEffect);
		Label phoneEffect2 = new Label("-");
		phoneEffect2.setFont(new Font("Serif",Font.PLAIN,20));
		phoneEffect2.setBounds(263,400,15,30);
		Layer.add(phoneEffect2);
		Label emailEffect2 = new Label("@");
		emailEffect2.setFont(new Font("Serif",Font.PLAIN,14));
		emailEffect2.setBounds(230,460,15,30);
		Layer.add(emailEffect2);
		
		ConfirmID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(data.idConfirm(idField.getText()) != null) {
					System.out.println("id 중복");
					JOptionPane.showMessageDialog(null, "ID중복", "Message", JOptionPane.ERROR_MESSAGE);
					idJudge = false;
				}else {
					if(idField.getText().length() > 4 ) {
						System.out.println("만들수 있는 id");
						JOptionPane.showMessageDialog(null, "만들수 있는 ID", "Message", JOptionPane.INFORMATION_MESSAGE);
						idJudge = true;
						idBox = idField.getText();
					}else {
						System.out.println("id가 너무 짧습니다.");
						JOptionPane.showMessageDialog(null, "id가 너무 짧습니다.\n다섯글자 이상해주시기 바랍니다.", "Message", JOptionPane.ERROR_MESSAGE);
						idJudge = false;
					}
					
				}
			}
		});
		
		ConfirmNickName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(data.nickNameConfirm(nickNameField.getText()) != null) {
					System.out.println("NickName 중복");
					JOptionPane.showMessageDialog(null, "NickName 중복", "Message", JOptionPane.ERROR_MESSAGE);
					nickNameJudge = false;
				}else {
					if(nickNameField.getText().length() > 1 ) {
						System.out.println("만들수 있는 NickName");
						JOptionPane.showMessageDialog(null, "만들수 있는 NickName", "Message", JOptionPane.INFORMATION_MESSAGE);
						nickNameJudge = true;
						nickNameBox = nickNameField.getText();
					}else {
						System.out.println("NickName이 너무 짧습니다.\n두 글자 이상 해주시기 바랍니다.");
						JOptionPane.showMessageDialog(null, "NickName이 너무 짧습니다.\n두 글자 이상 해주시기 바랍니다.", "Message", JOptionPane.ERROR_MESSAGE);
						nickNameJudge = false;
					}
					
				}
			}
		});
		
		Boolean signUpJudge = false;
		SignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((idJudge == true && idBox.equals(idField.getText())) &&
				   (nickNameJudge == true && nickNameBox.equals(nickNameField.getText())) &&
				   passwordField.getText().equals(RepasswordField.getText()) && 
				   passwordField.getText() != null && nickNameField.getText() != null &&
				   nameField.getText() != null && FirstphoneField.getText() != null &&
				   secondphoneField.getText() != null && thirdphoneField.getText() != null &&
				   FirstemailField.getText() != null && secondemailField.getText() != null) {
					data.insert(idField.getText(),passwordField.getText(), nickNameField.getText(), nameField.getText(), 
							  FirstphoneField.getText()+"-"+secondphoneField.getText()+"-"+thirdphoneField.getText(), 
							  FirstemailField.getText()+"@"+secondemailField.getText());
					dispose();
					JOptionPane.showMessageDialog(null, "ID를 성공적으로 만들었습니다.", "Message", JOptionPane.INFORMATION_MESSAGE);
				}else if(idJudge == false || (idJudge == true && !idBox.equals(idField.getText()))){
					JOptionPane.showMessageDialog(null, "ID중복 확인 바랍니다.", "Message", JOptionPane.ERROR_MESSAGE);
				}else if(nickNameJudge == false || (nickNameJudge == true && !nickNameBox.equals(nickNameField.getText()))) {
					JOptionPane.showMessageDialog(null, "nickName중복 확인 바랍니다.", "Message", JOptionPane.ERROR_MESSAGE);
				}
				else {
					System.out.println("등록안됬습니다.");
					JOptionPane.showMessageDialog(null, "모든 내용 기입바랍니다.", "Message", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		add(Layer);
		setVisible(true);
		
		/*Font font1 = new Font("SansSerif", Font.BOLD, 20);
		JTextField textfield = new JTextField (); 
		 
		textfield.setFont(font1);*/
	}
}
