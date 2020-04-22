package de.psb.util;

public class Logger {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    private static String color = ANSI_CYAN;

    public static void setColor(String color) {
        Logger.color = color;
    }

    @SafeVarargs
    public static <T> void log(T... t) {
        for (T msg : t) {
            System.out.println(color + msg);
        }
    }

    public static void logTime(long nanoseconds) {
        System.out.println(
                color +
                String.format("%02d", nanoseconds / 60_000_000_000L) + ":" +
                String.format("%02d", nanoseconds /   1_000_000_000) + "." +
                String.format("%09d", nanoseconds %   1_000_000_000)
        );
    }

}
