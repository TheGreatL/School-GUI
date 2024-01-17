/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SourceCodes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;

/**
 *
 * @author Ken-Carlon
 */
public class AskUser {
    
    public void ask() {
                      JDialog dialog  = new JDialog();
                    dialog.setModal(true);
                    dialog.setUndecorated(true);
                    dialog.getContentPane().setBackground(Color.gray);
                    dialog.setSize(400, 250);
                    dialog.setLayout(new FlowLayout());
                    JComboBox who = new JComboBox();
                    DefaultComboBoxModel model = new DefaultComboBoxModel(new String[]{
                        "Run Gui","Student","Teacher"
                    });
                  
                    JButton button = new JButton("Submit");
                    button.setPreferredSize(new Dimension(150,50));
                    button.addActionListener(new ActionListener(){
                          @Override
                          public void actionPerformed(ActionEvent e) {
                                
                              if(who.getSelectedItem().toString().equalsIgnoreCase("Student")){
                                  dialog.dispose();
                                  StudentInfo student =new StudentInfo();
                                  
                                    student.setViewFrame(true);
                                    
                                }
                              else if(who.getSelectedItem().toString().equalsIgnoreCase("Teacher")){
                                       dialog.dispose();
                                  TeacherInfo teacher =new TeacherInfo();
                                    teacher.setViewFrame(true);
                              
                                    
                                }
                              else if(who.getSelectedItem().toString().equalsIgnoreCase("Run Gui")){
                                   dialog.dispose();
                                         Main.runGUI();
                              }
                            
                          }
                        
                    });
                     who.setPreferredSize(new Dimension(150,50));
                    who.setModel(model);
                    dialog.add(who);
                    dialog.add(button);
                    dialog.setLocationRelativeTo(null);
                    
                    dialog.setVisible(true);
    }
    
}
