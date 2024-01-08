package database;


import SourceCodes.DashBoard;
import SourceCodes.GradePanelComponents;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Queue;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



public class DataBase {
	
	private static final String connectionUrl = "jdbc:sqlserver://KEN-CARLON;databaseName=SchoolDB;encrypt=false;trustServerCertificate=false";
	private static final  String username = "kencarlon";
	private static final  String password = "Skuubydoo123";
	private static PreparedStatement preparedStatement;
	private static final  String teacherPrefix = "10";
	private static final  String studentPrefix = "11";
                  public static  String who = "";
	private static String keyValue = "";
	private static final Queue <String>usrRecords = new LinkedList<>();
                  private static LinkedList<String> usrSubjects = new LinkedList<>();
	private static String  studentEmail;
                  private static String  studentName;
                  private static String  studentPassword;
                  private static String  studentID;
                  private static String  studentProgram;
                  private static String program;
                  private static String  studentYear;
                  private static String   studentSection;
                  private static String   studentContact;
                  private static String  studentGuardian;
                  private static String  studentAddress;
                  private static String  studentBirthday;
                  private static String  studentDateEnrolled;
	private static String status;
                  private static String studentPicture;
	private static String studentBio;
                  private static String subject1;
                  private static String subject2;
                  private static String subject3;
                  private static String subject4;
                  private static String subject5;
                  private static String subject6;
                  private static LinkedList<String> gradeTblInfo = new LinkedList<>();
	private static LinkedList<String> studentGrades = new LinkedList<>();
                  private static String subject1_PRELIM;
                  private static String subject1_MIDTERM;
                  private static String subject1_FINALS;
                  private static String subject1_GWA;
                  private static String subject2_PRELIM;
                  private static String subject2_MIDTERM;
                  private static String subject2_FINALS;
                  private static String subject2_GWA;
                  private static String subject3_PRELIM;
                  private static String subject3_MIDTERM;
                  private static String subject3_FINALS;
                  private static String subject3_GWA;
                  private static String subject4_PRELIM;
                  private static String subject4_MIDTERM;
                  private static String subject4_FINALS;
                  private static String subject4_GWA;
                  private static String subject5_PRELIM;
                  private static String subject5_MIDTERM;
                  private static String subject5_FINALS;
                  private static String subject5_GWA;
                  private static String subject6_PRELIM;
                  private static String subject6_MIDTERM;
                  private static String subject6_FINALS;
                  private static String subject6_GWA;
	public static void writeDataStudent(LinkedList<String> info) {
		try(Connection con = DriverManager.getConnection(connectionUrl,username,password);) {

			String insert ="SET IDENTITY_INSERT StudentTbl ON;INSERT INTO "
					+ "[SchoolDB].[dbo].[StudentTbl] ([Email],[Name],[Password],[Student_Number],[Program],[Year],[Section],[Contact],[Guardian],[Address],[Birthday],[Date_Enrolled],[Bio],[Picture],[Status])"
					+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
			 preparedStatement = con.prepareStatement(insert);
                         
			
			
                                                       
                                               
			 int size = info.size();
			 
			 
			 for(int i = 1; i<=size; i++) {
				
                                                                        switch(i){
                                                                            case 1:gradeTblInfo.add(info.peek());break;
                                                                            case 2:gradeTblInfo.add(info.peek());break;
                                                                            case 4:gradeTblInfo.add(info.peek());break;
                                                                            case 5:gradeTblInfo.add(info.peek());break;
                                                                            
                                                                        }
				 preparedStatement.setString(i,info.removeFirst().trim());

			 }
                                                  
			
			int rowsAffected = preparedStatement.executeUpdate();
			      setStudentGradeTbl(gradeTblInfo);
			if(rowsAffected>0) {
				System.out.println("Data input Successfully");
				JOptionPane.showMessageDialog(null, "Data input Successfully");
                                                                    
                                
			}
                                                    
			
		
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Error");
			JOptionPane.showMessageDialog(null, "Inputting Data Unsuccessful. re-check Your input","Error",JOptionPane.ERROR_MESSAGE);	
			}
	}
                 public static void writeDataTeacher(LinkedList<String> info) {
		try(Connection con = DriverManager.getConnection(connectionUrl,username,password);) {

			String insert ="INSERT INTO "
					+ "[SchoolDB].[dbo].[TeacherTbl] ([Email],[Name],[Password],[Teacher_Number],[Faculty],[Contact],[Guardian],[Address],[Birthday],[Date_Accept],[Picture],[Bio],[Status])"
					+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
			 preparedStatement = con.prepareStatement(insert);
			 
			
			 int size = info.size();
			 
			 
			 for(int i = 1; i<=size; i++) {
				
				 preparedStatement.setString(i,info.removeFirst().trim());

			 }
			
			int rowsAffected = preparedStatement.executeUpdate();
			
			if(rowsAffected>0) {
				
				JOptionPane.showMessageDialog(null, "Data input Successfully");
                                                                          setFacultyTeacherTbl();

			}
			
		
		}
		catch(SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Inputting Data Unsuccessful. re-check Your input","Error",JOptionPane.ERROR_MESSAGE);	
			}
	}
        public static void updateUserImage(String newImagePath, String userEmail){
            try(Connection connection = DriverManager.getConnection(connectionUrl, username, password);){
                String sqlCommand = "UPDATE [SchoolDB].[dbo].["+who+"Tbl] SET [Picture] = ? WHERE Email = ?";
                preparedStatement = connection.prepareStatement(sqlCommand);
                
                preparedStatement.setString(1, newImagePath);
                 preparedStatement.setString(2, userEmail);
                int rowsAffected = preparedStatement.executeUpdate();
                if(rowsAffected>0){
                    JOptionPane.showMessageDialog(DashBoard.mainFrame, "Data input Successfully");
                }
                else
                         JOptionPane.showMessageDialog(DashBoard.mainFrame, "Data Input Error");
                
            }
            catch(SQLException e){
                	e.printStackTrace();
	System.out.println("updateUserImage");
	JOptionPane.showMessageDialog(null, "Inputting Data Unsuccessful. re-check Your input","Error",JOptionPane.ERROR_MESSAGE);	
			
            }
        }
	
