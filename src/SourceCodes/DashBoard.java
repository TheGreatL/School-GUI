/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SourceCodes;


import database.DataBase;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import java.util.LinkedList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

/**
 *
 * @author Ken-Carlon
 */
public class DashBoard extends MouseAdapter implements ActionListener {
         public static final int COMPHEIGHT = 800;
         public static final int COMPWIDTH = 1280;
        public static final MatteBorder ICON_BORDER = BorderFactory.createMatteBorder(1,0, 1, 0, Color.black);
        public static final Border NO_LINE_BORDER = BorderFactory.createEmptyBorder();

       public static   JFrame mainFrame = new JFrame();
     
       public static   JButton homeIcon = new JButton();
       public static    JButton moduleIcon = new JButton();
       public static    JButton groupIcon = new JButton();
       public static    JButton studentBalIcon = new JButton();
       public static     JButton userIcon = new JButton();
       public static     JButton gradeIcon = new JButton();
        public static JButton logoutIcon = new JButton();
        public static   JPanel leftPanel  = new JPanel();
        public static final Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);
        public static ImageAvatar userAvatar = new ImageAvatar();
        public static final  Font ICON_FONT = new Font("Arial Rounded MT Bold",Font.BOLD,20);
        public static final Color lowOpacColor = new Color(0xA8AEFB);
         
        public  static   JPanel topPanel  = new JPanel();
        public static   JPanel  rightPanel = new JPanel();
        
     public static   JPanel logoutPanel = new JPanel();
      public static    JPanel iconPanel = new JPanel();
  
       public static LinkedList<String> listOfTodo = new LinkedList<>();
      
        
        public  JPanel homePanel = new JPanel();
        public  JPanel userPanel = new JPanel();
        public  JPanel groupPanel = new JPanel();
        public  JPanel modulePanel = new JPanel();
        public  JPanel balancePanel = new JPanel();
         public  JPanel gradePanel = new JPanel();
        public  JTabbedPane tabs = new JTabbedPane();
        
        public static  JLabel name = new JLabel();
        
        public static final Cursor DEFAULT_CURSOR = new Cursor(Cursor.DEFAULT_CURSOR);
         public static final Cursor HAND_CURSOR = new Cursor(Cursor.HAND_CURSOR);
        public static final Color PANEL_BG_COLOR = new Color(0xDDDDDD);
         public static final Color NORMAL_COLOR = Color.WHITE;
         public static final Color TOP_PANEL_COLOR = new Color (0x1181C8);
         public static final Color MODULE_PANEL_COLOR = new Color(0xFFDE59);
         public static final Color MODULE_SHORTCUT_COLOR = new Color(0x1181C8);
         public static DataBase userRecords;
 
      DashBoard()
      {
         DataBase.Subjects();
          setMainFrame();
                   

    
         
         setPanel();
         setLabel();  
          setHomePanelComponents(); 
          setUserPanelComponents();
          setModulePanelComponents();
            setGroupPanelComponents();
             setGradePanelComponents();
              setStudentBalancePanel();
          setTopPanel();
         addComponents();
   
        }
  
   

     

    private void setMainFrame() {
           mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.setUndecorated(true);
            mainFrame.setPreferredSize(new Dimension(COMPWIDTH,COMPHEIGHT));
            mainFrame.pack();
            mainFrame.setLocationRelativeTo(null);
            mainFrame.setLayout(new BorderLayout());
         
    }

   
     private void mouseEnteredShowComp() {
                             leftPanel.setPreferredSize(new Dimension(250,COMPHEIGHT));   
                             logoutPanel.setSize(new Dimension(250,200));
                             iconPanel.setSize(new Dimension(250,500)); 
          
                    homeIcon.setText("Home");

                       userIcon.setText("Users");

                      groupIcon.setText("Group");

                          moduleIcon.setText("Module");

                         studentBalIcon.setText("Balance");

                         gradeIcon.setText("Grade");
                           logoutIcon.setText("Exit");
                     
                }
     public void exitMouse(){ 
          leftPanel.setPreferredSize(new Dimension(80,COMPHEIGHT));
                          homeIcon.setText("");userIcon.setText(""); groupIcon.setText("");moduleIcon.setText("");studentBalIcon.setText(""); gradeIcon.setText("");logoutIcon.setText("");
 
     }
     
  
    private void setPanel() 
    {
        
            leftPanel.setPreferredSize(new Dimension(80,COMPHEIGHT));
            leftPanel.setBackground(NORMAL_COLOR);
              leftPanel.setLayout(new BorderLayout());
           leftPanel.setBorder(NO_LINE_BORDER);
          
           
            rightPanel.setBackground(Color.gray);
              rightPanel.setBorder(NO_LINE_BORDER);
           rightPanel.setLayout(null);
           
             tabs.setBounds(-10, -95, COMPWIDTH, COMPHEIGHT+30);
            //     tabs.setBounds(0, 0, COMPWIDTH, COMPHEIGHT);
             tabs.setBorder(NO_LINE_BORDER);
             
     
                       
                          
                   
                       
                        
                   
                         
          
           
                        
                        
                        iconPanel.setPreferredSize(new Dimension(250,600));
                        iconPanel.setBackground(NORMAL_COLOR);
                        iconPanel.setLayout(new GridLayout(6,1,0,0));
                        iconPanel.setBorder(NO_LINE_BORDER);
                        iconPanel.addMouseListener(this);
                        
                        logoutPanel.setPreferredSize(new Dimension(250,100));
                        logoutPanel.setBackground(NORMAL_COLOR);
                        logoutPanel.setLayout(new BorderLayout());
                         logoutPanel.setBorder(NO_LINE_BORDER);
                    
                        
                                        homePanel.setBackground(PANEL_BG_COLOR);
                                         userPanel.setBackground(PANEL_BG_COLOR);
                                         groupPanel.setBackground(PANEL_BG_COLOR);
                                         modulePanel.setBackground(PANEL_BG_COLOR);
                                         balancePanel.setBackground(PANEL_BG_COLOR);
                                         gradePanel.setBackground(PANEL_BG_COLOR);
                                         
                                         homePanel.setBorder(NO_LINE_BORDER);
                                         userPanel.setBorder(NO_LINE_BORDER);
                                         groupPanel.setBorder(NO_LINE_BORDER);
                                         modulePanel.setBorder(NO_LINE_BORDER);
                                         balancePanel.setBorder(NO_LINE_BORDER);
                                         gradePanel.setBorder(NO_LINE_BORDER);
                                         
                            
                                        
                                          
                                             
                                          
                                               
                                                 
                                                 
                                         homePanel.setLayout(null);
                                      //   setHomePanelComponents();
  
                                         userPanel.setLayout(null);
                                      
                    
                                      
                                          modulePanel.setLayout(null);
                                     
                                          
                                             groupPanel.setLayout(null);
                                       
                                          
                                       
                                          
                                          
                                         balancePanel.setLayout(null);
     
                                          
                                          
                                         gradePanel.setLayout(null);
                                        
                                         
    }

    private void addComponents() {
           iconPanel.add(homeIcon);
           iconPanel.add(userIcon);    
           iconPanel.add(moduleIcon);  
           iconPanel.add(groupIcon);
           iconPanel.add(studentBalIcon);  
             iconPanel.add(gradeIcon);   
             
         logoutPanel.add(logoutIcon,BorderLayout.CENTER);
        
          
           
           
           tabs.addTab("HomeTab", homePanel);
           tabs.addTab("User Tab", userPanel);
           tabs.addTab("Module Tab", modulePanel);
           tabs.addTab("Group Tab", groupPanel);
           tabs.addTab("Balance Tab", balancePanel);
           tabs.addTab("Grade Tab", gradePanel);
           
           
            rightPanel.add(tabs);
            leftPanel.add(iconPanel,BorderLayout.NORTH);
            leftPanel.add(logoutPanel, BorderLayout.SOUTH);
            mainFrame.add(rightPanel, BorderLayout.CENTER);
             mainFrame.add(leftPanel,BorderLayout.EAST);
    }

    private void setLabel() {
                        logoutIcon.setSize(30, 30);
                        logoutIcon.setIcon(MethodsForAll.setIconsReturnIcon("src/pictures/LeftPanelIcons/logoutIcon.png", logoutIcon));
                        logoutIcon.setHorizontalAlignment(JLabel.CENTER);
                        logoutIcon.setVerticalAlignment(JLabel.CENTER);
                          logoutIcon.setHorizontalAlignment(JLabel.CENTER);
                                logoutIcon.setFont(ICON_FONT);
                                logoutIcon.setBorder(NO_LINE_BORDER);
                                logoutIcon.setBackground(NORMAL_COLOR);
                                logoutIcon.setFocusable(false);
                                    logoutIcon.setCursor(handCursor);
                                            logoutIcon.addActionListener((ActionEvent e) -> {
                          int cond  =JOptionPane.showConfirmDialog(mainFrame, "Do you want to logout?", "Log out", JOptionPane.YES_NO_OPTION);
                          if(cond == JOptionPane.YES_OPTION){
                            
         
                              System.exit(0);
                          }
                         
  
                        });
     
                       logoutIcon.addMouseListener(new MouseAdapter(){
         
                
                  @Override
                public  void mouseEntered(MouseEvent e){
                    mouseEnteredShowComp();
                }
                  @Override
                   public void mouseExited(MouseEvent e)
                {
                   exitMouse();
                     
                }
           });
               
                     
                             homeIcon.setFont(ICON_FONT);       
                        homeIcon.setSize(40, 40);
                        homeIcon.setIcon(MethodsForAll.setIconsReturnIcon("src/pictures/LeftPanelIcons/homeIcon.png",homeIcon));
                        homeIcon.setVerticalTextPosition(JLabel.BOTTOM);
                        homeIcon.setHorizontalTextPosition(JLabel.CENTER);
                         homeIcon.setHorizontalAlignment(JLabel.CENTER);
                             homeIcon.setBorder(ICON_BORDER);
                              homeIcon.setBackground(DashBoard.PANEL_BG_COLOR);
                              homeIcon.setOpaque(true);
                              homeIcon.setCursor(DashBoard.DEFAULT_CURSOR);
                              homeIcon.addMouseListener(this);
                              homeIcon.setContentAreaFilled(true);
                              homeIcon.setFocusable(false);
                                  homeIcon.addActionListener(this);
                              
                        userIcon.setSize(40, 40);
                        userIcon.setIcon(MethodsForAll.setIconsReturnIcon("src/pictures/LeftPanelIcons/userIcon.png",userIcon));
                           userIcon.setVerticalTextPosition(JLabel.BOTTOM);
                           userIcon.setHorizontalTextPosition(JLabel.CENTER);
                              userIcon.setHorizontalAlignment(JLabel.CENTER);                       
                            userIcon.setFont(ICON_FONT);
                             userIcon.setCursor(handCursor);
                                  userIcon.addMouseListener(this);
                                 userIcon.setOpaque(true);
                                    userIcon.setBackground(DashBoard.NORMAL_COLOR);
                                        userIcon.setContentAreaFilled(true);
                              userIcon.setFocusable(false);
                                   userIcon.addActionListener(this);
                                   userIcon.setBorder(NO_LINE_BORDER);
                                       
                        moduleIcon.setSize(40, 40);
                        moduleIcon.setIcon(MethodsForAll.setIconsReturnIcon("src/pictures/LeftPanelIcons/moduleIcon.png",moduleIcon));
                           moduleIcon.setVerticalTextPosition(JLabel.BOTTOM);
                               moduleIcon.setHorizontalTextPosition(JLabel.CENTER);
                             moduleIcon.setHorizontalAlignment(JLabel.CENTER);
                                   moduleIcon.setFont(ICON_FONT);
                               moduleIcon.setCursor(handCursor);
                         moduleIcon.addMouseListener(this);
                         moduleIcon.setOpaque(true);
                               moduleIcon.setBackground(DashBoard.NORMAL_COLOR);      
                                          moduleIcon.setContentAreaFilled(true);
                              moduleIcon.setFocusable(false);
                                  moduleIcon.addActionListener(this);
                                      moduleIcon.setBorder(NO_LINE_BORDER);
                               
                        groupIcon.setSize(40, 40);
                        groupIcon.setIcon(MethodsForAll.setIconsReturnIcon("src/pictures/LeftPanelIcons/groupIcon.png",groupIcon));
                        groupIcon.setVerticalTextPosition(JLabel.BOTTOM);
                          groupIcon.setHorizontalTextPosition(JLabel.CENTER);
                            groupIcon.setFont(ICON_FONT);
                              groupIcon.setCursor(handCursor);
                            groupIcon.addMouseListener(this);
                              groupIcon.setOpaque(true);
                            groupIcon.setBackground(DashBoard.NORMAL_COLOR);      
                                        groupIcon.setContentAreaFilled(true);
                              groupIcon.setFocusable(false);
                                    groupIcon.addActionListener(this);
                                          groupIcon.setBorder(NO_LINE_BORDER);
                              
                     studentBalIcon.setSize(40, 40);
                     studentBalIcon.setIcon(MethodsForAll.setIconsReturnIcon("src/pictures/LeftPanelIcons/balanceIcon.png",studentBalIcon));
                       studentBalIcon.setVerticalTextPosition(JLabel.BOTTOM);
                      studentBalIcon.setHorizontalTextPosition(JLabel.CENTER);
                         studentBalIcon.setHorizontalAlignment(JLabel.CENTER);
                             studentBalIcon.setFont(ICON_FONT);
                                 studentBalIcon.setCursor(handCursor);
                                                     studentBalIcon.addMouseListener(this);
                              studentBalIcon.setOpaque(true);
                                 studentBalIcon.setBackground(DashBoard.NORMAL_COLOR);      
           studentBalIcon.setContentAreaFilled(true);
                              studentBalIcon.setFocusable(false);
                                     studentBalIcon.addActionListener(this);
                                              studentBalIcon.setBorder(NO_LINE_BORDER);
                                     
                      gradeIcon.setSize(40, 40);
                         gradeIcon.setBackground(DashBoard.NORMAL_COLOR);      
                      gradeIcon.setIcon(MethodsForAll.setIconsReturnIcon("src/pictures/LeftPanelIcons/gradeIcon.png",gradeIcon));
                      gradeIcon.setVerticalTextPosition(JLabel.BOTTOM);
                      gradeIcon.setHorizontalTextPosition(JLabel.CENTER);
                       groupIcon.setHorizontalAlignment(JLabel.CENTER);
                        gradeIcon.setHorizontalAlignment(JLabel.CENTER);
                         gradeIcon.setFont(ICON_FONT);
                         gradeIcon.setCursor(handCursor);
                         gradeIcon.addMouseListener(this);  
                               gradeIcon.addActionListener(this);
                                           gradeIcon.setContentAreaFilled(true);
                              gradeIcon.setFocusable(false);
                                         gradeIcon.setBorder(NO_LINE_BORDER);
    }
  
  
           public void setFrameVisible(boolean cond){
          mainFrame.setVisible(cond);
      }
           

