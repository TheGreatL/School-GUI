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
 public class StudentInfo extends User {

    public static JFrame myFrame = new JFrame();
     JTextField fName = new JTextField("First Name");
     JTextField mName = new JTextField("Middle Name");
     JTextField lName = new JTextField("Last Name");
     JTextField password = new JTextField("Password");
     JComboBox program = new JComboBox();
     JComboBox year = new JComboBox();
     JComboBox section = new JComboBox();
     JTextField contact = new JTextField("Contact");
     JTextField guardian = new JTextField("Guardian");
     JTextField address = new JTextField("Address");
     JTextField birthday = new JTextField("Birthday");
     JTextField bio = new JTextField("Bio");
     JComboBox status = new JComboBox();
     JButton submit = new JButton("Submit");
     String sections[] = new String[8];
     String whatProgram= "";
     StudentInfo(){
         myFrame.setLayout(new FlowLayout());
         myFrame.setSize(250, 625);
         myFrame.setTitle("Student Register");
         askName();
         askPassword();
         askProgram();
         askContact();
        askGuardian();
        askAddress();
        askBirthday();
        askBio();
                askYear();
                        askSection();
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
        myFrame.add(lName);
    }

    @Override
    public void askPassword() 
    {
         password.setPreferredSize(new Dimension(200,40));
          myFrame.add(password);
    }
    public void askSection(){
          section.setPreferredSize(new Dimension(200,20));
        section.setModel(new DefaultComboBoxModel(sections));
        myFrame.add(section);
    }
 public void askYear(){
        year.setPreferredSize(new Dimension(200,20));
        year.setModel(new DefaultComboBoxModel(new String[]{
            "1st","2nd","3rd","4th"
        }));
        myFrame.add(year);
    }
    @Override
    public void askProgram() {
           program.setPreferredSize(new Dimension(200,40));
       DefaultComboBoxModel model = new DefaultComboBoxModel(new String[]{
           "BSIT", "BSHM","BSTM"
       });
           program.setModel(model);
           program.addActionListener(new ActionListener(){
               @Override
               public void actionPerformed(ActionEvent e) 
               {
                   whatProgram = program.getSelectedItem().toString();
                
                    int index=0;
                    String prefix= "";
                    if(whatProgram.equalsIgnoreCase("BSIT"))
                       prefix="IT";
                    else if(whatProgram.equalsIgnoreCase("BSTM"))
                       prefix="TM";
                       else     if(whatProgram.equalsIgnoreCase("BSHM"))
                       prefix="HM";
                        for(int x=0;x<4;x++) { for(int y= 1;y<=2;y++) sections[index++] = prefix+"-"+(x+1)+"0"+y+"A"; }
                      section.setModel(new DefaultComboBoxModel(sections));
                       
               }

           
               
           });
                myFrame.add(program);
    }
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
                String uprogram = program.getSelectedItem().toString();

		String uyear = year.getSelectedItem().toString();
		
		
		String usection = section.getSelectedItem().toString();

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
                    list.add(uyear);
                    list.add(usection);
                    list.add(ucontact);
                    list.add(uguardian);
                    list.add(uaddress);
                    list.add(ubirthday);
                    list.add(dateEnrolled);
                    list.add(ubio);
                    list.add(pic);
                    list.add(ustatus);
                        if(DataBase.writeDataStudent(list)){
                     
                               Main.runGUI();
                                 myFrame.dispose();
                                 System.out.println(83);
                        }
                     
                }
                
            });
            myFrame.add(submit);
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
