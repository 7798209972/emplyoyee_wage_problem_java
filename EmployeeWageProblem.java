public class EmployeeWageProblem {

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