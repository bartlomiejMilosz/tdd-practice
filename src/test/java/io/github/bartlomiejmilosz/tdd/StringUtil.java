package io.github.bartlomiejmilosz.tdd;

public class StringUtil {
    public static String truncate(String input, int limit) {
        if (inputNullOrLessThanOne(input, limit))
            throw new IllegalArgumentException("String input must not be null and limit greater then 0");

        String ellipsis = "...";
        if (inputToShort(input, limit, ellipsis))
            return input;

        return input.substring(0, limit) + ellipsis;
    }

    private static boolean inputNullOrLessThanOne(String input, int limit) {
        return input == null || limit < 1;
    }

    private static boolean inputToShort(String input, int limit, String ellipsis) {
        return input.length() <= ellipsis.length() || input.length() <= limit;
    }
}