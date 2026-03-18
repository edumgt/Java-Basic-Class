package InterfacesAndAbstractionEXERCISES.MilitaryElite;

public class Mission {

    private String codeName;

    private MissionState state;

    public Mission(String codeName, MissionState state) {
        this.codeName = codeName;
        this.state = state;
    }

    public void completeMission() {
        this.state = MissionState.finished;
    }

    @Override
    public String toString() {
        return String.format("  Code Name: %s State: %s%n", codeName, state);
    }
}
