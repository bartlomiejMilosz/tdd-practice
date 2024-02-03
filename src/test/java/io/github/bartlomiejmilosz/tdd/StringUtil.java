package io.github.bartlomiejmilosz.tdd;

public class StringUtil {
    public static String truncate(String input, int limit) {
        if (input == null || limit < 1)
            throw new IllegalArgumentException("String input must not be null and limit greater then 0");

        if (input.length() > limit)
            return input.substring(0, limit) + "...";
        return input;
    }
}