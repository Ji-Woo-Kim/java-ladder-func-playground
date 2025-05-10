//package domain;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//import java.util.Random;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//public class LadderLinesTest {
//
//    @Test
//    @DisplayName("LadderLines가 정상적으로 생성된다.")
//    void createLadderLines() {
//        LadderLines ladderLines = LadderLines.generate(3, new LadderHeight(5), new Random(1));
//
//        assertNotNull(ladderLines);
//        assertEquals(5, ladderLines.getLines().size()); // 높이 5만큼 라인 생성 확인
//    }
//
//    @Test
//    @DisplayName("LadderLines가 랜덤하게 연결된다.")
//    void ladderLinesShouldBeConnectedRandomly() {
//        // ✅ 랜덤 시드 고정
//        Random random = new Random(42);  // 시드 값을 42로 고정하면 동일한 결과가 나옵니다.
//        LadderLines ladderLines = LadderLines.generate(3, new LadderHeight(3), random);
//
//        List<String> visualLines = ladderLines.getLines().stream()
//                .map(this::formatForView)
//                .toList();
//
//        // ✅ 시드값 42로 생성된 예상 결과
//        assertEquals("|     |-----|     |", visualLines.get(0));
//        assertEquals("|     |     |     |", visualLines.get(1));
//        assertEquals("|     |     |-----|", visualLines.get(2));
//    }
//
//    @Test
//    @DisplayName("사다리 타기 시, 최종 위치가 예상대로 반환된다.")
//    void getFinalPosition() {
//        LadderLines ladderLines = LadderLines.generate(3, new LadderHeight(3), new Random(1));
//
//        // 시작 인덱스가 0일 때 → 1로 이동 (첫 번째 라인에서 오른쪽)
//        int finalPosition = ladderLines.getFinalPosition(0);
//        assertEquals(1, finalPosition);
//
//        // 시작 인덱스가 1일 때 → 2로 이동 (두 번째 라인에서 오른쪽)
//        finalPosition = ladderLines.getFinalPosition(1);
//        assertEquals(2, finalPosition);
//
//        // 시작 인덱스가 2일 때 → 2 그대로 유지 (연결 없음)
//        finalPosition = ladderLines.getFinalPosition(2);
//        assertEquals(2, finalPosition);
//    }
//
//    @Test
//    @DisplayName("모든 라인이 올바르게 반환된다.")
//    void getAllLines() {
//        LadderLines ladderLines = LadderLines.generate(3, new LadderHeight(3), new Random(1));
//
//        List<LadderLine> lines = ladderLines.getLines();
//        assertEquals(3, lines.size());
//
//        // 첫 번째 줄이 올바르게 생성되었는지 체크
//        String expectedLine = formatForView(lines.get(0));
//        assertEquals("|-----|     |     |", expectedLine);
//    }
//
//    // 테스트 전용 사다리 출력 포맷 메서드
//    private String formatForView(LadderLine ladderLine) {
//        StringBuilder lineBuilder = new StringBuilder();
//        lineBuilder.append("|");
//
//        for (Point point : ladderLine.getPoints()) {
//            if (point.isConnectedRight()) {
//                lineBuilder.append("-----|");
//            } else {
//                lineBuilder.append("     |");
//            }
//        }
//        return lineBuilder.toString();
//    }
//}
