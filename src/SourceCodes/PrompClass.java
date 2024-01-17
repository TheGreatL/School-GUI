package SourceCodes;

import static SourceCodes.GradePanelComponents.gradeTable;
import database.DataBase;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class PrompClass {
                private static int num = 0;
	private static String textReturn = "";
	protected static PrompClass thes = new PrompClass();
	//protected static DashBoard d = new DashBoard();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private static String changedBio;
    private static String newPassword;

	/*
	protected static String showInputToDoList(JComponent plusIcon) {
                    
		JOptionPane pane  = new JOptionPane();
		
		Color textColor = Color.white;
		
		JPanel topPanel = new JPanel();
		topPanel.setPreferredSize(new Dimension(200,40));
		topPanel.setBackground(Color.red);
		topPanel.setLayout(null);
		
		JPanel belowPanel = new JPanel();
		belowPanel.setPreferredSize(new Dimension(200,40));
		belowPanel.setBackground(Color.LIGHT_GRAY);
		belowPanel.setLayout(null);

		
		JLabel exitButton = new JLabel("X");
		exitButton.setBounds(755, 0, 40, 40);
		exitButton.setFont(new Font("Arial Rounded MT Bold",Font.BOLD,40));
		exitButton.setForeground(textColor);
		exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		exitButton.setHorizontalAlignment(JLabel.CENTER);
		exitButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
					thes.dispose();
                     plusIcon.setEnabled(true);	
				
			}		

			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setForeground(Color.BLUE);
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setForeground(textColor);
				
			}
			
		});
		
		 isClicked = false;
		JLabel todoTxt = new JLabel("Add to-do item");
		todoTxt.setBounds(-132, 0, 500, 40);
		todoTxt.setHorizontalAlignment(JLabel.CENTER);
		todoTxt.setForeground(textColor);
		todoTxt.setFont(new Font("Arial Rounded MT Bold",Font.BOLD,30));
		
		JTextField todoDesc = new JTextField();
		todoDesc.setBounds(9, 55, 780, 100);
		todoDesc.setFont(new Font("Arial Rounded MT Bold",Font.BOLD,25));
		todoDesc.setBorder(BorderFactory.createSoftBevelBorder(3));
		
		JLabel saveButton = new JLabel("Save");
		saveButton.setBounds(750, 0, 40, 40);
		saveButton.setFont(new Font("Arial Rounded MT Bold",Font.BOLD,15));
		saveButton.setBorder(BorderFactory.createEmptyBorder());
		   textReturn = null;
                   
        saveButton.addMouseListener(new MouseAdapter(){
                    @Override
                    public void mouseClicked(MouseEvent e) {
                    	textReturn = todoDesc.getText();
                    	 todoDesc.setText("");
                    	 isClicked =true;
                                    
                    }
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        saveButton.setForeground(Color.blue);
                        
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        saveButton.setForeground(textColor);
                    }
              
                                        
                                    });
	
              
		thes.setUndecorated(true);
		thes.setLayout(new BorderLayout());
		thes.setPreferredSize(new Dimension(800,250));
		thes.pack();
		thes.setLocationRelativeTo(d.mainFrame);
		//thes.setLocationRelativeTo(null);
		
		topPanel.add(todoTxt);
		topPanel.add(exitButton);
		belowPanel.add(saveButton);
		
		thes.add(topPanel,BorderLayout.NORTH);
		thes.add(todoDesc,BorderLayout.CENTER);
		thes.add(belowPanel,BorderLayout.SOUTH);
		
		//thes.add(pane, BorderLayout.CENTER);
		
		thes.setVisible(true);
		
	System.out.println("s");
	return textReturn;
         
	
	}
	
	
	*/
	public static String getTXT() {
		return textReturn;
	}

	protected static void showInputToDoList(JComponent plusIcon) {
 
                                JDialog thes = new JDialog();

		
		Color textColor = Color.white;
		
		JPanel topPanel = new JPanel();
		topPanel.setPreferredSize(new Dimension(200,40));
		topPanel.setBackground(Color.red);
		topPanel.setLayout(null);
		
		JPanel belowPanel = new JPanel();
		belowPanel.setPreferredSize(new Dimension(200,40));
		belowPanel.setBackground(Color.LIGHT_GRAY);
		belowPanel.setLayout(null);

                                    JLabel todoTxt = new JLabel("Add to-do item");
		todoTxt.setBounds(-132, 0, 500, 40);
		todoTxt.setHorizontalAlignment(JLabel.CENTER);
		todoTxt.setForeground(textColor);
		todoTxt.setFont(new Font("Arial Rounded MT Bold",Font.BOLD,30));
		
		JTextArea todoDesc = new JTextArea();
		todoDesc.setBounds(9, 55, 780, 100);
		todoDesc.setFont(new Font("Arial Rounded MT Bold",Font.BOLD,25));
		todoDesc.setBorder(BorderFactory.createSoftBevelBorder(3));
	
		JScrollPane sp = new JScrollPane(todoDesc);
                
		JButton saveButton = new JButton("Save");
		saveButton.setBounds(750, 0, 40, 40);
                                   saveButton.setForeground(Color.WHITE);
		saveButton.setFont(new Font("Arial Rounded MT Bold",Font.BOLD,15));
		saveButton.setBorder(BorderFactory.createEmptyBorder());
                                   saveButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		saveButton.setContentAreaFilled(false);
                                           saveButton.setFocusable(false);
		JButton exitButton = new JButton("X");
		exitButton.setBounds(720, 0, 100, 40);
		exitButton.setFont(new Font("Arial Rounded MT Bold",Font.BOLD,40));
		exitButton.setForeground(textColor);
                                    exitButton.setBorder(DashBoard.NO_LINE_BORDER);
		exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		exitButton.setHorizontalAlignment(JLabel.CENTER);
                                    exitButton.setContentAreaFilled(false);
                                    exitButton.setFocusable(false);
                                   exitButton.addActionListener(new ActionListener(){
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                                              textReturn= "";
                                                              thes.dispose();
                                                              plusIcon.setEnabled(true);	
                                    }
                                       
                                   });
                
		exitButton.addMouseListener(new MouseAdapter() {


			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setForeground(Color.BLUE);
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setForeground(textColor);
				
			}
			
		});
		
	
		
          saveButton.addActionListener(new ActionListener(){

                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        textReturn = todoDesc.getText();
                    	 todoDesc.setText("");
                    	 thes.dispose();
                    	 plusIcon.setEnabled(true);	
                                    }
          });
        saveButton.addMouseListener(new MouseAdapter(){
                
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        saveButton.setForeground(Color.blue);
                        
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        saveButton.setForeground(textColor);
                    }
              
                                        
                                    });
	
              
		thes.setUndecorated(true);
		thes.getContentPane().setLayout(new BorderLayout());
		thes.setPreferredSize(new Dimension(800,250));
		thes.pack();
		thes.setLocationRelativeTo(DashBoard.mainFrame);
		thes.setModal(true);
                                
		//thes.setLocationRelativeTo(null);
		
		topPanel.add(todoTxt);
		topPanel.add(exitButton);
		belowPanel.add(saveButton);
	
		thes.getContentPane().add(topPanel,BorderLayout.NORTH);
		thes.getContentPane().add(sp,BorderLayout.CENTER);
		thes.getContentPane().add(belowPanel,BorderLayout.SOUTH);
		
		//thes.add(pane, BorderLayout.CENTER);
		
		thes.setVisible(true);
		

         
	
	}
        
                public  static  int exitProm(){
                        promp();
                        return num;
                         }
                public static void promp(){
                                JDialog dialog  = new JDialog();
                    dialog.setModal(true);
                    dialog.setUndecorated(true);
                    dialog.getContentPane().setBackground(Color.gray);
                    dialog.setSize(400, 250);
                    dialog.setLayout(null);
                    dialog.setLocationRelativeTo(DashBoard.mainFrame);
                        JLabel label = new JLabel("Message");
                    label.setBounds(0,0,110,110);
                    
                       JButton exitBtn= new JButton("Exit");
                    exitBtn.setBounds(100,100,110,50);
                    exitBtn.addActionListener(new ActionListener(){
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                num = 1;
                               dialog.dispose();
                               
                            }
                        
                    });
                    JButton logInBtn = new JButton("Login againt");
                    logInBtn.setBounds(200,100,100,50);
                     logInBtn.addActionListener(new ActionListener(){
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                num = 2;
                                                        dialog.dispose();
                            }
                        
                    });
                        JButton cancel = new JButton("cancel");
                    cancel.setBounds(200,200,100,50);
                     cancel.addActionListener(new ActionListener(){
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                                        dialog.dispose();
                            }
                        
                    });
        
                    dialog.add(cancel);
                    dialog.add(exitBtn);
                    dialog.add(logInBtn);
                    dialog.add(label);
                    dialog.setVisible(true);
                }
                
               public static String ChangeBio(){
                   prompBio();
                   return changedBio;
               }

    private static void prompBio() {
                                        JDialog dialog  = new JDialog();
                    dialog.setModal(true);
                    dialog.setUndecorated(true);
                    dialog.getContentPane().setBackground(Color.LIGHT_GRAY);
                    dialog.setSize(500, 265);
                    
                    dialog.setLayout(new FlowLayout());
                    dialog.setLocationRelativeTo(DashBoard.mainFrame);
                    JLabel changeBio= new JLabel("New BIO");
                    changeBio.setHorizontalAlignment(JLabel.CENTER);
                    changeBio.setPreferredSize(new Dimension(400,20));
                    
                    JTextArea newBio = new JTextArea();
                    newBio.setFont(new Font("Arial Rounded MT Bold",Font.BOLD,25));
	newBio.setPreferredSize(new Dimension(400,150));
                    newBio.setSize(400, 150);
                    newBio.setLineWrap(true);
                    JScrollPane sp = new JScrollPane(newBio,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                        sp.setPreferredSize(new Dimension(405,155));
                    
                      dialog.getContentPane().add(changeBio);
                         dialog.add(sp);
                      JButton exitBtn = new JButton("Exit");
                    exitBtn.setPreferredSize(new Dimension(195,20));
                    exitBtn.addActionListener(new ActionListener(){
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                              dialog.dispose();
                                              changedBio="";
                                            }
                        
                    });
                    dialog.getContentPane().add(exitBtn);
                    JButton submitBtn = new JButton("Submit");
                    submitBtn.setPreferredSize(new Dimension(195,20));
                        submitBtn.addActionListener(new ActionListener(){
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                              dialog.dispose();
                                              changedBio=newBio.getText();
                                            }
                        
                    });
                    dialog.getContentPane().add(submitBtn);
                    
                  
                         
                       dialog.setVisible(true);
    }

    static String getNewPassword() {
        newPasswordPromp("New Password","Confirm Your New Password" );
        return newPassword;
    }

    private static void newPasswordPromp(String one,String two) {
                  JDialog dialog  = new JDialog();
                    dialog.setModal(true);
                    dialog.setUndecorated(true);
                    dialog.getContentPane().setBackground(Color.LIGHT_GRAY);
                    dialog.setSize(500, 200);       
                    dialog.setLayout(new FlowLayout());
                    dialog.setLocationRelativeTo(DashBoard.mainFrame);
                    JTextField passOne = new JTextField(one);
                    
                    passOne.setPreferredSize(new Dimension(495,50));
                    passOne.setPreferredSize(new Dimension(495,50));
                    JTextField confirmPass = new JTextField(two);
                          confirmPass.setPreferredSize(new Dimension(495,50));
                          
                     dialog.add(passOne);
                     dialog.add(confirmPass);
                           JButton exitBtn = new JButton("Exit");
                    exitBtn.setPreferredSize(new Dimension(195,20));
                    exitBtn.addActionListener(new ActionListener(){
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                              dialog.dispose();
                                              newPassword="";
                                    
                                            }
                        
                    });
                    dialog.getContentPane().add(exitBtn);
                    JButton submitBtn = new JButton("Submit");
                    submitBtn.setPreferredSize(new Dimension(195,20));
                        submitBtn.addActionListener(new ActionListener(){
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                              dialog.dispose();
                                              if(!passOne.getText().isBlank()&&!confirmPass.getText().isBlank())
                                              {
                                                  
                                                     if(passOne.getText().equals(confirmPass.getText()))
                                                        newPassword=confirmPass.getText();
                                                     else
                                                     {
                                                         JOptionPane.showMessageDialog(dialog, "You Input is not match");
                                                        newPasswordPromp(passOne.getText(),confirmPass.getText());
                                                        } 
                                           
                                              }
                                              else{
                                                        JOptionPane.showMessageDialog(dialog, "You Cannot Leave the textfield empty");
                                                  newPasswordPromp(passOne.getText(),confirmPass.getText());
                                              }
                                            
                                                  
                                            }
                        
                    });
                    dialog.getContentPane().add(submitBtn);
                    dialog.setVisible(true);
    }
 static void firstGroupTable(String text) 
    {
                                 JDialog dialog  = new JDialog();
                    dialog.setModal(true);
                              dialog.setTitle(text);
                    dialog.setUndecorated(false);
                    dialog.getContentPane().setBackground(Color.LIGHT_GRAY);
                    dialog.setSize(500, 265);
                    
                    dialog.setLayout(new BorderLayout());
                    dialog.setLocationRelativeTo(DashBoard.mainFrame);
                    JTable table = new JTable();
                        table.getTableHeader().setReorderingAllowed(false);
                    JScrollPane scrollPane1 = new JScrollPane();
                    
                    JScrollPane scrollPane2 = new JScrollPane();
                    scrollPane2.setViewportView(table);
                    scrollPane1.setViewportView(scrollPane2);
                        DefaultTableModel tableModel = new DefaultTableModel(){
                    @Override
            	public boolean isCellEditable(int rows,int column) {
		return false;
				}
        };
                        tableModel.setColumnIdentifiers(new String[]{
                            "Name",
                            
                        });
                           table.setModel(tableModel);
                             DataBase.setTable(1, table);
                     
                        dialog.add(scrollPane1);
                    dialog.setVisible(true);
    }
    static void secondGroupTable    (String text,String who) {
        
        String w ="";
        if(who.equalsIgnoreCase("Student")){
            w ="Program";
        }
        else
            w = "Faculty";
                              JDialog dialog  = new JDialog();
                    dialog.setModal(true);
                              dialog.setTitle(text);
                    dialog.setUndecorated(false);
                    dialog.getContentPane().setBackground(Color.LIGHT_GRAY);
                    dialog.setSize(500, 265);
                    
                    dialog.setLayout(new BorderLayout());
                    dialog.setLocationRelativeTo(DashBoard.mainFrame);
                    JTable table = new JTable();      table.getTableHeader().setReorderingAllowed(false);
                    
                    JScrollPane scrollPane1 = new JScrollPane();
                    
                    JScrollPane scrollPane2 = new JScrollPane(table);
                    scrollPane2.setViewportView(table);
                    scrollPane1.setViewportView(scrollPane2);
                        DefaultTableModel tableModel = new DefaultTableModel(){
                    @Override
            	public boolean isCellEditable(int rows,int column) {
		return false;
				}
        };
                        tableModel.setColumnIdentifiers(new String[]{
                            "Name",w
                            
                        });
                            table.setModel(tableModel);
                    DataBase.setTable(2, table);
                    
                        dialog.add(scrollPane1);
                    dialog.setVisible(true);
    }

   
                        
                        
	
	

}
