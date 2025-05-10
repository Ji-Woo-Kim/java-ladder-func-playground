package domain;

public enum Point {

    // 왼쪽으로 연결됨
    CONNECTED_LEFT(-1),
    // 오른쪽으로 연결됨
    CONNECTED_RIGHT(1),
    // 양쪽 아무 곳에도 연결되지 않음
    NOT_CONNECTED(0);

    private final int offset;

    Point(int offset) {
        this.offset = offset;
    }

    public int moveFrom(int currentPosition) {
        return currentPosition + offset;
    }

    public boolean isConnectedLeft() {
        return this == CONNECTED_LEFT;
    }

    public boolean isConnectedRight() {
        return this == CONNECTED_RIGHT;
    }

    public boolean isNotConnected() {
        return this == NOT_CONNECTED;
    }
}
