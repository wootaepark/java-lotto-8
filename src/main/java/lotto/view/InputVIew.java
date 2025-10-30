package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.InputValidator;

public class InputVIew {

    public static int inputBudget() {
        System.out.println("구입 금액을 입력해주세요");
        String budget = Console.readLine();
        InputValidator.validateInputBudget(budget);
        return Integer.parseInt(budget);
    }

}
