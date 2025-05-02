package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder generate(Width width, Height height, Random random) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height.value(); i++) {
            lines.add(Line.generate(width.value(), random));
        }
        return new Ladder(lines);
    }

    public List<Line> getLines() {
        return lines;
    }
}
