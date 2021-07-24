import java.util.Scanner;

public abstract class Staff implements ICalculator {
	protected String id;
	protected String name;
	protected int age;
	protected double factor;
	protected String startDate;
	protected String department;
	protected int annullLeave;
	protected int calculateSalary;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getFactor() {
		return factor;
	}

	public void setFactor(double factor) {
		this.factor = factor;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getAnnullLeave() {
		return annullLeave;
	}

	public void setAnnulLeave(int annulLeave) {
		this.annullLeave = annulLeave;
	}

	public float getCalculateSalary() {
		return calculateSalary;
	}

	public Staff(String id, String name, int age, double factor, String startDate, String department,
			int annulLeave) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.factor = factor;
		this.startDate = startDate;
		this.department = department;
		this.annullLeave = annulLeave;
	}

	public Staff() {
		// TODO Auto-generated constructor stub
	}

	public abstract String toString();

	public void calculateSalary() {
		this.calculateSalary = 0;
	}
}
