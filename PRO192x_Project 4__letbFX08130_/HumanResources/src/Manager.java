import java.util.Scanner;

public class Manager extends Staff implements ICalculator {
	private int jobTitle;
	private final int FIVE_MILLION = 5000000;
	private final int EIGHT_MILLION = 8000000;
	private final int SIX_MILLION = 6000000;

	public int getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(int jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Manager(String id, String name, int age, double factor, String startDate, String department, int annulLeave,
			int jobTitle) {
		super(id, name, age, factor, startDate, department, annulLeave);
		this.jobTitle = jobTitle;
	}

	public Manager() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ID: " + this.id + " Name: " + this.name + " Age: " + this.age + " Factor: " + this.factor
				+ " Start date: " + this.startDate + " Department: " + this.department + " Annulleave: "
				+ this.annullLeave + " Job title: " + this.jobTitle;

	}
	

	@Override
	public void calculateSalary() {
		int allowance;
		if (getJobTitle() == 1)
			allowance = EIGHT_MILLION;
		else if (getJobTitle() == 2)
			allowance = FIVE_MILLION;
		else
			allowance = SIX_MILLION;
		this.calculateSalary = (int) (getFactor() * FIVE_MILLION + allowance);
	}
}
