public class App {
    public static void main(String[] args) throws Exception {
        var board = new Board();
        var player = new Player();
        var computer = new AI();
        var gameManager = new GameManager();

        gameManager.startGame(board, player, computer);
    }
}
