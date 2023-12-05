import Base.*;

import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        /**
         * Creating Worker and Freelancer objects
         */
        Employee freelancer1 = Freelancer.createFreelancer("Tommy", "Cash", "15/05/1986","+2222222222", 6.3, "Worker");
        Employee freelancer2 = Freelancer.createFreelancer("Snoop", "Dog", "10/07/1963","+999999999999", 1999.3, "Freelancer" );
        Employee freelancer3 = Freelancer.createFreelancer("Dr", "Dre", "02/04/1962","+888888888", 33.3, "Freelancer" );
        Employee worker1 = Worker.createWorker("Slim", "Shady", "03/09/1975","+5555555555", 99999.3, "Worker" );
        Employee worker2 = Worker.createWorker("Nikki", "Minaj", "15/12/1986","+79033699965", 33333.33, "Freelancer" );

        /**
         * We fill the newly created custom collection with our objects
         */
        EmployeesList<Employee> list = new EmployeesList();
        list.addEmployee(freelancer1);
        list.addEmployee(freelancer2);
        list.addEmployee(freelancer3);
        list.addEmployee(worker1);
        list.addEmployee(worker2);

        /**
         *  Print it using forEach
         */
        list.forEach(Employee -> System.out.println(Employee.toString()));
        System.out.println();

        /**
         * Sort the collection using the compareTo method
         */
        list.sortEmployee(Employee::compareTo);
        list.forEach(Employee -> System.out.println(Employee.toString()));
        System.out.println();

        /**
         *  create an object of our custom comparator.
         * Sort the collection using this comparator
         *  Print the results sorted by increasing salary.
         */
        EmployeesSalaryComparator salaryComparator = new EmployeesSalaryComparator();
        list.sortEmployee(salaryComparator);
        list.forEach(Employee -> System.out.println(Employee.toString()));
    }
}

