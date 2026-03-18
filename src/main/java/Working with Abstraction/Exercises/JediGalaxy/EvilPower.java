package WorkingWithAbstractionEXERCISES.JediGalaxy;

public class EvilPower {

    public void move(int[] evilPosition, Field field){
        int evilRow = evilPosition[0];
        int evilCol = evilPosition[1];

        while (evilRow >= 0 && evilCol >= 0) {
            if (field.isInBounds(evilRow, evilCol)) {
                field.setValue(evilRow, evilCol , 0);
            }
            evilRow--;
            evilCol--;
        }
    }

}
