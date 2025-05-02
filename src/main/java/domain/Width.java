package domain;

public record Width(int value) {

    public Width {
        if (value < 2) {
            throw new IllegalArgumentException("사다리의 넓이는 2 이상이어야 합니다.");
        }
    }
}
