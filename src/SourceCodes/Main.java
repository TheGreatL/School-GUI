package SourceCodes;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import database.DataBase;
import java.time.LocalDate;

public class Main {
    
	static Scanner input = new Scanner(System.in);

	public static void main(String args[]) {


           askUser();
	runGUI();
	



	}
	

	public static void runGUI() {
		new Thread(() -> {
			
				// Your existing code for weather data retrieval
				LogInFrame frame = new LogInFrame();
				frame.showFrame(true);
				// Update UI on the EDT (Event Dispatch Thread)

			
			
		}).start();
		
		
		
		
	}


	protected static void askUser() {
		 String tchrPrefix = "2003";
		 String stdnPrefix = "2004";
		 
                                    String whoPrefix = "";
                                    
                                   System.out.println("What are you?\n1.Student\n2.Teacher");
                                   int what = input.nextInt();
                                   input.nextLine();
                                   if(what == 1){
                                       whoPrefix = stdnPrefix;
                                       
                                       long rand =(long) (100000000L+Math.random() * 100000000);
		String stud_Id =whoPrefix+(Long.toString(rand).substring(0, 7));

		LocalDate datenow = LocalDate.now();
                
                                    
		System.out.println("Enter your First Name: ");
		String fname = input.nextLine();
		System.out.println("Enter your Middle Name: ");
		String mname = input.nextLine();
		System.out.println("Enter your Last Name: ");
		String lname = input.nextLine();
		
		String email = 	lname+stud_Id.substring(4, 11)+"@sti.edu.ph";

		String name = fname+" "+mname+" "+lname+" ";
		
		System.out.println("Enter your Password:");
		String password = input.nextLine();

		
	
                         	System.out.println("Program: ");
		String prg = input.nextLine();
		System.out.println("Year: ");
		String year = input.nextLine();
		
		System.out.println("Section: ");
		String section = input.nextLine();

		System.out.println("Contact Number: ");
		String contact = input.nextLine();

		System.out.println("Guardian: ");
		String guardian = input.nextLine();

		System.out.println("Addresss: ");
		String address = input.nextLine();

		System.out.println("Birthday: ");
		String birthday = input.nextLine();

		String dateEnrolled = datenow.toString();

		System.out.println("Status: ");
		String status = input.nextLine().toUpperCase();
		
		
		String pic = "src//pictures//DefaultIcons//defaultPfP.png";

		System.out.println("Bio: ");
		String bio = input.nextLine();
		
		
		LinkedList<String> infoList = new LinkedList<String>(Arrays.asList(email,  name,password, stud_Id, prg,year,section, contact, guardian, address, birthday,dateEnrolled,bio, pic,status  ));
                                System.out.println(infoList);      
		DataBase.writeDataStudent(infoList);
                                       
                                       
                                   }
                                   else if (what == 2){
                                       whoPrefix = tchrPrefix;
                                              
                                       long rand =(long) (100000000L+Math.random() * 100000000);
		String teacher_Id =whoPrefix+(Long.toString(rand).substring(0, 7));

		LocalDate datenow = LocalDate.now();
                
                                    
		System.out.println("Enter your First Name: ");
		String fname = input.nextLine();
		System.out.println("Enter your Middle Name: ");
		String mname = input.nextLine();
		System.out.println("Enter your Last Name: ");
		String lname = input.nextLine();
		
		String email = 	lname+teacher_Id.substring(4, 11)+"@sti.edu.ph";

		String name = fname+" "+mname+" "+lname+" ";
		
		System.out.println("Enter your Password:");
		String password = input.nextLine();

		
	
                         	System.out.println("Faculty: ");
		String faculty = input.nextLine().toUpperCase();


		System.out.println("Contact Number: ");
		String contact = input.nextLine();

		System.out.println("Guardian: ");
		String guardian = input.nextLine();

		System.out.println("Addresss: ");
		String address = input.nextLine();

		System.out.println("Birthday: ");
		String birthday = input.nextLine();

		String dateAccept = datenow.toString();

		
		
		
		String pic = "src//pictures//DefaultIcons//defaultPfP.png";
                
                                    
		System.out.println("Bio: ");
		String bio = input.nextLine();
		
                                  System.out.println("Status: ");
		String status = input.nextLine().toUpperCase();
		
		LinkedList<String> infoList = new LinkedList<String>(Arrays.asList(email,  name,password, teacher_Id, faculty, contact, guardian, address, birthday,dateAccept,pic, bio,status  ));
                                System.out.println(infoList);      
		DataBase.writeDataTeacher(infoList);
                            
                                       
                                       
                                       
                                       
                                       
                                       
                                   }    
		
    

	
		
		input.close();
	}
}
