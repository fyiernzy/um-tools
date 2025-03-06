/*
 * Copyright (c) 2025 UMTools contribution.
 * This program is made available under the terms of the MIT License.
 */
package org.umtools.util;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciitable.CWC_LongestLine;
import org.apache.commons.lang3.text.WordUtils;

import java.util.List;
import java.util.stream.Stream;


/**
 * Utility class for printing tables in a formatted manner using ASCII art.
 *
 * @author Ng, Zhi Yang
 * @since 1.0
 */
public class TableUtils {

    private TableUtils() {

    }

    /**
     * Renders a table with the given headers and data.
     *
     * @param headers the headers of the table
     * @param data    the data of the table
     * @since 1.0
     */
    public static void renderTable(String[] headers, String[][] data) {
        checkHeaders(headers);
        checkData(data);

        AsciiTable table = new AsciiTable();
        table.addRule();
        table.addRow((Object[]) headers);
        table.addRule();

        for (String[] row : data) {
            table.addRow((Object[]) row);
            table.addRule();
        }

        table.setPaddingLeftRight(1);
        table.getRenderer().setCWC(new CWC_LongestLine());
        System.out.println(table.render());
    }

    /**
     * Renders a table with the given headers and data.
     *
     * @param headers the headers of the table
     * @param data    the data of the table
     * @since 1.0
     */
    public static void renderTable(String[] headers, List<String[]> data) {
        checkData(data);
        renderTable(headers, data.toArray(String[][]::new));
    }

    /**
     * Renders a table with the given headers and raw data.
     *
     * @param headers the headers of the table
     * @param rawData the raw data of the table
     * @param <T>     the type of the raw data
     * @since 1.0
     */
    public static <T> void renderTableWithRawData(String[] headers, List<T> rawData) {
        renderTable(headers, dataList(headers, rawData));
    }

    private static <T> List<String[]> dataList(String[] headers, List<T> objects) {
        checkHeaders(headers);
        checkRawData(objects);
        return objects.stream()
                .map(obj -> objToData(headers, obj))
                .toList();
    }

    private static <T> String[] objToData(String[] headers, T object) {
        return Stream.of(headers)
                .map(header -> getFieldValue(object, toFieldName(header)))
                .toArray(String[]::new);
    }

    private static String getFieldValue(Object object, String fieldName) {
        return ReflectionUtils.readFieldAsString(object, fieldName);
    }

    private static String toFieldName(String header) {
        String fieldName = WordUtils.capitalizeFully(header).replace(" ", "");
        return WordUtils.uncapitalize(fieldName);
    }

    private static void checkHeaders(String[] headers) {
        Asserts.isNotEmpty(headers, IllegalArgumentException.class, "Headers cannot be null or empty");
    }

    private static void checkData(String[][] data) {
        Asserts.isNotEmpty(data, IllegalArgumentException.class, "Data cannot be null or empty");
    }

    private static void checkData(List<String[]> data) {
        Asserts.isNotEmpty(data, IllegalArgumentException.class, "Data cannot be null or empty");
    }

    private static void checkRawData(List<?> rawData) {
        Asserts.isNotEmpty(rawData, IllegalArgumentException.class, "Raw data cannot be null or empty");
    }
}

