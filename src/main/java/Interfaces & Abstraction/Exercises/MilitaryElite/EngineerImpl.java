package InterfacesAndAbstractionEXERCISES.MilitaryElite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {
    private List<Repair> repairs;

    public EngineerImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new ArrayList<>();

    }


    public void addRepair(Repair repair) {
        repairs.add(repair);
    }


    @Override
    public Collection<Repair> getRepairs() {
        return this.repairs;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("Repairs:").append(System.lineSeparator());
        for (Repair repair : repairs) {
            sb.append(repair);
        }
        return sb.toString();
    }
}
