package lotto.utils;

public class InputValidator {

    final static int DIVIDER = 1000;

    public static void validateInputBudget(String budget) {
        validateIsNumeric(budget);
        validateIsDivisibleByDivider(Integer.parseInt(budget));
    }

    private static void validateIsNumeric(String budget) {
        try {
            Integer.parseInt(budget);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바르지 않은 형태의 구매 금액 입니다.");
        }
    }

    private static void validateIsDivisibleByDivider(int budget) {
        if (budget % DIVIDER != 0) {
            throw new IllegalArgumentException("구매 금액은 " + DIVIDER + "원 단위로 입력해야 합니다.");
        }
    }
}
