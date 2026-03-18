package WorkingWithAbstractionEXERCISES.JediGalaxy;

public class Galaxy {
    private Field field;
    private Jedi jedi;
    private EvilPower evilPower;

    public Galaxy(Field field) {
        this.field = field;
        jedi = new Jedi();
        evilPower = new EvilPower();
    }

    public void eliminateStars(int[] evilPosition) {
        evilPower.move(evilPosition, field);
    }

    public int collectStars(int[] playerPosition) {
        return jedi.move(playerPosition, field);
    }
}
