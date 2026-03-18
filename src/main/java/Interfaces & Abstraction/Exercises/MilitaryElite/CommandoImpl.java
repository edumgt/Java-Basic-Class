package InterfacesAndAbstractionEXERCISES.MilitaryElite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {

    private List<Mission> missions;

    public CommandoImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new ArrayList<>();
    }

    public void addMission(Mission mission) {
        missions.add(mission);
    }


    @Override
    public Collection<Mission> getMissions() {
        return this.missions;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("Missions:").append(System.lineSeparator());
        for (Mission mission : missions) {
            sb.append(mission);
        }
        return sb.toString();
    }


}
