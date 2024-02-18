public class Worker extends Person{
    private float weeklySalary;
    private int dailyWorkingHours;

    public int getDailyWorkingHours() {
        return dailyWorkingHours;
    }

    public void setDailyWorkingHours(int dailyWorkingHours) {
        validateWorkigHours(dailyWorkingHours);
        this.dailyWorkingHours = dailyWorkingHours;
    }

    public float getWeeklySalary() {
        return weeklySalary;
    }

    public void setWeeklySalary(float weeklySalary) {
        validateWeeklySalary(weeklySalary);
        this.weeklySalary = weeklySalary;
    }

    private void validateWeeklySalary(float weeklySalary) {
        if(weeklySalary <= 0) {
            throw new IllegalArgumentException("Invalid week salary - must be a positive number bigger than 0.");
        }
    }

    private void validateWorkigHours(int dailyWorkingHours) {
        if(dailyWorkingHours < 1 || dailyWorkingHours > 12) {
            throw new IllegalArgumentException("Invalid working hours - must be between 1 and 12 hours.");
        }
    }


    public Worker(String firstName, String surname, float weeklySalary, int dailyWorkingHours) {
        super(firstName, surname);
        setWeeklySalary(weeklySalary);
        setDailyWorkingHours(dailyWorkingHours);
    }

    private float calculateSalaryPerHours() {
        return weeklySalary/(dailyWorkingHours*5);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("*** Worker\n");
        sb.append(super.toString());
        sb.append("\nWeek Salary: ").append(weeklySalary).append("\n");
        sb.append("Hours per day: ").append(dailyWorkingHours).append("\n");
        sb.append("Salary per hours: " );
        sb.append(calculateSalaryPerHours());
        return sb.toString();
    }
}
