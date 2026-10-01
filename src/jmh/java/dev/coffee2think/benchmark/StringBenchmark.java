package dev.coffee2think.benchmark;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 2, time = 500, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 3, time = 500, timeUnit = TimeUnit.MILLISECONDS)
@Fork(1)
@State(Scope.Thread)
public class StringBenchmark {

    @Param({"99x", "9x", "x", "99", "9", "0"})
    private String str;


    // contains vs lastIndexOf vs charAt(length - 1)
    @Benchmark
    public boolean contains() {
        return str.contains("x");
    }

    @Benchmark
    public int lastIndexOf() {
        return str.lastIndexOf("x");
    }

    @Benchmark
    public boolean charAt() {
        return str.charAt(str.length() - 1) == 'x';
    }

    @Benchmark
    public boolean endsWith() {
        return str.endsWith("x");
    }
}
