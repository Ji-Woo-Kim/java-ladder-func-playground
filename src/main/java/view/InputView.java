package view;

import domain.Height;
import domain.Width;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public Width readWidth() {
        System.out.println("사다리의 넓이는 몇 개인가요?");
        return new Width(scanner.nextInt());
    }

    public Height readHeight() {
        System.out.println("사다리의 높이는 몇 개인가요?");
        return new Height(scanner.nextInt());
    }
}
