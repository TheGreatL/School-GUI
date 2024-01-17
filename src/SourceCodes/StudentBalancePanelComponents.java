package SourceCodes;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Ken-Carlon
 */
public class StudentBalancePanelComponents {
    DashBoard board;
        JPanel mainPanel = new JPanel();
    StudentBalancePanelComponents(DashBoard board) {
  
        this.board = board;
        welcome();
        roundPanel();
        mainPanel();
    }

    private void roundPanel() {
        JPanel roundPanel = new JPanel(){
            
            @Override
            public void paint(Graphics g){
                Graphics2D _2d = (Graphics2D) g;
                _2d.setPaint(DashBoard.MODULE_PANEL_COLOR);
                _2d.fillRoundRect(0, 0, 1000,70, 50,50);
                _2d.setPaint(Color.BLACK);
                _2d.setStroke(new BasicStroke(5));
                _2d.drawRoundRect(0, 0, 1000-1, 70-1, 50, 50);
            }
        };
        roundPanel.setBounds(115, 100,1000, 70);
        board.balancePanel.add(roundPanel);
    }

    private void mainPanel() {
    
        mainPanel.setBackground(DashBoard.PANEL_BG_COLOR);
        mainPanel.setBounds(115, 180, 1000, 600);
        mainPanel.setLayout(null);
        panel1Balance();
        panel2Balance();
        panel3Balance();
        panel4Balance();
        
        board.balancePanel.add(mainPanel);
    
    }
    private void panel1Balance()
    {
        JPanel panel = new JPanel();
   
        panel.setBounds(5, 5, 490, 400);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        panel.setLayout(new BorderLayout());
       JLabel t= new JLabel("Student FEE:");
       t.setHorizontalAlignment(JLabel.CENTER);
        JLabel s=  new JLabel("\u20B1 30,0000");
         s.setHorizontalAlignment(JLabel.CENTER);
        panel.add(t,BorderLayout.NORTH);
        panel.add(s,BorderLayout.CENTER);
        mainPanel.add(panel);
    }
    
    private void panel2Balance()
    {
        JPanel panel = new JPanel();
        panel.setBounds(500, 5, 490,200);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        mainPanel.add(panel);
    }
    private void panel3Balance()
    {
        JPanel panel = new JPanel();
        panel.setBounds(5,420,490,160);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        mainPanel.add(panel);
    }
    private void panel4Balance()
    {
        JPanel panel = new JPanel();
       
        panel.setBounds(500,220,490,360);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        mainPanel.add(panel);
    }

    private void welcome() {
     
            JPanel panel = new JPanel();
           
                  panel.setBounds(133, 105, 960, 55);
                  panel.setBackground(DashBoard.MODULE_PANEL_COLOR);

                  panel.setLayout(new BorderLayout());
                                       
                         JLabel  balancePanelTitle = new JLabel("Student Balance");
                            balancePanelTitle.setFont(new Font("Arial",Font.BOLD,50));
                            balancePanelTitle.setHorizontalAlignment(JLabel.CENTER);
                            balancePanelTitle.setVerticalAlignment(JLabel.CENTER);
                            panel.add(balancePanelTitle,BorderLayout.CENTER);

                               board.balancePanel.add(panel);
    
    }
    
}
