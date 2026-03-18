package InterfacesAndAbstractionEXERCISES.MilitaryElite;

public class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {

    private Corps corps;

    public SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary, Corps corps){
        super(id, firstName, lastName, salary);
        this.corps = corps;
    }




    @Override
    public Corps getCorp() {
        return corps;
    }

    @Override
    public String toString(){
        return super.toString() + String.format("Corps: %s%n", corps);
    }
}
