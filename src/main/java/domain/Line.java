package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {

    private final List<Point> points;

    public Line(Width width) {
        points = new ArrayList<>();
        for (int i = 0; i < width.value(); i++) {
            points.add(new Point());
        }
    }

    public void connect(Random random) {
        for (int i = 0; i < points.size() - 1; i++) { // 가로줄 겹침 방지
            if (i > 0 && points.get(i - 1).isConnectedToRight()) {
                continue;
            }
            if (random.nextBoolean()) {
                points.get(i).connectToRight();
                points.get(i + 1).connectToLeft();
            }
        }
    }

    public List<Point> getPoints() {
        return points;
    }
}
