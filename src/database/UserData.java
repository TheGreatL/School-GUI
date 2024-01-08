package database;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.*;

public class UserData {
	private BufferedReader reader;
	private BufferedWriter writer;
	private Path filePath;
	private LocalDate datenow;
	private LinkedList<String> list;
	private static Queue<String> usrRecords;
	private Scanner scan;
	private static String usrEmail;
	private String studentEmail,
			studentPassword,
			studentName,
			studentID,
			studentProgram,
			studentContact,
			studentGuardian,
			studentAddress,
			studentBirthday,
			studentDateEnrolled,
			studentPicture,
			studentYear,
			studentBio;

	private final int SUB_STRING;
	private final int LISTSIZE;

	UserData() { // Arrays.asList();
		list = new LinkedList<>(Arrays.asList("EM_A", "P_SS", "S_NE", "S_ID", "SPRG", "C_TN", "G_RD", "ADDS", "B_DY",
				"DATE", "PIC_", "YEAR"));
		LISTSIZE = list.size();
		SUB_STRING = 6;
		usrEmail = " ";

		usrRecords = new LinkedList<>();

		filePath = Paths.get("src//database//StudentRecords.txt");
		datenow = LocalDate.now();

		try {
			scan = new Scanner(filePath);

			if (!Files.exists(filePath))
				Files.createFile(filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean isInputValid(String email, String password) {
		boolean condition = false;

		String s; // Initialize outside the loop
		s = " ";
		String ems = " ";
		String pass = " ";
		// System.out.println("Dine: "+email);
		// System.out.println("Pine: "+password);
		try {

			// scan = new Scanner(filePath);
			reader = Files.newBufferedReader(filePath);
			while ((s = reader.readLine()) != null) {

				if (s.startsWith("EM_A")) {
					if (s.substring(SUB_STRING).trim().equalsIgnoreCase(email)) {
						ems = s.substring(SUB_STRING).trim();
						usrEmail = ems;
						// System.out.println("E: "+ems);
					}
				} else if (s.startsWith("P_SS")) {

					if (s.substring(SUB_STRING).trim().equals(password)) {
						pass = s.substring(SUB_STRING).trim();

						// System.out.println("P: "+pass);
						// System.out.println("EM_S :"+email);
						// System.out.println(ems.equals(email));
						// System.out.println(ems.equals(email)&& pass.equals(password));

					}
				}

				else if (s.startsWith("-")) {
					// System.out.println(s);
					ems = " ";
					pass = " ";
				}

				if (ems.equalsIgnoreCase(email) && pass.trim().equals(password)) {
					return condition = true;
				}

			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		scan.close();
		return condition;

	}

	public void writeStudentInfo(String info[]) {
		list = new LinkedList<>(Arrays.asList("EM_A", "P_SS", "S_NE", "S_ID", "SPRG", "C_TN", "G_RD", "ADDS", "B_DY",
				"DATE", "PIC_", "YEAR", "B_IO"));
		// Name
		// StudentID
		// Contact
		// Guardian
		// Address
		// Birthday
		// Email
		// Password

		try {
			writer = Files.newBufferedWriter(filePath, CREATE, APPEND);

			for (String s : info) {
				writer.write(list.removeFirst() + ": " + s);
				writer.newLine();
			}

			writer.write("-------------------------------------------------");
			writer.newLine();
			writer.flush();
			writer.close();
		}

		catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void getUserInfo() {
		boolean condition = false;
		String s = "";
		try {
			reader = Files.newBufferedReader(filePath);
			while ((s = reader.readLine()) != null) {
				if (s.substring(SUB_STRING).trim().equals(usrEmail)) {
					condition = true;
				} else if (s.startsWith("-")) {
					condition = false;
				}

				if (condition && LISTSIZE >= usrRecords.size()) {
					String add = s.substring(SUB_STRING);
					usrRecords.offer(add);
				}
			}
			// System.out.println(usrRecords);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setAllValues() {

		setStudentEmail(usrRecords.poll());

		setStudentPassword(usrRecords.poll());

		setStudentName(usrRecords.poll());

		setStudentID(usrRecords.poll());

		setStudentProgram(usrRecords.poll());

		setStudentContact(usrRecords.poll());

		setStudentGuardian(usrRecords.poll());

		setStudentAddress(usrRecords.poll());

		setStudentBirthday(usrRecords.poll());

		setStudentDateEnrolled(usrRecords.poll());

		setStudentPicture(usrRecords.poll());

		setStudentYear(usrRecords.poll());

		setStudentBio(usrRecords.poll());

	}

	protected void setStudentBio(String bio) {
		this.studentBio = bio;
	}

	protected void setStudentEmail(String email) {
		this.studentEmail = email;
	}

	protected void setStudentPassword(String password) {
		this.studentPassword = password;
	}

	protected void setStudentName(String name) {

		this.studentName = capitalizeWords(name);
	}

	protected void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	protected void setStudentProgram(String program) {
		this.studentProgram = capitalizeWords(program);
	}

	protected void setStudentContact(String contact) {
		this.studentContact = contact;
	}

	protected void setStudentGuardian(String guardian) {
		this.studentGuardian = capitalizeWords(guardian);
	}

	protected void setStudentAddress(String address) {
		this.studentAddress = capitalizeWords(address);
	}

	protected void setStudentBirthday(String birthday) {
		this.studentBirthday = birthday;
	}

	protected void setStudentDateEnrolled(String date) {
		this.studentDateEnrolled = date;
	}

	protected void setStudentPicture(String picture) {
		this.studentPicture = picture;
	}

	protected void setStudentYear(String year) {
		this.studentYear = capitalizeWords(year);
	}

	protected String getStudentEmail() {
		return studentEmail;
	}

	protected String getStudentBio() {
		return studentBio;
	}

	protected String getStudentPassword() {
		return studentPassword;
	}

	protected String getStudentName() {
		return studentName;
	}

	protected String getStudentID() {
		return studentID;
	}

	protected String getStudentProgram() {
		return studentProgram;
	}

	protected String getStudentContact() {
		return studentContact;
	}

	protected String getStudentGuardian() {
		return studentGuardian;
	}

	protected String getStudentAddress() {
		return studentAddress;
	}

	protected String getStudentBirthday() {
		return studentBirthday;
	}

	protected String getStudentDateEnrolled() {
		return studentDateEnrolled;
	}

	protected String getStudentPicture() {
		return studentPicture;
	}

	protected String getStudentYear() {
		return studentYear;
	}

	private String capitalizeWords(String sentence) {
		StringBuilder result = new StringBuilder();

		// Split the sentence into words using space as a delimiter
		String[] words = sentence.split("\\s");

		for (String word : words) {
			// Capitalize the first letter of each word
			if (!word.isEmpty()) {
				result.append(Character.toUpperCase(word.charAt(0)))
						.append(word.substring(1))
						.append(" ");
			}
		}

		// Remove the trailing space and return the result
		return result.toString().trim();
	}
}
