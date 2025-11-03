package lotto.utils.validator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class BonusNumberValidatorTest {

    @Test
    void 올바른_입력일_경우_보너스_번호_정상_반환() {

        // given
        String input = "15";

        // when
        int result = BonusNumberValidator.validateInputBonusNumber(input);

        // then
        assertEquals(15, result);
    }

    @Test
    void 숫자가_아닌_문자열_입력_예외_발생() {
        // given
        String input = "abc";

        // when
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> BonusNumberValidator.validateInputBonusNumber(input)
        );

        // then
        assertEquals("숫자만 입력 가능합니다.", exception.getMessage());
    }


    @Test
    void 보너스_번호가_1보다_작을_경우_예외_발생() {
        // given
        String input = "-10";

        // when
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> BonusNumberValidator.validateInputBonusNumber(input)
        );

        // then
        assertEquals("보너스 번호는 1부터 45 사이의 숫자여야 합니다.", exception.getMessage());
    }

    @Test
    void 보너스_번호가_45보다_클_경우_예외_발생() {
        // given
        String input = "50";

        // when
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> BonusNumberValidator.validateInputBonusNumber(input)
        );

        // then
        assertEquals("보너스 번호는 1부터 45 사이의 숫자여야 합니다.", exception.getMessage());
    }

}
