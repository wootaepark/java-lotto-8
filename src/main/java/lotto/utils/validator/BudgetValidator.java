package lotto.utils.validator;

import static lotto.utils.constant.LottoConstants.LOTTO_PRICE;

public class BudgetValidator {


    public static void validateInputBudget(String budget) {
        int numericBudget = validateIsNumeric(budget);
        validateIsNonNegative(numericBudget);
        validateIsDivisibleByDivider(numericBudget);
    }

    private static int validateIsNumeric(String budget) {
        try {
            return Integer.parseInt(budget);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바르지 않은 형태의 구매 금액 입니다.");
        }
    }

    private static void validateIsDivisibleByDivider(int budget) {
        if (budget % LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException("구매 금액은 " + LOTTO_PRICE.getValue() + "원 단위로 입력해야 합니다.");
        }
    }

    private static void validateIsNonNegative(int budget) {
        if (budget < 0) {
            throw new IllegalArgumentException("음수는 투자금액으로 입력이 불가능합니다.");
        }
    }
}
