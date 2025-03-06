/*
 * Copyright (c) 2025 UMTools contribution.
 * This program is made available under the terms of the MIT License.
 */
package org.umtools.util;

/**
 * Utility class for running benchmarks and measuring execution times.
 * Supports measuring average execution time and maximum execution time
 * for benchmarking tasks.
 *
 * @author Ng, Zhi Yang
 * @since 1.0
 */
public class BenchmarkRunner {

    /**
     * Runs each benchmark and prints the average and maximum execution times.
     *
     * @param iterations Number of iterations to run each benchmark.
     * @param benchmarks Array of Benchmark tasks.
     */
    public static void runBenchmarks(BenchmarkType type, long iterations, Benchmark... benchmarks) {
        for (Benchmark benchmark : benchmarks) {
            long execTime = getExecTime(type, iterations, benchmark);
            System.out.printf("%s - %s: %d ns%n", benchmark.getName(), type.label, execTime);
        }
    }

    public static void runBenchmarksWithWarmup(BenchmarkType type, long warmupIterations, long iterations, Benchmark... benchmarks) {
        for (Benchmark benchmark : benchmarks) {
            benchmark.measureAvgTime(warmupIterations);
        }
        runBenchmarks(type, iterations, benchmarks);
    }

    private static long getExecTime(BenchmarkType type, long iterations, Benchmark benchmark) {
        return switch (type) {
            case AVG_TIME -> benchmark.measureAvgTime(iterations);
            case MAX_TIME -> benchmark.measureMaxTime(iterations);
            default -> 0;
        };
    }

    public enum BenchmarkType {
        AVG_TIME("Average Time"),
        MAX_TIME("Max Time");

        public final String label;

        BenchmarkType(String label) {
            this.label = label;
        }
    }
}
