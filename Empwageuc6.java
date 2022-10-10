package empwage;

public class Empwageuc6 {
	public int wagePerHour = 20;
	public int workingHour;
	public int isPresent;
	public int totalworkingDays = 0;
	public int totalSalary = 0;
	public int numWorkingDays = 20;
	public int hoursInMonth = 100;
	int dailyWage;
	public int totalWorkingHour = 0;

	public Empwageuc6() {
		System.out.println("welcome to the Employee Wage Computation!!!");
	}

	public static void main(String[] args) {
		Empwageuc6 emp = new Empwageuc6();

		emp.calculateMonthlyWage();
	}

	// Calculate Employee Wage
	public void calculateMonthlyWage() {
		while (totalWorkingHour <= hoursInMonth && totalworkingDays <= numWorkingDays) {
			checkWorkHour();
			int dailyWage = wagePerHour * workingHour;
			totalWorkingHour = totalWorkingHour + workingHour;
			totalSalary = dailyWage + totalSalary;
			totalworkingDays++;
		}
		System.out.println("the total wage of employee is = " + totalSalary);
	}

	public int getRandomNumber() {
		int flag = (int) (Math.random() * 3);
		return flag;

	}

	public void checkWorkHour() {
		isPresent = getRandomNumber();
		switch (isPresent) {
		case 0:
			workingHour = 0;
			break;
		case 1:
			workingHour = 8;
			break;
		default:
			workingHour = 8;
			break;
		}

	}

}
