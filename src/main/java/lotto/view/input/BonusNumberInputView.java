package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.validator.BonusNumberValidator;

public class BonusNumberInputView {

    public static int inputBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요");
        String bonusNumber = Console.readLine();
        return BonusNumberValidator.validateInputBonusNumber(bonusNumber);
    }
}
