import java.util.Scanner;

public class GameManager {

    private Scanner input = new Scanner(System.in);

    public void startGame(Board board, Player player, AI computer) {
        boolean gameOver = false;
        boolean playAgain = true;

        System.out.println("|-------------------------------------------|");
        System.out.println("|Bem vindo ao Jogo da Velha do Sandrolaxx\uD83D\uDD25!|");
        System.out.println("|-------------------------------------------|");

        while (playAgain) {
            while (!gameOver) {
                player.getPlayerMove(board);

                gameOver = board.isGameOver(board.getGameBoard(), player, computer);
                if (gameOver) {
                    break;
                }

                computer.getAIMove(board);

                gameOver = board.isGameOver(board.getGameBoard(), player, computer);
                if (gameOver) {
                    break;
                }
            }

            System.out.println("Pontos Jogador: " + player.getScore());
            System.out.println("Pontos Computador: " + computer.getScore());
            System.out.println("Gostaria de jogar novamente? S/N");
            String result = input.nextLine();

            switch (result) {
                case "S":
                case "s":
                    System.out.println("Bora mais uma!\u26A1");
                    board.resetGame();

                    playAgain = true;
                    gameOver = false;
                    board.printBoard();
                    break;

                case "N":
                case "n":
                    System.out.println("Obrigado por jogar!\u2665");
                    playAgain = false;
                    break;
                default:
                    break;
            }
        }
    }
}
