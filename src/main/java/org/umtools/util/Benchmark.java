/*
 * Copyright (c) 2025 UMTools contribution.
 * This program is made available under the terms of the MIT License.
 */
package org.umtools.util;

/**
 * Represents a benchmarking task that can measure execution time.
 * Provides methods to measure average and maximum execution time
 * for a given task.
 *
 * @author Ng, Zhi Yang
 * @since 1.0
 */
public class Benchmark {

    private final String name;
    private final Runnable task;

    public Benchmark(String name, Runnable task) {
        this.name = name;
        this.task = task;
    }

    public String getName() {
        return name;
    }

    /**
     * Measures the average execution time in nanoseconds.
     *
     * @param iterations Number of times to execute the task.
     * @return Average execution time in ns.
     */
    public long measureAvgTime(long iterations) {
        long totalTime = 0;
        for (int i = 0; i < iterations; i++) {
            long startTime = System.nanoTime();
            task.run();
            totalTime += (System.nanoTime() - startTime);
        }
        return totalTime / iterations;
    }

    /**
     * Measures the maximum execution time in nanoseconds.
     *
     * @param iterations Number of times to execute the task.
     * @return Maximum execution time in ns.
     */
    public long measureMaxTime(long iterations) {
        long maxTime = 0;
        for (int i = 0; i < iterations; i++) {
            long startTime = System.nanoTime();
            task.run();
            long execTime = System.nanoTime() - startTime;
            if (execTime > maxTime) {
                maxTime = execTime;
            }
        }
        return maxTime;
    }
}

