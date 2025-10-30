package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputVIew {

    public static int inputBudget() {
        System.out.println("구입 금액을 입력해주세요");
        return Integer.parseInt(Console.readLine());
    }

}
