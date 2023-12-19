package sdbms;
//3.main class
import java.util.Scanner;
import customexception.InvalidChoiceException;
public class Solution {

	public static void main(String[] args) {
		System.out.println("Welcome to Student Database Project");
		System.out.println("----------------------------------------");

		Scanner scan= new Scanner(System.in);
		//upcasting to achieve Abstraction
		StudentManagementSystem sms = new StudentManagmentSystemImpl();

		// infinite loop
		while(true){
			System.out.println("1:Add Student\n2:Display Student");
			System.out.println("3:DisplayAll Student\n4:Remove Student");
			System.out.println("5:RemoveAll Student\n6:Update Student");
			System.out.println("7:Count Student\n8:Sort Student");
			System.out.println("9:GetStudentWithHighestMarks");
			System.out.println("10:GetStudentWithLowestMarks\n11:EXIT");
			System.out.println("Enter choice");
			int choice =scan.nextInt();

			switch(choice) {
			case 1:
				sms.addStudent();
				break;
			case 2:
				sms.displayStudent();
				break;
			case 3:
				sms.displayAllStudent();
				break;
			case 4:
				sms.removeStudent();
				break;
			case 5:
				sms.removeAllStudent();
				break;
			case 6:
				sms.updateStudent();
				break;
			case 7:
				sms.countStudent();
				break;
			case 8:
				sms.sortStudent();
				break;
			case 9:
				sms.getStudentWithHighestMarks();
				break;
			case 10:
				sms.getStudentWithLowestMarks();
				break;
			case 11:
				System.out.println("thank you");
				System.exit(0);
			default:
				try {
					String message= "invalid choice kindly enter valid choice";
					throw new InvalidChoiceException(message);
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}


			}//end of  switch
			System.out.println("--------------------------------------");

		}//end of while loop

	}//end of main()

}//end of class
