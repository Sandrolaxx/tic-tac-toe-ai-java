package model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import model.enums.EnumPlayer;

public class AI {

    private Integer score = 0;

    private List<Classification> childNodes;

    public void getAIMove(Board board) {
        childNodes = new ArrayList<>();

        var startTime = System.nanoTime();
        minimax(board, 0, EnumPlayer.AI);

        var move = getBestMove();

        board.updateBoard(move, EnumPlayer.AI);
        var endTime = System.nanoTime();

        var formatter = new DecimalFormat("#0.00");
        var difference = (endTime - startTime) / 1e6;
        System.out.println("\u23F1 Jogada realizada pela I.A em: ".concat(formatter.format(difference).concat("s")));
        System.out.println("--------------------------------------");
    }

    private Integer minimax(Board board, Integer depth, EnumPlayer player) {

        if (checkWin(board.getGameBoard(), true)) {
            return 1;
        }

        if (checkWin(board.getGameBoard(), false)) {
            return -1;
        }

        List<Move> possibleMoves = board.getAvailablePlays();
        List<Integer> scoreList = new ArrayList<>();

        if (possibleMoves.isEmpty()) {
            return 0;
        }

        for (int i = 0; i < possibleMoves.size(); i++) {
            Move actualMove = possibleMoves.get(i);

            if (player == EnumPlayer.AI) {
                board.getGameBoard()[actualMove.getyAxis()][actualMove.getxAxis()] = player.getValue();
                Integer actualScore = minimax(board, depth + 1, EnumPlayer.HUMAN);

                scoreList.add(actualScore);

                if (depth == 0) {
                    childNodes.add(new Classification(actualScore, actualMove));
                }
            } else if (player == EnumPlayer.HUMAN) {
                board.getGameBoard()[actualMove.getyAxis()][actualMove.getxAxis()] = player.getValue();

                Integer actualScore = minimax(board, depth + 1, EnumPlayer.AI);

                scoreList.add(actualScore);
            }

            board.resetBoardSimulation(actualMove);
        }

        return player == EnumPlayer.AI ? getMax(scoreList) : getMin(scoreList);
    }

    private Move getBestMove() {
        int max = Integer.MIN_VALUE;
        int best = -1;

        for (int i = 0; i < childNodes.size(); i++) {
            if (max < childNodes.get(i).getMiniMaxscore()) {
                max = childNodes.get(i).getMiniMaxscore();
                best = i;
            }
        }

        return childNodes.get(best).getMove();
    }

    public int getMax(List<Integer> simulationScore) {
        int max = Integer.MIN_VALUE;
        int position = -1;

        for (int i = 0; i < simulationScore.size(); i++) {
            if (simulationScore.get(i) > max) {
                max = simulationScore.get(i);
                position = i;
            }
        }

        return simulationScore.get(position);
    }

    public int getMin(List<Integer> simulationScore) {
        int min = Integer.MAX_VALUE;
        int position = -1;

        for (int i = 0; i < simulationScore.size(); i++) {
            if (simulationScore.get(i) < min) {
                min = simulationScore.get(i);
                position = i;
            }
        }

        return simulationScore.get(position);
    }

    private boolean checkWin(char[][] gameboard, boolean isIAWin) {
        char player = isIAWin ? EnumPlayer.AI.getValue() : EnumPlayer.HUMAN.getValue();

        if ((gameboard[0][0] == player && gameboard[0][2] == player && gameboard[0][4] == player)
                || (gameboard[1][0] == player && gameboard[1][2] == player && gameboard[1][4] == player)
                || (gameboard[2][0] == player && gameboard[2][2] == player && gameboard[2][4] == player)
                || (gameboard[0][0] == player && gameboard[1][0] == player && gameboard[2][0] == player)
                || (gameboard[0][2] == player && gameboard[1][2] == player && gameboard[2][2] == player)
                || (gameboard[0][4] == player && gameboard[1][4] == player && gameboard[2][4] == player)
                || (gameboard[0][0] == player && gameboard[1][2] == player && gameboard[2][4] == player)
                || (gameboard[2][0] == player && gameboard[1][2] == player && gameboard[0][4] == player)) {
            return true;
        }

        return false;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

}
