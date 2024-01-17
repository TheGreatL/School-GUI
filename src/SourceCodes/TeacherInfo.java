/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SourceCodes;

import database.DataBase;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.LinkedList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author Ken-Carlon
 */
public class TeacherInfo extends User {
  public static JFrame myFrame = new JFrame();
     JTextField fName = new JTextField("First Name");
     JTextField mName = new JTextField("Middle Name");
     JTextField lName = new JTextField("Last Name");
     JTextField password = new JTextField("Password");
     JComboBox faculty = new JComboBox(); 
     DefaultComboBoxModel model = new DefaultComboBoxModel(new String[]{
         "ICT","HM","TM"
     });
     JTextField contact = new JTextField("Contact");
     JTextField guardian = new JTextField("Guardian");
     JTextField address = new JTextField("Address");
     JTextField birthday = new JTextField("Birthday");
     JTextField bio = new JTextField("Bio");
     JComboBox status = new JComboBox();
     JButton submit = new JButton("Submit");
     
     String whatProgram= "";
     TeacherInfo(){
         myFrame.setLayout(new FlowLayout());
         myFrame.setSize(250, 600);
         myFrame.setTitle("Student Register");
         askName();
         askPassword();
         askProgram();
         askContact();
        askGuardian();
        askAddress();
        askBirthday();
        askBio();
        askStatus();
        setButton();
     }
  
    void setViewFrame(boolean b) {
               myFrame.setLocationRelativeTo(null);
        myFrame.setVisible(b);
    }

    @Override
    public void askName() {
   fName.setPreferredSize(new Dimension(200,40));
         mName.setPreferredSize(new Dimension(200,40));
         lName.setPreferredSize(new Dimension(200,40));
                
        myFrame.add(fName);
        myFrame.add(mName);
        myFrame.add(lName);    }

    @Override
    public void askPassword() {
  password.setPreferredSize(new Dimension(200,40));
          myFrame.add(password);    }
    
       private void setButton() {
            submit.setPreferredSize(new Dimension(200,40));
            submit.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                                      long rand =(long) (100000000L+Math.random() * 100000000);
		String stud_Id ="2004"+(Long.toString(rand).substring(0, 7));
                
		LocalDate datenow = LocalDate.now();
                String email =lName.getText()+stud_Id.substring(4, 11)+"@sti.edu.ph";
                String name = fName.getText()+" "+mName.getText()+" "+lName.getText()+" ";
                String upassword= password.getText();
                String uprogram = faculty.getSelectedItem().toString();

		

		String ucontact = contact.getText();

		String uguardian = guardian.getText();

		String uaddress = address.getText();
                                    
		String ubirthday = birthday.getText();
                                          String dateEnrolled = datenow.toString();
		String ubio = bio.getText();
                            String pic = "src//pictures//DefaultIcons//defaultPfP.png";
		
		String ustatus = status.getSelectedItem().toString();
		
		
		

		
		
          
                    LinkedList list = new LinkedList();
                    list.add(email);
                    list.add(name);
                    list.add(upassword);
                    list.add(stud_Id);
                    list.add(uprogram);
                    
                    list.add(ucontact);
                    list.add(uguardian);
                    list.add(uaddress);
                    list.add(ubirthday);
                    list.add(dateEnrolled);
                     list.add(pic);
                    list.add(ubio);
                   
                    list.add(ustatus);
       
                        if(DataBase.writeDataTeacher(list))      {myFrame.dispose(); Main.runGUI();}
                }
                
            });
            myFrame.add(submit);
               }

    @Override
    public void askProgram() {
        faculty.setPreferredSize(new Dimension(200,40));
        faculty.setModel(model);
        myFrame.add(faculty);
    }

      @Override
    public void askContact() {
 contact.setPreferredSize(new Dimension(200,40));
                
        myFrame.add(contact);    
    }

    @Override
    public void askGuardian() {
        guardian.setPreferredSize(new Dimension(200,40));
                
        myFrame.add(guardian);    
    }

    @Override
    public void askAddress() {
            address.setPreferredSize(new Dimension(200,40));
                
        myFrame.add(address);   
    }

    @Override
    public void askBirthday() {
                   birthday.setPreferredSize(new Dimension(200,40));
                
        myFrame.add(birthday);   
    }

    @Override
    public void askBio() {
                         bio.setPreferredSize(new Dimension(200,40));
                
        myFrame.add(bio);   
    }

    @Override
    public void askStatus() {
          status.setPreferredSize(new Dimension(200,20));
        status.setModel(new DefaultComboBoxModel(new String[]{
           "ACTIVE","INACTIVE"
        }));
        myFrame.add(status);
    }

    
    
}
