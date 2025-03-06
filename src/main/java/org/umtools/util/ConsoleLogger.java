/*
 * Copyright (c) 2025 UMTools contribution.
 * This program is made available under the terms of the MIT License.
 */
package org.umtools.util;

import org.fusesource.jansi.Ansi;

import static org.fusesource.jansi.Ansi.ansi;

/**
 * Utility class for logging messages to format the console output
 *
 * @author Ng, Zhi Yang
 * @since 1.0
 */
public class ConsoleLogger {
    public static final Ansi.Color RED = Ansi.Color.RED;
    public static final Ansi.Color GREEN = Ansi.Color.GREEN;
    public static final Ansi.Color YELLOW = Ansi.Color.YELLOW;
    public static final Ansi.Color BLUE = Ansi.Color.BLUE;

    public static void logInfo(String message) {
        logBlue(message);
    }

    public static void logError(String message) {
        logRed(message);
    }

    public static void logSuccess(String message) {
        logGreen(message);
    }

    public static void logWarning(String message) {
        logYellow(message);
    }

    public static void logBlue(String message) {
        logWithColor(BLUE, message);
    }

    public static void logYellow(String message) {
        logWithColor(YELLOW, message);
    }

    public static void logGreen(String message) {
        logWithColor(GREEN, message);
    }

    public static void logRed(String message) {
        logWithColor(RED, message);
    }

    public static void logWithColor(Ansi.Color color, String message) {
        System.out.println(ansi().fg(color).bold().a(message).reset());
    }
}
