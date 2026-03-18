package WorkingWithAbstractionEXERCISES.JediGalaxy;

public class Field {

    private long[][] starsField;

    public Field(int rows, int cols) {
        this.starsField = new long[rows][cols];
        fillInGalaxy(starsField);
    }

    private void fillInGalaxy(long[][] galaxy) {
        long value = 0;
        for (int row = 0; row < galaxy.length; row++) {
            for (int col = 0; col < galaxy[row].length; col++) {
                galaxy[row][col] = value++;
            }
        }

    }

    public boolean isInBounds(int row, int col) {
        return row >= 0 && row < starsField.length && col >= 0 && col < starsField[row].length;
    }

    public long getValue(int row, int col){
        return this.starsField[row][col];
    }

    public void setValue(int row, int col, int newValue){
        this.starsField[row][col] = newValue;
    }

    public int getColLength(){
        return starsField[1].length;
    }
}
