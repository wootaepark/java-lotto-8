package lotto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Set;
import lotto.domain.WinningNumber;
import org.junit.jupiter.api.Test;

class WinningNumberServiceImplTest {

    private final WinningNumberServiceImpl winningNumberService = new WinningNumberServiceImpl();

    @Test
    void 올바른_입력일_경우_당첨_번호_인스턴스를_정상적으로_생성() {

        // given
        Set<Integer> mainNumbers = Set.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        // when
        WinningNumber winningNumber = winningNumberService.generateWinningNumber(mainNumbers, bonusNumber);

        // then
        assertNotNull(winningNumber);
        assertEquals(mainNumbers, winningNumber.getMainNumbers());
        assertEquals(bonusNumber, winningNumber.getBonusNumber());
    }


    @Test
    void 보너스_번호가_메인_번호와_중복될_경우_예외를_발생시킨다() {
        Set<Integer> mainNumbers = Set.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 6;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> winningNumberService.generateWinningNumber(mainNumbers, bonusNumber));
        assertEquals("[ERROR] 보너스 번호와 당첨 번호는 중복 될 수 없습니다.", exception.getMessage());
    }
}