      public static boolean isInputInDB(String Uemail,String Upassword){
        	

        	
            boolean condition = false;
           
            try(Connection con = DriverManager.getConnection(connectionUrl,username,password);) {
            
            	Statement statement = con.createStatement();
            	   String SQL = """
                                SELECT StudentTbl.Email,StudentTbl.Password, [TeacherTbl].Email,[TeacherTbl].Password
                                FROM [SchoolDB].[dbo].[StudentTbl] INNER JOIN [SchoolDB].[dbo].[TeacherTbl] ON StudentTbl.Status = TeacherTbl.Status;""";
            	   ResultSet result = statement.executeQuery(SQL);
     
            	   while(result.next()) {
            		   
            		
            		if(result.getString(1).equalsIgnoreCase(Uemail) &&  
            				result.getString(2).equals(Upassword)) {
                                                    who ="Student";
            			keyValue = result.getString(1);
            				return condition = true;
            		}
                        else if(result.getString(3).equalsIgnoreCase(Uemail) &&  
            				result.getString(4).equals(Upassword)) {
            			keyValue = result.getString(3);
                                                    who ="Teacher";
            				return condition = true;
            		}
            		
            	   }
            	
			} catch (SQLException e) {
				System.out.println("Error");
				e.printStackTrace();
			} 
      
            return condition;
        }
   