@Override
   public void mouseEntered(MouseEvent e){
            leftPanel.setPreferredSize(new Dimension(250,COMPHEIGHT));   
                             logoutPanel.setSize(new Dimension(250,200));  
             
                             iconPanel.setSize(new Dimension(250,500)); 
          
                    homeIcon.setText("Home");

                       userIcon.setText("Users");

                      groupIcon.setText("Group");

                          moduleIcon.setText("Module");

                         studentBalIcon.setText("Balance");

                         gradeIcon.setText("Grade");
                           logoutIcon.setText("Exit");
                           
                    if(e.getSource() == homeIcon){
                        if(homeIcon.getBorder() == DashBoard.NO_LINE_BORDER)
                        homeIcon.setBackground(lowOpacColor);
                    }
                    else     if(e.getSource() == moduleIcon){
                              if(moduleIcon.getBorder() == DashBoard.NO_LINE_BORDER)
                        moduleIcon.setBackground(lowOpacColor);
                              }
            else     if(e.getSource() == groupIcon){
                      if(groupIcon.getBorder() == DashBoard.NO_LINE_BORDER)
                        groupIcon.setBackground(lowOpacColor);
            }
         else     if(e.getSource() == studentBalIcon){
                   if(studentBalIcon.getBorder() == DashBoard.NO_LINE_BORDER)
                        studentBalIcon.setBackground(lowOpacColor);
         }
         else     if(e.getSource() == userIcon){
                   if(userIcon.getBorder() == DashBoard.NO_LINE_BORDER)
                        userIcon.setBackground(lowOpacColor);
   }
         else     if(e.getSource()== gradeIcon){
                   if(gradeIcon.getBorder() == DashBoard.NO_LINE_BORDER)
                        gradeIcon.setBackground(lowOpacColor);
         }
   }
    @Override
     public void mouseExited(MouseEvent e){ 
               leftPanel.setPreferredSize(new Dimension(80,COMPHEIGHT));
                          homeIcon.setText("");userIcon.setText(""); groupIcon.setText("");moduleIcon.setText("");studentBalIcon.setText(""); gradeIcon.setText("");logoutIcon.setText("");
 
             if(e.getSource() == homeIcon){
               if(homeIcon.getBorder() != DashBoard.ICON_BORDER)
                   homeIcon.setBackground(DashBoard.NORMAL_COLOR);
                 
             }
                    
                    else     if(e.getSource() == moduleIcon){
                           if(moduleIcon.getBorder() != DashBoard.ICON_BORDER)
                   moduleIcon.setBackground(DashBoard.NORMAL_COLOR);
                    }
                   
            else     if(e.getSource() == groupIcon){
                  if(groupIcon.getBorder() != DashBoard.ICON_BORDER)
                   groupIcon.setBackground(DashBoard.NORMAL_COLOR);
            }
         else     if(e.getSource() == studentBalIcon){
                        if(studentBalIcon.getBorder() != DashBoard.ICON_BORDER)
                   studentBalIcon.setBackground(DashBoard.NORMAL_COLOR);
         }
         else     if(e.getSource() == userIcon){
                   if(userIcon.getBorder() != DashBoard.ICON_BORDER)
                   userIcon.setBackground(DashBoard.NORMAL_COLOR);
         }
         else     if(e.getSource() == gradeIcon) {
                       if(gradeIcon.getBorder() != DashBoard.ICON_BORDER)
                   gradeIcon.setBackground(DashBoard.NORMAL_COLOR);
         }
     }

