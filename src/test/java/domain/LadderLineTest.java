package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderLineTest {

    @Test
    @DisplayName("랜덤 생성 시, 사다리 라인이 정상적으로 생성된다.")
    void createRandomLadderLine() {
        Random random = new Random(1);
        LadderLine ladderLine = new LadderLine(3, random);

        // 랜덤 시드 1로 생성했을 때 기대하는 포맷
        String expected = "|-----|     |     |";
        assertEquals(expected, formatForView(ladderLine));
    }

    @Test
    @DisplayName("커스텀 포인트로 생성 시, 올바르게 시각적으로 표현된다.")
    void createCustomLadderLine() {
        // 직접 포인트 지정
        LadderLine ladderLine = new LadderLine(List.of(
                Point.NOT_CONNECTED,
                Point.CONNECTED_RIGHT,
                Point.NOT_CONNECTED
        ));

        // 기대하는 포맷
        String expected = "|     |-----|     |";
        assertEquals(expected, formatForView(ladderLine));
    }

    @Test
    @DisplayName("사다리 타기에서 올바르게 이동한다.")
    void moveCorrectly() {
        LadderLine ladderLine = new LadderLine(List.of(
                Point.CONNECTED_RIGHT,
                Point.CONNECTED_LEFT,
                Point.NOT_CONNECTED
        ));

        // |-----|-----|     |
        assertEquals(1, ladderLine.move(0)); // 0 → 1 (오른쪽 연결)
        assertEquals(0, ladderLine.move(1)); // 1 → 0 (왼쪽 연결)
        assertEquals(2, ladderLine.move(2)); // 2 → 2 (연결 안 됨)
    }

    @Test
    @DisplayName("사다리의 끝에 도달했을 때 이동하지 않는다.")
    void doNotMoveWhenAtTheEnd() {
        LadderLine ladderLine = new LadderLine(List.of(
                Point.NOT_CONNECTED,
                Point.NOT_CONNECTED,
                Point.NOT_CONNECTED
        ));

        assertEquals(2, ladderLine.move(2)); // 끝에 도달하면 이동하지 않음
    }

    @Test
    @DisplayName("포인트가 정상적으로 반환된다.")
    void getPoints() {
        LadderLine ladderLine = new LadderLine(List.of(
                Point.NOT_CONNECTED,
                Point.CONNECTED_RIGHT,
                Point.NOT_CONNECTED
        ));

        List<Point> points = ladderLine.getPoints();
        assertEquals(3, points.size());
        assertEquals(Point.NOT_CONNECTED, points.get(0));
        assertEquals(Point.CONNECTED_RIGHT, points.get(1));
        assertEquals(Point.NOT_CONNECTED, points.get(2));
    }

    // 테스트 전용 사다리 출력 포맷 메서드
    private String formatForView(LadderLine ladderLine) {
        StringBuilder lineBuilder = new StringBuilder();
        lineBuilder.append("|");

        for (Point point : ladderLine.getPoints()) {
            if (point.isConnectedRight()) {
                lineBuilder.append("-----|");
            } else {
                lineBuilder.append("     |");
            }
        }
        return lineBuilder.toString();
    }
}
