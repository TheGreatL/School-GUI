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
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Ken-Carlon
 */
public class ModulePanelComponents {
    static int i= 0;
      JPanel modulePanel ;
    private DashBoard board;
        private static JPanel taskPanel = new JPanel();
  
    public ModulePanelComponents(DashBoard board){
        this.board = board;
           modules();
              moduleTxt();
        modulePanel();
        calendar();
     
  
    }
    public void modulePanel(){
        int height = 625;
     modulePanel = new JPanel(){
            
            @Override
            public void paint(Graphics g){
               
                Graphics2D g2D = (Graphics2D) g;
                
    
                
                g2D.setPaint(Color.WHITE);
                g2D.fillRoundRect(0, 60, 800, height, 70, 70);
                g2D.setPaint(Color.black);
                g2D.setStroke(new BasicStroke(5));
                g2D.drawRoundRect(2, 60, 795, height-1, 70, 70);
                            g2D.setPaint(DashBoard.MODULE_SHORTCUT_COLOR);
                g2D.fillRoundRect(20, 70, 755, 40, 40, 40);
                            g2D.setPaint(DashBoard.MODULE_PANEL_COLOR);
                 g2D.fillRoundRect(33, 75, 730, 30, 40, 40);
            
            }
        };
        modulePanel.setFocusable(false);
        modulePanel.setBounds(20, 60, 800,800);
       
        
        board.modulePanel.add(modulePanel);
    }
    public void moduleTxt(){
              JLabel modulePanelTitle = new JLabel("Modules");
              modulePanelTitle.setFont(DashBoard.ICON_FONT);
                modulePanelTitle.setBounds(400, 100, 100, 100);
                
             
                                                board.modulePanel.add(modulePanelTitle);
    }
    public void modules(){
        JPanel contPanel = new JPanel();
        contPanel.setBackground(Color.WHITE);
        contPanel.setBounds(40, 180, 760, 500);
         contPanel.setLayout(new FlowLayout());
         
        JLabel subject1 = new JLabel(DashBoard.userRecords.getSubject1());
        subject1.setPreferredSize(new Dimension(740,70));
        
        subject1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        subject1.setFont(DashBoard.ICON_FONT);
        subject1.setSize(50,50);
        subject1.setIcon(MethodsForAll.setIconsReturnIcon("src/pictures/book.png", subject1));
        subject1.setHorizontalTextPosition(JLabel.RIGHT);
        subject1.setCursor(DashBoard.HAND_CURSOR);
        
         JLabel subject2 = new JLabel(DashBoard.userRecords.getSubject2());
        subject2.setPreferredSize(new Dimension(740,70));
        subject2.setFont(DashBoard.ICON_FONT);
          subject2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
          
           subject2.setSize(50,50);
        subject2.setIcon(MethodsForAll.setIconsReturnIcon("src/pictures/book.png", subject1));
        subject2.setHorizontalTextPosition(JLabel.RIGHT);
        subject2.setCursor(DashBoard.HAND_CURSOR);
        
         JLabel subject3 = new JLabel(DashBoard.userRecords.getSubject3());
        subject3.setPreferredSize(new Dimension(740,70));
        subject3.setFont(DashBoard.ICON_FONT);
          subject3.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        
                     subject3.setSize(50,50);
        subject3.setIcon(MethodsForAll.setIconsReturnIcon("src/pictures/book.png", subject1));
        subject3.setHorizontalTextPosition(JLabel.RIGHT);
        subject3.setCursor(DashBoard.HAND_CURSOR);
          
         JLabel subject4 = new JLabel(DashBoard.userRecords.getSubject4());
        subject4.setPreferredSize(new Dimension(740,70));
        subject4.setFont(DashBoard.ICON_FONT);
          subject4.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        
                        subject4.setSize(50,50);
        subject4.setIcon(MethodsForAll.setIconsReturnIcon("src/pictures/book.png", subject1));
        subject4.setHorizontalTextPosition(JLabel.RIGHT);
        subject4.setCursor(DashBoard.HAND_CURSOR);
          
         JLabel subject5 = new JLabel(DashBoard.userRecords.getSubject5());
        subject5.setPreferredSize(new Dimension(740,70));
        subject5.setFont(DashBoard.ICON_FONT);
          subject5.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        
                               subject5.setSize(50,50);
        subject5.setIcon(MethodsForAll.setIconsReturnIcon("src/pictures/book.png", subject1));
        subject5.setHorizontalTextPosition(JLabel.RIGHT);
        subject5.setCursor(DashBoard.HAND_CURSOR);
          
         JLabel subject6 = new JLabel(DashBoard.userRecords.getSubject6());
        subject6.setPreferredSize(new Dimension(740,70));
        subject6.setFont(DashBoard.ICON_FONT);
          subject6.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
   
                                   subject6.setSize(50,50);
        subject6.setIcon(MethodsForAll.setIconsReturnIcon("src/pictures/book.png", subject1));
        subject6.setHorizontalTextPosition(JLabel.RIGHT);
        subject6.setCursor(DashBoard.HAND_CURSOR);
          
      
          contPanel.add(subject1);
            contPanel.add(subject2);
             contPanel.add(subject3);
             contPanel.add(subject4);
                  contPanel.add(subject5);
                    contPanel.add(subject6);
      
            board.modulePanel.add(contPanel);
        
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
        board.modulePanel.add(calendarPanel);
        todoTask();
    }
    
    public void todoTask(){
   
        taskPanel.setBackground(Color.WHITE);
        taskPanel.setLayout(new GridLayout(3,1,0,0));
        taskPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,5));
        JLabel todo = new JLabel("To-Do: ");
        todo.setFont(DashBoard.ICON_FONT);
        todo.setBounds(870, 345, 275, 100);
        
        taskPanel.setBounds(870, 410, 275, 300);
        
        board.modulePanel.add(todo);
        board.modulePanel.add(taskPanel);
    }
       protected static void updateTask(){
           if(i<=2){
            
                JLabel todoLabel = new JLabel();
           
                todoLabel.setText(DashBoard.listOfTodo.removeFirst());
           todoLabel.setBackground(taskPanel.getBackground());
           todoLabel.setOpaque(true);
          todoLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
           todoLabel.setPreferredSize(new Dimension(275,90));
           taskPanel.add(todoLabel);
                   taskPanel.repaint();
           taskPanel.revalidate();
           }
            i++;    
   
    }
       protected static void removeTask(){
           
                  taskPanel.repaint();
           taskPanel.revalidate();
       }
}
