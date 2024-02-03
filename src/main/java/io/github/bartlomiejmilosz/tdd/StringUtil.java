package io.github.bartlomiejmilosz.tdd;

public class StringUtil {
    public static String truncate(String input, int limit, String cutOffChars) {
        if (inputNullOrLessThanOne(input, limit))
            throw new IllegalArgumentException("String input must not be null and limit greater then 0");

        if (input.isBlank() || input.isEmpty())
            throw new IllegalArgumentException("String input cannot be empty or blank");

        if (inputToShort(input, limit, cutOffChars))
            return input;

        return input.substring(0, limit) + cutOffChars;
    }

    public static String defaultTruncate(String input, int limit) {
        return truncate(input, limit, "...");
    }

    private static boolean inputNullOrLessThanOne(String input, int limit) {
        return input == null || limit < 1;
    }

    private static boolean inputToShort(String input, int limit, String cutOffChars) {
        return input.length() <= cutOffChars.length() || input.length() <= limit;
    }
}