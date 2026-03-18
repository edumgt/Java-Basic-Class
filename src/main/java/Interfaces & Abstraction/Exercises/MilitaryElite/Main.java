package InterfacesAndAbstractionEXERCISES.MilitaryElite;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Private> privs = new ArrayList<>();

        while (!"End".equals(input)) {

            String[] data = input.split("\\s+");
            String soldierType = data[0];
            int id = Integer.parseInt(data[1]);
            String firstName = data[2];
            String lastName = data[3];

            switch (soldierType) {

                case "Private":
                    double privateSalary = Double.parseDouble(data[4]);
                    Private priv = new PrivateImpl(id, firstName, lastName, privateSalary);
                    privs.add(priv);
                    System.out.print(priv);
                    break;
                case "LieutenantGeneral":
                    double lieutenantGeneralSalary = Double.parseDouble(data[4]);

                    LieutenantGeneralImpl lieutenantGeneral = new LieutenantGeneralImpl(id, firstName, lastName, lieutenantGeneralSalary);

                    for (int i = 5; i < data.length; i++) {
                        int currrentId = Integer.parseInt(data[i]);
                        Private neededPrivate = privs.stream().filter(p -> p.getId() == currrentId).findFirst().orElse(null);

                        if (neededPrivate != null) {
                            lieutenantGeneral.addPrivate(neededPrivate);
                        }
                    }
                    System.out.print(lieutenantGeneral);
                    break;
                case "Engineer":
                    double engineerSalary = Double.parseDouble(data[4]);

                    if (!isCorpValid(data[5])) {
                        break;
                    }
                    Corps engineerCorps = Corps.valueOf(data[5]);
                    EngineerImpl engineer = new EngineerImpl(id, firstName, lastName, engineerSalary, engineerCorps);

                    for (int i = 6; i < data.length; i += 2) {
                        String repairName = data[i];
                        int hoursWorked = Integer.parseInt(data[i + 1]);
                        engineer.addRepair(new Repair(repairName, hoursWorked));
                    }
                    System.out.print(engineer);
                    break;
                case "Commando":
                    double commandoSalary = Double.parseDouble(data[4]);
                    if (!isCorpValid(data[5])) {
                        break;
                    }
                    Corps commandoCorps = Corps.valueOf(data[5]);
                    CommandoImpl commando = new CommandoImpl(id, firstName, lastName, commandoSalary, commandoCorps);

                    for (int i = 6; i < data.length; i += 2) {
                        String codeName = data[i];

                        if (isMissionStateValid(data[i + 1])) {
                            Mission mission = new Mission(codeName, MissionState.valueOf(data[i + 1]));
                            commando.addMission(mission);
                        }
                    }
                    System.out.print(commando);
                    break;
                case "Spy":
                    String codeName = data[4];
                    Spy spy = new SpyImpl(id, firstName, lastName, codeName);
                    System.out.print(spy);
                    break;
            }
            input = scanner.nextLine();
        }


    }

    public static boolean isMissionStateValid(String name) {

        for (MissionState missionState : MissionState.values()) {
            if (missionState.name().equals(name)) {
                return true;
            }
        }
        return false;

    }

    public static boolean isCorpValid(String name) {

        for (Corps corps : Corps.values()) {
            if (corps.name().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
