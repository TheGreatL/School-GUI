package SourceCodes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.BorderFactory;
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
    
}
