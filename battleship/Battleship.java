public class Battleship {
    public static void main(String[] args) {
        Game game = new Game();
        game.placeShips();
        while (!game.finished()) {
            game.playerTurn();
            game.computerTurn();
        }
        game.printWinner();
    }
}
