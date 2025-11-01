package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.Set;
import lotto.utils.validator.WinningNumberValidator;

public class WinningNumberInputView {

    public static Set<Integer> inputWinningNumber() {
        System.out.println("\n당첨 번호를 입력해 주세요");
        String winningNumber = Console.readLine();
        return WinningNumberValidator.validateInputWinningNumber(winningNumber);

    }
}
