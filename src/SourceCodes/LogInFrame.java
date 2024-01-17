package SourceCodes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import database.DataBase;

import java.net.URI;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.awt.Component;


public class LogInFrame extends MouseAdapter implements ActionListener  {
	
	public JFrame mainFrame;
	private JPanel rightpanel,leftpanel,bgPanel;
	private JButton submitButton, reportIssue;
	private JLabel email,password,loginText,leftIcon,hidePass,showPass;
	private JTextField temail;
	private JPasswordField tpassword;
	private Color bg;
	private ImageIcon show,hide;
	private Cursor handCursor;
	private DataBase data;
	private JLabel warning_error;
	private Desktop reportWebsite;
	private DashBoard dashBoard;

	public LogInFrame()
	{
		
		
		show = new ImageIcon(getClass().getResource("/pictures/show.png"));
		hide = new ImageIcon(getClass().getResource("/pictures/hide.png"));
		
		bg = new Color(0xFFFD59);
	
		
		reportWebsite = Desktop.getDesktop();
		handCursor = new Cursor(Cursor.HAND_CURSOR);
		
		
		data = new DataBase();
		
		setFrame();
		setPanel();
		setButton();
		setLabel_SetTextField();
	
		addElements();
		rightpanel.revalidate();
		rightpanel.repaint();
		
	}
	private ImageIcon loadImage(String url) {
		try {
		BufferedImage image = ImageIO.read(new File(url));
		ImageIcon icon = new ImageIcon(image);
		return icon;
		}
		catch (IOException e) {
			JOptionPane.showMessageDialog(mainFrame,"Error, Cannot load the picutre","Error",JOptionPane.ERROR_MESSAGE);
		}
		JOptionPane.showMessageDialog(mainFrame,"Error, Cannot load the picutre","Error",JOptionPane.ERROR_MESSAGE);
		return null;
		
	}
	private ImageIcon setIconn(String url,JLabel label) {
		
		Image i = loadImage(url).getImage().getScaledInstance(label.getHeight(), label.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon();
		icon.setImage(i);
		return icon;
	}

	private void addElements() {
		
		rightpanel.add(loginText);
		rightpanel.add(email);
		rightpanel.add(password);
		//rightpanel.add(leftIcon);
		rightpanel.add(showPass);
		rightpanel.add(hidePass);
		rightpanel.add(temail);
		rightpanel.add(tpassword);
		
		rightpanel.add(submitButton);
		rightpanel.add(reportIssue);
		rightpanel.add(warning_error);
		
	
		leftpanel.add(leftIcon,BorderLayout.CENTER);
	
			
			
		bgPanel.add(rightpanel,BorderLayout.CENTER);
		bgPanel.add(leftpanel,BorderLayout.WEST);
		mainFrame.getContentPane().add(bgPanel,BorderLayout.CENTER);
		
	}
	private void setLabel_SetTextField() {
		email = new JLabel("Email Address: ");
		email.setFont(new Font("Tahoma", Font.BOLD, 20));
		email.setBounds(10, 168, 178, 45);
		
		password = new JLabel("Password: ");
		password.setFont(new Font("Tahoma", Font.BOLD, 20));
		password.setBounds(10, 260, 133, 25);
		
		loginText = new JLabel("Login");
		loginText.setFont(new Font("Segoe UI Black", Font.PLAIN, 47));
		loginText.setForeground(Color.black);
		loginText.setBounds(143,75,178, 60);
		
		
		leftIcon = new JLabel();
		leftIcon.setSize(325, mainFrame.getHeight());
		leftIcon.setBackground(Color.green);
		leftIcon.setIcon(setIconn("src/pictures/nova.jpg",leftIcon));
		
		
		
		temail = new JTextField();
		temail.setFont(new Font("Tahoma",Font.PLAIN,20));
		temail.setBounds(11, 211, 333, 39);
		temail.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		tpassword = new JPasswordField();
		tpassword.setFont(new Font("Tahoma",Font.PLAIN,20));
		tpassword.setBounds(10, 295, 333, 39);
		tpassword.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		tpassword.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar() == '\n')
					evalInput();
			}

		
			
		});
		
		hidePass = new JLabel();
		hidePass.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		hidePass.setAlignmentX(Component.CENTER_ALIGNMENT);
		hidePass.setAlignmentY(Component.CENTER_ALIGNMENT);
		hidePass.setIcon(hide);
		hidePass.setBounds(347, 303, 30, 25);
		hidePass.setVerticalAlignment(JLabel.CENTER);
		hidePass.setHorizontalAlignment(JLabel.CENTER);
		//hidePass.setBorder(BorderFactory.createLineBorder(Color.black));
		
		
		
		
		
		showPass = new JLabel();
		showPass.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		showPass.setAlignmentX(Component.CENTER_ALIGNMENT);
		showPass.setAlignmentY(Component.CENTER_ALIGNMENT);
		showPass.setIcon(show);
		showPass.setBounds(347, 303, 30, 25);
		showPass.setVerticalAlignment(JLabel.CENTER);
		showPass.setHorizontalAlignment(JLabel.CENTER);
		
		

		showPass.setVisible(false);

		hidePass.addMouseListener(new MouseAdapter() {
			
			@Override
				public void mousePressed(MouseEvent e) {
					if(e.getSource() == hidePass) {
						showPass.setVisible(true);
						hidePass.setVisible(false);
						tpassword.setEchoChar((char)0);
					}
					
				}
			@Override
				public void mouseReleased(MouseEvent e) {
				hidePass.setVisible(true);
				showPass.setVisible(false);
				tpassword.setEchoChar('\u25cf');
			}
		
			});
		
		//------------------------------------------
		tpassword.addFocusListener(new FocusAdapter() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        hidePass.setVisible(true);
		        showPass.setVisible(true);
		    }

		    @Override
		    public void focusLost(FocusEvent e) {
		        hidePass.setVisible(false);
		        showPass.setVisible(false);
		    }
		});
		temail.addFocusListener(new FocusAdapter() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        hidePass.setVisible(true);
		        showPass.setVisible(true);
		    }

		    @Override
		    public void focusLost(FocusEvent e) {
		        if (!email.getText().isEmpty()) {
		            hidePass.setVisible(false);
		            showPass.setVisible(false);
		        }
		    }
		});

	
		///////-------------------------------------
		
		warning_error = new JLabel("Input correct \n Email Address and Password");
		warning_error.setFont(new Font("Tahoma", Font.BOLD, 13));
		warning_error.setForeground(new Color(254, 12, 18));
		warning_error.setBounds(31, 334, 343, 25);
		warning_error.setIconTextGap(2);
		warning_error.setVisible(false);
		
	}
	private void setButton() {
		submitButton = new JButton("Submit");

		submitButton.setFocusable(true);
		submitButton.setBackground(Color.white);
		submitButton.setBorder(BorderFactory.createEtchedBorder());
		submitButton.setFont(new Font("Tahoma", Font.BOLD, 19));
		submitButton.setBounds(260, 360, 100, 45);
		submitButton.setCursor(handCursor);
		submitButton.addActionListener(this);
		submitButton.setBorder(BorderFactory.createLineBorder(Color.black,1));
		
		reportIssue = new JButton("Report Issue");
		reportIssue.setContentAreaFilled(false);
		reportIssue.setFocusable(true);
		reportIssue.setBackground(bg);
		reportIssue.setBorder(null);
		reportIssue.setFont(new Font("Dialog", Font.PLAIN, 15));
		reportIssue.setBounds(143, 437, 107, 39);
		reportIssue.addActionListener(this);
		reportIssue.setCursor(handCursor);
		
	
		//leftIcon.setBounds(320, 294, 40, 30);
	
	}
	private void setPanel() {

		bgPanel = new JPanel();
		bgPanel.setPreferredSize(new Dimension(mainFrame.getWidth(),mainFrame.getHeight()));
		bgPanel.setLayout(new BorderLayout());
		
		rightpanel =new JPanel();
		rightpanel.setPreferredSize(new Dimension(385, mainFrame.getWidth()));
		rightpanel.setBackground(bg);
		rightpanel.setLayout(null);

		leftpanel = new JPanel();
		leftpanel.setPreferredSize(new Dimension(325, mainFrame.getWidth()));
		leftpanel.setBackground(new Color(0x25A561));
		leftpanel.setLayout(new BorderLayout());
		
		
	}
	private void setFrame() {
		mainFrame = new JFrame("Log in Frame");
		mainFrame.setResizable(false);
		mainFrame.setUndecorated(true);
		
		mainFrame.pack();
		mainFrame.setSize(720,520);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setShape(new RoundRectangle2D.Double(0, 0,   mainFrame.getWidth(), mainFrame.getHeight(),  50,  50));
		mainFrame.setLocationRelativeTo(null);
		mainFrame.getContentPane().setLayout(new BorderLayout());
		mainFrame.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
		
		
		
	}
	public void showFrame(boolean isShowing) {
		mainFrame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource() == submitButton)
		{		
				
				evalInput();
		}
		if(e.getSource() == reportIssue) {
			openWebPage("https://helpdesk.sti.edu/User/Login?ReturnUrl=%2f");
		}
		
	}
	private void evalInput() {
		String uemail = temail.getText().toLowerCase().trim();
		String upassword = String.valueOf(tpassword.getPassword());
	
	if(!uemail.isEmpty() && !upassword.isEmpty()) {
		if(DataBase.isInputInDB(uemail, upassword))
		{
		
			tpassword.setBorder(BorderFactory.createLineBorder(Color.black,1));
			warning_error.setVisible(false);
			DataBase.Datas();
                                               
			JOptionPane.showMessageDialog(mainFrame, "Login Successful");
                                                    temail.setText(""); tpassword.setText("");
			mainFrame.dispose();                           
			DashBoard.setUserDataInstance(data);
			dashBoard = new DashBoard();
			dashBoard.setFrameVisible(true);
					
				
		
		}
		else 
		{	
			JOptionPane.showMessageDialog(mainFrame, "Wrong email/Password. \nTry Again.","Error",JOptionPane.PLAIN_MESSAGE);
			tpassword.setBorder(BorderFactory.createLineBorder(Color.red,3));
			warning_error.setVisible(true);
		}
	}
	else {
		JOptionPane.showMessageDialog(mainFrame, "You cannot leave field blank","Error",JOptionPane.ERROR_MESSAGE
                
                
                );
	}
	}
		public void openWebPage(String url){
		   try {         
		    reportWebsite.browse(URI.create(url));
		   }
		   catch (IOException e) {
                                        JOptionPane.showMessageDialog(mainFrame, "Cannot Conenct to web page", "Error",JOptionPane.ERROR_MESSAGE);
		   }
		}
		
}