/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SourceCodes;

import calendar.DateChooser;
import database.DataBase;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Ken-Carlon
 */
public class GroupPanelComponents {
    DashBoard board;
    private JPanel groupPanel;
    GroupPanelComponents(DashBoard board){
        this.board = board;
     //   gropTxt();
        groupComp();
        roundPanel();
        
        
        calendar();
    }

    

    private void roundPanel() {
 int height = 625;   
 JLabel groupPanelTitle = new JLabel("Groups");
              groupPanelTitle.setFont(DashBoard.ICON_FONT);
                groupPanelTitle.setBounds(260, 110, 300, 100);
                     groupPanelTitle.setHorizontalAlignment(JLabel.CENTER);
                     groupPanelTitle.setVerticalAlignment(JLabel.CENTER);
                groupPanelTitle.setFont(new Font("Arial",Font.BOLD,35));
          
                board.groupPanel.add(groupPanelTitle);
     groupPanel = new JPanel(){
            
            @Override
            public void paint(Graphics g){
               
                Graphics2D g2D = (Graphics2D) g;
                
    
                
                g2D.setPaint(Color.LIGHT_GRAY);
                g2D.fillRoundRect(0, 60, 800, height, 70, 70);
                g2D.setPaint(Color.black);
                g2D.setStroke(new BasicStroke(5));
                g2D.drawRoundRect(2, 60, 795, height-1, 70, 70);
                            g2D.setPaint(Color.WHITE);
                g2D.fillRoundRect(20, 70, 755, 60, 40, 40);
                    g2D.setPaint(Color.black);
                g2D.setStroke(new BasicStroke(5));
                g2D.drawRoundRect(20, 70, 755, 60, 40, 40);
              
            
            }
        };
        groupPanel.setFocusable(false);
        groupPanel.setBounds(20, 60, 800,800);
       
        
        board.groupPanel.add(groupPanel);
    
           
    }

    private void groupComp() {
           JPanel leftP = new JPanel();

    
      //    leftP.setBounds(30, 200, 800, 580);
              leftP.setBounds(40, 195, 760, 500);
          leftP.setBackground(Color.LIGHT_GRAY);
          leftP.setLayout(new GridLayout(2,0));
       String s ="";
          if(DataBase.who.equalsIgnoreCase("Teacher")){
           s =  DashBoard.userRecords.getStudentProgram()+" Faculty group";
          }
          else{
           s =  DashBoard.userRecords.getStudentProgram()+" group";
          }
         
          JLabel firstGroup = new JLabel( s);
          firstGroup.setBackground(Color.cyan);
             firstGroup.setOpaque(true);
          firstGroup.setHorizontalAlignment(JLabel.CENTER);
          firstGroup.setFont(new Font("Arial",Font.BOLD,80));
          firstGroup.setCursor(DashBoard.HAND_CURSOR);
       
          firstGroup.addMouseListener(new MouseAdapter(){
            
              @Override
              public void mouseClicked(MouseEvent e){
                        PrompClass.firstGroupTable(firstGroup.getText());
              }
          });
        
          JLabel secondGroup = new JLabel(DataBase.who+" group");
          secondGroup.setBackground(Color.MAGENTA);
             secondGroup.setOpaque(true);
               secondGroup.setHorizontalAlignment(JLabel.CENTER);
          secondGroup.setFont(new Font("Arial",Font.BOLD,80));
          secondGroup.setCursor(DashBoard.HAND_CURSOR);
       
          secondGroup.addMouseListener(new MouseAdapter(){
            
              @Override
              public void mouseClicked(MouseEvent e){
                  PrompClass.secondGroupTable(secondGroup.getText(),DataBase.who);
              }
          });
          
          leftP.add(firstGroup);
          leftP.add(secondGroup);
          board.groupPanel.add(leftP);
    }
      public void calendar(){
        JPanel calendarPanel = new JPanel();
        calendarPanel.setBackground(Color.red);
        calendarPanel.setBounds(870, 122, 275, 225);
        calendarPanel.setLayout(new BorderLayout());
        DateChooser dateChooser = new DateChooser();
        dateChooser.setForeground(DashBoard.MODULE_PANEL_COLOR);

             dateChooser.setFont( DashBoard.ICON_FONT);
             
             calendarPanel.add(dateChooser,BorderLayout.CENTER);
        board.groupPanel.add(calendarPanel);
    
    }
}
