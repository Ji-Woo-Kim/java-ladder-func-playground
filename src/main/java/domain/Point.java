package domain;

public class Point {

    private boolean connectedToRight;
    private boolean connectedToLeft;

    public Point() {
        this.connectedToRight = false;
        this.connectedToLeft = false;
    }

    public boolean isConnectedToRight() {
        return connectedToRight;
    }

    public void connectToRight() {
        this.connectedToRight = true;
    }

    public void connectToLeft() {
        this.connectedToLeft = true;
    }
}
