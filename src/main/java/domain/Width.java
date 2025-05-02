package domain;

public record Width(int value) {

    private static final int MIN_WIDTH_VALUE = 1;

    public Width {
        if (value < MIN_WIDTH_VALUE) {
            throw new IllegalArgumentException("사다리의 넓이는 1 이상이어야 합니다.");
        }
    }
}
