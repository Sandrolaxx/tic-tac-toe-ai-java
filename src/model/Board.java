package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import model.enums.EnumPlayer;

public class Board {

    private char[][] gameBoard = {
            { '_', '|', '_', '|', '_' },
            { '_', '|', '_', '|', '_' },
            { ' ', '|', ' ', '|', ' ' }
    };

    public void printBoard() {
        for (char[] row : this.getGameBoard()) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public void updateBoard(Move move, EnumPlayer player) {
        this.getGameBoard()[move.getyAxis()][move.getxAxis()] = player.getValue();

        printBoard();
    }

    public void resetBoardSimulation(Move move) {
        if (move.getyAxis() == 2) {
            this.getGameBoard()[move.getyAxis()][move.getxAxis()] = ' ';
        } else {
            this.getGameBoard()[move.getyAxis()][move.getxAxis()] = '_';
        }
    }

    public boolean isValidPosition(int position) {
        switch (position) {
            case 1:
                if (this.getGameBoard()[0][0] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 2:
                if (this.getGameBoard()[0][2] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 3:
                if (this.getGameBoard()[0][4] == '_') {
                    return true;
                } else {
                    return false;
                }

            case 4:
                if (this.getGameBoard()[1][0] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 5:
                if (this.getGameBoard()[1][2] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 6:
                if (this.getGameBoard()[1][4] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 7:
                if (this.getGameBoard()[2][0] == ' ') {
                    return true;
                } else {
                    return false;
                }
            case 8:
                if (this.getGameBoard()[2][2] == ' ') {
                    return true;
                } else {
                    return false;
                }
            case 9:
                if (this.getGameBoard()[2][4] == ' ') {
                    return true;
                } else {
                    return false;
                }

            default:
                return false;
        }
    }

    public Move getMovePosition(int position) {
        switch (position) {
            case 1:
                return new Move(0, 0);
            case 2:
                return new Move(0, 2);
            case 3:
                return new Move(0, 4);
            case 4:
                return new Move(1, 0);
            case 5:
                return new Move(1, 2);
            case 6:
                return new Move(1, 4);
            case 7:
                return new Move(2, 0);
            case 8:
                return new Move(2, 2);
            case 9:
                return new Move(2, 4);
            default:
                throw new RuntimeException("Erro, posição não mapeada!");
        }
    }

    public boolean isGameOver(char[][] gameboard, Player player, AI computer) {
        // Vitoria Horizontal
        if (gameboard[0][0] == 'X' && gameboard[0][2] == 'X' && gameboard[0][4] == 'X') {
            System.out.println("Jogador Ganhou\uD83E\uDDD1!");
            player.setScore(player.getScore() + 1);
            return true;
        }
        if (gameboard[0][0] == 'O' && gameboard[0][2] == 'O' && gameboard[0][4] == 'O') {
            System.out.println("I.A Ganhou\uD83E\uDD16!");
            computer.setScore(computer.getScore() + 1);
            return true;
        }
        if (gameboard[1][0] == 'X' && gameboard[1][2] == 'X' && gameboard[1][4] == 'X') {
            System.out.println("Jogador Ganhou\uD83E\uDDD1!");
            player.setScore(player.getScore() + 1);
            return true;
        }
        if (gameboard[1][0] == 'O' && gameboard[1][2] == 'O' && gameboard[1][4] == 'O') {
            System.out.println("I.A Ganhou\uD83E\uDD16!");
            computer.setScore(computer.getScore() + 1);
            return true;
        }
        if (gameboard[2][0] == 'X' && gameboard[2][2] == 'X' && gameboard[2][4] == 'X') {
            System.out.println("Jogador Ganhou\uD83E\uDDD1!");
            player.setScore(player.getScore() + 1);
            return true;
        }
        if (gameboard[2][0] == 'O' && gameboard[2][2] == 'O' && gameboard[2][4] == 'O') {
            System.out.println("I.A Ganhou\uD83E\uDD16!");
            computer.setScore(computer.getScore() + 1);
            return true;
        }

        // Vitoria Vertical
        if (gameboard[0][0] == 'X' && gameboard[1][0] == 'X' && gameboard[2][0] == 'X') {
            System.out.println("Jogador Ganhou\uD83E\uDDD1!");
            player.setScore(player.getScore() + 1);
            return true;
        }
        if (gameboard[0][0] == 'O' && gameboard[1][0] == 'O' && gameboard[2][0] == 'O') {
            System.out.println("I.A Ganhou\uD83E\uDD16!");
            computer.setScore(computer.getScore() + 1);
            return true;
        }

        if (gameboard[0][2] == 'X' && gameboard[1][2] == 'X' && gameboard[2][2] == 'X') {
            System.out.println("Jogador Ganhou\uD83E\uDDD1!");
            player.setScore(player.getScore() + 1);
            return true;
        }
        if (gameboard[0][2] == 'O' && gameboard[1][2] == 'O' && gameboard[2][2] == 'O') {
            System.out.println("I.A Ganhou\uD83E\uDD16!");
            computer.setScore(computer.getScore() + 1);
            return true;
        }

        if (gameboard[0][4] == 'X' && gameboard[1][4] == 'X' && gameboard[2][4] == 'X') {
            System.out.println("Jogador Ganhou\uD83E\uDDD1!");
            player.setScore(player.getScore() + 1);
            return true;
        }
        if (gameboard[0][4] == 'O' && gameboard[1][4] == 'O' && gameboard[2][4] == 'O') {
            System.out.println("I.A Ganhou\uD83E\uDD16!");
            computer.setScore(computer.getScore() + 1);
            return true;
        }

        // Vitoria Diagonal
        if (gameboard[0][0] == 'X' && gameboard[1][2] == 'X' && gameboard[2][4] == 'X') {
            System.out.println("Jogador Ganhou\uD83E\uDDD1!");
            player.setScore(player.getScore() + 1);
            return true;
        }
        if (gameboard[0][0] == 'O' && gameboard[1][2] == 'O' && gameboard[2][4] == 'O') {
            System.out.println("I.A Ganhou\uD83E\uDD16!");
            computer.setScore(computer.getScore() + 1);
            return true;
        }

        if (gameboard[2][0] == 'X' && gameboard[1][2] == 'X' && gameboard[0][4] == 'X') {
            System.out.println("Jogador Ganhou\uD83E\uDDD1!");
            player.setScore(player.getScore() + 1);
            return true;
        }
        if (gameboard[2][0] == 'O' && gameboard[1][2] == 'O' && gameboard[0][4] == 'O') {
            System.out.println("I.A Ganhou\uD83E\uDD16!");
            computer.setScore(computer.getScore() + 1);
            return true;
        }

        if (gameboard[0][0] != '_' && gameboard[0][2] != '_' && gameboard[0][4] != '_' && gameboard[1][0] != '_' &&
                gameboard[1][2] != '_' && gameboard[1][4] != '_' && gameboard[2][0] != ' ' && gameboard[2][2] != ' '
                && gameboard[2][4] != ' ') {
            System.out.println("Empate!\uD83E\uDDD1\uD83E\uDD1D\uD83E\uDD16");
            return true;
        }

        return false;
    }

    public List<Move> getAvailablePlays() {
        var plays = new ArrayList<Move>();
        var numberOfMovesEndExclusive = 10;

        IntStream.range(1, numberOfMovesEndExclusive).forEach(position -> {
            if (isValidPosition(position)) {
                plays.add(getMovePosition(position));
            }
        });

        return plays;
    }

    public void resetGame() {
        char[][] newBoard = {
                { '_', '|', '_', '|', '_' },
                { '_', '|', '_', '|', '_' },
                { ' ', '|', ' ', '|', ' ' }
        };

        setGameBoard(newBoard);
    }

    public char[][] getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(char[][] gameBoard) {
        this.gameBoard = gameBoard;
    }

}
