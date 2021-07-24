import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class HumanResoucres {
	private static ArrayList<Staff> StaffList;
	private static ArrayList<Department> dplist;

	public HumanResoucres() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StaffList = new ArrayList<>();
		dplist = new ArrayList<>();
		doMenu(scan);
		

	}

	public static void menu() {
		System.out.println("-------------------------");
		System.out.println("1.Display all staff");
		System.out.println("2.Display all department");
		System.out.println("3.Display staff by department");
		System.out.println("4.Add new staff");
		System.out.println("5.Search by ID or Name");
		System.out.println("6.Display all payslip");
		System.out.println("7.Sorted payslip");
		System.out.println("8.Quit");

	}

	public static void doMenu(Scanner scan) {
		boolean flag = false;
		Staff staff = null;
		do {
			menu();
			int chose = Integer.parseInt(scan.nextLine());
			switch (chose) {
			case 1:
				StaffList();
				flag = true;
				break;
			case 2:
				departmentList();
				flag = true;
				break;
			case 3:
				displayStaffByDepartment(scan);
				flag = true;
				break;
			case 4:
				addStaff(scan);
				flag = true;
				break;
			case 5:
				search(scan);
				flag = true;
				break;
			case 6:
				AllPaySlip(StaffList);
				flag = true;
				break;
			case 7:
				ArrayList<Staff> newList = new ArrayList<>(StaffList);
				sortedPaySlip(newList);
				flag = true;
				break;
			case 8:
				flag = false;
				break;
			}
		} while (flag);
	}

	public static void addStaff(Scanner scan) {
		System.out.println("1. Employee");
		System.out.println("2. Manager");

		int option = scan.nextInt();
		boolean isManager = false;
		switch (option) {
		case 1:
			isManager = false;
			break;
		case 2:
			isManager = true;
			break;
		default:
			System.out.println("Please int put 1 for Employee, 2 for Manager");
			addStaff(scan);
			return;
		}

		System.out.println("ID:");
		String id = scan.nextLine();
		id = scan.nextLine();
		System.out.println("Name: ");
		String name = scan.nextLine();
		System.out.println("Age: ");
		int age = Integer.parseInt(scan.nextLine());
		System.out.println("Factor ");
		double factor = Double.parseDouble(scan.nextLine());
		System.out.println("Start Date: dd-mm-yy ");
		String startDate = scan.nextLine();
		System.out.println("Department: ");
		String department = scan.nextLine().toUpperCase();
		System.out.println("annullLeave: ");
		int annullLeave = Integer.parseInt(scan.nextLine());

		setJobTitle(scan, isManager, id, name, age, factor, startDate, department, annullLeave);
		calcSalary();
		System.out.println("staff added");

		checkDepartment(department);
	}

	public static void setJobTitle(Scanner scan, boolean isManager, String id, String name, int age, double factor,
			String startDate, String department, int annullLeave) {
		// for input manage information
		if (isManager) {
			System.out.println("Please chose job title: ");
			System.out.println("1. Business Leader");
			System.out.println("2. Project Leader");
			System.out.println("3. Technical Leader");
			int jobTitle;
			// if user input more than 3 and less than 1, they must input until correctly.
			do {
				jobTitle = Integer.parseInt(scan.nextLine());
			} while (jobTitle > 3 || jobTitle < 1);

			Manager manager = new Manager(id, name, age, factor, startDate, department, annullLeave, jobTitle);
			StaffList.add(manager);
		} else {
			// for input employee information
			System.out.println("Over time: ");
			int overTime = Integer.parseInt(scan.nextLine());
			Employee employee = new Employee(id, name, age, factor, startDate, department, annullLeave, overTime);
			StaffList.add(employee);
		}
	}

	public static void checkDepartment(String department) {
		Scanner scan = new Scanner(System.in);
		boolean check = false;
		// found deparment and add staff to this department
		for (Department dp : dplist) {
			if (dp.getDepartmentName().equals(department)) {
				check = true;
				dp.setNumOfStaff(dp.getNumOfStaff() + 1);
			}
		}
		// add new department and id ,if coundn't find
		if (!check) {
			Department dp = new Department(dplist.size() + 1, department, 1);
			dplist.add(dp);
		}
	}

	// show department list
	private static void departmentList() {
		if (dplist.size() == 0) {
			System.out.println("No department to show");
		} else {
			for (Department department : dplist) {
				System.out.println(department.toString());
			}
		}
	}

	private static void StaffList() {
		for (Staff nhanVien : StaffList) {
			System.out.println(nhanVien.toString());
		}
	}

	private static void search(Scanner scan) {
		System.out.println("1. Search by id or name");
		String option = scan.nextLine();
		boolean check = true;
		for (Staff staff : StaffList) {
			if (staff.getName().equals(option) || staff.getId().equals(option)) {
				check = true;
				System.out.println(staff.toString());
			}
		}
		if (!check) {
			System.out.println("No id or name have found");
		}
	}

	private static void displayStaffByDepartment(Scanner scan) {
		if (dplist.size() == 0) {
			System.out.println("No department to show");
		} else {
			// Show all departmnent ID ,name and search by department ID
			System.out.println("please intput department ID");
			for (Department department : dplist) {
				System.out.println("ID: " + department.getDepartmentId() + ", Name: " + department.getDepartmentName());
			}
			boolean check = true;
			int option = Integer.parseInt(scan.nextLine());
			// found department ID
			for (Department department : dplist) {
				if (option == department.getDepartmentId()) {
					for (Staff st : StaffList) {
						if (department.getDepartmentName().equals(st.getDepartment())) {
							check = true;
							System.out.println(st.toString());
						}
					}
					break;
				}
			}
			// No id have found
			if (!check) {
				System.out.println("No department ID have found");
			}
		}
	}

	// print payslip for all staff
	private static void AllPaySlip(ArrayList<Staff> list) {
		// for Employee
		for (Staff staff : StaffList) {
			if (staff instanceof Employee) {
				System.out.println(String.format("%-10s%-20s%,.2f", staff.getName(), staff.getDepartment(),
						((Employee) staff).getCalculateSalary()));

			
				// for Manager
			} else if (staff instanceof Manager) {
				System.out.println(String.format("%-10s%-20s%,.2f", staff.getName(), staff.getDepartment(),
						((Manager) staff).getCalculateSalary()));
			}
		}
	}

	// calculator all staff salary
	private static void calcSalary() {
		for (Staff staff : StaffList) {
			staff.calculateSalary();
		}
	}

	public static void sortedPaySlip(ArrayList<Staff> newList) {
		Collections.sort(StaffList, new Comparator<Staff>() {
			@Override
			public int compare(Staff s1, Staff s2) {
				if (s1.calculateSalary < s2.calculateSalary) {
					return -1;
				} else {
					if (s1.calculateSalary == s2.calculateSalary) {
						return 0;
					} else {
						return 1;
					}
				}
			}
		});
		AllPaySlip(newList);
	}
}