protected static void setUserDataInstance(DataBase data) {
	userRecords = data;

	}

    private void setHomePanelComponents() {
             HomePanelComponents homePanelComponents = new HomePanelComponents(this);
                 	  homePanelComponents.weatherPart();
                    homePanelComponents.setToDoList();
                    homePanelComponents.schoolEventPanel();
     	  homePanelComponents.setCalendar();
    	  homePanelComponents.shortcutHandout();
    }
     
                            
                            public void action(ActionEvent e){
                                      if(e.getSource() ==homeIcon ){
            tabs.setSelectedIndex(0);
            homeIcon.setBackground(PANEL_BG_COLOR);
             homeIcon.setCursor(DashBoard.DEFAULT_CURSOR);
             homeIcon.setBorder(DashBoard.ICON_BORDER);
             
             
            userIcon.setBackground(NORMAL_COLOR);
               userIcon.setCursor(DashBoard.HAND_CURSOR);
             userIcon.setBorder(DashBoard.NO_LINE_BORDER);
             
             
             moduleIcon.setBackground(NORMAL_COLOR);
               moduleIcon.setCursor(DashBoard.HAND_CURSOR);
             moduleIcon.setBorder(DashBoard.NO_LINE_BORDER);
             
              groupIcon.setBackground(NORMAL_COLOR);
                groupIcon.setCursor(DashBoard.HAND_CURSOR);
             groupIcon.setBorder(DashBoard.NO_LINE_BORDER);
             
               studentBalIcon.setBackground(NORMAL_COLOR);
                 studentBalIcon.setCursor(DashBoard.HAND_CURSOR);
             studentBalIcon.setBorder(DashBoard.NO_LINE_BORDER);
               
                gradeIcon.setBackground(NORMAL_COLOR);
                  gradeIcon.setCursor(DashBoard.HAND_CURSOR);
             gradeIcon.setBorder(DashBoard.NO_LINE_BORDER);
                
                
        }
       else    if(e.getSource() ==userIcon ){
            tabs.setSelectedIndex(1);

                userIcon.setBackground(PANEL_BG_COLOR);
             userIcon.setCursor(DashBoard.DEFAULT_CURSOR);
             userIcon.setBorder(DashBoard.ICON_BORDER);
             
            homeIcon.setBackground(NORMAL_COLOR);
               homeIcon.setCursor(DashBoard.HAND_CURSOR);
             homeIcon.setBorder(DashBoard.NO_LINE_BORDER);
             
             
             moduleIcon.setBackground(NORMAL_COLOR);
               moduleIcon.setCursor(DashBoard.HAND_CURSOR);
             moduleIcon.setBorder(DashBoard.NO_LINE_BORDER);
             
              groupIcon.setBackground(NORMAL_COLOR);
                groupIcon.setCursor(DashBoard.HAND_CURSOR);
             groupIcon.setBorder(DashBoard.NO_LINE_BORDER);
             
               studentBalIcon.setBackground(NORMAL_COLOR);
                 studentBalIcon.setCursor(DashBoard.HAND_CURSOR);
             studentBalIcon.setBorder(DashBoard.NO_LINE_BORDER);
               
                gradeIcon.setBackground(NORMAL_COLOR);
                  gradeIcon.setCursor(DashBoard.HAND_CURSOR);
             gradeIcon.setBorder(DashBoard.NO_LINE_BORDER);
            
           
        }
        else     if(e.getSource() ==moduleIcon ){
            tabs.setSelectedIndex(2);
               moduleIcon.setBackground(PANEL_BG_COLOR);
             moduleIcon.setCursor(DashBoard.DEFAULT_CURSOR);
             moduleIcon.setBorder(DashBoard.ICON_BORDER);
             
            homeIcon.setBackground(NORMAL_COLOR);
               homeIcon.setCursor(DashBoard.HAND_CURSOR);
             homeIcon.setBorder(DashBoard.NO_LINE_BORDER);
             
             
             userIcon.setBackground(NORMAL_COLOR);
               userIcon.setCursor(DashBoard.HAND_CURSOR);
             userIcon.setBorder(DashBoard.NO_LINE_BORDER);
             
              groupIcon.setBackground(NORMAL_COLOR);
                groupIcon.setCursor(DashBoard.HAND_CURSOR);
             groupIcon.setBorder(DashBoard.NO_LINE_BORDER);
             
               studentBalIcon.setBackground(NORMAL_COLOR);
                 studentBalIcon.setCursor(DashBoard.HAND_CURSOR);
             studentBalIcon.setBorder(DashBoard.NO_LINE_BORDER);
               
                gradeIcon.setBackground(NORMAL_COLOR);
                  gradeIcon.setCursor(DashBoard.HAND_CURSOR);
             gradeIcon.setBorder(DashBoard.NO_LINE_BORDER);
        }
          else       if(e.getSource() ==groupIcon ){
            tabs.setSelectedIndex(3);
                      groupIcon.setBackground(PANEL_BG_COLOR);
             groupIcon.setCursor(DashBoard.DEFAULT_CURSOR);
             groupIcon.setBorder(DashBoard.ICON_BORDER);
             
            homeIcon.setBackground(NORMAL_COLOR);
               homeIcon.setCursor(DashBoard.HAND_CURSOR);
             homeIcon.setBorder(DashBoard.NO_LINE_BORDER);
             
             
             userIcon.setBackground(NORMAL_COLOR);
               userIcon.setCursor(DashBoard.HAND_CURSOR);
             userIcon.setBorder(DashBoard.NO_LINE_BORDER);
             
              moduleIcon.setBackground(NORMAL_COLOR);
                moduleIcon.setCursor(DashBoard.HAND_CURSOR);
             moduleIcon.setBorder(DashBoard.NO_LINE_BORDER);
             
               studentBalIcon.setBackground(NORMAL_COLOR);
                 studentBalIcon.setCursor(DashBoard.HAND_CURSOR);
             studentBalIcon.setBorder(DashBoard.NO_LINE_BORDER);
               
                gradeIcon.setBackground(NORMAL_COLOR);
                  gradeIcon.setCursor(DashBoard.HAND_CURSOR);
             gradeIcon.setBorder(DashBoard.NO_LINE_BORDER);
        }
           else         if(e.getSource() ==studentBalIcon ){
               if(DataBase.who.equalsIgnoreCase("Student")){
                     tabs.setSelectedIndex(4);
                studentBalIcon.setBackground(PANEL_BG_COLOR);
             studentBalIcon.setCursor(DashBoard.DEFAULT_CURSOR);
             studentBalIcon.setBorder(DashBoard.ICON_BORDER);
             
            homeIcon.setBackground(NORMAL_COLOR);
               homeIcon.setCursor(DashBoard.HAND_CURSOR);
             homeIcon.setBorder(DashBoard.NO_LINE_BORDER);
             
             
             userIcon.setBackground(NORMAL_COLOR);
               userIcon.setCursor(DashBoard.HAND_CURSOR);
             userIcon.setBorder(DashBoard.NO_LINE_BORDER);
             
              moduleIcon.setBackground(NORMAL_COLOR);
                moduleIcon.setCursor(DashBoard.HAND_CURSOR);
             moduleIcon.setBorder(DashBoard.NO_LINE_BORDER);
             
               groupIcon.setBackground(NORMAL_COLOR);
                 groupIcon.setCursor(DashBoard.HAND_CURSOR);
             groupIcon.setBorder(DashBoard.NO_LINE_BORDER);
               
                gradeIcon.setBackground(NORMAL_COLOR);
                  gradeIcon.setCursor(DashBoard.HAND_CURSOR);
             gradeIcon.setBorder(DashBoard.NO_LINE_BORDER);
               }
               else{
                   JOptionPane.showMessageDialog(mainFrame, "This Panel is only for Students");
               }
          
        }
           else    if(e.getSource() ==gradeIcon ){
            tabs.setSelectedIndex(5);
             gradeIcon.setBackground(PANEL_BG_COLOR);
             gradeIcon.setCursor(DashBoard.DEFAULT_CURSOR);
             gradeIcon.setBorder(DashBoard.ICON_BORDER);
             
            homeIcon.setBackground(NORMAL_COLOR);
               homeIcon.setCursor(DashBoard.HAND_CURSOR);
             homeIcon.setBorder(DashBoard.NO_LINE_BORDER);
             
             
             userIcon.setBackground(NORMAL_COLOR);
               userIcon.setCursor(DashBoard.HAND_CURSOR);
             userIcon.setBorder(DashBoard.NO_LINE_BORDER);
             
              moduleIcon.setBackground(NORMAL_COLOR);
                moduleIcon.setCursor(DashBoard.HAND_CURSOR);
             moduleIcon.setBorder(DashBoard.NO_LINE_BORDER);
             
               groupIcon.setBackground(NORMAL_COLOR);
                 groupIcon.setCursor(DashBoard.HAND_CURSOR);
             groupIcon.setBorder(DashBoard.NO_LINE_BORDER);
               
                studentBalIcon.setBackground(NORMAL_COLOR);
                  studentBalIcon.setCursor(DashBoard.HAND_CURSOR);
             studentBalIcon.setBorder(DashBoard.NO_LINE_BORDER);
        }
                            }

    @Override
    public void actionPerformed(ActionEvent e) {
   action(e);
    }

    private void setUserPanelComponents() {
        UserPanelCompponents com = new UserPanelCompponents(this);
        com.info();
     com.userImage();
     com.bottomLeftPanel();
    com.bottomRightPanel();
    }

    private void setModulePanelComponents() {
        ModulePanelComponents module = new ModulePanelComponents(this);
        
    }

    private void setTopPanel() {
                                      
                                            topPanel.setPreferredSize(new Dimension(1280 ,80));
                                         topPanel.setBackground(DashBoard.TOP_PANEL_COLOR);
                                         topPanel.setLayout(null);
                                         
                                      
                                             userAvatar.setBounds(0, 0, 80, 80);   
                                             userAvatar.setIcon(MethodsForAll.setIconsReturnIcon(userRecords.getStudentPicture() , userAvatar));
                                             userAvatar.setForeground(Color.CYAN);
                                             userAvatar.setBorder(NO_LINE_BORDER);
                                             userAvatar.setBorderSize(5);
                                         
                       name.setText(userRecords.getStudentName()); 
                        name.setFont(new Font("Tahoma",Font.BOLD,15));
                        name.setBounds(100,5,200,100);
                        name.setVerticalAlignment(JLabel.NORTH);
                         name.setHorizontalAlignment(JLabel.LEFT);
                              name.setForeground(Color.WHITE);
                             
                        String recordWrite ="";
                        if(DataBase.who.equals("Student"))
                        recordWrite =userRecords.getStudentYear()+" Year - "+userRecords.getStudentSection();
                        else
                                recordWrite =userRecords.getStudentProgram()+" Faculty";
                        
                        JSeparator separate = new JSeparator();
                        separate.setBounds(95, 25,name.getText().length()+130, 10);
                        separate.setForeground(NORMAL_COLOR);
                        topPanel.add(separate);
                        
                        
                         JLabel sectionAndYear = new JLabel(recordWrite);
                        sectionAndYear.setBounds(105, 15, 200, 50);
                            sectionAndYear.setFont(new Font("Tahoma",Font.BOLD,13));
                            sectionAndYear.setForeground(Color.WHITE);
                               JPanel onlineIndicator = new JPanel(){
                            
                            @Override
                            public void paint(Graphics g){
                     
                                Graphics2D g2d = (Graphics2D) g;
                                Color color;
                                if(userRecords.getStudentStatus().equalsIgnoreCase("Active"))
                                color = Color.green;
                                else
                                    color = Color.red;
                                g2d.setPaint(color);
                                g2d.fillArc(0, 0, 25  , 25, 0, 360);
                                    
                                String message ="";
                                    g2d.setPaint(Color.WHITE);
                                    g2d.setFont(new Font("",Font.BOLD,13));
                                if(color == Color.green){
                                    message = "Active";
                                    g2d.drawString(message, 30, 18);
                                }
                                else{
                                    message = "In-Active";
                                    g2d.drawString(message, 30, 20);
                                
                                }
                            }
                        };
                        onlineIndicator.setBounds(125, 50, 100, 50);
                           topPanel.add(userAvatar);
                           topPanel.add(onlineIndicator);
                           topPanel.add(sectionAndYear);
                           topPanel.add(name);
                                   
                                           
                                         mainFrame.add(topPanel,BorderLayout.NORTH);
    }

    private void setGroupPanelComponents() {
        GroupPanelComponents group = new GroupPanelComponents(this);
        
    }

    private void setStudentBalancePanel() {
        new StudentBalancePanelComponents(this);
    }

    private void setGradePanelComponents()
    {
        new GradePanelComponents(this);
    }

   
 
}