       public static void Datas() {
                       
    	   try(Connection con = DriverManager.getConnection(connectionUrl,username,password);){
    			Statement statement = con.createStatement();
    			  String SQL = "SELECT * FROM dbo."+who+"Tbl WHERE Email = '"+keyValue+"';";
           	   ResultSet result = statement.executeQuery(SQL);
           	   
           	   
           	   while(result.next() )
           	   {
                       if(who.equalsIgnoreCase("Student"))
                       {
	           	   for(int x = 1;  x<=15;x++) 
	           		usrRecords.offer(result.getString(x));

                                             setStudentAllValues();   
                                             setStudentGrade();
                       }
                       else{
                                       for(int x = 1;  x<=13;x++)
                                    usrRecords.offer(result.getString(x));
                                           setTeacherAllValues();
                                         
                       }
                       
           	   }
                   
         
    	   }
    	   catch(SQLException e) {
    		   e.printStackTrace();
    	   }
       
    	
       }
       public static void setTeacherAllValues(){
       
                 studentEmail = usrRecords.poll();
	studentName = capitalizeWords( usrRecords.poll());
	studentPassword = usrRecords.poll();
	studentID = usrRecords.poll();
	studentProgram =   capitalizeWords(usrRecords.poll());
	studentContact = usrRecords.poll();
	studentGuardian =  capitalizeWords(usrRecords.poll());
	studentAddress =       capitalizeWords(usrRecords.poll());
	studentBirthday = usrRecords.poll();
	studentDateEnrolled = usrRecords.poll();
	
	studentPicture = usrRecords.poll();
	studentBio =       capitalizeWords(usrRecords.poll());
        status =       capitalizeWords(usrRecords.poll());
               program = studentProgram;
}
   	public static void setStudentAllValues() 
   	{
        
              studentEmail = usrRecords.poll();

	studentName = capitalizeWords( usrRecords.poll());
	studentPassword = usrRecords.poll();
	studentID = usrRecords.poll();
	studentProgram =   capitalizeWords(usrRecords.poll());
	studentYear = usrRecords.poll();
	studentSection = capitalizeWords(usrRecords.poll());
	studentContact = usrRecords.poll();
	studentGuardian =  capitalizeWords(usrRecords.poll());
	studentAddress =       capitalizeWords(usrRecords.poll());
	studentBirthday = usrRecords.poll();
	studentDateEnrolled = usrRecords.poll();
	
	studentPicture = usrRecords.poll();
         
        
	studentBio =       capitalizeWords(usrRecords.poll());
        status =       capitalizeWords(usrRecords.poll());
	
                program = studentProgram;

	}

    private static void setStudentGradeTbl(LinkedList<String> peek) {
        
        try(Connection con = DriverManager.getConnection(connectionUrl, username, password)){
            String query ="INSERT INTO [SchoolDB].[dbo].[StudentGradeTbl] ([Email],[Name],[Student_Number],[Program]) VALUES(?,?,?,?);";
            preparedStatement = con.prepareStatement(query);
            
            int size = peek.size();
            
            for(int i = 1; i<=size;i++){
                	preparedStatement.setString(i,peek.removeFirst().trim());

            }
            preparedStatement.executeUpdate();
            
            
        }   catch (SQLException ex) {
            ex.printStackTrace();
            }
    }

    private static void setStudentGrade() {
        try(Connection con = DriverManager.getConnection(connectionUrl, username, password)){
            Statement statement = con.createStatement();
            String query ="SELECT * FROM DBO.StudentGradeTbl WHERE Student_Number ='"+studentID+"';";
            
            ResultSet resultset = statement.executeQuery(query);
            
            while(resultset.next()){
                for(int i = 5;i<=28;i++){
                    studentGrades.add(resultset.getString(i));
                }
                setGrades();
            }
      
        }
        catch(SQLException e){
            e.printStackTrace();
            
        }
    }

