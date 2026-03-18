package InterfacesAndAbstractionEXERCISES.MilitaryElite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {

    private List<Private> privates;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new ArrayList<>();
    }

    public void addPrivate(Private pr) {
        privates.add(pr);
    }


    @Override
    public Collection<Private> getPrivates() {
        return privates;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("Privates:").append(System.lineSeparator());
        List<Private> sortedPrivates = privates.stream().sorted((f, s) -> Integer.compare(s.getId(), f.getId())).collect(Collectors.toList());
        for (Private priv : sortedPrivates) {
            sb.append("  ").append(priv);
        }
        return sb.toString();
    }
}
