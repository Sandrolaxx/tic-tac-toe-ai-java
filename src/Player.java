import java.util.Scanner;

import model.enums.EnumPlayer;

public class Player {

    private Integer score = 0;

    private Scanner input = new Scanner(System.in);

    public void getPlayerMove(Board board) {
        var movementPosition = resquestNewMovement();
        
        var isValidMove = board.isValidPosition(movementPosition);

        while (!isValidMove) {
            System.out.println("Movimento inválido\uD83D\uDE45. Tente novamente!");
            
            movementPosition = resquestNewMovement();
            isValidMove = board.isValidPosition(movementPosition);
        }
        
        board.updateBoard(board.getMovePosition(movementPosition), EnumPlayer.HUMAN);
        System.out.println("Jogada realizada!");
    }

    private Integer resquestNewMovement() {
        System.out.println("Selecione o local da jogada. (1-9)");

        try {
            return Integer.valueOf(input.next());
        } catch (Exception e) {
            return 0;
        }
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
    
}
