package Base;

import java.util.Comparator;

/**
 * A class that implements a comparator interface that sorts our objects according to salary.
 */
public class EmployeesSalaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return Double.compare(o1.getAverageSalary(), o2.getAverageSalary());
    }
}
