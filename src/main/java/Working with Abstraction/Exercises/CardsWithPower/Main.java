package WorkingWithAbstractionEXERCISES.CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rank = scanner.nextLine();
        String suit = scanner.nextLine();
        int power = Card.valueOf(rank).getRank() + Suit.valueOf(suit).getPower();

        System.out.printf("Card name: %s of %s; Card power: %d", rank, suit, power);
    }
}
