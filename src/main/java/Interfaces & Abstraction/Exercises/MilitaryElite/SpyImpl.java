package InterfacesAndAbstractionEXERCISES.MilitaryElite;

public class SpyImpl extends SoldierImpl implements Spy {

    private String codeName;

    public SpyImpl(int id, String firstName, String lastName, String codeName) {
        super(id, firstName, lastName);
        this.codeName = codeName;
    }


    @Override
    public String getCodeName() {
        return codeName;
    }

    @Override
    public String toString(){
        return super.toString() + System.lineSeparator() + String.format("Code Number: %s%n", codeName);
    }
}