    private static void setGrades()
    {
            subject1_PRELIM = studentGrades.removeFirst();
                   subject1_MIDTERM = studentGrades.removeFirst();
                   subject1_FINALS = studentGrades.removeFirst();
                   subject1_GWA = studentGrades.removeFirst();
                   subject2_PRELIM = studentGrades.removeFirst();
                   subject2_MIDTERM = studentGrades.removeFirst();
                   subject2_FINALS = studentGrades.removeFirst();
                   subject2_GWA = studentGrades.removeFirst();
                   subject3_PRELIM = studentGrades.removeFirst();
                   subject3_MIDTERM = studentGrades.removeFirst();
                   subject3_FINALS = studentGrades.removeFirst();
                   subject3_GWA = studentGrades.removeFirst();
                   subject4_PRELIM = studentGrades.removeFirst();
                   subject4_MIDTERM = studentGrades.removeFirst();
                   subject4_FINALS = studentGrades.removeFirst();
                   subject4_GWA = studentGrades.removeFirst();
                   subject5_PRELIM = studentGrades.removeFirst();
                   subject5_MIDTERM = studentGrades.removeFirst();
                   subject5_FINALS = studentGrades.removeFirst();
                   subject5_GWA = studentGrades.removeFirst();
                   subject6_PRELIM = studentGrades.removeFirst();
                   subject6_MIDTERM = studentGrades.removeFirst();
                   subject6_FINALS = studentGrades.removeFirst();
                   subject6_GWA = studentGrades.removeFirst();
    }

