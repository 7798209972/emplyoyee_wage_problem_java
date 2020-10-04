import java.util.Scanner;

class CompanyEmpWage
{

	/* Declaring Variables */
	public String company;
	public int no_of_days, no_of_hours, wage_rate;
	Scanner me=new Scanner(System.in);

	/* Method to getting Company name, maximum No of days,working hours and Wage rate per hour */

	public void EmpWageBuilder()
	{
		System.out.println("Enter Company Name : ");
		company=me.next();
		System.out.println("Enter maximum number of working days for a month : ");
		no_of_days=me.nextInt();
		System.out.println("Enter maximum number of working hours for a month : ");
		no_of_hours=me.nextInt();
		System.out.println("Enter Wage Rate per hours : ");
		wage_rate=me.nextInt();
	}
}
public class EmployeeWageProblem extends CompanyEmpWage{

	/* Constants */

	public static final int IS_FULL_TIME = 1;
	public static final int IS_PART_TIME = 2;

	/* Declaring Full Day Hour & Employee Wage Per Hour */
	
	public static final int FULL_DAY_HOUR = 8;

	/* Adding Part Time Hour */

	public static final int PART_TIME_HOUR = 4;


	/* Declaring Variables */

	public int total_hours=0;
	public int wage=0;
	public int total_wage=0;
	public int total_working_hour=0;
	public String status;
	public int i=1;


	/* Using Default Constructer for Initializing Welcome Message */

	EmployeeWageProblem()
	{
		/* Welcome Message */

		System.out.println("============================================");
		System.out.println("Welcome to Employee Wage Computation Program");
		System.out.println("============================================");
	}

	

	/* Method to Compute Employee Wage */

	public void computeEmpWage()
	{

		/* Message Displaying */
		System.out.println("============================================");
		System.out.println("Employee Wage Details of "+company+" for "+no_of_days+" Days");
		System.out.println("============================================");

		/* Calcuting Wages till a condition of maximum working hours or day is reached a month */

		while ( i<=no_of_days && total_working_hour<=no_of_hours )
		{

		/* Using Random function for checking attendance */

		int emp_attendance = (int) (Math.floor(Math.random()*10)%3);

		/* Solving Using Switvh Case Statement */

		switch(emp_attendance)
		{
			case IS_FULL_TIME :

					/* Getting Status & Working Hours */

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

		/* Calculating Wage */

		wage=total_hours*wage_rate;

		/* Calculating Total Wage for a Month */
		total_wage+=wage;
		
		System.out.println("Day "+i+" "+status+" Wage - Rs."+wage+"/-");

		/* Increamenting Working Hours & Days*/

		i++;
		total_working_hour+=total_hours;
	}
	System.out.println("============================================");
	System.out.println("Total Wage : Rs."+total_wage+"/-");
	System.out.println("Total Working Hours : "+total_working_hour);
	System.out.println("============================================");
	// return total_wage;

	}
	public static void main(String[] args)
	{
		//Creating objects

		EmployeeWageProblem obj1=new EmployeeWageProblem();
		EmployeeWageProblem obj2=new EmployeeWageProblem();

		//Calling methods

		obj1.EmpWageBuilder();
		obj1.computeEmpWage();
		obj2.EmpWageBuilder();
		obj2.computeEmpWage();
		
	}
}