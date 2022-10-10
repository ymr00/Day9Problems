package empwage;

public class Empwageuc4 {
	public int wagePerHour = 20;
	public int workingHour;
	public int isPresent;

	public Empwageuc4() {
		System.out.println("welcome to the Employee Wage Computation!!!");
	}

	public static void main(String[] args) {
		Empwageuc4 emp = new Empwageuc4();

		emp.calculateDailyWage();
	}
	// Calculate Daily Employee Wage

	public void calculateDailyWage() {
		checkEmployee();
		int dailyWage = wagePerHour * workingHour;
		System.out.println("the daily wage of employee is = " + dailyWage);
	}

	public int getRandomNumber() {
		int flag = (int) (Math.random() * 3);
		return flag;

	}

	public void checkEmployee() {
		isPresent = getRandomNumber();
		System.out.println(isPresent);
		switch (isPresent) {
		case 0:
			System.out.println("Employee is absent");
			workingHour = 0;
			break;
		case 1:
			System.out.println("Employee is Present");
			workingHour = 8;
			break;
		default:
			System.out.println("Employee is working  Part-Time");
			workingHour = 8;
			break;
		}

	}

}
