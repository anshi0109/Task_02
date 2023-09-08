import java.util.*;
import java.util.stream.*;
class Employee{
	int id;
	int age;
	double salary;
	int yearofjoining;
	String name;
	String gender;
	String department;
	 int fcount=0;
	 
	Employee(int  id,String name,int age,String gender,String department,int yearofjoining,double salary){
		this.id=id;
		this.name=name;
		this.age=age;
		this.gender=gender;
		this.department=department;
		this.yearofjoining=yearofjoining;
		this.salary=salary;
	}
	
	public String toString(){
		return "id="+id+ " Age="+age+ " Name: "+name+ " Gender="+gender;
	}
	
	int getAge(){
		return age;
	}
	String getName(){
		return name;
	}
	String getdepartment(){
		return department;
	}
	double getSalary(){
		return salary;
	}
	int getJoindate(){
		return yearofjoining;
	}
	public String getgender(){
		return gender;
	}
}

class Task_02{
	public static void main(String ar[]){
		ArrayList<Employee> al = new ArrayList<Employee>();
         
       al.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
       al.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 135000.0));
       al.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
       al.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
       al.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
       al.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
       al.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
       al.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
       al.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
       al.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
       al.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
       al.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
       al.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
       al.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
       al.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
       al.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
       al.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));
       
		//How many male and female employees are there in the organization?	
		long malecount=al.stream().filter(employe->"Male".equals(employe.getgender())).count();
		long femalecount=al.stream().filter(employe->employe.getgender().equals("Female")).count();
		System.out.println("Total number of male employes are: "+malecount);
		System.out.println("Total number of femalemale employes are: "+femalecount);
		System.out.println();
		
		//Print the name of all departments in the organization?	
		Set<String> set=al.stream().map(x->x.department).collect(Collectors.toSet());
		System.out.println(set);
		System.out.println();
		
		//What is the average age of male and female employees?	
		double averagefemale=al.stream().filter(employe->"Female".equals(employe.getgender())).mapToInt(Employee::getAge).average().orElse(0.0);
		double averagemale=al.stream().filter(employe->"Male".equals(employe.getgender())).mapToInt(Employee::getAge).average().orElse(0.0);
		System.out.println("The Average age of female: "+averagefemale);
		System.out.println("The Average age of female: "+averagemale);
		System.out.println();
		
		// 4) Get the details of highest paid employee in the organization?	
		Employee highestsalary=al.stream().max((e1,e2)->Double.compare(e1.getSalary(),e2.getSalary())).orElse(null);
		System.out.println("The height salary person is "+highestsalary.getName());
		System.out.println();
		
		//5) Get the names of all employees who have joined after 2015?	
		System.out.println("The peoples who join after 2015 are ");
		List<String> s=al.stream().filter(employe -> employe.getJoindate()> 2015 ).map(Employee::getName).collect(Collectors.toList());
		s.forEach(System.out::println);
		System.out.println();
		
		//6) Count the number of employees in each department?	
		Map<String,Long> depart=al.stream().collect(Collectors.groupingBy(x->x.getdepartment(),Collectors.counting()));
		System.out.println(depart);
		System.out.println();
		
		//7) What is the average salary of each department?	
		Map<String,Double> sal=al.stream().collect(Collectors.groupingBy(x->x.getdepartment(),Collectors.averagingDouble(Employee::getSalary)));
		System.out.println(sal);
		System.out.println();
		
		//8) Get the details of youngest male employee in the product development department?	
		Optional<Employee> youngest=al.stream().filter(x->"Male".equals(x.getgender()) && "Product Development".equals(x.getdepartment())).min(Comparator.comparingInt(x->x.getAge()));
		if(youngest.isPresent()){
			Employee y=youngest.get();
			System.out.println(y);
		}
		else
			System.out.println("No yougest male employee is found");
		System.out.println();
		
		//9)How many male and female employees are there in the sales and marketing team?	
		long maleCountMarketing=al.stream().filter(x->"Male".equals(x.getgender())&& "Sales And Marketing".equals(x.getdepartment())).count();
		long femaleCountMarketing=al.stream().filter(x->"Female".equals(x.getgender())&& "Sales And Marketing".equals(x.getdepartment())).count();
		System.out.println("Male count in the Sale And Marketing are: "+maleCountMarketing);
		System.out.println("Female count in the Sale And Marketing are: "+femaleCountMarketing);
		System.out.println();
		
		//10) What is the average salary of male and female employees?	
		Map<String,Double> averageSalaryByGender=al.stream().collect(Collectors.groupingBy(Employee::getgender,Collectors.averagingDouble(x->x.getSalary())));
		Double maleAverage=averageSalaryByGender.get("Male");
		Double femaleAverage=averageSalaryByGender.get("Female");
		System.out.println("The average salary of MAle is: "+maleAverage);
		System.out.println("The Average salary of Female is: "+femaleAverage);
		System.out.println();
		
		 
		 
		 //11) List down the names of all employees in each department?	
		 Map<String,List<String>> namesByDepartment=al.stream().collect(Collectors.groupingBy(Employee::getdepartment,Collectors.mapping(Employee::getName,Collectors.toList())));
		 
		 namesByDepartment.forEach((department, employeeNames) -> {
            System.out.println("Department: " + department);
            employeeNames.forEach(name -> System.out.println("- " + name));
        });
		System.out.println();
		
		//12) What is the average salary and total salary of the whole organization?	
		Double totalSalary=al.stream().mapToDouble(Employee::getSalary).sum();
		Double aSalary=al.stream().mapToDouble(Employee::getSalary).average().orElse(0);
		System.out.println("Total salary is :"+totalSalary);
		System.out.println("Average salary is :"+aSalary);
		System.out.println();
		
		// 13) Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years?			
		List<Employee> youngerThan25=al.stream().filter(x->x.getAge() <= 25).collect(Collectors.toList());
		System.out.println("Employee younger than 25:");
		youngerThan25.forEach(x->System.out.println(x.getName()));
		System.out.println();
		
		List<Employee> olderThan25=al.stream().filter(x->x.getAge() > 25).collect(Collectors.toList());
		System.out.println("Employee elder than 25:");
		olderThan25.forEach(x->System.out.println(x.getName()));
		System.out.println();
		
		//14) Who is the oldest employee in the organization? What is his age and which department he belongs to?
		Employee oldest=al.stream().max((e1,e2)->Integer.compare(e1.getAge(),e2.getAge())).orElse(null);
		if(oldest!=null){
			System.out.println("Oldest Employee :"+oldest.getName());
			System.out.println("Age :"+oldest.getAge());
			System.out.println("Department :"+oldest.getdepartment());
		}
		else{
			System.out.println("There is no oldest employee");
		}
	}
}


         
