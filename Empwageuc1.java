package empwage;

import java.util.Random;

public class Empwageuc1 {
	public static void main(String[] args) {
		System.out.println("Welcome to Employee Wage Computation Program.");
		Random ran = new Random();
		int num = ran.nextInt(2);
//		int num1 = (int) Math.random(); 
		System.out.println("Random Number is : " + num);
//		System.out.println("Random Number1 is : " + num1);

		if (num == 1)
			System.out.println("Employee is Present. ");
		else
			System.out.println("Employee is Absent. ");

	}

}
