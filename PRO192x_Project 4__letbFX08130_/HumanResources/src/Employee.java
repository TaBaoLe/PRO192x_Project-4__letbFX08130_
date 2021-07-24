import java.util.Scanner;

public class Employee extends Staff implements ICalculator {
	private int overTime;
	private final int THREE_MILLION = 3000000;
	private final int TWO_HUNDRED_THOUSAND = 200000;

	public int getOverTime() {
		return overTime;
	}

	public void setOverTime(int overTime) {
		this.overTime = overTime;
	}

	public Employee(String id, String name, int age, double factor, String startDate, String department,
			int annulLeave, int overTime) {
		super(id, name, age, factor, startDate, department, annulLeave);
		this.overTime = overTime;
	}

	public Employee() {

	}

	@Override
	public String toString() {
		return "ID: " + this.id + " Name: " + this.name + " Age: " + this.age + " Factor: " + this.factor + " Start date: "
				+ this.startDate + " Department: " + this.department + " AnnullLeave: " + this.annullLeave + " Overtime: "
				+ this.overTime;
	}

	@Override
	public void calculateSalary() {
		this.calculateSalary = (int) ((getFactor() * THREE_MILLION) + (getOverTime() * TWO_HUNDRED_THOUSAND));
	}
}
