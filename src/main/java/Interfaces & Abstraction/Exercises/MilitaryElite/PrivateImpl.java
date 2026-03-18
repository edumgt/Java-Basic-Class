package InterfacesAndAbstractionEXERCISES.MilitaryElite;

public class PrivateImpl extends SoldierImpl implements Private {

    private double salary;

    public PrivateImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        this.salary = salary;
    }





    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public String toString(){
        return super.toString() + String.format("Salary: %.2f%n", salary);
    }
}
