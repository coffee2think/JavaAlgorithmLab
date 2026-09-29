package dev.coffee2think.benchmark;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * 출처: dev.coffee2think.programmers.lv0.q120871
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 5)
@Measurement(iterations = 5)
@Fork(2)
@State(Scope.Thread)
public class ContainsThreeBenchmark {

    @Param({"123456", "777777", "999999"})
    private int number;

    @Benchmark
    public boolean arithmetic() {
        return containsThreeArithmetic(number);
    }

    @Benchmark
    public boolean stringContains() {
        return String.valueOf(number).contains("3");
    }

    private boolean containsThreeArithmetic(int number) {
        while (number > 0) {
            if (number % 3 == 0) {
                return true;
            }
            number /= 10;
        }

        return false;
    }
}
