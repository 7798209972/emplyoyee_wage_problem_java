public class EmployeeWageProblem {

	/* Constants */

	public static final int IS_FULL_TIME = 1;
	public static final int IS_PART_TIME = 2;

	/* Declaring Full Day Hour & Employee Wage Per Hour */
	
	public static final int FULL_DAY_HOUR = 8;
	public static final int EMPLOYEE_RATE_PER_HOUR = 20;

	/* Adding Part Time Hour */

	public static final int PART_TIME_HOUR = 4;

	/* Declaring Variables */

	public int total_hours=0;
	public int wage=0;
	public int total_wage=0;
	public int total_working_hour=0;
	public String status;
	public int i=1;


	public void get_employee_wage()
	{
		/* Welcome Message */

		System.out.println("============================================");
		System.out.println("Welcome to Employee Wage Computation Program");
		System.out.println("============================================");

		/* Using Random function for checking attendance */

		int emp_attendance = (int) (Math.floor(Math.random()*10)%3);

		/* Solving Using Switvh Case Statement */

		while ( i<=20 )
		{

		int emp_attendance = (int) (Math.floor(Math.random()*10)%3);

		switch(emp_attendance)
		{
			case IS_FULL_TIME :
					status="Full time |";
					total_hours=FULL_DAY_HOUR;
					break;
			case IS_PART_TIME:
					status="Part time |";
					total_hours=PART_TIME_HOUR;
					break;
			default :
					status="Absent |";
					total_hours=0;
					break;
		}
		wage=total_hours*EMPLOYEE_RATE_PER_HOUR;
		total_wage+=wage;
		
		System.out.println("Day "+i+" "+status+" Wage - Rs."+wage+"/-");
		i++;
		total_working_hour+=total_hours;
	}
	System.out.println("============================================");

	}
	public static void main(String[] args)
	{
		
		EmployeeWageProblem obj=new EmployeeWageProblem();
		obj.get_employee_wage();
		
		
	}
}