package sdbms;
//1. interface
public interface StudentManagementSystem {
	void addStudent();
	void displayStudent();
	void displayAllStudent();
	void removeStudent();
	void removeAllStudent();
	void updateStudent();
	void countStudent();
	void sortStudent();
	void getStudentWithHighestMarks();
	void getStudentWithLowestMarks();

}
// all method inside interface are automatically public & abstract