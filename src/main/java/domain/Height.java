package domain;

public record Height(int value) {

    public Height {
        if (value < 1) {
            throw new IllegalArgumentException("사다리의 높이는 1 이상이어야 합니다.");
        }
    }
}
