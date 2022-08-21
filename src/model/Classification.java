package model;

public class Classification {

    private Integer miniMaxscore;

    private Move move;

    public Classification(Integer miniMaxscore, Move move) {
        this.miniMaxscore = miniMaxscore;
        this.move = move;
    }

    public Integer getMiniMaxscore() {
        return miniMaxscore;
    }

    public void setMiniMaxscore(Integer miniMaxscore) {
        this.miniMaxscore = miniMaxscore;
    }

    public Move getMove() {
        return move;
    }

    public void setMove(Move move) {
        this.move = move;
    }

}
