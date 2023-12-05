package Base;

public class Freelancer extends Employee{

    private double hourlyRate;

    private Freelancer(String firstName, String lastNane, String birthdayDate, String phoneNumber, double hourlyRate, String position) {
        super(firstName, lastNane, birthdayDate, phoneNumber, position);
        this.hourlyRate = hourlyRate;
    }

    /**
     * @param firstName
     * @param lastNane
     * @param birthdayDate
     * @param phoneNumber
     * @param hourlyRate
     * @param position
     * @return
     */
    public static Freelancer createFreelancer(String firstName, String lastNane, String birthdayDate, String phoneNumber, double hourlyRate, String position){
        if(firstName == null)
            throw new RuntimeException("The name is incorrect");
        if(lastNane == null)
            throw new RuntimeException("Last name is incorrect");
        if(birthdayDate == null)
            throw new RuntimeException("Incorrect date of birth");
        if(phoneNumber == null)
            throw new RuntimeException("The phone number is not specified or is specified incorrectly");
        if(hourlyRate <= 0.0)
            throw new RuntimeException("The hourly wage value cannot be less than or equal to zero");
        if(position == null)
            throw new RuntimeException("Employee position not specified");

        return new Freelancer(firstName, lastNane, birthdayDate, phoneNumber, hourlyRate, position);
    }

    /**
     * Implementation of a method of an abstract parent class
     * @return
     */
    @Override
    public double getAverageSalary(){
        return 20.8 * 8 * hourlyRate;
    }
}
