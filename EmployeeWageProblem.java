import java.util.*;

//Creating Interface
interface IComputeEmpWage
{
	//Declaring methods
	public void addCompanyEmpWage(String company, int emp_rate_per_hour, int no_of_working_days, int max_hours_per_month);
	public void computeEmpWage();
	public int getTotalWage(String company);
}

class CompanyEmpWage
{

	// Declaring Variables
	public final String company;
	public final int emp_rate_per_hour;
	public final int no_of_working_days;
	public final int max_hours_per_month;
	public int totalEmpWage;

	// Method to getting Company name, maximum No of days,working hours and Wage rate per hour

	public CompanyEmpWage(String company, int emp_rate_per_hour, int no_of_working_days, int max_hours_per_month)
	{
		this.company=company;
		this.emp_rate_per_hour=emp_rate_per_hour;
		this.no_of_working_days=no_of_working_days;
		this.max_hours_per_month=max_hours_per_month;
		totalEmpWage=0;

	}

	//Method for Set total employee Wage for company
	public void setTotalEmpWage(int totalEmpWage)
	{
		this.totalEmpWage=totalEmpWage;
	}


	// Return or displaying Total employee Wage of Company
	@Override
	public String toString()
	{
		return "==================================================\nTotal Employee Wage of Company : "+company+" is : Rs."+totalEmpWage+"/-";
	}
}
public class EmployeeWageProblem implements IComputeEmpWage{

	//Constants

	public static final int IS_FULL_TIME = 1;
	public static final int IS_PART_TIME = 2;

	//Declaring Full Day Hour & Employee Wage Per Hour
	
	public static final int FULL_DAY_HOUR = 8;

	//Adding Part Time Hour

	public static final int PART_TIME_HOUR = 4;

	//Declaring Array List and HashMap

	private int no_of_company=0;
	private ArrayList<CompanyEmpWage> company_emp_wage_list;
	private HashMap<String, CompanyEmpWage> company_to_emp_wage_map;

	//Default constructor for welcome message and initialization
	public EmployeeWageProblem()
	{
		System.out.println("==================================================");
		System.out.println("Welcome to Employee Wage Computation Program\n");
		company_emp_wage_list=new ArrayList<>();
		company_to_emp_wage_map=new HashMap<>();
	}

	//Method for getting rate, company name, max working hours and max working days
	public void addCompanyEmpWage(String company, int emp_rate_per_hour, int no_of_working_days, int max_hours_per_month)
	{
		CompanyEmpWage companyEmpWage= new CompanyEmpWage(company, emp_rate_per_hour, no_of_working_days, max_hours_per_month);

		//Adding data to ArrayList
		company_emp_wage_list.add(companyEmpWage);

		//Adding data to hashmap
		company_to_emp_wage_map.put(company, companyEmpWage);

	}


	//Method for computing employee wage according to number of compamies
	public void computeEmpWage()
	{
		//loop along with size of company list
		for(int k=0; k<company_emp_wage_list.size(); k++)
		{
			//Creating object for CompanyEmpWage class
			CompanyEmpWage companyEmpWage=company_emp_wage_list.get(k);
			companyEmpWage.setTotalEmpWage(this.computeEmpWage(companyEmpWage));
			System.out.println(companyEmpWage);
		}
	}


	// Getting Total employee Wage of Company from HashMap
	@Override
	public int  getTotalWage(String company)
	{
		return company_to_emp_wage_map.get(company).totalEmpWage;
	}


	// Computing Employee Wage for particular company
	public int computeEmpWage(CompanyEmpWage companyEmpWage)
	{
		//Declaring variables for calculation

		int emp_hrs=0;
		int totalemp_hrs=0;
		int total_working_days=0;
		int total_wage=0;
		int i=1;
		int daily_wage=0;
		String status;

		/* Message displaying with company name and no of days*/
		System.out.println("==================================================");
		System.out.println("Employee Wage Details of "+companyEmpWage.company+" for "+companyEmpWage.no_of_working_days+" Days");
		System.out.println("==================================================");

		while ( totalemp_hrs <= companyEmpWage.max_hours_per_month && total_working_days < companyEmpWage.no_of_working_days )
		{

		/* Using Random function for checking attendance */

		int emp_attendance = (int) (Math.floor(Math.random()*10)%3);

		/* Solving Using Switvh Case Statement */

		switch(emp_attendance)
		{
			case IS_FULL_TIME :

					/* Getting Status & Working Hours */
					status="Full time |";
					emp_hrs=FULL_DAY_HOUR;
					break;
			case IS_PART_TIME:
					status="Part time |";
					emp_hrs=PART_TIME_HOUR;
					break;
			default :
					status="Absent |";
					emp_hrs=0;
					break;
		}

		/* Calculating Total Wage for a Month */
		totalemp_hrs+=emp_hrs;
		daily_wage=emp_hrs*companyEmpWage.emp_rate_per_hour;

		total_wage+=daily_wage;
		
		// System.out.println("Day "+i+" Emp Hrs :"+emp_hrs);
		System.out.println("Day "+i+" Emp Hrs :"+emp_hrs+" "+status+" Wage - Rs."+daily_wage+"/-");
		i++;

		}
		return totalemp_hrs*companyEmpWage.emp_rate_per_hour;
	}

	public static void main(String[] args)
	{
		//Creating objects
		EmployeeWageProblem empWageBuilder= new EmployeeWageProblem();

		//Calling methods
		empWageBuilder.addCompanyEmpWage("TCS", 230, 20, 100);
		empWageBuilder.addCompanyEmpWage("Infosys", 250, 20, 100);

		empWageBuilder.computeEmpWage();

		//Getting total employee wage of particular company
		System.out.println("Total Wage of TCS :"+empWageBuilder.getTotalWage("TCS"));
		System.out.println("Total Wage of Infosys :"+empWageBuilder.getTotalWage("TCS"));
		
	}
}