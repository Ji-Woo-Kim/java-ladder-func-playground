package domain;

public record Height(int value) {

    private static final int MIN_HEIGHT_VALUE = 1;

    public Height {
        if (value < MIN_HEIGHT_VALUE) {
            throw new IllegalArgumentException("사다리의 높이는 1 이상이어야 합니다.");
        }
    }
}
