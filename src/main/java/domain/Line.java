package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {

    private final List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    public static Line generate(int width, Random random) {
        List<Point> result = new ArrayList<>();
        boolean prevHasLine = false;

        for (int i = 0; i < width - 1; i++) {
            boolean hasLine = !prevHasLine && random.nextBoolean();
            result.add(new Point(hasLine));
            prevHasLine = hasLine;
        }

        return new Line(result);
    }

    public List<Point> getLinks() {
        return points;
    }
}
