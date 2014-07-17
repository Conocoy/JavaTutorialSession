import java.io.*;

public class EmployeeTest{

	public static void main(String[] args){
		Employee empOne = new Employee("Mischa");
		Employee empTwo = new Employee("Yara");
	
		empOne.empAge(27);
		empOne.empDesignation("Unemployed / Student");
		empOne.empSalary(100.0);
	
		empTwo.setAll(27,"Boener",800.99);
	
		empOne.printEmployee();
		System.out.println("");
		empTwo.printEmployee();
	
	}
}