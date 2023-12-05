package Base;

import java.util.*;
import java.util.function.Consumer;

/**
 *The goal was to implement the Iterable interface in order to work with it and understand the internal kitchen a little.
 * Therefore, I followed a relatively simple path.
 * @param <Employee>
 */

public class EmployeesList<Employee> implements Iterable<Employee>{

    private List<Employee> employeeList;

    public EmployeesList(){
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }
    public void removeEmployee(Employee employee) {
        employeeList.remove(employee);
    }

    public void sortEmployee(Comparator<? super Employee> comparator){
        employeeList.sort(comparator);
    }

    @Override
    public void forEach(Consumer<? super Employee> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Iterator<Employee> iterator() {
        return employeeList.iterator();
    }

    @Override
    public Spliterator<Employee> spliterator() {
        return Iterable.super.spliterator();
    }
}
