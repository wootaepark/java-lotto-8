package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.validator.BudgetValidator;

public class BudgetInputVIew {

    public static int inputBudget() {
        System.out.println("구입 금액을 입력해주세요");
        String budget = Console.readLine();
        BudgetValidator.validateInputBudget(budget);

        return Integer.parseInt(budget);
    }

}
