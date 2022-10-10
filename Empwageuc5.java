package empwage;

public class Empwageuc5 {
	public int wagePerHour = 20;
	public int workingHour;
	public int isPresent;
	public int workingDay=0;
	public int totalSalary = 0;
	int dailyWage;
	public int totalWorkingHour = 0;

	public Empwageuc5() {
		System.out.println("welcome to the Employee Wage Computation!!!");
	}

	public static void main(String[] args) {
		Empwageuc5 emp = new Empwageuc5();

		emp.calculateMonthlyWage();
	}

	// Calculate Employee Wage
	public void calculateMonthlyWage() {
		while (workingDay <= 20 && workingHour <=100 ) {
			checkEmployee();
			int dailyWage = wagePerHour * workingHour;
			totalWorkingHour = totalWorkingHour + workingHour;
			totalSalary = dailyWage + totalSalary;
			workingDay++;
			workingHour++;
			
			 
		}
		System.out.println("the daily wage of employee is = " + dailyWage);
		
		System.out.println("the total wage of employee is = " + totalSalary);

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
		case 2:
			System.out.println("Employee is working  Part-Time");
			workingHour = 8;
			break;
		}

	}

}
