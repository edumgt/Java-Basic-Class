package ReflectionAndAnnotationEXERCISES.BarracksWars.models.units;

public class Gunner extends AbstractUnit {

    private static final int ARCHER_HEALTH = 20;

    private static final int ARCHER_DAMAGE = 20;


    public Gunner() {
        super(ARCHER_HEALTH, ARCHER_DAMAGE);
    }
}