    public static void displayGrade(JTable tableModel) 
    {
        try(Connection con = DriverManager.getConnection(connectionUrl, username, password))
        {
            String where="";
         if(program.equals("ICT")) where="BSIT";
         else      if(program.equals("TM")) where="BSTM";
         else      if(program.equals("HM")) where="BSHM";
             
            DefaultTableModel talbw =(DefaultTableModel) tableModel.getModel();
            Statement statement =con.createStatement();
            String query ="SELECT * FROM dbo.StudentGradeTbl WHERE Program ='"+where+"' ";
            ResultSet result = statement.executeQuery(query);
            while(result.next())
            {
                int index=0;
               Object obj[] = new Object[29];
            
                for(int i = 2;i<=28;i++){
                    
                    if(i!=4)
                    obj[index++] = result.getString(i);     
                }
                talbw.addRow(obj);

   
            }
                
        }   catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
                   public String getSubject1_PRELIMGrade(){
                       return subject1_PRELIM;
                   }
                   public String getSubject1_MIDTERMGrade(){
                       return subject1_MIDTERM;
                   }
                   public String getSubject1_FINALSGrade(){
                       return subject1_FINALS;
                   }
                   public String getSubject1_GWA(){
                       return subject1_GWA;
                   }
                   public String getSubject2_PRELIMGrade(){
                       return subject2_PRELIM;
                   }
                   public String getSubject2_MIDTERMGrade(){
                       return subject2_MIDTERM;
                   }
                   public String getSubject2_FINALSGrade(){
                       return subject2_FINALS;
                   }
                   public String getSubject2_GWA(){
                       return subject2_GWA;
                   }
                   public String getSubject3_PRELIMGrade(){
                       return subject3_PRELIM;
                   }
                   public String getSubject3_MIDTERMGrade(){
                       return subject3_MIDTERM;
                   }
                   public String getSubject3_FINALSGrade(){
                       return subject3_FINALS;
                   }
                   public String getSubject3_GWA(){
                       return subject3_GWA;
                   }
                   public String getSubject4_PRELIMGrade(){
                       return subject4_PRELIM;
                   }
                   public String getSubject4_MIDTERMGrade(){
                       return subject4_MIDTERM;
                   }
                   public String getSubject4_FINALSGrade(){
                       return subject4_FINALS;
                   }
                   public String getSubject4_GWA(){
                       return subject4_GWA;
                   }
                   public String getSubject5_PRELIMGrade(){
                       return subject5_PRELIM;
                   }
                   public String getSubject5_MIDTERMGrade(){
                       return subject5_MIDTERM;
                   }
                   public String getSubject5_FINALSGrade(){
                       return subject5_FINALS;
                   }
                   public String getSubject5_GWA(){
                       return subject5_GWA;
                   }
                   public String getSubject6_PRELIMGrade(){
                       return subject6_PRELIM;
                   }
                   public String getSubject6_MIDTERMGrade(){
                       return subject6_MIDTERM;
                   }
                   public String getSubject6_FINALSGrade(){
                       return subject6_FINALS;
                   }
                   public String getSubject6_GWA(){
                       return subject6_GWA;
                   }

	
	public String getStudentEmail() {
		return studentEmail;
	}

	public String getStudentBio() {
		return studentBio;
	}

	public String getStudentPassword() {
		return studentPassword;
	}

	public String getStudentName() {
		return studentName;
	}

	public String getStudentID() {
		return studentID;
	}

	public String getStudentProgram() {
                                    
		return studentProgram;
	}

	public String getStudentContact() {
		return studentContact;
	}

	public String getStudentGuardian() {
		return studentGuardian;
	}

	public String getStudentAddress() {
		return studentAddress;
	}

	public String getStudentBirthday() {
		return studentBirthday;
	}

	public String getStudentDateEnrolled() {
		return studentDateEnrolled;
	}

	public String getStudentPicture() {
		return studentPicture;
	}

	public String getStudentYear() {
		return studentYear;
	}
	public String getStudentSection() {
		return studentSection;
	}
	public String getStudentStatus() {
		return status;
	}

	private static String capitalizeWords(String sentence) {
		StringBuilder result = new StringBuilder();

		// Split the sentence into words using space as a delimiter
		String[] words = sentence.split("\\s");

		for (String word : words) {
				if (!word.isEmpty()) {
				result.append(Character.toUpperCase(word.charAt(0)))
						.append(word.substring(1))
						.append(" ");
			}
		}

	
		return result.toString().trim();
	}
        
        public static void setFacultyTeacherTbl(){
            try(Connection connect =  DriverManager.getConnection(connectionUrl, username, password);){
                Statement statement = connect.createStatement();
                            statement.executeUpdate("INSERT INTO ICTTeacherTbl(Faculty, Email, Name, Teacher_Number) " +
                    "SELECT Faculty, Email, Name, Teacher_Number FROM TeacherTbl WHERE Faculty = 'ICT'");

            // Execute the second SQL command
            statement.executeUpdate("INSERT INTO HRMTeacherTbl(Faculty, Email, Name, Teacher_Number) " +
                    "SELECT Faculty, Email, Name, Teacher_Number FROM TeacherTbl WHERE Faculty = 'HRM'");

            // Execute the third SQL command
            statement.executeUpdate("INSERT INTO TourismTeacherTbl(Faculty, Email, Name, Teacher_Number) " +
                    "SELECT Faculty, Email, Name, Teacher_Number FROM TeacherTbl WHERE Faculty = 'TOURISM'");

            System.out.println("Data inserted successfully!");
            }
            catch(SQLException e){
                e.printStackTrace();
            }
            
        }
        public static void Subjects(){
            try(Connection connect = DriverManager.getConnection(connectionUrl, username, password)){
                Statement statement = connect.createStatement();
                      String sqlCommand = "SELECT  * FROM DBO.SubjectTbl where Program = '"+program+"' OR Faculty = '"+program+"';";
                      ResultSet rs = statement.executeQuery(sqlCommand);
                      
                      while(rs.next()){
                                 for(int x = 3; x<=8;x++)
                                 usrSubjects.add(rs.getString(x));
                      }
                  
                      setSujbects();
               
                     }
            catch(SQLException e){
           
                JOptionPane.showMessageDialog(DashBoard.mainFrame, "Error in getting User Subjects","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        public static void setSujbects()
        {
            
            subject1 = usrSubjects.removeFirst();
              subject2 = usrSubjects.removeFirst();
                subject3 = usrSubjects.removeFirst();
                  subject4= usrSubjects.removeFirst();
                    subject5 = usrSubjects.removeFirst();
                      subject6 = usrSubjects.removeFirst();
            
        }
        public String getSubject1(){
            return subject1;
        }
            public String getSubject2(){
            return subject2;
        }
            public String getSubject3(){
            return subject3;
        }
             public String getSubject4(){
            return subject4;
        }
           public String getSubject5(){
            return subject5;
        }
           public String getSubject6(){
            return subject6;
        }
       public static void gradeUpdate(DefaultTableModel tableModel, int selectedRow, int selectedColumn, String selected_ID, int num_Sub, JTextField prelim, JTextField midterm, JTextField finals)
       {
      
         
           String num = Integer.toString(num_Sub);
          
           try(Connection con = DriverManager.getConnection(connectionUrl, username, password))
           {
         String   query = "UPDATE dbo.StudentGradeTbl SET [Subject"+num_Sub+"_Prelim] = ? ,[Subject"+num_Sub+"_Midterm] = ? ,[Subject"+num_Sub+"_Finals] = ? ,[Subject"+num_Sub+"_GWA] = ? WHERE Student_Number = '"+selected_ID+"' ";
    
           
             preparedStatement = con.prepareStatement(query);
             
             
               int PRELIMG= Integer.parseInt(prelim.getText());
               int MIDTERMG= Integer.parseInt(midterm.getText());
               int FINALSG= Integer.parseInt(finals.getText());
               int GWA= (int)((PRELIMG * 0.3)+(MIDTERMG * 0.3)+(FINALSG * 0.6));
             
               preparedStatement.setInt(1, PRELIMG);
               preparedStatement.setInt(2, MIDTERMG);
               preparedStatement.setInt(3, FINALSG);
               preparedStatement.setInt(4, GWA);
                     
               int executeUpdate = preparedStatement.executeUpdate();
               if(executeUpdate>0){
                   JOptionPane.showMessageDialog(DashBoard.mainFrame, "Update Successful");
                   switch(num_Sub){
                       case 1:
                           tableModel.setValueAt(PRELIMG, selectedRow, 2);
                           tableModel.setValueAt(MIDTERMG, selectedRow, 3);
                           tableModel.setValueAt(FINALSG, selectedRow, 4);
                           tableModel.setValueAt(GWA, selectedRow, 5);
                           break;
                       case 2:
                           tableModel.setValueAt(PRELIMG, selectedRow, 6);
                           tableModel.setValueAt(MIDTERMG, selectedRow, 7);
                           tableModel.setValueAt(FINALSG, selectedRow, 8);
                           tableModel.setValueAt(GWA, selectedRow, 9);
                           break;
                       case 3:
                           tableModel.setValueAt(PRELIMG, selectedRow, 10);
                           tableModel.setValueAt(MIDTERMG, selectedRow, 11);
                           tableModel.setValueAt(FINALSG, selectedRow, 12);
                           tableModel.setValueAt(GWA, selectedRow, 13);
                           break;
                       case 4:
                           tableModel.setValueAt(PRELIMG, selectedRow, 14);
                           tableModel.setValueAt(MIDTERMG, selectedRow, 15);
                           tableModel.setValueAt(FINALSG, selectedRow, 16);
                           tableModel.setValueAt(GWA, selectedRow, 17);
                           break;
                       case 5:
                           tableModel.setValueAt(PRELIMG, selectedRow, 18);
                           tableModel.setValueAt(MIDTERMG, selectedRow, 19);
                           tableModel.setValueAt(FINALSG, selectedRow, 20);
                           tableModel.setValueAt(GWA, selectedRow, 21);
                           break;
                       case 6:
                            tableModel.setValueAt(PRELIMG, selectedRow, 22);
                           tableModel.setValueAt(MIDTERMG, selectedRow, 23);
                           tableModel.setValueAt(FINALSG, selectedRow, 24);
                           tableModel.setValueAt(GWA, selectedRow, 25);
                           break;
                   }
                 
               }
          
           } catch (SQLException ex) {
                ex.printStackTrace();
           }
       }
        
  
}
