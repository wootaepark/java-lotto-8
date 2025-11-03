package lotto.utils.validator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;
import org.junit.jupiter.api.Test;

class MainNumberValidatorTest {
    @Test
    void 정상적인_6개_번호_입력() {
        String input = "1, 2, 3, 4, 5, 6";

        Set<Integer> result = MainNumberValidator.validateInputWinningNumber(input);

        assertEquals(6, result.size());
        assertTrue(result.contains(1));
        assertTrue(result.contains(6));
    }

    @Test
    void 번호_6개_아님_예외() {
        String input = "1,2,3,4,5";

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> MainNumberValidator.validateInputWinningNumber(input)
        );

        assertEquals("당첨 번호의 수는 6개여야 합니다.", exception.getMessage());
    }

    @Test
    void 중복된_번호_입력_예외() {
        String input = "1,2,3,3,5,6";

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> MainNumberValidator.validateInputWinningNumber(input)
        );

        assertEquals("당첨 번호에 중복된 숫자가 있습니다.", exception.getMessage());
    }

    @Test
    void 범위_벗어난_번호_입력_예외() {
        String input = "0,2,3,4,5,46";

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> MainNumberValidator.validateInputWinningNumber(input)
        );

        assertEquals("당첨 번호는 1부터 45 사이의 숫자여야 합니다.", exception.getMessage());
    }

    @Test
    void 숫자_아닌_입력_예외() {
        String input = "1,2,3,4,5,a";

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> MainNumberValidator.validateInputWinningNumber(input)
        );

        assertEquals("숫자만 입력이 가능합니다.", exception.getMessage());
    }
}
