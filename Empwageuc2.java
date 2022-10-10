package empwage;

public class Empwageuc2 {
	public int wagePerHour = 20;
	public int workingHour;
	public int isPresent;
	
	 public Empwageuc2() {
		System.out.println("welcome to the Employee Wage Computation!!!");
	 }
public static void main(String[] args) {
	Empwageuc2 emp =new Empwageuc2();
	
	emp.calculateDailyWage();
}
//Calculate Daily Employee Wage 

public void calculateDailyWage(  ) {
	checkEmployee();
 int dailyWage = wagePerHour*workingHour;
 System.out.println("the daily wage of employee is = " + dailyWage);
}

public int getRandomNumber() {
	int flag = (int) (Math.random() * 2);
	System.out.println("Random Number is : ");
	return flag;


}

public void checkEmployee() {
	isPresent= getRandomNumber();
	System.out.println(isPresent);
	if (isPresent == 0) {
		System.out.println("Employee is absent");
		workingHour= 0;
		
	} else if (isPresent == 1) {
		System.out.println("Employee is Present");
		workingHour= 8;
	}

}

}
