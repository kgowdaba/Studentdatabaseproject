package sdbms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import customexception.InvalidChoiceException;
import customexception.StudentNotFoundException;
import customsorting.SortStudentByAge;
import customsorting.SortStudentById;
import customsorting.SortStudentByMarks;
import customsorting.SortStudentByName;

//2.implementation class
public class StudentManagmentSystemImpl implements StudentManagementSystem {
	Scanner scan= new Scanner(System.in);
	//we are using collection as our Database ->map-> LinkedHashMap
	// key-> Student Id and value-> Student Object
	Map<String,Student> db=new LinkedHashMap<String,Student>();

	@Override
	public void addStudent()
	{
		//Accepting age
		System.out.println("Enter Age:");
		int age= scan.nextInt();

		//Accepting name
		System.out.println("Enter Name:");
		String name= scan.next();

		//Accepting marks
		System.out.println("Enter Marks:");
		int marks= scan.nextInt();

		//creating a Student instance(Object)
		Student std=new Student(age,name,marks);

		//Adding Entry inside Database (Map)
		db.put(std.getId(), std);
		System.out.println("Student Record Inserted Successfully");
		System.out.println("Your Student Id is" +std.getId());
	}
	@Override
	public void displayStudent()
	{
		//Accepting Student Id &  into uppercase
		System.out.println("Enter Student Id");
		String id =scan.next();//JSP101, Jsp101,jsp101
		id=id.toUpperCase();//JSP101

		//checking if the id is present or not
		if(db.containsKey(id)) {
			Student std=db.get(id);//getting value (Student object)
			System.out.println("Id:"+std.getId());
			System.out.println("Age:"+std.getAge());
			System.out.println("Name:"+std.getName());
			System.out.println("Marks:"+std.getMarks());
			//System.out.println(std);//toString is Overridden
		}
		else {
			try {
				String message="Student with the Id"+id+"is not found";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void displayAllStudent()
	{
		// Displaying when the Database is not empty 
		if(!db.isEmpty()) {
			System.out.println("Student Deatails are as Follows");
			System.out.println("-----------------------------------");
			//Converting Map into Set using ketSet()
			Set<String> keys=db.keySet();//jsp101,jsp102,jsp103
			//Traversing keys (Student Id's)
			for(String key: keys) {
				System.out.println(db.get(key));//getting value (student obj)
			}
		}
		else {
			try {
				String message ="No Student Records Found to Display";
				throw new StudentNotFoundException(message);
			}
			catch(StudentNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void removeStudent()
	{
		System.out.println("Enter Student Id");
		String id=scan.next();//JSP101, Jsp101,jsp101
		id=id.toUpperCase();//JSP101 or in one line scan.next().touppercase();
		//checking if the id is present or not
		if(db.containsKey(id)) {
			System.out.println("Student Record Found");
			System.out.println(db.get(id));//getting Student object
			db.remove(id);
			System.out.println("Student Record Deleted Successfully");
		}
		else {
			try {
				String message="Student with the Id"+id+"is not found";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void removeAllStudent()
	{
		if(!db.isEmpty()) {
			System.out.println("No Student Records:"+db.size());
			db.clear();
			System.out.println("All Student Records Deleted Successfully");
		}
		else {
			try {
				String message ="No Student Records Found to Delete";
				throw new StudentNotFoundException(message);
			}
			catch(StudentNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void updateStudent()
	{
		System.out.println("Enter Student Id");
		String id=scan.next();//JSP101, Jsp101,jsp101
		id=id.toUpperCase();//JSP101 or in one line scan.next().touppercase();
		//checking if the id is present or not
		if(db.containsKey(id)) {
			System.out.println("Student Record Found");
			Student std= db.get(id);//getting Student object

			System.out.println("1.Update Age\n2.Update Name\n3.Update Marks");
			System.out.println("Enter choice");
			int choice = scan.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter Age");
				int age = scan.nextInt();
				std.setAge(age);//or std.setAge(scan.nextInt());
				System.out.println("Age Updated Successfully");
				break;
			case 2:
				System.out.println("Enter Name");
				String name = scan.next();
				std.setName(name);
				System.out.println("Name Updated Successfully");
				break;
			case 3:
				System.out.println("Enter Marks");
				int marks = scan.nextInt();
				std.setMarks(marks);
				System.out.println("Marks Updated Successfully");
				break;
			default:
				try {
					String message= "invalid choice kindly enter valid choice";
					throw new InvalidChoiceException(message);
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
		else {
			try {
				String message="Student with the Id"+id+"is not found";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void countStudent()
	{
		System.out.println("No of Student Records: "+db.size());
	}
	@Override
	public void sortStudent()
	{
		//Reference of list & object of Arraylist Storing Student Obeject
		List<Student> list= new ArrayList<Student>();
		//converting Map into Set using key set
		Set<String> keys=db.keySet();
		//travesing keys
		for(String key:keys) {
			Student std = db.get(key);//getting Student object
			list.add(std);//adding Student object into list
		}
		System.out.println("1:Sort Student by Id\n2:Sort Student By Age");
		System.out.println("3:Sort Student  by Name\n4:Sort Student By Maeks");
		System.out.println("Enter choice");
		int choice = scan.nextInt();

		switch(choice) {
		case 1:
			Collections.sort(list,new SortStudentById());
			for(Student s:list) {
				System.out.println(s);
			}
			break;
		case 2:
			Collections.sort(list,new SortStudentByAge());
			for(Student s:list) {
				System.out.println(s);
			}
			break;
		case 3:
			Collections.sort(list,new SortStudentByName());
			for(Student s:list) {
				System.out.println(s);
			}
			break;
		case 4:
			Collections.sort(list,new SortStudentByMarks());
			for(Student s:list) {
				System.out.println(s);
			}
			break;
		default:
			try {
				String message= "invalid choice kindly enter valid choice";
				throw new InvalidChoiceException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}		
		}
	}
	@Override
	public void getStudentWithHighestMarks()
	{
		//Reference of list & object of Arraylist Storing Student Obeject
		List<Student> list= new ArrayList<Student>();
		//converting Map into Set using key set
		Set<String> keys=db.keySet();
		//travesing keys
		for(String key:keys) {
			Student std = db.get(key);//getting Student object
			list.add(std);//adding Student object into list
		}
		Collections.sort(list, new SortStudentByMarks());
		System.out.println("Student with Highest Marks:");
		System.out.println(list.get(list.size()-1));
	}
	@Override
	public void getStudentWithLowestMarks()
	{
		//Reference of list & object of Arraylist Storing Student Obeject
		List<Student> list= new ArrayList<Student>();
		//converting Map into Set using key set
		Set<String> keys=db.keySet();
		//travesing keys
		for(String key:keys) {
			Student std = db.get(key);//getting Student object
			list.add(std);//adding Student object into list
		}
		Collections.sort(list, new SortStudentByMarks());
		System.out.println("Student with LOwest  Marks:");
		System.out.println(list.get(0));
	}

}
