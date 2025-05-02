import domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class LadderTest {

    @Test
    @DisplayName("지정한 넓이와 높이에 맞게 사다리가 올바르게 생성되어야 함.")
    void ladder_size_test() {
        Width width = new Width(4);
        Height height = new Height(5);
        Ladder ladder = Ladder.generate(width, height, new Random(20));

        assertEquals(5, ladder.getLines().size());
        for (Line line : ladder.getLines()) {
            assertEquals(4, line.getPoints().size());
        }
    }

    @Test
    @DisplayName("사다리 타기가 올바르게 되어야 함.")
    void ladder_moving_test() {
        Width width = new Width(3); // 너비 : 3 (=3명의 참가자)
        Height height = new Height(1); // 높이 : 1
        Ladder ladder = Ladder.generate(width, height, new Random() {
            @Override
            public boolean nextBoolean() {
                return true; // 너비 인덱스 기준 0-1만 연결되어 있는 사다리 생성
            }
        });

        assertEquals(1, ladder.getFinalPosition(0));
        assertEquals(0, ladder.getFinalPosition(1));
        assertEquals(2, ladder.getFinalPosition(2));
    }

    @Test
    @DisplayName("사다리 생성 시, 가로줄이 중첩되지 않게 생성되어야 함.")
    void ladder_generate_overlap_test() {
        Line line = new Line(new Width(5));
        line.connect(new Random(20));

        List<Point> points = line.getPoints();
        for (int i = 0; i < points.size() - 2; i++) {
            if (points.get(i).isConnectedToRight()) {
                assertFalse(points.get(i + 1).isConnectedToRight());
            }
        }
    }

    @Test
    @DisplayName("입력받은 사다리 높이 값은 1이상이어야 함.")
    void height_throws_exception_test() {
        assertThrows(IllegalArgumentException.class, () -> new Height(0));
        assertThrows(IllegalArgumentException.class, () -> new Height(-1));
    }
}
