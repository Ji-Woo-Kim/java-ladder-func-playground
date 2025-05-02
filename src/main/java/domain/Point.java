package domain;

public class Point {

    private final Boolean hasRightLine;

    public Point(Boolean hasRightLine) {
        this.hasRightLine = hasRightLine;
    }

    public Boolean hasRightLine() {
        return hasRightLine;
    }
}
