package WorkingWithAbstractionEXERCISES.JediGalaxy;

public class Jedi {

    public int move(int[] playerPosition, Field field) {
        int sum = 0;

        int playerRow = playerPosition[0];
        int playerCol = playerPosition[1];

        while (playerRow >= 0 && playerCol < field.getColLength()) {
            if (field.isInBounds(playerRow, playerCol)) {
                sum += field.getValue(playerRow, playerCol);
            }
            playerCol++;
            playerRow--;
        }

        return sum;
    }

}
