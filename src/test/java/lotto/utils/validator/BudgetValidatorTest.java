package lotto.utils.validator;

import static lotto.utils.constant.LottoConstants.LOTTO_PRICE;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class BudgetValidatorTest {


    @Test
    void 정상적인_예산_입력_통과() {
        String budget = String.valueOf(LOTTO_PRICE.getValue() * 5); // 5장 구매

        assertDoesNotThrow(() -> BudgetValidator.validateInputBudget(budget));
    }

    @Test
    void 숫자가_아닌_입력_예외() {
        String budget = "abc";

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> BudgetValidator.validateInputBudget(budget)
        );

        assertEquals("올바르지 않은 형태의 구매 금액 입니다.", exception.getMessage());
    }

    @Test
    void 음수_입력_예외() {
        String budget = "-1000";

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> BudgetValidator.validateInputBudget(budget)
        );

        assertEquals("음수는 투자금액으로 입력이 불가능합니다.", exception.getMessage());
    }

    @Test
    void 단위_불일치_입력_예외() {
        int invalidBudget = LOTTO_PRICE.getValue() * 3 + 500; // 500원 단위 불일치
        String budget = String.valueOf(invalidBudget);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> BudgetValidator.validateInputBudget(budget)
        );

        assertEquals("구매 금액은 " + LOTTO_PRICE.getValue() + "원 단위로 입력해야 합니다.", exception.getMessage());
    }
}
