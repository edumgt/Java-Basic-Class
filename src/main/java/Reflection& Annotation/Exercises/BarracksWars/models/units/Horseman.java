package ReflectionAndAnnotationEXERCISES.BarracksWars.models.units;

public class Horseman extends AbstractUnit {

    private static final int ARCHER_HEALTH = 50;

    private static final int ARCHER_DAMAGE = 10;

    public Horseman() {
        super(ARCHER_HEALTH, ARCHER_DAMAGE);
    }
}
