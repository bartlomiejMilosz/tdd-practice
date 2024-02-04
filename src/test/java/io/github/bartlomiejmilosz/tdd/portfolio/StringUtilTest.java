package io.github.bartlomiejmilosz.tdd.portfolio;

import io.github.bartlomiejmilosz.tdd.StringUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class StringUtilTest {

    @ParameterizedTest
    @MethodSource("validLimitProvider")
    void limitReached_StringTruncates(int limit, String output) {
        String input = "The economy is about to";

        Assertions.assertEquals(output, StringUtil.defaultTruncate(input, limit));
    }

    public static Stream<Arguments> validLimitProvider() {
        return Stream.of(
                Arguments.of(11, "The economy..."),
                Arguments.of(1, "T...")
        );
    }

    @ParameterizedTest
    @MethodSource("inputOutputLimitProvider")
    void limitNotReached_StringNotChanged(String input, int limit) {
        String expected = "The economy is about to";
        Assertions.assertEquals(expected, StringUtil.defaultTruncate(input, limit));
    }

    public static Stream<Arguments> inputOutputLimitProvider() {
        String expected = "The economy is about to";
        return Stream.of(
                Arguments.of(expected, 40),
                Arguments.of(expected, expected.length())
        );
    }

    @ParameterizedTest
    @MethodSource("invalidArgumentProvider")
    void invalidInputIsRejected(String input, int limit) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> StringUtil.defaultTruncate(input, limit));
    }

    public static Stream<Arguments> invalidArgumentProvider() {
        return Stream.of(
                Arguments.of(null, 5),
                Arguments.of("Some input", 0)
        );
    }

    @ParameterizedTest
    @MethodSource("shortInputLessOrEqualToEllipsis")
    void inputShortenOrEqualThanLimit_StringNotChanged(String input, int limit) {
        Assertions.assertEquals(input, StringUtil.defaultTruncate(input, limit));
    }

    public static Stream<Arguments> shortInputLessOrEqualToEllipsis() {
        String input = "The";
        return Stream.of(
                Arguments.of(input, 2),
                Arguments.of(input, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("cutOffCharsProvider")
    void customCutOffCharsNotBreakingOverallLogic(String expected ,String input, int limit, String cutOffChars) {
        Assertions.assertEquals(expected, StringUtil.truncate(input, limit, cutOffChars));
    }

    public static Stream<Arguments> cutOffCharsProvider() {
        String testIO = "The";
        return Stream.of(
                Arguments.of("The eco>>", "The economy", 7, ">>"),
                Arguments.of(testIO, testIO, 3, ">>>"),
                Arguments.of(testIO, testIO, 80, "custom-cutOff"),
                Arguments.of("T&&", testIO, 1, "&&")
        );
    }

    @ParameterizedTest
    @MethodSource("blankInputProvider")
    void blankOrEmptyInput(String input, int limit) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> StringUtil.defaultTruncate(input, limit));
    }

    public static Stream<Arguments> blankInputProvider() {
        int limit = 10;
        return Stream.of(
                Arguments.of("", limit),
                Arguments.of("   ", limit)
        );
    }
}
