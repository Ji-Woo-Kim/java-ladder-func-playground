package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PointTest {

    @Test
    @DisplayName("왼쪽으로 연결되어 있을 때, 인덱스가 -1 이동한다.")
    void moveLeft() {
        Point point = Point.CONNECTED_LEFT;
        int newPosition = point.moveFrom(2);

        assertEquals(1, newPosition);
    }

    @Test
    @DisplayName("오른쪽으로 연결되어 있을 때, 인덱스가 +1 이동한다.")
    void moveRight() {
        Point point = Point.CONNECTED_RIGHT;
        int newPosition = point.moveFrom(2);

        assertEquals(3, newPosition);
    }

    @Test
    @DisplayName("연결되지 않은 경우, 인덱스가 그대로 유지된다.")
    void stay() {
        Point point = Point.NOT_CONNECTED;
        int newPosition = point.moveFrom(2);

        assertEquals(2, newPosition);
    }

    @Test
    @DisplayName("오른쪽 연결 여부 확인")
    void isRight() {
        Point point = Point.CONNECTED_RIGHT;

        assertEquals(true, point.isConnectedRight());
        assertEquals(false, point.isConnectedLeft());
        assertEquals(false, point.isNotConnected());
    }

    @Test
    @DisplayName("왼쪽 연결 여부 확인")
    void isLeft() {
        Point point = Point.CONNECTED_LEFT;

        assertEquals(false, point.isConnectedRight());
        assertEquals(true, point.isConnectedLeft());
        assertEquals(false, point.isNotConnected());
    }

    @Test
    @DisplayName("연결 안 됨 여부 확인")
    void isNotConnected() {
        Point point = Point.NOT_CONNECTED;

        assertEquals(false, point.isConnectedRight());
        assertEquals(false, point.isConnectedLeft());
        assertEquals(true, point.isNotConnected());
    }
}
