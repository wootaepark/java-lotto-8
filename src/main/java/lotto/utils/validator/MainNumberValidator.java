package lotto.utils.validator;

import static lotto.utils.constant.LottoConstants.LOTTO_NUMBER_COUNT;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainNumberValidator {

    public static Set<Integer> validateInputWinningNumber(String input) {
        // 1. ',' 구분 시 번호의 개수가 6개인지
        // 2. 중복된 숫자가 없는지
        // 3. 각 번호의 범위가 올바른지
        // 4. 올바른 형태의 input 인지 (, 이외의 다른 문자)

        List<Integer> mainNumbers = parseNumbers(input);
        validateDuplicateNumbers(mainNumbers);
        validateMainNumbersCount(mainNumbers);
        validateMainNumbersRange(mainNumbers);

        // List 로 검증 로직한 후 Set 형태로 안전하게 데이터 이동
        return new HashSet<>(mainNumbers);


    }


    // 1.
    private static void validateMainNumbersCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("당첨 번호의 수는 " + LOTTO_NUMBER_COUNT + "개여야 합니다.");
        }
    }

    // 2.
    private static void validateDuplicateNumbers(List<Integer> numbers) {
        long distinctCount = numbers.stream().distinct().count();
        if (distinctCount != numbers.size()) {
            throw new IllegalArgumentException("당첨 번호에 중복된 숫자가 있습니다.");
        }
    }


    // 3.
    private static void validateMainNumbersRange(List<Integer> numbers) {
        boolean hasInvalid = numbers.stream()
                .anyMatch(number -> number < 1 || number >= 45);
        if (hasInvalid) {
            throw new IllegalArgumentException("당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

    }

    // 4.
    private static List<Integer> parseNumbers(String input) {
        try {
            return Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력이 가능합니다.");
        }
    }

}
