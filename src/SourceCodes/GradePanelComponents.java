/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SourceCodes;

import database.DataBase;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ken-Carlon
 */
public class GradePanelComponents {
       final int WIDTH =560;
       final int HEIGHT =190;
        int num_Sub=0;
        int selectedRow;
        int selectedColumn;
        String selected_ID;
    DashBoard board;
       JTextField prelim = new JTextField();
       JTextField midterm = new JTextField();
       JTextField finals = new JTextField();
       JTextField gwa = new JTextField();
        static   DefaultTableModel tableModel = new DefaultTableModel(){
                    @Override
            	public boolean isCellEditable(int rows,int column) {
		return false;
				}
        };
    private final    JPanel mainPanel = new JPanel();
          Color SUBJECT_BACKGROUND_COLOR= new Color(0x1181C8);
          public static JTable gradeTable = new JTable();
          private JScrollPane scrollPane1 = new JScrollPane();
          private JScrollPane scrollPane2 = new JScrollPane();
          
          
    public GradePanelComponents(DashBoard board) {
        
       this.board = board;
       setWelcome();
       roundPanel();
       mainPanel();
    }
        private void roundPanel() {
            int width=1160;
      
        JPanel roundPanel = new JPanel()
        {
            
            @Override
            public void paint(Graphics g){
                Graphics2D _2d = (Graphics2D) g;
                _2d.setPaint(DashBoard.MODULE_PANEL_COLOR);
                _2d.fillRoundRect(0, 0, width,70, 50,50);
                _2d.setPaint(Color.BLACK);
                _2d.setStroke(new BasicStroke(5));
                _2d.drawRoundRect(0, 0, width-1, 70-1, 50, 50);
            }
        };
        roundPanel.setBounds(25, 100,width, 70);
        board.gradePanel.add(roundPanel);
    }

