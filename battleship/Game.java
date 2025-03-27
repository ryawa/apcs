import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private static final int SIZE = 10;
    private static final int shipLengths[] = { 5, 4, 3, 3, 2 };
    private static final int maxHits = Arrays.stream(shipLengths).sum();

    private Grid playerGrid = new Grid(SIZE);
    private Grid computerGrid = new Grid(SIZE);
    private int playerHits = 0;
    private int computerHits = 0;

    Scanner s = new Scanner(System.in);
    Random r = new Random();

    public void placeShips() {
        placePlayerShips();
        placeComputerShips();
    }

    private void placePlayerShips() {
        for (int length : shipLengths) {
            System.out.println("Placing ship of length " + length);

            while (true) {
                System.out.print("Position (input as x, y): ");
                String pos = s.nextLine();
                String[] posParts = pos.split(", ");
                int x = Integer.parseInt(posParts[0]);
                int y = Integer.parseInt(posParts[1]);

                System.out.print("Direction (H/V): ");
                String dir = s.nextLine();
                boolean horiz = Character.toLowerCase(dir.charAt(0)) == 'h';
                if (placeShip(playerGrid, x, y, horiz, length)) {
                    break;
                }
                System.out.println("Invalid position, please try again");
            }
        }
    }

    private void placeComputerShips() {
        for (int length : shipLengths) {
            while (true) {
                int x = r.nextInt(SIZE);
                int y = r.nextInt(SIZE);
                boolean horiz = r.nextBoolean();
                if (placeShip(computerGrid, x, y, horiz, length)) {
                    break;
                }
            }
        }
    }

    private boolean placeShip(Grid grid, int x, int y, boolean horiz, int length) {
        boolean valid = true;
        if (horiz) {
            for (int i = x; i < x + length; i++) {
                if (!grid.inBounds(i, y) || (grid.get(i, y) & Grid.SHIP) != 0) {
                    valid = false;
                }
            }
            if (valid) {
                for (int i = x; i < x + length; i++) {
                    grid.set(i, y, Grid.SHIP);
                }
            }
        } else {
            for (int j = y; j < y + length; j++) {
                if (!grid.inBounds(x, j) || (grid.get(x, j) & Grid.SHIP) != 0) {
                    valid = false;
                }
            }
            if (valid) {
                for (int j = y; j < y + length; j++) {
                    grid.set(x, j, Grid.SHIP);
                }
            }
        }
        return valid;
    }

    public boolean finished() {
        return playerHits == maxHits || computerHits == maxHits;
    }

    public void playerTurn() {
        while (true) {
            System.out.print("Enter guess (input as x, y): ");
            String pos = s.nextLine();
            String[] posParts = pos.split(", ");
            int x = Integer.parseInt(posParts[0]);
            int y = Integer.parseInt(posParts[1]);

            int val = computerGrid.get(x, y);
            if ((val & Grid.HIT) == 0) {
                computerGrid.set(x, y, val | Grid.HIT);
                if ((val & Grid.SHIP) != 0) {
                    System.out.println("Hit!");
                    playerHits++;
                } else {
                    System.out.println("Miss!");
                }
                break;
            }
            System.out.println("Invalid position, please try again");
        }
    }

    public void computerTurn() {
        while (true) {
            int x = r.nextInt(SIZE);
            int y = r.nextInt(SIZE);

            int val = playerGrid.get(x, y);
            if ((val & Grid.HIT) == 0) {
                System.out.println("Computer guessed " + x + ", " + y);
                playerGrid.set(x, y, val | Grid.HIT);
                if ((val & Grid.SHIP) != 0) {
                    System.out.println("Computer hit!");
                    computerHits++;
                } else {
                    System.out.println("Computer miss!");
                }
                break;
            }
        }
    }

    public void printWinner() {
        if (playerHits == maxHits) {
            System.out.println("You won!");
        } else if (computerHits == maxHits) {
            System.out.println("Computer won!");
        }
    }
}
