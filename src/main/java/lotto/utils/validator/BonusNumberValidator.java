package lotto.utils.validator;

public class BonusNumberValidator {

    public static int validateInputBonusNumber(String input) {
        // 1. 숫자형태의 input 인지
        // 2. 번호가 1과 45 사이의 수인지

        int bonusNumber = parseNumber(input);
        validateBonusNumberRange(bonusNumber);
        return bonusNumber;

    }

    // 1.
    private static int parseNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }


    // 2.
    private static void validateBonusNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
