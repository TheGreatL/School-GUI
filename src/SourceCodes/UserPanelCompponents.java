/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SourceCodes;

import static SourceCodes.DashBoard.userAvatar;
import static SourceCodes.DashBoard.userRecords;
import database.DataBase;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Ken-Carlon
 */
public class UserPanelCompponents {
   DashBoard board;
     JPanel mainPanel = new JPanel();
         public static ImageAvatar userImage = new ImageAvatar();
    UserPanelCompponents(DashBoard board){
    this.board = board;    
 
    }
    
    
   
      
      protected void userImage(){
          JPanel cover = new JPanel(){
                @Override
           public void paint(Graphics g){
        
               Graphics2D g2D = (Graphics2D) g;
        
       //       g2D.drawImage(new ImageIcon("src/pictures/BGLight.jpg").getImage(), 0,0, null);
             
                       g2D.setPaint(new Color(0x1181C8));
                     g2D.fillRoundRect(0, 40,1245, 120   , 70,70);
                             g2D.setPaint(new Color(0xFFDE59));
                     g2D.fillRoundRect(0, 0,1245, 100   , 70   ,70);
                
           }
          };
    
          cover.setBounds(-40, 75, 1245, 200);
  

          userImage.setBounds(60, 80, 150   , 150);
          userImage.setIcon(MethodsForAll.setIconsReturnIcon(DashBoard.userRecords.getStudentPicture(), userImage));
          userImage.setBorderSize(10);
          userImage.setForeground(Color.cyan);
          userImage.setCursor(DashBoard.HAND_CURSOR);
            
          userImage.addMouseListener(new MouseAdapter(){
              @Override
              public void mouseClicked(MouseEvent e){
                  int x = JOptionPane.showConfirmDialog(DashBoard.mainFrame, "Do you want to change your Icon? ","Change",JOptionPane.YES_NO_OPTION);
                  if(x == 0){
                  JFileChooser fileChooser = new JFileChooser();
                    int response =    fileChooser.showSaveDialog(DashBoard.mainFrame);
                    if(response == JFileChooser.APPROVE_OPTION){
                            DataBase.updateUserImage( fileChooser.getSelectedFile().getAbsolutePath(),DashBoard.userRecords.getStudentEmail());
                                DataBase.Datas();
                                 userImage.setIcon(MethodsForAll.setIconsReturnIcon(DashBoard.userRecords.getStudentPicture(), userImage));
                               DashBoard.userAvatar.setIcon(MethodsForAll.setIconsReturnIcon(DashBoard.userRecords.getStudentPicture(), DashBoard.userAvatar));
                                              DashBoard.userAvatar.repaint();
                                                                 userImage.repaint();
                                
                          
                    }
                  }

              }
          });
                  JButton settignsButton = new JButton();
          settignsButton.setBounds(1150, 90, 30, 30);
          settignsButton.setIcon(MethodsForAll.setIconsReturnIcon("src/pictures/settings.png", settignsButton));
          settignsButton.setBackground(new Color(0xFFDE59));
          settignsButton.setBorder(DashBoard.NO_LINE_BORDER);
          
          board.userPanel.add(settignsButton);
          board.userPanel.add(userImage);
          board.userPanel.add(cover);
      } 
      protected  void bottomLeftPanel(){
          Dimension sizeComp = new Dimension(780,50);
          JPanel leftP = new JPanel();

          leftP.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
          leftP.setBounds(20, 250, 800, 530);
          leftP.setBackground(DashBoard.PANEL_BG_COLOR);
          leftP.setLayout(new FlowLayout());
          
          JLabel infoLabel =  new JLabel("Info");
          infoLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
          infoLabel.setBounds(10, 15, 780, 30);
          infoLabel.setPreferredSize(new Dimension(780,30));
          infoLabel.setFont(DashBoard.ICON_FONT);
          infoLabel.setForeground(Color.BLACK);
          leftP.add(infoLabel);
          
          JLabel campusTxt = new JLabel("Campus: STI Fairview");
           campusTxt.setPreferredSize(sizeComp);
           campusTxt.setFont(DashBoard.ICON_FONT);
           
               JLabel academicLevelTxt = new JLabel("Academic Level: Tertiary");
                          academicLevelTxt.setPreferredSize(sizeComp);
                            academicLevelTxt.setFont(DashBoard.ICON_FONT);

                    JLabel sectionorFaculty = new JLabel("Section: "+DashBoard.userRecords.getStudentSection());
                             sectionorFaculty.setPreferredSize(sizeComp);
                            sectionorFaculty.setFont(DashBoard.ICON_FONT);

                             
                         JLabel programTxt = new JLabel("Program: "+DashBoard.userRecords.getStudentProgram());
                          programTxt.setPreferredSize(sizeComp);
                                       programTxt.setFont(DashBoard.ICON_FONT);

                          
                              JLabel yearLevel = new JLabel("Year Level: "+DashBoard.userRecords.getStudentYear());
                          yearLevel.setPreferredSize(sizeComp);
                                       yearLevel.setFont(DashBoard.ICON_FONT);

                          
                              JLabel userID = new JLabel("User ID: "+DashBoard.userRecords.getStudentID());
                                         userID.setPreferredSize(sizeComp);
                                         userID.setFont(DashBoard.ICON_FONT);

                                                        
                              JLabel contact = new JLabel("Contact Number: "+DashBoard.userRecords.getStudentContact());
                                         contact.setPreferredSize(sizeComp);
                                         contact.setFont(DashBoard.ICON_FONT);

                              JLabel email = new JLabel("Email: "+DashBoard.userRecords.getStudentEmail());
                                         email.setPreferredSize(sizeComp);
                                         email.setFont(DashBoard.ICON_FONT);

                                     leftP.add(campusTxt);
                                                leftP.add(academicLevelTxt);
                                                           leftP.add(sectionorFaculty);
                                                                      leftP.add(programTxt);
                                                                                 leftP.add(yearLevel);
                                                                                        leftP.add(userID);
                                                                                               leftP.add(contact);
                                                                                                     leftP.add(email);
                                                                                 
            if(DataBase.who.equalsIgnoreCase("Teacher")){
                programTxt.setText("Faculty: "+DashBoard.userRecords.getStudentProgram());
                                        leftP.remove(sectionorFaculty);
                                        leftP.remove(yearLevel);
            }

          board.userPanel.add(leftP);
      }

    protected void bottomRightPanel() {

       mainPanel.setBounds(830,250,375,530);
       mainPanel.setBackground(DashBoard.PANEL_BG_COLOR);
       mainPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
       mainPanel.setLayout(new FlowLayout());
       board.userPanel.add(mainPanel);
 
       
    }

}