    private void mainPanel() 
    {
   
  
        mainPanel.setBounds(25, 180, 1160, 600);
    
        mainPanel.setBackground(Color.white);
        if(DataBase.who.equalsIgnoreCase("Student")){
                mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT,10,5));
          subject1();
        subject2();
        subject3();
        subject4();
        subject5();
        subject6();
    }
        else{
             mainPanel.setBounds(25, 180, 1160, 500);
              mainPanel.setLayout(new BorderLayout());
            setTeacherUI();
            setButtons();
              adds();

        }
      
        board.gradePanel.add(mainPanel);
    }

    private void subject1() 
    {
        JPanel panel = new JPanel();
  
        panel.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        panel.setLayout(new BorderLayout(15,0));
        panel.setBackground(mainPanel.getBackground());
        
        JPanel subjectGrade = new JPanel();
        subjectGrade.setBackground(DashBoard.PANEL_BG_COLOR);
        subjectGrade.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        subjectGrade.setLayout(new GridLayout(3,1,0,0));
        
        JLabel subject = new JLabel(DashBoard.userRecords.getSubject1());
        subject.setOpaque(true);
        subject.setFont(new Font("Arial",Font.BOLD,14));
        subject.setBackground(SUBJECT_BACKGROUND_COLOR);
            subject.setHorizontalAlignment(JLabel.CENTER);
        JPanel term = new JPanel();
        term.setLayout(new GridLayout(1,3,0,0));
        term.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        
        JLabel prelim= new JLabel("Prelim");
   
        prelim.setHorizontalAlignment(JLabel.CENTER);
          JLabel midterm= new JLabel("Midterm");
        midterm.setHorizontalAlignment(JLabel.CENTER);
          JLabel finals= new JLabel("Finals");
        finals.setHorizontalAlignment(JLabel.CENTER);
        term.add(prelim);
        term.add(midterm);
        term.add(finals);
             
                    
             JPanel grade = new JPanel();
            grade.setLayout(new GridLayout(1,3,0,0));
        grade.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        grade.setBackground(Color.WHITE);
        
            JLabel prelimGrade= new JLabel(DashBoard.userRecords.getSubject1_PRELIMGrade());
        prelimGrade.setHorizontalAlignment(JLabel.CENTER);
     
        
          JLabel midtermGrade= new JLabel(DashBoard.userRecords.getSubject1_MIDTERMGrade());
        midtermGrade.setHorizontalAlignment(JLabel.CENTER);
        
          JLabel finalsGrade= new JLabel(DashBoard.userRecords.getSubject1_FINALSGrade());
        finalsGrade.setHorizontalAlignment(JLabel.CENTER);
        
        grade.add(prelimGrade);
        grade.add(midtermGrade);
        grade.add(finalsGrade);
        
        subjectGrade.add(subject);
        subjectGrade.add(term);
        subjectGrade.add(grade);
        
        JPanel gwaGrade = new JPanel();
             gwaGrade.setBackground(DashBoard.PANEL_BG_COLOR);
             gwaGrade.setPreferredSize(new Dimension(100,500));
             gwaGrade.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
             gwaGrade.setLayout(new GridLayout(3,1,0,0));
             
              JLabel gwa = new JLabel("GWA");
        gwa.setOpaque(true);
        gwa.setFont(new Font("Arial",Font.BOLD,20));
        gwa.setBackground(SUBJECT_BACKGROUND_COLOR);
           gwa.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));    
           gwa.setHorizontalAlignment(JLabel.CENTER);
        
    
        JLabel total = new JLabel("Total");
        total.setHorizontalAlignment(JLabel.CENTER);
                   total.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));    
    total.setOpaque(true);
               JLabel gwaGrades = new JLabel(DashBoard.userRecords.getSubject1_GWA());
           gwaGrades.setHorizontalAlignment(JLabel.CENTER);
               gwaGrades.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));    
                 gwaGrades.setBackground(Color.WHITE);
                 gwaGrades.setOpaque(true);
            gwaGrade.add(gwa);
            gwaGrade.add(total);
            gwaGrade.add(gwaGrades);
            
             panel.add(subjectGrade,BorderLayout.CENTER);
             panel.add(gwaGrade,BorderLayout.EAST);
        mainPanel.add(panel);
    }
      private void subject2() 
    {
             JPanel panel = new JPanel();
  
        panel.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        panel.setLayout(new BorderLayout(15,0));
        panel.setBackground(mainPanel.getBackground());
        
        JPanel subjectGrade = new JPanel();
        subjectGrade.setBackground(DashBoard.PANEL_BG_COLOR);
        subjectGrade.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        subjectGrade.setLayout(new GridLayout(3,1,0,0));
        
        JLabel subject = new JLabel(DashBoard.userRecords.getSubject2());
        subject.setOpaque(true);
        subject.setHorizontalAlignment(JLabel.CENTER);
       subject.setFont(new Font("Arial",Font.BOLD,14));
        subject.setBackground(SUBJECT_BACKGROUND_COLOR);
        
        JPanel term = new JPanel();
        term.setLayout(new GridLayout(1,3,0,0));
        term.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        
        JLabel prelim= new JLabel("Prelim");
   
        prelim.setHorizontalAlignment(JLabel.CENTER);
          JLabel midterm= new JLabel("Midterm");
        midterm.setHorizontalAlignment(JLabel.CENTER);
          JLabel finals= new JLabel("Finals");
        finals.setHorizontalAlignment(JLabel.CENTER);
        term.add(prelim);
        term.add(midterm);
        term.add(finals);
             
                    
             JPanel grade = new JPanel();
            grade.setLayout(new GridLayout(1,3,0,0));
        grade.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        grade.setBackground(Color.WHITE);
        
            JLabel prelimGrade= new JLabel(DashBoard.userRecords.getSubject2_PRELIMGrade());
        prelimGrade.setHorizontalAlignment(JLabel.CENTER);
     
        
          JLabel midtermGrade= new JLabel(DashBoard.userRecords.getSubject2_MIDTERMGrade());
        midtermGrade.setHorizontalAlignment(JLabel.CENTER);
        
          JLabel finalsGrade= new JLabel(DashBoard.userRecords.getSubject2_FINALSGrade());
        finalsGrade.setHorizontalAlignment(JLabel.CENTER);
        
        grade.add(prelimGrade);
        grade.add(midtermGrade);
        grade.add(finalsGrade);
        
        subjectGrade.add(subject);
        subjectGrade.add(term);
        subjectGrade.add(grade);
        
        JPanel gwaGrade = new JPanel();
             gwaGrade.setBackground(DashBoard.PANEL_BG_COLOR);
             gwaGrade.setPreferredSize(new Dimension(100,500));
             gwaGrade.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
             gwaGrade.setLayout(new GridLayout(3,1,0,0));
             
              JLabel gwa = new JLabel("GWA");
        gwa.setOpaque(true);
        gwa.setFont(new Font("Arial",Font.BOLD,20));
        gwa.setBackground(SUBJECT_BACKGROUND_COLOR);
           gwa.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));    
           gwa.setHorizontalAlignment(JLabel.CENTER);
        
    
        JLabel total = new JLabel("Total");
        total.setHorizontalAlignment(JLabel.CENTER);
                   total.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));    
    total.setOpaque(true);
               JLabel gwaGrades = new JLabel(DashBoard.userRecords.getSubject2_GWA());
           gwaGrades.setHorizontalAlignment(JLabel.CENTER);
               gwaGrades.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));    
                 gwaGrades.setBackground(Color.WHITE);
                 gwaGrades.setOpaque(true);
            gwaGrade.add(gwa);
            gwaGrade.add(total);
            gwaGrade.add(gwaGrades);
            
             panel.add(subjectGrade,BorderLayout.CENTER);
             panel.add(gwaGrade,BorderLayout.EAST);
        mainPanel.add(panel);
    }
       private void subject3() 
    {
               JPanel panel = new JPanel();
  
        panel.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        panel.setLayout(new BorderLayout(15,0));
        panel.setBackground(mainPanel.getBackground());
        
        JPanel subjectGrade = new JPanel();
        subjectGrade.setBackground(DashBoard.PANEL_BG_COLOR);
        subjectGrade.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        subjectGrade.setLayout(new GridLayout(3,1,0,0));
        
        JLabel subject = new JLabel(DashBoard.userRecords.getSubject3());
        subject.setOpaque(true);    subject.setHorizontalAlignment(JLabel.CENTER);
        subject.setFont(new Font("Arial",Font.BOLD,14));
        subject.setBackground(SUBJECT_BACKGROUND_COLOR);
        
        JPanel term = new JPanel();
        term.setLayout(new GridLayout(1,3,0,0));
        term.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        
        JLabel prelim= new JLabel("Prelim");
   
        prelim.setHorizontalAlignment(JLabel.CENTER);
          JLabel midterm= new JLabel("Midterm");
        midterm.setHorizontalAlignment(JLabel.CENTER);
          JLabel finals= new JLabel("Finals");
        finals.setHorizontalAlignment(JLabel.CENTER);
        term.add(prelim);
        term.add(midterm);
        term.add(finals);
             
                    
             JPanel grade = new JPanel();
            grade.setLayout(new GridLayout(1,3,0,0));
        grade.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        grade.setBackground(Color.WHITE);
        
            JLabel prelimGrade= new JLabel("10.00");
        prelimGrade.setHorizontalAlignment(JLabel.CENTER);
     
        
          JLabel midtermGrade= new JLabel("10.00");
        midtermGrade.setHorizontalAlignment(JLabel.CENTER);
        
          JLabel finalsGrade= new JLabel("10.23");
        finalsGrade.setHorizontalAlignment(JLabel.CENTER);
        
        prelimGrade.setText(DashBoard.userRecords.getSubject3_PRELIMGrade());
        midtermGrade.setText(DashBoard.userRecords.getSubject3_MIDTERMGrade());
        finalsGrade.setText(DashBoard.userRecords.getSubject3_FINALSGrade());
        grade.add(prelimGrade);
        grade.add(midtermGrade);
        grade.add(finalsGrade);
        
        subjectGrade.add(subject);
        subjectGrade.add(term);
        subjectGrade.add(grade);
        
        JPanel gwaGrade = new JPanel();
             gwaGrade.setBackground(DashBoard.PANEL_BG_COLOR);
             gwaGrade.setPreferredSize(new Dimension(100,500));
             gwaGrade.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
             gwaGrade.setLayout(new GridLayout(3,1,0,0));
             
              JLabel gwa = new JLabel("GWA");
        gwa.setOpaque(true);
        gwa.setFont(new Font("Arial",Font.BOLD,20));
        gwa.setBackground(SUBJECT_BACKGROUND_COLOR);
           gwa.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));    
           gwa.setHorizontalAlignment(JLabel.CENTER);
        
    
        JLabel total = new JLabel("Total");
        total.setHorizontalAlignment(JLabel.CENTER);
                   total.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));    
    total.setOpaque(true);
               JLabel gwaGrades = new JLabel(DashBoard.userRecords.getSubject3_GWA());
           gwaGrades.setHorizontalAlignment(JLabel.CENTER);
               gwaGrades.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));   
                 gwaGrades.setBackground(Color.WHITE);
                 gwaGrades.setOpaque(true);
            gwaGrade.add(gwa);
            gwaGrade.add(total);
            gwaGrade.add(gwaGrades);
            
             panel.add(subjectGrade,BorderLayout.CENTER);
             panel.add(gwaGrade,BorderLayout.EAST);
        mainPanel.add(panel);
    }
      private void subject4() 
    {
             JPanel panel = new JPanel();
  
        panel.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        panel.setLayout(new BorderLayout(15,0));
        panel.setBackground(mainPanel.getBackground());
        
        JPanel subjectGrade = new JPanel();
        subjectGrade.setBackground(DashBoard.PANEL_BG_COLOR);
        subjectGrade.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        subjectGrade.setLayout(new GridLayout(3,1,0,0));
        
        JLabel subject = new JLabel(DashBoard.userRecords.getSubject4());
        subject.setOpaque(true);    subject.setHorizontalAlignment(JLabel.CENTER);
        subject.setFont(new Font("Arial",Font.BOLD,14));
        subject.setBackground(SUBJECT_BACKGROUND_COLOR);
        
        JPanel term = new JPanel();
        term.setLayout(new GridLayout(1,3,0,0));
        term.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        
        JLabel prelim= new JLabel("Prelim");
   
        prelim.setHorizontalAlignment(JLabel.CENTER);
          JLabel midterm= new JLabel("Midterm");
        midterm.setHorizontalAlignment(JLabel.CENTER);
          JLabel finals= new JLabel("Finals");
        finals.setHorizontalAlignment(JLabel.CENTER);
        term.add(prelim);
        term.add(midterm);
        term.add(finals);
             
                    
             JPanel grade = new JPanel();
            grade.setLayout(new GridLayout(1,3,0,0));
        grade.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        grade.setBackground(Color.WHITE);
        
            JLabel prelimGrade= new JLabel("10.00");
        prelimGrade.setHorizontalAlignment(JLabel.CENTER);
     
        
          JLabel midtermGrade= new JLabel("10.00");
        midtermGrade.setHorizontalAlignment(JLabel.CENTER);
        
          JLabel finalsGrade= new JLabel("10.23");
        finalsGrade.setHorizontalAlignment(JLabel.CENTER);
        
               prelimGrade.setText(DashBoard.userRecords.getSubject4_PRELIMGrade());
        midtermGrade.setText(DashBoard.userRecords.getSubject4_MIDTERMGrade());
        finalsGrade.setText(DashBoard.userRecords.getSubject4_FINALSGrade());
        

        grade.add(prelimGrade);
        grade.add(midtermGrade);
        grade.add(finalsGrade);
        
        subjectGrade.add(subject);
        subjectGrade.add(term);
        subjectGrade.add(grade);
        
        JPanel gwaGrade = new JPanel();
             gwaGrade.setBackground(DashBoard.PANEL_BG_COLOR);
             gwaGrade.setPreferredSize(new Dimension(100,500));
             gwaGrade.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
             gwaGrade.setLayout(new GridLayout(3,1,0,0));
             
              JLabel gwa = new JLabel("GWA");
        gwa.setOpaque(true);
     
        gwa.setFont(new Font("Arial",Font.BOLD,20));
        gwa.setBackground(SUBJECT_BACKGROUND_COLOR);
           gwa.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));    
           gwa.setHorizontalAlignment(JLabel.CENTER);
        
    
        JLabel total = new JLabel("Total");
        total.setHorizontalAlignment(JLabel.CENTER);
                   total.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));    
    total.setOpaque(true);
               JLabel gwaGrades = new JLabel(DashBoard.userRecords.getSubject4_GWA());
           gwaGrades.setHorizontalAlignment(JLabel.CENTER);
               gwaGrades.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));    
                 gwaGrades.setBackground(Color.WHITE);
                 gwaGrades.setOpaque(true);
            gwaGrade.add(gwa);
            gwaGrade.add(total);
            gwaGrade.add(gwaGrades);
            
             panel.add(subjectGrade,BorderLayout.CENTER);
             panel.add(gwaGrade,BorderLayout.EAST);
        mainPanel.add(panel);
    }
       private void subject5() 
    {
          JPanel panel = new JPanel();
  
        panel.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        panel.setLayout(new BorderLayout(15,0));
        panel.setBackground(mainPanel.getBackground());
        
        JPanel subjectGrade = new JPanel();
        subjectGrade.setBackground(DashBoard.PANEL_BG_COLOR);
        subjectGrade.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        subjectGrade.setLayout(new GridLayout(3,1,0,0));
        
        JLabel subject = new JLabel(DashBoard.userRecords.getSubject5());
        subject.setOpaque(true);    subject.setHorizontalAlignment(JLabel.CENTER);
        subject.setFont(new Font("Arial",Font.BOLD,14));
        subject.setBackground(SUBJECT_BACKGROUND_COLOR);
        
        JPanel term = new JPanel();
        term.setLayout(new GridLayout(1,3,0,0));
        term.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        
        JLabel prelim= new JLabel("Prelim");
   
        prelim.setHorizontalAlignment(JLabel.CENTER);
          JLabel midterm= new JLabel("Midterm");
        midterm.setHorizontalAlignment(JLabel.CENTER);
          JLabel finals= new JLabel("Finals");
        finals.setHorizontalAlignment(JLabel.CENTER);
        term.add(prelim);
        term.add(midterm);
        term.add(finals);
             
                    
             JPanel grade = new JPanel();
            grade.setLayout(new GridLayout(1,3,0,0));
        grade.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        grade.setBackground(Color.WHITE);
        
            JLabel prelimGrade= new JLabel("10.00");
        prelimGrade.setHorizontalAlignment(JLabel.CENTER);
     
        
          JLabel midtermGrade= new JLabel("10.00");
        midtermGrade.setHorizontalAlignment(JLabel.CENTER);
        
          JLabel finalsGrade= new JLabel("10.23");
        finalsGrade.setHorizontalAlignment(JLabel.CENTER);
                               prelimGrade.setText(DashBoard.userRecords.getSubject5_PRELIMGrade());
        midtermGrade.setText(DashBoard.userRecords.getSubject5_MIDTERMGrade());
        finalsGrade.setText(DashBoard.userRecords.getSubject5_FINALSGrade());
        grade.add(prelimGrade);
        grade.add(midtermGrade);
        grade.add(finalsGrade);
        
        subjectGrade.add(subject);
        subjectGrade.add(term);
        subjectGrade.add(grade);
        
        JPanel gwaGrade = new JPanel();
             gwaGrade.setBackground(DashBoard.PANEL_BG_COLOR);
             gwaGrade.setPreferredSize(new Dimension(100,500));
             gwaGrade.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
             gwaGrade.setLayout(new GridLayout(3,1,0,0));
             
              JLabel gwa = new JLabel("GWA");
        gwa.setOpaque(true);
        gwa.setFont(new Font("Arial",Font.BOLD,20));
        gwa.setBackground(SUBJECT_BACKGROUND_COLOR);
           gwa.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));    
           gwa.setHorizontalAlignment(JLabel.CENTER);
        
    
        JLabel total = new JLabel("Total");
        total.setHorizontalAlignment(JLabel.CENTER);
                   total.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));    
    total.setOpaque(true);
               JLabel gwaGrades = new JLabel(DashBoard.userRecords.getSubject5_GWA());
           gwaGrades.setHorizontalAlignment(JLabel.CENTER);
               gwaGrades.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));    
                 gwaGrades.setBackground(Color.WHITE);
                 gwaGrades.setOpaque(true);
            gwaGrade.add(gwa);
            gwaGrade.add(total);
            gwaGrade.add(gwaGrades);
            
             panel.add(subjectGrade,BorderLayout.CENTER);
             panel.add(gwaGrade,BorderLayout.EAST);
        mainPanel.add(panel);
    }
      private void subject6() 
    {
            JPanel panel = new JPanel();
  
        panel.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        panel.setLayout(new BorderLayout(15,0));
        panel.setBackground(mainPanel.getBackground());
        
        JPanel subjectGrade = new JPanel();
        subjectGrade.setBackground(DashBoard.PANEL_BG_COLOR);
        subjectGrade.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        subjectGrade.setLayout(new GridLayout(3,1,0,0));
        
        JLabel subject = new JLabel(DashBoard.userRecords.getSubject6());
        subject.setOpaque(true);    subject.setHorizontalAlignment(JLabel.CENTER);
        subject.setFont(new Font("Arial",Font.BOLD,14));
        subject.setBackground(SUBJECT_BACKGROUND_COLOR);
        
        JPanel term = new JPanel();
        term.setLayout(new GridLayout(1,3,0,0));
        term.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        
        JLabel prelim= new JLabel("Prelim");
   
        prelim.setHorizontalAlignment(JLabel.CENTER);
          JLabel midterm= new JLabel("Midterm");
        midterm.setHorizontalAlignment(JLabel.CENTER);
          JLabel finals= new JLabel("Finals");
        finals.setHorizontalAlignment(JLabel.CENTER);
        term.add(prelim);
        term.add(midterm);
        term.add(finals);
             
                    
             JPanel grade = new JPanel();
            grade.setLayout(new GridLayout(1,3,0,0));
        grade.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        grade.setBackground(Color.WHITE);
        
            JLabel prelimGrade= new JLabel("10.00");
        prelimGrade.setHorizontalAlignment(JLabel.CENTER);
     
        
          JLabel midtermGrade= new JLabel("10.00");
        midtermGrade.setHorizontalAlignment(JLabel.CENTER);
        
          JLabel finalsGrade= new JLabel("10.23");
        finalsGrade.setHorizontalAlignment(JLabel.CENTER);
        
                              prelimGrade.setText(DashBoard.userRecords.getSubject6_PRELIMGrade());
        midtermGrade.setText(DashBoard.userRecords.getSubject6_MIDTERMGrade());
        finalsGrade.setText(DashBoard.userRecords.getSubject6_FINALSGrade());
        grade.add(prelimGrade);
        grade.add(midtermGrade);
        grade.add(finalsGrade);
        
        subjectGrade.add(subject);
        subjectGrade.add(term);
        subjectGrade.add(grade);
        
        JPanel gwaGrade = new JPanel();
             gwaGrade.setBackground(DashBoard.PANEL_BG_COLOR);
             gwaGrade.setPreferredSize(new Dimension(100,500));
             gwaGrade.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
             gwaGrade.setLayout(new GridLayout(3,1,0,0));
             
              JLabel gwa = new JLabel("GWA");
        gwa.setOpaque(true);
        gwa.setFont(new Font("Arial",Font.BOLD,20));
        gwa.setBackground(SUBJECT_BACKGROUND_COLOR);
           gwa.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));    
           gwa.setHorizontalAlignment(JLabel.CENTER);
        
    
        JLabel total = new JLabel("Total");
        total.setHorizontalAlignment(JLabel.CENTER);
                   total.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));    
    total.setOpaque(true);
               JLabel gwaGrades = new JLabel(DashBoard.userRecords.getSubject6_GWA());
           gwaGrades.setHorizontalAlignment(JLabel.CENTER);
               gwaGrades.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));    
                 gwaGrades.setBackground(Color.WHITE);
                 gwaGrades.setOpaque(true);
            gwaGrade.add(gwa);
            gwaGrade.add(total);
            gwaGrade.add(gwaGrades);
            
             panel.add(subjectGrade,BorderLayout.CENTER);
             panel.add(gwaGrade,BorderLayout.EAST);
        mainPanel.add(panel);
    }

    private void setTeacherUI()
    {
        gwa.setEditable(false);
        JLabel selectedSubject = new JLabel();
    
        selectedSubject.setBounds(25, 710, 500, 20);
      
        selectedSubject.setVerticalAlignment(JLabel.CENTER);
        
          JLabel nameOfSelectedRow = new JLabel();
            nameOfSelectedRow.setBounds(25, 690, 500, 20);
        nameOfSelectedRow.setVerticalAlignment(JLabel.TOP);
        board.gradePanel.add(nameOfSelectedRow);
         board.gradePanel.add(selectedSubject);
        gradeTable.getTableHeader().setReorderingAllowed(false);
    
        gradeTable.addMouseListener(new MouseAdapter(){
           @Override
           public void mouseClicked(MouseEvent e){
        
              int column=    gradeTable.getSelectedColumn();
              int row=         gradeTable.getSelectedRow();
                     selectedRow =row;
                     selectedColumn = column;
               
                     if(selectedRow<=1){
                             selected_ID = tableModel.getValueAt(row, 1).toString();
              nameOfSelectedRow.setText(tableModel.getValueAt(row, 0).toString());
  
               
              try{
                    if(2<=column && 5>=column){
                        num_Sub=1;
                             selectedSubject.setText(DashBoard.userRecords.getSubject1());
                         prelim.setText(tableModel.getValueAt(row, 2).toString());
              midterm.setText(tableModel.getValueAt(row, 3).toString());
              finals.setText(tableModel.getValueAt(row, 4).toString());
              gwa.setText(tableModel.getValueAt(row, 5).toString());
              }
                    else if(6<=column &&9>=column){
                          num_Sub=2;
                          selectedSubject.setText(DashBoard.userRecords.getSubject2());
                                        prelim.setText(tableModel.getValueAt(row, 6).toString());
              midterm.setText(tableModel.getValueAt(row,7).toString());
              finals.setText(tableModel.getValueAt(row, 8).toString());
              gwa.setText(tableModel.getValueAt(row, 9).toString());
                    }
                        else if(10<=column &&13>=column){
                                 num_Sub=3;
                                  selectedSubject.setText(DashBoard.userRecords.getSubject3());
                                        prelim.setText(tableModel.getValueAt(row, 10).toString());
              midterm.setText(tableModel.getValueAt(row, 11).toString());
              finals.setText(tableModel.getValueAt(row, 12).toString());
              gwa.setText(tableModel.getValueAt(row, 13).toString());
                    }
                        else if(14<=column &&17>=column){
                                   num_Sub=4;
                                    selectedSubject.setText(DashBoard.userRecords.getSubject4());
                                        prelim.setText(tableModel.getValueAt(row, 14).toString());
              midterm.setText(tableModel.getValueAt(row, 15).toString());
              finals.setText(tableModel.getValueAt(row, 16).toString());
              gwa.setText(tableModel.getValueAt(row, 17).toString());
                    }
                        else if(18<=column &&21>=column){
                               num_Sub=5;
                                  selectedSubject.setText(DashBoard.userRecords.getSubject5());
                                        prelim.setText(tableModel.getValueAt(row, 18).toString());
              midterm.setText(tableModel.getValueAt(row, 19).toString());
              finals.setText(tableModel.getValueAt(row, 20).toString());
              gwa.setText(tableModel.getValueAt(row, 21).toString());
                    }
                        else if(22<=column &&25>=column){
                               num_Sub=6;
                                 selectedSubject.setText(DashBoard.userRecords.getSubject6());
                                        prelim.setText(tableModel.getValueAt(row, 22).toString());
              midterm.setText(tableModel.getValueAt(row, 23).toString());
              finals.setText(tableModel.getValueAt(row, 24).toString());
              gwa.setText(tableModel.getValueAt(row, 25).toString());
                    }
                        else{
                                 selectedSubject.setText("");
               prelim.setText("");
              midterm.setText("");
              finals.setText("");
              gwa.setText("");
                        }
              }
              catch(NullPointerException ex){
                  JOptionPane.showMessageDialog(DashBoard.mainFrame, "Error at"+ex.getMessage());
              }
              
                     }
                     else if(selectedRow>1)
                     JOptionPane.showMessageDialog(DashBoard.mainFrame, "Select 1 row at a time");
          
                 
       
           } 
        });
        tableModel.setColumnIdentifiers(new String[]{
            "Student Name",
            "Student Number",
            DashBoard.userRecords.getSubject1()+" Prelim",
            DashBoard.userRecords.getSubject1()+" Midterm",
            DashBoard.userRecords.getSubject1()+" Finals",
            DashBoard.userRecords.getSubject1()+" GWA",
        
            DashBoard.userRecords.getSubject2()+" Prelim",
            DashBoard.userRecords.getSubject2()+" Midterm",
            DashBoard.userRecords.getSubject2()+" Finals",
            DashBoard.userRecords.getSubject2()+" GWA",
            
            DashBoard.userRecords.getSubject3()+" Prelim",
            DashBoard.userRecords.getSubject3()+" Midterm",
            DashBoard.userRecords.getSubject3()+" Finals",
            DashBoard.userRecords.getSubject3()+" GWA",
            
            DashBoard.userRecords.getSubject4()+" Prelim",
            DashBoard.userRecords.getSubject4()+" Midterm",
            DashBoard.userRecords.getSubject4()+" Finals",
            DashBoard.userRecords.getSubject4()+" GWA",
            
            DashBoard.userRecords.getSubject5()+" Prelim",
            DashBoard.userRecords.getSubject5()+" Midterm",
            DashBoard.userRecords.getSubject5()+" Finals",
            DashBoard.userRecords.getSubject5()+"GWA",
            
            DashBoard.userRecords.getSubject6()+" Prelim",
            DashBoard.userRecords.getSubject6()+" Midterm",
            DashBoard.userRecords.getSubject6()+" Finals",
            DashBoard.userRecords.getSubject6()+" GWA",
        });
    
          scrollPane2.setViewportView(gradeTable);
          scrollPane1.setViewportView(scrollPane2);
      gradeTable.setModel(tableModel);
        DataBase.displayGrade(gradeTable);
  
      
       
  
        
    }
    public void adds(){
              mainPanel.add(scrollPane1,BorderLayout.CENTER);
    }

    private  void setButtons() 
    {
          String regex= "^(0|[1-9][0-9]?|100)$";
        JButton editButton = new JButton("Edit Grade");
        editButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!prelim.getText().isBlank() &&!midterm.getText().isBlank() && !finals.getText().isBlank())
                  if(prelim.getText().matches(regex) && midterm.getText().matches(regex) && finals.getText().matches(regex)){
                            DataBase.gradeUpdate(tableModel,selectedRow,selectedColumn,selected_ID,num_Sub,prelim,midterm,finals);
                  }
                  else
                      JOptionPane.showMessageDialog(DashBoard.mainFrame, "Please double check your answer. Only 0-100 are allowed");
          
                else
                    JOptionPane.showMessageDialog(DashBoard.mainFrame, "Don`t leave the textfield blank");
            }
            
        });
        editButton.setBounds(1100, 690, 100, 90);
      
       JTextField searchBar = new JTextField();
       
       JPanel txtPanel = new JPanel();
    txtPanel.setBounds(25, 735, 800, 20);
    txtPanel.setBackground(DashBoard.PANEL_BG_COLOR);
        txtPanel.setLayout(new GridLayout(1,4));
        txtPanel.add(new JLabel("PRELIM"));
        txtPanel.add(new JLabel("MIDTERM"));
        txtPanel.add(new JLabel("FINALS"));
        txtPanel.add(new JLabel("GWA"));
       JPanel compPanel = new JPanel();
       compPanel.setBackground(Color.RED);
       compPanel.setBounds(25, 755,800, 25);
       compPanel.setLayout(new GridLayout(1,4));
       compPanel.add(prelim);
       compPanel.add(midterm);
       compPanel.add(finals);
       compPanel.add(gwa);
       board.gradePanel.add(txtPanel);
       board.gradePanel.add(compPanel);
       board.gradePanel.add(editButton);
       board.gradePanel.add(searchBar);
    }

    private void setWelcome() {
            JPanel panel = new JPanel();
           
                  panel.setBounds(42, 105, 1125, 55);
                  panel.setBackground(DashBoard.MODULE_PANEL_COLOR);
                  panel.setLayout(new BorderLayout());
                                       
                         JLabel gradePanelTitle = new JLabel("Grade");
                           gradePanelTitle.setFont(new Font("Arial",Font.BOLD,50));
                            gradePanelTitle.setHorizontalAlignment(JLabel.CENTER);
                            gradePanelTitle.setVerticalAlignment(JLabel.CENTER);
                         if(DataBase.who.equalsIgnoreCase("Teacher")){
                             String what="";
                             if(DashBoard.userRecords.getStudentProgram().equalsIgnoreCase("ICT"))
                                 what = "BSIT";
                             else if(DashBoard.userRecords.getStudentProgram().equalsIgnoreCase("HM"))
                                 what = "BSHM";
                             else if(DashBoard.userRecords.getStudentProgram().equalsIgnoreCase("TM"))
                                 what = "BSTM";
                             
                                   gradePanelTitle.setText(what+" Students");
                         }
                       
                          
                            panel.add(gradePanelTitle,BorderLayout.CENTER);

                               board.gradePanel.add(panel);
    }
   
}
