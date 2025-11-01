package lotto.utils.validator;

import static lotto.utils.constant.LottoConstants.LOTTO_NUMBER_COUNT;

import java.util.Arrays;
import java.util.List;

public class WinningNumberValidator {

    public static List<Integer> validateInputWinningNumber(String input) {
        // 1. ',' 구분 시 번호의 개수가 6개인지 
        // 2. 각 번호의 범위가 올바른지
        // 3. 올바른 형태의 input 인지 (, 이외의 다른 문자)

        List<Integer> winningNumbers = parseNumbers(input);
        validateWinningNumbersCount(winningNumbers);
        validateWinningNumbersRange(winningNumbers);
        return winningNumbers;


    }


    // 1.
    private static void validateWinningNumbersCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("당첨 번호의 수는 " + LOTTO_NUMBER_COUNT + "개여야 합니다.");
        }
    }

    // 2.
    private static void validateWinningNumbersRange(List<Integer> numbers) {
        boolean hasInvalid = numbers.stream()
                .anyMatch(number -> number < 1 || number >= 45);
        if (hasInvalid) {
            throw new IllegalArgumentException("당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

    }

    // 3.
    private static List<Integer> parseNumbers(String input) {
        try {
            return Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력이 가능합니다.");
        }

        // 추가로 개수 6개랑, 1과 45 사이의 숫자 검증 필요
    }

}
