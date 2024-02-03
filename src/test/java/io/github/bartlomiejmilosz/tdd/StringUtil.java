package io.github.bartlomiejmilosz.tdd;

public class StringUtil {
    public static String truncate(String input, int limit) {
        if (input.length() > limit)
            return input.substring(0, limit) + "...";
        return input;
    }
}