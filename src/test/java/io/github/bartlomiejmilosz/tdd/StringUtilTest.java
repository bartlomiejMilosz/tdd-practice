package io.github.bartlomiejmilosz.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class StringUtilTest {

    @Test
    void LimitReached_StringTruncates() {
        String input = "The economy is about to";
        int limit = 11;

        Assertions.assertEquals("The economy...", StringUtil.truncate(input, limit));
    }

    @ParameterizedTest
    @MethodSource("inputOutputLimitProvider")
    void limitNotReached_StringNotChanged(String input, int limit) {
        Assertions.assertEquals("The economy is about to", StringUtil.truncate(input, limit));
    }

    public static Stream<Arguments> inputOutputLimitProvider() {
        return Stream.of(
                Arguments.of("The economy is about to", 40),
                Arguments.of("The economy is about to", 23)
        );
    }
}
