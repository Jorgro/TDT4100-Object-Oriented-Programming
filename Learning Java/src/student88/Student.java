package student88;

public class Student {
	
	private String name;
	private String studentid;
	
	public Student(String name, String studentid) {
		this.name = name;
		this.studentid = studentid;
				
	}
	public String getName() {
		return this.name;
	}
	public String getStudentNumber() {
		return this.studentid;
		
	}
	public String toString() {
		return this.name + " (" + this.studentid +")";
	}
}
