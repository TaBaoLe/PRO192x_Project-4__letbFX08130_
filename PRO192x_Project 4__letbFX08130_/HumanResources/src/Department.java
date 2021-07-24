import java.util.Scanner;

public class Department {
	protected int departmentId;
	protected String departmentName;
	protected int numOfStaff;

	public int getDepartmentId() {
		return departmentId;
	}

	public Department(int departmentId, String departmentName, int numOfStaff) {
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.numOfStaff = numOfStaff;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public int getNumOfStaff() {
		return numOfStaff;
	}

	public void setNumOfStaff(int numOfStaff) {
		this.numOfStaff = numOfStaff;
	}

	public Department() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Department Id: " + getDepartmentId()+ "\t departmentName: " + getDepartmentName() + "\t numOfStaff: "
				+ getNumOfStaff();
	}

}
