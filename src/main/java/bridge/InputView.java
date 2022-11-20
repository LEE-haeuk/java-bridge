package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String NUMBER_REGEX = "^[0-9]*$";
    private static final String CHARACTER_REGEX = "^[a-zA-Z]*$";
    private static final String ERROR_MESSAGE = "[ERROR]";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String bridgeSize = Console.readLine();

        validateBridgeSize(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String moving = Console.readLine();

        validateMoving(moving);
        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    public void validateBridgeSize(final String bridgeSize) {
        final int parsedBridgeSize = Integer.parseInt(bridgeSize);

        validateEmptyString(bridgeSize);
        validateNumber(bridgeSize);
        validateInteger(parsedBridgeSize);
        validateRange(parsedBridgeSize);
    }

    public void validateEmptyString(final String text) {
        if (text.length() == 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "입력된 값이 없습니다.");
        }
    }

    public void validateNumber(final String text) {
        if (!text.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "입력된 문자는 숫자가 아닙니다.");
        }
    }

    public void validateInteger(final int integer) {
        if (integer >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "2^31 - 1 보다 큰 수를 입력할 수 없습니다.");
        }
        if (integer <= Integer.MIN_VALUE) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "2^31 보다 작은 수를 입력할 수 없습니다.");
        }
    }

    public void validateRange(final int bridgeSize) {
        if (bridgeSize > 20) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "20 보다 큰 수를 입력할 수 없습니다.");
        }
        if (bridgeSize < 3) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "3 보다 작은 수를 입력할 수 없습니다.");
        }
    }

    public void validateMoving(final String moving) {
        validateEmptyString(moving);
        validateCharacter(moving);
        validateDuplicatedCharacter(moving);
        validateCommand(moving);
    }

    public void validateCharacter(String text) {
        if (!text.matches(CHARACTER_REGEX)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "영문자를 입력해야 합니다.");
        }
    }

    public void validateDuplicatedCharacter(String text) {
        if (text.length() > 1) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "너무 많이 입력했습니다.");
        }
    }

    public void validateCommand(String moving) {
        if (!(moving.contains("U") | moving.contains("D"))) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "U 또는 D가 아닌 문자를 입력했습니다.");
        }
    }
}
