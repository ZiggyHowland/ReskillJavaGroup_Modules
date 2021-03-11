package javaBasics.labs.streams_appB;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Main {

	private static Collection<Employee> emps = createEmployees();


	private static Collection<Employee> createEmployees() {
		Collection<Employee> emps = new ArrayList<>();		
		emps.add(new Employee("Peter Smith", "London", 25000));
		emps.add(new Employee("Johan Mitra", "Berlin", 21000));
		emps.add(new Employee("Diane Evans", "London", 32000));
		emps.add(new Employee("Meera Jones", "Geneva", 2500000));
		emps.add(new Employee("Gerry Lomax", "London", 7000));
		emps.add(new Employee("Steff Holby", "Berlin", 55000));
		emps.add(new Employee("Franz Elsom", "Berlin", 75000));
		emps.add(new Employee("Simon Peter", "Geneva", 150000));
		return emps;
	}
	

	public static void main(String... args) {



		displayEmployeeFullDetails();
		displayEmployeeNames();
		displayWageBill();
		displaySortedDistinctOffices();
		displayFilteredEmployees("Berlin employees", e -> e.getOffice() == "Berlin");
		displayFilteredEmployees("Highly paid employees", e -> e.getSalary() > 50_000.0);
		displayFilteredEmployees("Highly paid employees in Berlin",
				e -> e.getOffice() == "Berlin" && e.getSalary() > 50_000);
		displaySalaryStats();
		displaySalaryTests("Berlin");
		displaySalaryTests("Geneva");
		displaySalaryTests("London");

		testCollect();

	}

	private static void displayEmployeeFullDetails() {
		try (Stream<Employee> stream = emps.stream()) {
			System.out.println("\nFull details of all employees:");
			stream.forEach(Employee::display);
			stream.forEach(e -> e.display());
		}				
	}

	private static void displayEmployeeNames() {
		Stream<Employee> stream = emps.stream();
		System.out.println("-------------\nEmployee names:");
		stream.forEach( e -> System.out.println(e.getName()) );
	}

	private static void displayWageBill() {
		DoubleStream ds;
		Stream<Employee> stream = emps.stream();

		if (true) {
			// ALTERNATIVE A: Lambda
			ToDoubleFunction<Employee> d = e -> e.getSalary();
			ds = stream.mapToDouble(d);
		}
		else {
			// ALTERNATIVE B: Method reference
			ds = stream.mapToDouble(Employee::getSalary);
		}

		double sum = ds.sum();
		System.out.println("----------\nTotal wage bill: " + sum);
	}
	
	private static void displaySortedDistinctOffices() {
		System.out.println("------------\nOffices sorted:");
		Stream<Employee> stream = emps.stream();
		stream.map(e -> e.getOffice())
				.distinct()
				.sorted()
				.forEach(System.out::println);

	}
	
	private static void displayFilteredEmployees(String description, Predicate<Employee> predicate) {
		System.out.println("---------------\nFiltered employees - " + description + ":");
		Stream<Employee> stream = emps.stream();
		stream.filter(predicate)
			  .forEach(Employee::display);
	}
	
	private static void displaySalaryStats() {
		System.out.println("-----------\nEmployee statistics");
		double minSalary = initSalaryStream().min().getAsDouble();
		System.out.println("Minimum salary of all employees: " + minSalary);
		double maxSalary = initSalaryStream().max().getAsDouble();
		System.out.println("Maximum salary of all employees: " + maxSalary);
		double avgSalary = initSalaryStream().average().getAsDouble();
		System.out.println("Average salary of all employees: " + avgSalary);

		System.out.println("\nTop 3 employees by salary [descending]:");
		emps.stream()
				.sorted( Comparator.comparingDouble(Employee::getSalary).reversed() )
				.limit(3)
				.forEach(Employee::display);

		System.out.println("\nTop 3 employees by name [ascending]:");
		emps.stream()
				.sorted(Comparator.comparing( Employee::getName))
				.limit(3)
				.forEach(Employee::display);

	}

	private static void displaySalaryTests(String city) {
		System.out.println("-------------\n" + city + " salary test:");
		long count;
		Predicate<Employee> cityPred = e -> e.getOffice() == city;
		count = emps.stream()
				.filter(cityPred)
				.filter(e -> e.getSalary() < 7_000)
				.count();

		System.out.println( count == 0 ? "All employees earn above 7000" : count + " employees earn below 7000");
		count = emps.stream()
				.filter(cityPred)
				.filter(e -> e.getSalary() > 1_000_000)
				.count();
		System.out.println( count == 0 ? "No employees earn above 1M" : count + (count == 1 ? " employees earn" : " employee earns") +  " above 1M");

		Optional<Employee> firstEmployee = emps.stream()
				.filter(cityPred)
				.min( Comparator.comparingInt(Employee::getId) );
		if (firstEmployee.isPresent()) {
			firstEmployee.get().display();
		}
		else {
			System.out.println("No employees hired in " + city);
		}

	}


	private static void testCollect() {
		double salarySum = emps.stream()
				.map( e -> e.getSalary() )
				.reduce(0.0, (a, b) -> a + b);
		System.out.println("---------------\nSum of salaries: " + salarySum);


		OptionalDouble salaryAverage;
		System.out.println("---------------\nAverage of salaries: ");
		Map<String, List<Employee>> employeesByCity =
			emps.stream()
				.collect(
						Collectors.groupingBy( Employee::getOffice )
				);
		for (Map.Entry<String, List<Employee>> entry : employeesByCity.entrySet()) {
			salaryAverage = entry.getValue().stream()
				.mapToDouble( e -> e.getSalary() )
				.average();
			System.out.println(entry.getKey() + ": " + salaryAverage.getAsDouble());
		}



	}





	private static DoubleStream initSalaryStream() {
		Stream<Employee> stream = emps.stream();
		return stream.mapToDouble( e -> e.getSalary() );
	}

}
