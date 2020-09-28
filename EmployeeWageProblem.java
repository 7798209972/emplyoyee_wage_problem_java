public class EmployeeWageProblem {

	/* Constants */

	public static final int IS_FULL_TIME = 1;
	public static final int IS_PART_TIME = 2;

	/* Declaring Full Day Hour & Employee Wage Per Hour */
	
	public static final int FULL_DAY_HOUR = 8;
	public static final int EMPLOYEE_RATE_PER_HOUR = 20;


	public void get_employee_wage()
	{
		/* Welcome Message */

		System.out.println("============================================");
		System.out.println("Welcome to Employee Wage Computation Program");
		System.out.println("============================================");

		/* Using Random function for checking attendance */

		int emp_attendance = (int) (Math.floor(Math.random()*10)%3);
		
	}
	public static void main(String[] args)
	{
		
		EmployeeWageProblem obj=new EmployeeWageProblem();
		obj.get_employee_wage();
		
		
	}
}