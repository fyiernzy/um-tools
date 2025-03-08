/*
 * Copyright (c) 2025 UMTools contribution.
 * This program is made available under the terms of the MIT License.
 */
package org.umtools.util;

import java.nio.charset.StandardCharsets;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Utility class for handling validated user input from the console.
 *
 * @author Ng, Zhi Yang
 * @since 1.0
 */
public final class InputUtils {

    private static final Scanner SCANNER = new Scanner(System.in, StandardCharsets.UTF_8);

    private InputUtils() {

    }

    /**
     * Prompts the user for a string input.
     *
     * @param message the prompt message to display to the user
     * @return the string input entered by the user
     * @since 1.0
     */
    public static String strInput(String message) {
        return validatedLineInput(
                message,
                nextLine(),
                s -> true,
                "Please enter a valid string value.",
                "Invalid input."
        );
    }

    /**
     * Prompts the user for an integer input.
     *
     * @param message the prompt message to display to the user
     * @return the integer value entered by the user
     * @since 1.0
     */
    public static int intInput(String message) {
        return validatedTokenInput(
                message,
                nextInt(),
                i -> true,
                "Please enter a valid integer value.",
                "Invalid input."
        );
    }

    /**
     * Prompts the user for a double input.
     *
     * @param message the prompt message to display to the user
     * @return the double value entered by the user
     * @since 1.0
     */
    public static double doubleInput(String message) {
        return validatedTokenInput(
                message,
                nextDouble(),
                d -> true,
                "Please enter a valid double value.",
                "Invalid input."
        );
    }

    /**
     * Prompts the user for a long input.
     *
     * @param message the prompt message to display to the user
     * @return the long value entered by the user
     * @since 1.0
     */
    public static long longInput(String message) {
        return validatedTokenInput(
                message,
                nextLong(),
                l -> true,
                "Please enter a valid long value.",
                "Invalid input."
        );
    }

    /**
     * Performs validated input using a line-based input supplier.
     * <p>
     * This method continually prompts the user with the specified message
     * until a valid input is provided. No flush is performed because the supplier
     * (scanner.nextLine) already consumes the whole line.
     * </p>
     *
     * @param <T>          the type of the input
     * @param message      the prompt message to display to the user
     * @param supplier     the supplier that provides the input
     * @param validator    a predicate to validate the input
     * @param errorMessage the message to display if an InputMismatchException occurs
     * @param invalidMsg   the message to display if the input fails validation
     * @return a validated input of type T
     * @since 1.0
     */
    public static <T> T validatedLineInput(String message, Supplier<T> supplier, Predicate<T> validator, String errorMessage, String invalidMsg) {
        while (true) {
            try {
                System.out.print(message);
                T input = supplier.get();
                if (validator.test(input)) {
                    return input;
                }
                System.out.println(invalidMsg);
            } catch (InputMismatchException ex) {
                System.out.println(errorMessage);
            }
        }
    }

    /**
     * Performs validated input using a token-based input supplier.
     * <p>
     * This method continually prompts the user with the specified message until
     * a valid input is provided. After reading the input, it checks if there is
     * any leftover input using the provided tokenChecker. If not, it flushes the
     * remainder of the line.
     * </p>
     *
     * @param <T>          the type of the input
     * @param message      the prompt message to display to the user
     * @param supplier     the supplier that provides the input
     * @param validator    a predicate to validate the input
     * @param errorMessage the message to display if an InputMismatchException occurs
     * @param invalidMsg   the message to display if the input fails validation
     * @return a validated input of type T
     * @since 1.0
     */
    public static <T> T validatedTokenInput(String message, Supplier<T> supplier, Predicate<T> validator, String errorMessage, String invalidMsg) {
        while (true) {
            try {
                System.out.print(message);
                T input = supplier.get();
                if (validator.test(input)) {
                    return input;
                }
                System.out.println(invalidMsg);
            } catch (InputMismatchException ex) {
                System.out.println(errorMessage);
            } finally {
                // If the expected token is not present, flush the rest of the line.
                if (SCANNER.hasNextLine()) {
                    SCANNER.nextLine();
                }
            }
        }
    }

    public static Supplier<String> nextLine() {
        return SCANNER::nextLine;
    }

    public static Supplier<Integer> nextInt() {
        return SCANNER::nextInt;
    }

    public static Supplier<Double> nextDouble() {
        return SCANNER::nextDouble;
    }

    public static Supplier<Long> nextLong() {
        return SCANNER::nextLong;
    }
}
