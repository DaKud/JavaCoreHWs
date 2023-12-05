package Base;

public class Worker extends Employee{
    private double salary;

    private Worker(String firstName, String lastNane, String birthdayDate, String phoneNumber, double salary, String position) {
        super(firstName, lastNane, birthdayDate, phoneNumber, position);
        this.salary = salary;
    }

    /**
     * @param firstName
     * @param lastNane
     * @param birthdayDate
     * @param phoneNumber
     * @param salary
     * @param position
     * @return
     */
    public static Worker createWorker(String firstName, String lastNane, String birthdayDate, String phoneNumber, double salary, String position){
        if(firstName == null)
            throw new RuntimeException("The name is incorrect");
        if(lastNane == null)
            throw new RuntimeException("Last name is incorrect");
        if(birthdayDate == null)
            throw new RuntimeException("Incorrect date of birth");
        if(phoneNumber == null)
            throw new RuntimeException("The phone number is not specified or is specified incorrectly");
        if(salary <= 0.0)
            throw new RuntimeException("The hourly wage value cannot be less than or equal to zero");
        if(position == null)
            throw new RuntimeException("Employee position not specified");

        return new Worker(firstName, lastNane, birthdayDate, phoneNumber, salary, position);
    }

    /**
     * Implementation of a method of an abstract parent class
     * @return
     */
    @Override
    public double getAverageSalary(){
        return salary;
    }
}
