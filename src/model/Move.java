package model;

public class Move {
    private int yAxis;

    private int xAxis;

    public Move(int yAxis, int xAxis) {
        this.yAxis = yAxis;
        this.xAxis = xAxis;
    }

    @Override
    public String toString() {
        return "[" + yAxis + ", " + xAxis + "]";
    }

    public int getyAxis() {
        return yAxis;
    }

    public void setyAxis(int yAxis) {
        this.yAxis = yAxis;
    }

    public int getxAxis() {
        return xAxis;
    }

    public void setxAxis(int xAxis) {
        this.xAxis = xAxis;
    }

}
