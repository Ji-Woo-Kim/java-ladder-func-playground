package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderLine {

    private final List<Point> points;

    public LadderLine(int width, Random random) {
        points = new ArrayList<>();
        Point previous = Point.NOT_CONNECTED;

        for (int i = 0; i < width; i++) {
            Point nextPoint = createNextPoint(previous, random);

            // 마지막 포인트 연결 방지
            if (i == width - 1) {
                nextPoint = Point.NOT_CONNECTED;
            }

            points.add(nextPoint);
            previous = nextPoint;
        }
    }

    public LadderLine(List<Point> points) {
        this.points = List.copyOf(points);
    }

    public List<Point> getPoints() {
        return List.copyOf(points);
    }

    private Point createNextPoint(Point previous, Random random) {
        // 이전 포인트가 오른쪽으로 연결되어 있으면, 현재 포인트는 왼쪽과 연결되어 있다는 것과 같음
        if (previous.isConnectedRight()) {
            return Point.CONNECTED_LEFT;
        }
        // 랜덤하게 오른쪽 연결 여부 결정
        if (random.nextBoolean()) {
            return Point.CONNECTED_RIGHT;
        }
        return Point.NOT_CONNECTED;
    }

    public int move(int currentPosition) {
        // 오른쪽으로 가려할 때, 맨 끝부분에서는 더 이동하지 않도록
        if (currentPosition < 0 || currentPosition >= points.size()) {
            return currentPosition;
        }

        Point currentPoint = points.get(currentPosition);
        int nextPosition = currentPoint.moveFrom(currentPosition);
        // 다음 위치가 범위를 넘어서면 현재 위치 유지
        if (nextPosition >= 0 && nextPosition < points.size()) {
            return nextPosition;
        }

        return nextPosition;
    }
}
